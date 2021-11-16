package com.thales.financial.transactions.unit;

import com.thales.financial.transactions.dto.FinancialTransactionDTO;
import com.thales.financial.transactions.enums.TransactionType;
import com.thales.financial.transactions.repository.FinancialTransactionsRepository;
import com.thales.financial.transactions.repository.FinancialTransactionsRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.eq;

public class FinancialTransactionsRepositoryImplTest {

    private NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    private FinancialTransactionsRepository repository = new FinancialTransactionsRepositoryImpl(jdbcTemplate);

    @Test
    @DisplayName("Deve chamar o batchUpdate com a query correta")
    public void shouldCallBatchUpdateWithTheCorrectQuery() throws IOException {
        //given
        String query = "INSERT INTO transactions (type, date, hour, value, cpf, card, store_owner, store_name) " +
                "VALUES(:type, :date, :hour, :value, :cpf, :card, :storeOwner, :storeName);";
        List<FinancialTransactionDTO> dtos = new ArrayList<>();
        dtos.add(new FinancialTransactionDTO(
                TransactionType.ALUGUEL,
                "10/10/2019",
                "12:00",
                402.10,
                "00865912077",
                "card",
                "storeOwner",
                "storeName"));

        //when
        repository.create(dtos);

        //then
        verify(jdbcTemplate, times(1)).batchUpdate(eq(query), any(MapSqlParameterSource[].class));
    }
}
