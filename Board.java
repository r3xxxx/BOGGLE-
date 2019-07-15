//REX GODBOUT
//CS110
//BOGGLE

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 board stores play-field for game
 */
public class Board {

    private ArrayList<String> dice;
    private ArrayList<ArrayList<Tile>> board;

    /**
     constructor for board, generates board list and fills in tile spots
     */
    public Board() {
        dice = new ArrayList<>();
        board = new ArrayList<>();

        dice.add("rifobx");
        dice.add("ifehey");
        dice.add("denows");
        dice.add("utoknd");
        dice.add("hmsrao");
        dice.add("lupets");
        dice.add("acitoa");
        dice.add("ylgkue");
        dice.add("qbmjoa");
        dice.add("ehispn");
        dice.add("vetign");
        dice.add("baliyt");
        dice.add("ezavnd");
        dice.add("ralesc");
        dice.add("uwilrg");
        dice.add("pacemd");

        this.board.add(new ArrayList<>());
        this.board.add(new ArrayList<>());
        this.board.add(new ArrayList<>());
        this.board.add(new ArrayList<>());

        Collections.shuffle(dice);

        Random r = new Random();

        int diceCount = 0;
         
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++) {
                this.board.get(i).add(new Tile(dice.get(diceCount).charAt(r.nextInt(6)), i, j));
                diceCount++;
            }
        }
    }

     public Tile getTile(int row, int col){
     return board.get(row).get(col);
     }
    /**
     overriden to string for board class
     @return out it returns string representation of board
     */
    @Override
    public String toString() {
        String out = "";
        for(ArrayList<Tile> row : board) {
            for(Tile t : row) {
                out += t.toString();
                out += "\t";
            }
            out += "\n";
        }
        return out;
    }
}