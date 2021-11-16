package com.thales.financial.transactions.service;

import com.thales.financial.transactions.exception.InvalidCNABFileException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FinancialTransactionsService {

    void batchInsertFromFile(MultipartFile file) throws InvalidCNABFileException;

    List getFinancialTransactions(int page, int size);

}
