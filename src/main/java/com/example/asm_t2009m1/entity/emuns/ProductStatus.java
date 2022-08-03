package com.example.asm_t2009m1.entity.emuns;

public enum ProductStatus {

    ACTIVE(1), DEACTIVE(0), DELETED(-1), UNDEFINED(-2);

    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ProductStatus of(int value) {
        for (ProductStatus status :
                ProductStatus.values()) {
            if(status.getValue() == value){
                return status;
            }
        }
        return ProductStatus.UNDEFINED;
    }
}
