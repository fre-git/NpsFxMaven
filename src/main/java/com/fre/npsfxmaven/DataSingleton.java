package com.fre.npsfxmaven;


public class DataSingleton {
    private static final DataSingleton instance = new DataSingleton();
    private Nps nps;

    private DataSingleton() {    }

    public static DataSingleton getInstance(){
        return instance;
    }

    public Nps getNps(){
        return nps;
    }

    public void setNps(Nps nps){
        this.nps = nps;
    }

}
