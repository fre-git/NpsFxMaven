package com.fre.npsfxmaven;

public interface Storable {
    String getName();
    int getProcessingOrder();
    void bumpProcessingOrder();
    void setProcessingOrder(int i);
    String getFullLine();

}
