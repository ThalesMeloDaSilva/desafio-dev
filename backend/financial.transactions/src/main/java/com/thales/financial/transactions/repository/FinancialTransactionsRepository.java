package com.thales.financial.transactions.repository;

import com.thales.financial.transactions.dto.FinancialTransactionDTO;

import java.util.List;

public interface FinancialTransactionsRepository {

    void create(List<FinancialTransactionDTO> dtos);

    List<FinancialTransactionDTO> get(int offset, int size);

}
