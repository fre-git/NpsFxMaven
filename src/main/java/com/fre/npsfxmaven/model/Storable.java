package com.fre.npsfxmaven.model;

public interface Storable {
    String getName();
    int getProcessingOrder();
    void bumpProcessingOrder();
    void setProcessingOrder(int i);
    String getFullLine();

    void validate();

}
