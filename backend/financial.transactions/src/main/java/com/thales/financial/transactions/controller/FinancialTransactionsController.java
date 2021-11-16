package com.thales.financial.transactions.controller;

import com.thales.financial.transactions.exception.InvalidCNABFileException;
import com.thales.financial.transactions.service.FinancialTransactionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/financial-transactions")
public class FinancialTransactionsController {

    private FinancialTransactionsService service;

    public FinancialTransactionsController(FinancialTransactionsService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity upload(MultipartFile file) {
        try {
            service.batchInsertFromFile(file);
        } catch (InvalidCNABFileException ex) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List getFinancialTransactions(@RequestParam(value = "page", required = false, defaultValue = "1")
                                                 int page,
                                         @RequestParam(value = "size", required = false, defaultValue = "10")
                                                 int size) {
        return service.getFinancialTransactions(page, size);
    }

}
