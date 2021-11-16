package com.thales.financial.transactions.service;

import com.thales.financial.transactions.dto.FinancialTransactionDTO;
import com.thales.financial.transactions.exception.InvalidCNABFileException;
import com.thales.financial.transactions.repository.FinancialTransactionsRepository;
import com.thales.financial.transactions.utils.FileParser;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public class FinancialTransactionsServiceImpl implements FinancialTransactionsService {

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

    private List<FinancialTransactionDTO> extractTransactions(List<String> lines) {
        return null;
    }

    @Override
    public List getFinancialTransactions(int page, int size) {
        return null;
    }
}
