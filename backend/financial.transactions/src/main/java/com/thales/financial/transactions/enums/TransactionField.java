package com.thales.financial.transactions.enums;

public enum TransactionField {

    TYPE(0, 1, 1),
    DATE(1, 9, 8),
    VALUE(9, 19, 10),
    CPF(19, 30, 11),
    CARD(30, 42, 12),
    HOUR(42, 48, 6),
    STORE_OWNER(48, 62, 14),
    STORE_NAME(62, 80, 19),;

    private final Integer startPosition;
    private final Integer endPosition;
    private final Integer size;

    TransactionField(Integer startPosition, Integer finalPosition, Integer size) {
        this.startPosition = startPosition;
        this.endPosition = finalPosition;
        this.size = size;
    }

    public Integer getStartPosition() {
        return startPosition;
    }

    public Integer getEndPosition() {
        return endPosition;
    }

    public Integer getSize() {
        return size;
    }
}
