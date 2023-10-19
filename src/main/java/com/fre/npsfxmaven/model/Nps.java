package com.fre.npsfxmaven.model;

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

    public Nps(String name, int processingOrder) {
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

    public Nps(String fullLine, String name, Integer processingOrder, String state, int policySource, String conditionId,
               String conditionData, String profileId, String profileData) {
        this.fullLine = fullLine;
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

        return "add np name=\"" + getName() + "\" state=\"" + getState() + "\" processingorder=\""
                + getProcessingOrder() + "\" policysource=\"" + getPolicySource() + "\" conditionid=\""
                + getConditionId() + "\" conditiondata=\"" + getConditionData() + "\" profileid=\""
                + getProfileId() + "\" profiledata=\"" + getProfileData() + "\"";
    }

    public String getName() {
        return name;
    }

    public int getProcessingOrder() {
        return processingOrder;
    }

    public String getState() {
        return state;
    }

    public int getPolicySource() {
        return policySource;
    }

    public String getConditionId() {
        return conditionId;
    }

    public String getConditionData() {
        return conditionData;
    }

    public String getProfileId() {
        return profileId;
    }

    public String getProfileData() {
        return profileData;
    }

    @Override
    public void setProcessingOrder(int i){
        this.processingOrder = i;
    }

    @Override
    public String toString(){
        return this.processingOrder + ": " +  this.name;
    }

    @Override
    public void validate() {
        validateNpsName();
        validateProcessingOrder();
    }

    public void validateProcessingOrder() {
        if(processingOrder <= 0){
            throw new RuntimeException("ProcessingOrder must be positive number");
        }
    }

    public void validateNpsName() {
        if(name == null || name == ""){
            throw new RuntimeException("Name can't be empty");
        }
    }



}
