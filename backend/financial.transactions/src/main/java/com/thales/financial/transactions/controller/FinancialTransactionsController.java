package com.thales.financial.transactions.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/financial-transactions")
public class FinancialTransactionsController {

    @PostMapping("/upload")
    public ResponseEntity upload(MultipartFile file) {

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List getFinancialTransactions(@RequestParam(value = "page", required = false, defaultValue = "1")
                                                 int page,
                                         @RequestParam(value = "size", required = false, defaultValue = "10")
                                                 int size) {
        return null;
    }

}
