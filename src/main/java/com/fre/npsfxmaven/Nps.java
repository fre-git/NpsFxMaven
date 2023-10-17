package com.fre.npsfxmaven;

public class Nps implements Storable , Comparable<Nps> {
    private String fullLine;
    private String name;
    private int processingOrder;
    private String state;
    private int policySource;
    private String conditionId;
    private String conditionData;
    private String profileId;
    private String profileData;

    public Nps(String fullLine, String name, int processingOrder) {
        this.fullLine = fullLine;
        this.name = name;
        this.processingOrder = processingOrder;
    }

    public Nps(String name, Integer processingOrder, String state, int policySource, String conditionId,
               String conditionData, String profileId, String profileData) {
        this.name = name;
        this.processingOrder = processingOrder;
        this.state = state;
        this.policySource = policySource;
        this.conditionId = conditionId;
        this.conditionData = conditionData;
        this.profileId = profileId;
        this.profileData = profileData;
    }

    public void bumpProcessingOrder(){
        ++this.processingOrder;
    }



    @Override
    public int compareTo(Nps nps) {
        if (this.processingOrder == nps.processingOrder) {
            return this.name.compareTo(nps.name);
        }
        return Integer.compare(this.processingOrder, nps.processingOrder);
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
    public void setProcessingOrder(int i){
        this.processingOrder = i;
    }

    @Override
    public String toString(){
        return this.processingOrder + ": " +  this.name;
    }

/*
    @Override
    public void validate() {
        System.out.println("start validating");
        validateNpsName();
        validateProcessingOrder();
    }

    private void validateProcessingOrder() {
        if(processingOrder < 0){
            throw new RuntimeException("ProcessingOrder can't be negative");
        }
    }

    private void validateNpsName() {
        if(name == null){
            throw new RuntimeException("Name can't be empty");
        }
    }

 */

}
