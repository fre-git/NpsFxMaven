package com.fre.npsfxmaven.util;

public class StringProcessor {
    public static String getName(String line){
        int nameStart = line.indexOf("name=\"") + "name=\"".length();
        int nameEnd = line.indexOf("\" state");
        return line.substring(nameStart, nameEnd);
    }

    public static int getProcessingNumber(String line){
        int processingOrderStart = line.indexOf("processingorder=\"") + "processingorder=\"".length();
        int processingOrderEnd = line.indexOf("\" policy");
        return Integer.parseInt(line.substring(processingOrderStart, processingOrderEnd));
    }

    public static String getState(String line){
        int nameStart = line.indexOf("state=\"") + "state=\"".length();
        int nameEnd = line.indexOf("\" processingorder");
        return line.substring(nameStart, nameEnd);
    }

    public static int getPolicy(String line){
        int nameStart = line.indexOf("policysource=\"") + "policysource=\"".length();
        int nameEnd = line.indexOf("\" conditionid");
        return Integer.parseInt(line.substring(nameStart, nameEnd));
    }

    public static String getConditionId(String line){
        int nameStart = line.indexOf("conditionid=\"") + "conditionid=\"".length();
        int nameEnd = line.indexOf("\" conditiondata");
        return line.substring(nameStart, nameEnd);
    }

    public static String getConditionData(String line){
        int nameStart = line.indexOf("conditiondata=\"") + "conditiondata=\"".length();
        int nameEnd = line.indexOf("\" profileid");
        return line.substring(nameStart, nameEnd);
    }

    public static String getProfileId(String line){
        int nameStart = line.indexOf("profileid=\"") + "profileid=\"".length();
        int nameEnd = line.indexOf("\" profiledata");
        return line.substring(nameStart, nameEnd);
    }

    public static String getProfileData(String line){
        int nameStart = line.indexOf("profiledata=\"") + "profiledata=\"".length();
        int nameEnd = line.length()-1;
        return line.substring(nameStart, nameEnd).replace("\"" , "");
    }
}
