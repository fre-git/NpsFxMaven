package com.fre.npsfxmaven;

public interface Storable {
    String getName();
    int getProcessingOrder();

    boolean equals(Nps nps);
}
