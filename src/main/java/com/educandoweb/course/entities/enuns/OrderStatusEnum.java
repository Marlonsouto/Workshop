package com.educandoweb.course.entities.enuns;

public enum OrderStatusEnum {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);
    private final int codeStatus;

    private OrderStatusEnum(int status) {
        this.codeStatus =status;
    }
    public int getCodeStatus() {
        return codeStatus;
    }
    public static OrderStatusEnum valueEnumOf(int status) {
        for ( OrderStatusEnum value : OrderStatusEnum.values() ) {
            if (value.getCodeStatus() == status ){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid order status code");
    }
}
