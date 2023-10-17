package com.fre.npsfxmaven;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class NpsStorage implements IStorage{
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

    public void bumpNps(Storable npsToBump){
        for (Storable nps : npsStorage) {
            if (nps.getProcessingOrder() >= npsToBump.getProcessingOrder()) {
                nps.bumpProcessingOrder();
            }
        }
        npsStorage.add(npsToBump);
    }

    public void getNps(String orderOne, String orderTwo){
        List<Storable> listNpsStorage = npsStorage.stream().toList();

        int index1 = Integer.parseInt(orderOne) - 1;
        int index2 = Integer.parseInt(orderTwo) -1;

        int temp = listNpsStorage.get(index1).getProcessingOrder();
        listNpsStorage.get(index1).setProcessingOrder(listNpsStorage.get(index2).getProcessingOrder());
        listNpsStorage.get(index2).setProcessingOrder(temp);
        for (Storable s: listNpsStorage) {
            System.out.println(s);
        }

        TreeSet<Storable> treeSetNps = new TreeSet<>(listNpsStorage);
        for (Storable s: treeSetNps) {
            System.out.println(s);
        }
        setStorage(treeSetNps);
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
