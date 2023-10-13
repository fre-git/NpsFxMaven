package com.fre.npsfxmaven;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class NpsStorage {
    private Collection<Nps> npsRecords;
    private Collection<Nps> npsTreeSet;

    public NpsStorage(){
        this.npsRecords = new LinkedHashSet<>();
        this.npsTreeSet = new TreeSet<>();
    }

    public void setStorage(Set lHSet){
        this.npsRecords = lHSet;
    }

    public void addNps(Nps nps){
        if(npsRecords.contains(nps)){
            System.out.println("already in list");
        } else{
            System.out.println("does not exist");
            npsRecords.add(nps);
        }
    }

    public Collection<Nps> getNpsRecords(){
        return npsRecords;
    }

    public Collection<Nps> getNpsRecordsTreeSet(){
        npsTreeSet = new TreeSet<>(npsRecords);
        return npsTreeSet;
    }

    @Override
    public String toString(){
        String storage = "";
        for (Nps nps: npsRecords) {
            storage += nps + "\n";
        }
        return storage;
    }
}
