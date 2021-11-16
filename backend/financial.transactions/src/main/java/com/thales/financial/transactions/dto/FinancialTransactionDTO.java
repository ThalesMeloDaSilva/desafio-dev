package com.thales.financial.transactions.dto;

import com.thales.financial.transactions.enums.TransactionType;

public class FinancialTransactionDTO {

    private String id;
    private TransactionType type;
    private String date;
    private String hour;
    private Double value;
    private String cpf;
    private String card;
    private String storeOwner;
    private String storeName;

    public FinancialTransactionDTO(String id,
                                   TransactionType type,
                                   String date,
                                   String hour,
                                   Double value,
                                   String cpf,
                                   String card,
                                   String storeOwner,
                                   String storeName) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.hour = hour;
        this.value = value;
        this.cpf = cpf;
        this.card = card;
        this.storeOwner = storeOwner;
        this.storeName = storeName;
    }

    public FinancialTransactionDTO(TransactionType type,
                                   String date,
                                   String hour,
                                   Double value,
                                   String cpf,
                                   String card,
                                   String storeOwner,
                                   String storeName) {
        this.type = type;
        this.date = date;
        this.hour = hour;
        this.value = value;
        this.cpf = cpf;
        this.card = card;
        this.storeOwner = storeOwner;
        this.storeName = storeName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(String storeOwner) {
        this.storeOwner = storeOwner;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}