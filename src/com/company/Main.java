package com.company;

class Main{
    public static void main(String[] args) {
        String javaReservedWorlds = "C:\\Users\\Артём\\epam_hw4_task2\\resources\\JavaReservedWorlds.txt";
        String inputFile             = "C:\\Users\\Артём\\epam_hw4_task2\\src\\com\\company\\Parser.java";
        String outputFile            = "outputFile.txt";

        Parser parser = new Parser();
        parser.countJavaWords(javaReservedWorlds, inputFile, outputFile);

    }
}
