package com.thales.financial.transactions.unit;


import com.thales.financial.transactions.controller.FinancialTransactionsController;
import com.thales.financial.transactions.service.FinancialTransactionsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FinancialTransactionsControllerTest {

    private FinancialTransactionsService service = mock(FinancialTransactionsService.class);
    private FinancialTransactionsController controller = new FinancialTransactionsController(service);

    @Test
    @DisplayName("Upload deve retornar OK para um arquivo válido")
    public void uploadDhouldReturnOKForValidFile() {
        //given
        MultipartFile file = mock(MultipartFile.class);

        //when
        doNothing().when(service).batchInsertFromFile(file);
        ResponseEntity response = controller.upload(file);

        //then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }



}
