package com.thales.financial.transactions.enums;

import java.util.HashMap;
import java.util.Map;

public enum TransactionType {

    DEBITO("1", "Débito", "+"),
    BOLETO("2", "Boleto", "-"),
    FINANCIAMENTO("3", "Financiamento", "-"),
    CREDITO("4", "Crédito", "+"),
    REC_EMP("5", "Recebimento;Empréstimo", "+"),
    VENDAS("6", "Vendas", "+"),
    REC_TED("7", "Recebimento TED", "+"),
    REC_DOC("8", "Recebimento DOC", "+"),
    ALUGUEL("9", "Aluguel", "-");

    private final String id;
    private final String description;
    private final String operator;

    private static final Map<String, TransactionType> lookup = new HashMap<String, TransactionType>();

    static {
        for (TransactionType type : TransactionType.values()) {
            lookup.put(type.id, type);
        }
    }

    TransactionType(String id, String description, String operator) {
        this.id = id;
        this.description = description;
        this.operator = operator;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getOperator() {
        return operator;
    }

    public static TransactionType getById(String id) {
        return lookup.get(id);
    }
}
