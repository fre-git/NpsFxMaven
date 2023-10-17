package com.fre.npsfxmaven;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReaderAndWriter {
    File file;

    public File readFile(String file){
        return new File(file);
    }

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
                    //save Nps and add to linkedHashSet
                    Storable nps = new Nps(line, name, processingNumber);
                    npsRecords.add(nps);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        return npsRecords;
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
}
