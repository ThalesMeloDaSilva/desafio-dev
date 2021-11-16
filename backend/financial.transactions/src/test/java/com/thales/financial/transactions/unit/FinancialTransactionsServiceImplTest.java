package com.thales.financial.transactions.unit;

import com.thales.financial.transactions.exception.InvalidCNABFileException;
import com.thales.financial.transactions.repository.FinancialTransactionsRepository;
import com.thales.financial.transactions.service.FinancialTransactionsService;
import com.thales.financial.transactions.service.FinancialTransactionsServiceImpl;
import com.thales.financial.transactions.utils.FileParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FinancialTransactionsServiceImplTest {

    private FinancialTransactionsRepository repository = mock(FinancialTransactionsRepository.class);
    private FileParser fileParser = mock(FileParser.class);
    private FinancialTransactionsService service = new FinancialTransactionsServiceImpl(repository, fileParser);

    @Test
    @DisplayName("Não deve lançar exceção para um arquivo valido")
    public void shouldDoNotThrowExceptionForAValidFile() throws IOException {
        //given
        MultipartFile file = mock(MultipartFile.class);

        //when
        when(fileParser.parse(file)).thenReturn(new ArrayList<String>());
        service.batchInsertFromFile(file);
    }

    @Test
    @DisplayName("Deve lançar exceção para um arquivo invalido")
    public void shouldThrowInvalidCNABFileExceptionForAInvalidFile() throws IOException {
        //given
        MultipartFile file = mock(MultipartFile.class);

        //when
        when(file.getName()).thenReturn("file-name.txt");
        when(fileParser.parse(file)).thenThrow(new IOException());
        InvalidCNABFileException thrown = assertThrows(InvalidCNABFileException.class, () -> {
            service.batchInsertFromFile(file);
        }, "InvalidCNABFileException error was expected");

        //then
        assertEquals("File file-name.txt is invalid", thrown.getMessage());
    }

}
