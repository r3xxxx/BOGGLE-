//REX GODBOUT
//CS110
//BOGGLE

import java.util.ArrayList;

/**
 word class for calculating points and displaying words
 */
public class Word {

    private ArrayList<Tile> wordList;
    private int points;

    /**
     constructor for word class
     @param wordList arrayList of tile objects used to create word
     */
    public Word(ArrayList<Tile> wordList) {
        this.wordList = wordList;
        updateScore();
    }

    /**
     returns word list
     @return ArrayList of tile objects
     */
    public ArrayList<Tile> getWordList() {
        return wordList;
    }

    /**
     sets worlist
     @param wordList ArrayList of Tile objects
     */
    public void setWordList(ArrayList<Tile> wordList) {
        this.wordList = wordList;
        updateScore();
    }

    /**
     returns point value of a word
     @return point value of a word
     */
    public int getPoints() {
        return points;
    }

    /**
     sets point variable when word changes or a new word is created
     */
    private void updateScore() {
        switch (this.toString().length()){
        
            case 1:
                break;
            case 2:
                break;
            case 3:
                this.points = 1;
                break;
            case 4:
                this.points = 1;
                break;
            case 5:
                this.points = 2;
                break;
            case 6:
                this.points = 3;
                break;
            case 7:
                this.points = 5;
                break;
            default:
                this.points = 11;
        }

    }

    /**
     overriden toString for word class
     @return string of word
     */
    @Override
    public String toString() {
        String out = "";
        for(Tile t : wordList) {
            out += t.toString();
        }
        return out;
    }
}