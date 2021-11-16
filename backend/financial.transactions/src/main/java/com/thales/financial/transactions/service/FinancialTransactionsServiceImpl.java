package com.thales.financial.transactions.service;

import com.thales.financial.transactions.dto.FinancialTransactionDTO;
import com.thales.financial.transactions.enums.TransactionField;
import com.thales.financial.transactions.enums.TransactionType;
import com.thales.financial.transactions.exception.InvalidCNABFileException;
import com.thales.financial.transactions.repository.FinancialTransactionsRepository;
import com.thales.financial.transactions.utils.FileParser;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.thales.financial.transactions.enums.TransactionField.*;

public class FinancialTransactionsServiceImpl implements FinancialTransactionsService {

    private static final Double NORMALIZE_VALUE_FACTOR = 100.00;

    private FinancialTransactionsRepository repository;
    private FileParser fileParser;

    public FinancialTransactionsServiceImpl(FinancialTransactionsRepository repository, FileParser fileParser) {
        this.repository = repository;
        this.fileParser = fileParser;
    }

    @Override
    public void batchInsertFromFile(MultipartFile file) throws InvalidCNABFileException {
        try {
            List<String> lines = fileParser.parse(file);
            List<FinancialTransactionDTO> transactions = extractTransactions(lines);
            repository.create(transactions);
        } catch (IOException e) {
            String errorMessage = "File " + file.getName() + " is invalid";
            throw new InvalidCNABFileException(errorMessage);
        }
    }

    @Override
    public List getFinancialTransactions(int page, int size) {
        return null;
    }

    private List<FinancialTransactionDTO> extractTransactions(List<String> lines) {
        return lines.stream().map(this::extractTransaction).collect(Collectors.toList());
    }

    private FinancialTransactionDTO extractTransaction(String line) {
        String date = getField(line, DATE);
        String hour = getField(line, HOUR);
        String cpf = getField(line, CPF);
        String card = getField(line, CARD);
        String storeOwner = getField(line, STORE_OWNER);
        String storeName = getField(line, STORE_NAME);
        return new FinancialTransactionDTO(getType(line), date, hour, getValue(line), cpf, card, storeOwner, storeName);
    }

    private String getField(String line, TransactionField field) {
        return line.substring(field.getStartPosition(), field.getEndPosition());
    }

    private TransactionType getType(String line) {
        return TransactionType.getById(getField(line, TYPE));
    }

    private double getValue(String line) {
        return Double.parseDouble(getField(line, VALUE)) / NORMALIZE_VALUE_FACTOR;
    }
}
