package com.thales.financial.transactions.repository;

import com.thales.financial.transactions.dto.FinancialTransactionDTO;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class FinancialTransactionsRepositoryImpl implements FinancialTransactionsRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public FinancialTransactionsRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(List<FinancialTransactionDTO> dtos) {
        String query = "INSERT INTO transactions (type, date, hour, value, cpf, card, store_owner, store_name) " +
                "VALUES(:type, :date, :hour, :value, :cpf, :card, :storeOwner, :storeName);";

        List<MapSqlParameterSource> batchParameterSource = dtos.stream().map(this::dtoToParameters).collect(Collectors.toList());

        jdbcTemplate.batchUpdate(query, batchParameterSource.toArray(MapSqlParameterSource[]::new));
    }

    @Override
    public List<FinancialTransactionDTO> get(int offset, int size) {
        return null;
    }

    private MapSqlParameterSource dtoToParameters(FinancialTransactionDTO dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("type", Integer.parseInt(dto.getType().getId()));
        source.addValue("date", dto.getDate());
        source.addValue("hour", dto.getHour());
        source.addValue("value", dto.getValue());
        source.addValue("cpf", dto.getCpf());
        source.addValue("card", dto.getCard());
        source.addValue("storeOwner", dto.getStoreOwner());
        source.addValue("storeName", dto.getStoreName());
        return source;
    }
}
