//REX GODBOUT
//CS110
//BOGGLE

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 Dictionary class used to check if words are valid
 */
public class Dictionary {


    private ArrayList<String> dict;

    /**
     constructor for dictionary class
     @param file text file where dictionary is stored
     */
    public Dictionary(String file) throws IOException  {
        
        dict = new ArrayList<String>();
        
        Scanner inFile;
        File toRead;
        
        try {
           toRead = new File(file);
           inFile = new Scanner(toRead);
           
           
           while (inFile.hasNext()) {
   
               dict.add(inFile.nextLine());
   
           }
           
           inFile.close();
           
        } catch (IOException e) {
           System.out.print(e);
        } 
    }


    /**
     determines if word is valid
     @param wordList takes in list of tiles of object
     @return out returns whether or not term is valid
     */
    public boolean isValidWord(ArrayList<Tile> wordList) {
        String out = "";
        for(Tile t : wordList) {
            out += t.toString();
        }

        return dict.contains(out) && out.length() > 2;

    }








}