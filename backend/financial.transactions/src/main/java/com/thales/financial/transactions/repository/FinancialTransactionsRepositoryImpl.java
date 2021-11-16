package com.thales.financial.transactions.repository;

import com.thales.financial.transactions.dto.FinancialTransactionDTO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class FinancialTransactionsRepositoryImpl implements FinancialTransactionsRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public FinancialTransactionsRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(List<FinancialTransactionDTO> dtos) {

    }

    @Override
    public List<FinancialTransactionDTO> get(int offset, int size) {
        return null;
    }
}
