package com.fre.npsfxmaven.model;

import com.fre.npsfxmaven.util.StringProcessor;
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

                    String name = StringProcessor.getName(line);
                    int processingNumber = StringProcessor.getProcessingNumber(line);
                    String state = StringProcessor.getState(line);
                    int policySource = StringProcessor.getPolicy(line);
                    String conditionId = StringProcessor.getConditionId(line);
                    String conditionData = StringProcessor.getConditionData(line);
                    String profileId = StringProcessor.getProfileId(line);
                    String profileData = StringProcessor.getProfileData(line);

                    //save Nps and add to treeSet
                    Storable nps = new Nps(name, processingNumber, state, policySource, conditionId, conditionData,
                            profileId, profileData);
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
    public String saveFile(Collection<Storable> treeSet, String pathName) throws IOException {
        FileWriter csvFileWriter = new FileWriter(pathName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(csvFileWriter);

        //empty file before saving
        PrintWriter writer = new PrintWriter(pathName);
        writer.print("");
        writer.close();

        for (Storable nps: treeSet) {
            bufferedWriter.write(nps.getFullLine());
            bufferedWriter.write("\n");
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        return "Save completed";
    }

    public String saveFileAs(Collection<Storable> treeSet) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save file as");
        Stage stage = new Stage();
        String pathname = fileChooser.showOpenDialog(stage).getPath();

        FileWriter csvFileWriter = new FileWriter(pathname, true);
        BufferedWriter bufferedWriter = new BufferedWriter(csvFileWriter);

        //Empty file before saving
        PrintWriter writer = new PrintWriter(pathname);
        writer.print("");
        writer.close();

        for (Storable nps: treeSet) {
            bufferedWriter.write(nps.getFullLine());
            bufferedWriter.write("\n");
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        return "Save completed";
    }
}
