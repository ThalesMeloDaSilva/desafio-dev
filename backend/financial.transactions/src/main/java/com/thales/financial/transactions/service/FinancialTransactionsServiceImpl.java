package com.thales.financial.transactions.service;

import com.thales.financial.transactions.exception.InvalidCNABFileException;
import com.thales.financial.transactions.repository.FinancialTransactionsRepository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class FinancialTransactionsServiceImpl implements FinancialTransactionsService {

    private FinancialTransactionsRepository repository;

    @Override
    public void batchInsertFromFile(MultipartFile file) throws InvalidCNABFileException {

    }

    @Override
    public List getFinancialTransactions(int page, int size) {
        return null;
    }
}
