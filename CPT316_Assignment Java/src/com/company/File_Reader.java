package com.company;

import java.io.*;

public class File_Reader {

    // Find the total num of lines in the file
    int read_numlines() {
        int numLines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("wordlist.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                numLines++;
            }
            reader.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return numLines;
    }

    // Print the strings read from the text file into the array words
    void print_array(String [] words) {
        int count = 0;

        try{
            BufferedReader reader = new BufferedReader(new FileReader("wordlist.txt"));
            String line;

            while((line = reader.readLine()) != null)
            {
                words[count] = line;
                count++;
            }

            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    void print_file(String[] words) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("quickSortResults.txt")); // Creation of a text file

            // Output the sorted array into the text file
            for(int i = 0; i < words.length; i++) {
                writer.write(words[i]+"\n");
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
