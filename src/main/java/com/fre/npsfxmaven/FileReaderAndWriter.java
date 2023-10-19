package com.fre.npsfxmaven;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class FileReaderAndWriter implements IReaderAndWriter{
    File file;

    @Override
    public File readFile(String file){
        return new File(file);
    }

    @Override
     public Set<Storable> processFile(String fileString){
        file = new File(fileString);
        Set<Storable> npsRecords = new TreeSet<>();
        try{
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                //remove empty lines
                if(!line.equals("")){
                    String name = getName(line);
                    int processingNumber = getProcessingNumber(line);
                    String state = getState(line);
                    int policySource = getPolicy(line);

                    String conditionId = getConditionId(line);
                    String conditionData = getConditionData(line);
                    String profileId = getProfileId(line);
                    String profileData = getProfileData(line);

                    //save Nps and add to linkedHashSet
                    Storable nps = new Nps(line, name, processingNumber, state, policySource, conditionId, conditionData,
                            profileId, profileData);
                    //Storable nps = new Nps(line, name, processingNumber);
                    npsRecords.add(nps);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        return npsRecords;
    }

    @Override
    public String saveFile(Collection<Storable> treeSet) throws IOException {
        FileWriter csvFileWriter = new FileWriter("src/main/resources/com/fre/npsfxmaven/nps.txt", true);
        csvFileWriter.write("");
        BufferedWriter bufferedWriter = new BufferedWriter(csvFileWriter);

        PrintWriter writer = new PrintWriter("src/main/resources/com/fre/npsfxmaven/nps.txt");
        writer.print("");
        writer.close();

        for (Storable nps: treeSet) {
            System.out.println(nps.getFullLine());
            bufferedWriter.write(nps.getFullLine());
            bufferedWriter.write("\n");
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        return "Save completed";
    }

    public String saveFileAs(Collection<Storable> treeSet) throws IOException {
        //
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save file as");
        Stage stage = new Stage();
        String pathname = fileChooser.showOpenDialog(stage).getPath();
        //


        FileWriter csvFileWriter = new FileWriter(pathname, true);
        csvFileWriter.write("");
        BufferedWriter bufferedWriter = new BufferedWriter(csvFileWriter);

        PrintWriter writer = new PrintWriter("src/main/resources/com/fre/npsfxmaven/nps2.txt");
        writer.print("");
        writer.close();


        for (Storable nps: treeSet) {
            System.out.println(nps.getFullLine());
            bufferedWriter.write(nps.getFullLine());
            bufferedWriter.write("\n");
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        return "Save completed";
    }



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
