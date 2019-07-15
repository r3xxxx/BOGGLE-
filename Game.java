//REX GODBOUT
//CS 110 
//GAME CLASS for boggle 

import java.util.ArrayList;
import java.io.*;
import java.lang.Math;

public class Game { 
//is valid selection will take in row and column will return true if adjacent to tile 
   /**
      Constructor for Game class 
   */

   public Game() {
   
   selected= new ArrayList<Tile>();
   score = 0; 
   board = new Board();
   try {
      dict = new Dictionary("Dictionary.txt");
   } catch (IOException e) {
      System.out.print(e);
   }
   words = new ArrayList<String>();
   }
   
   private ArrayList<Tile> selected;
   private ArrayList<String> words;
   private int score;
   private Board board;
   private Dictionary dict;
   
   
   /**
      determines if selection is valid 
      @return true/false it returns true or false if selection is valid or not
      @param row 
      @param col
   */
   
   public boolean isSelected(int row, int col){
   
   return board.getTile(row,col).isSelected();
   }
   
   
   
   public boolean isValidSelection(int row, int col){
   
   if (selected.isEmpty()){return true;}
  
   int rowSelect = selected.get(selected.size()-1).getRow(); 
   int colSelect = selected.get(selected.size()-1).getColumn();
   
   if ((Math.abs(rowSelect-row) ==1 | Math.abs(colSelect-col)== 1) 
      && (Math.abs(rowSelect-row)<2 && Math.abs(colSelect-col)<2)){
      
      return true;
      
      }
   return false;  
   }      
   /**
      adds to selected if selection is valid
      @param row 
      @param col
   */
   public void addToSelected(int row,int col){
  
      if (isValidSelection(row,col)){
      board.getTile(row, col).setSelected(true);
      selected.add(board.getTile(row, col));
      }
   
   }
   
   /**
     gets tile from board
     @return Tile  
     @param row 
     @param col 
   */
   public Tile getTile(int row, int col){
      return board.getTile(row, col);
   }
   
   
   /**
      removes last character selected in selected bank 
      @param row 
      @param col
   */
   //(selected.size()-1) is get last index 
   public void removeFromSelected(int row, int col){
   
      if(row == selected.get(selected.size()-1).getRow() 
         && col == selected.get(selected.size()-1).getColumn()){
         selected.remove(selected.size()-1);
         board.getTile(row, col).setSelected(false);
      } 

   
   }
   /**
      returns all selected tiles from array list 
      @return selected it returns all selected tiles from array list    
   */
   public ArrayList<Tile> getSelectedTiles(){

      return selected;
   }
   /**
      clears selected characters from selected bank
   */
   public void clearSelected(){
   
   for (Tile t : selected){
      t.setSelected(false);
   }
   selected.clear();

   }
   /**
     tests selected characters if they create a word and adds point to score 
     @return true/false it returns true or false if word is valid or not 
   */
   public boolean testSelected(){
      
      Word points = new Word(selected);
   
      if (dict.isValidWord(selected) && !words.contains(points.toString())){
         words.add(points.toString());
         score+=points.getPoints();
         clearSelected();
      return true; 
      
      }
   return false;
   }
   
   public int getScore() {
      return score;
   }
   
   public ArrayList<String> getWords(){
      return words;
   }

/**
overriden to string for board class
@return out it returns string representation of board selected characters, tested words, and score
*/
   @Override
      public String toString() {
         String out = board.toString();
            out+="\nSelected:"+selected;
      
            out+="\nwords:"+ words; 
       
            out+="\nScore:"+score;
       
         return out;

      }
}