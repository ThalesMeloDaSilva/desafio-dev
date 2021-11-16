package com.thales.financial.transactions.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FinancialTransactionsService {

    void batchInsertFromFile(MultipartFile file);

    List getFinancialTransactions(int page, int size);

}
