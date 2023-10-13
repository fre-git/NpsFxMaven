package com.fre.npsfxmaven;

import java.util.Collection;
import java.util.TreeSet;

public class NpsStorage {
    Collection<Storable> npsStorage = new TreeSet<>((nps1, nps2) -> {
        if (nps1.getProcessingOrder() == nps2.getProcessingOrder()) {
            return nps1.getName().compareTo(nps2.getName());
        }
        return Integer.compare(nps1.getProcessingOrder(), nps2.getProcessingOrder());
    });

    public void addNps(Storable newNps) {
        for (Storable nps : npsStorage) {
            if (nps.getName().equals(newNps.getName())) {
                System.out.println("Network with name " + newNps.getName() + " already exists.");
                return;
            } else if (nps.getProcessingOrder() >= newNps.getProcessingOrder()) {
                nps.bumpProcessingOrder();
            }
        }
        npsStorage.add(newNps);
    }

    public void setStorage(Collection storage){
        this.npsStorage = storage;
    }

    public Collection<Storable> getNpsRecords(){
        return npsStorage;
    }

    @Override
    public String toString(){
        String storage = "";
        for (Storable nps: npsStorage) {
            storage += nps + "\n";
        }
        return storage;
    }
}
