package com.fre.npsfxmaven;

public class Nps implements Storable , Comparable<Nps> {
    private String fullLine;
    private String name;
    private Integer processingOrder;

    public Nps(String fullLine, String name, int processingOrder) {
        this.fullLine = fullLine;
        this.name = name;
        this.processingOrder = processingOrder;
    }

    public String getFullLine() {
        return fullLine;
    }

    public String getName() {
        return name;
    }

    public int getProcessingOrder() {
        return processingOrder;
    }

    @Override
    public boolean equals(Nps nps){
        if(this.getName() == nps.getName()){
            System.out.println("is equal");
            return true;
        } else {
            System.out.println("is not equal");
            return false;
        }
    }

    @Override
    public int hashCode(){
        return getName().hashCode();
    }

    @Override
    public int compareTo(Nps nps) {
        if(this.processingOrder == nps.processingOrder){
            ++nps.processingOrder;
            return this.processingOrder.compareTo(nps.processingOrder);
        }
        return this.processingOrder.compareTo(nps.processingOrder);
    }

    @Override
    public String toString(){
        return this.processingOrder + ": " +  this.name;
    }

}
