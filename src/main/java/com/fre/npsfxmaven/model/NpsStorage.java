package com.fre.npsfxmaven.model;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class NpsStorage implements IStorage{
    String nameAlreadyExist = "Network with this name already exists.";
    String nameIsEmpty = "Network name can't be empty";
    String npsAdded = "Added Nps";

    Collection<Storable> npsStorage = new TreeSet<>((nps1, nps2) -> {
        if (nps1.getProcessingOrder() == nps2.getProcessingOrder()) {
            return nps1.getName().compareTo(nps2.getName());
        }
        return Integer.compare(nps1.getProcessingOrder(), nps2.getProcessingOrder());
    });

    public String addNps(Storable newNps) {
    newNps.validate();
        for (Storable nps : npsStorage) {
            if (nps.getName().equals(newNps.getName())) {
                //System.out.println("Network with name " + newNps.getName() + " already exists.");
                return nameAlreadyExist;
            } else if(newNps.getName().equals(null) || newNps.getName().equals("")) {
                //System.out.println("network name can't be empty");
                return nameIsEmpty;
            }
            else if (nps.getProcessingOrder() >= newNps.getProcessingOrder()) {
                System.out.println("nps name: " + newNps.getName());
                System.out.println(">=");
                nps.bumpProcessingOrder();
            }
        }
        System.out.println("add?");
        npsStorage.add(newNps);
        return npsAdded;
    }

    public void switchNps(String orderOne, String orderTwo){
        List<Storable> listNpsStorage = npsStorage.stream().toList();

        int index1 = Integer.parseInt(orderOne) - 1;
        int index2 = Integer.parseInt(orderTwo) -1;

        int temp = listNpsStorage.get(index1).getProcessingOrder();
        listNpsStorage.get(index1).setProcessingOrder(listNpsStorage.get(index2).getProcessingOrder());
        listNpsStorage.get(index2).setProcessingOrder(temp);

        TreeSet<Storable> treeSetNps = new TreeSet<>(listNpsStorage);
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
        StringBuilder storage = new StringBuilder();
        for (Storable nps: npsStorage) {
            storage.append(nps).append("\n");
        }
        return storage.toString();
    }
}
