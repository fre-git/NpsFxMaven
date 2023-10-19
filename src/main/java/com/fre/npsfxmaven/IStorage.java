package com.fre.npsfxmaven;

import java.util.Collection;

public interface IStorage {
    void addNps(Storable nps);

    void setStorage(Collection storage);

    Collection<Storable> getNpsRecords();


}
