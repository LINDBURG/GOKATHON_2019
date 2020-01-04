package com.fourman.anamdobby;

public enum OrderStatus {
    NOT_STARTED(0),
    PROCESSING(1),
    DONE(2);

    private Integer number;

    OrderStatus(int number) {
        this.number = number;
    }

    public Integer getStatusNumber() {
        return number;
    }
}
