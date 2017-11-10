package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Parser {
    private static Map<String,Integer> result;


    Parser(){
        result = new HashMap<>();
    }

    public void countJavaWords(String javaReservedWorlds, String inputFile, String outputFile){
        try (FileWriter fileToWriteIn = new FileWriter(outputFile);
             FileReader javaWords = new FileReader(javaReservedWorlds);
             FileReader fileToReadFrom = new FileReader(inputFile))
        {
            ArrayList<Character> charStreamJavaWords= new ArrayList<>();
            while(javaWords.read() > 0) {
                charStreamJavaWords.add((char) javaWords.read());
            };

            ArrayList<Character> charStreamInputFile = new ArrayList<>();
            while(fileToReadFrom.read() > 0){
                charStreamInputFile.add((char) fileToReadFrom.read());
            }

            char[] charsJavaWords = new char[charStreamJavaWords.size()];
            char[] charsInputFile = new char[charStreamInputFile.size()];

            int index = 0;
            for (Character ch:charStreamInputFile) {
                charsInputFile[index] = ch;
                index++;
            }
            index = 0;
            for (Character ch:charStreamJavaWords) {
                charsJavaWords[index] = ch;
                index++;
            }

            String javaWords_String = new String(charsJavaWords);
            String[] arrayOfReservedWords = javaWords_String.split(" ");

            for (String word:arrayOfReservedWords) {
                System.out.println(word);
            }

            String fileToReadFrom_String = new String(charsInputFile);
            String[] arrayInputFile = fileToReadFrom_String.split("\\s");

            for (int i = 0; i < arrayOfReservedWords.length; i++) {
                int count = 0;
                for (int j = 0; j < arrayInputFile.length; j++) {
                    if(arrayOfReservedWords[i].equals(arrayInputFile[j])) {
                        result.put(arrayOfReservedWords[i],++count);
                    }
                }
            }

            String[] result_String = new String[result.size()];
            index = 0;
            for (Map.Entry entry : result.entrySet()){
                result_String[index] = "Word " + "\"" + entry.getKey() + "\"" +
                        " was used in file "
                        + inputFile + " "
                        + entry.getValue() + " times.\n";
                index++;
            }

            StringBuilder stringBuilder= new StringBuilder();
            for (String aResult_String : result_String) {
                stringBuilder.append(aResult_String);
            }

            fileToWriteIn.write(stringBuilder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
