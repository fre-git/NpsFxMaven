package com.fre.npsfxmaven.model;

import java.util.Collection;

public interface IStorage {
    String addNps(Storable nps);

    void setStorage(Collection storage);

    Collection<Storable> getNpsRecords();


}
