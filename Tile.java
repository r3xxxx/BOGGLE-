//REX GODBOUT
//CS110
//BOGGLE

/**
Tile class used to represent letters on the board
 */
public class Tile {

    private int row;
    private int column;
    private char letter;
    private boolean isSelected;

    /**
     constructor for tile class
     @param letter letter for tile
     @param row row for tile
     @param column column for tile
     */
    public Tile(char letter, int row, int column) {
        this.row = row;
        this.column = column;
        this.letter = letter;
        this.isSelected = false;
    }

    /**
     secondary constructor for Qu case
     @param letter letter for tile, taken from first char of string
     @param row row for tile
     @param column column for tile
     */
    public Tile(String letter, int row, int column) {
        this.row = row;
        this.column = column;
        this.letter = letter.charAt(0);
        this.isSelected = false;
    }

    /**
     returns tile row
     @return tile row
     */
    public int getRow() {
        return row;
    }

    /**
     sets tile row
     @param row tile row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     returns tile column
     @return tile column
     */
    public int getColumn() {
        return column;
    }

    /**
     sets tile column
     @param column tile column
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     returns tile letter
     @return tile letter
     */
    public char getLetter() {
        return letter;
    }

    /**
     sets tile letter
     @param letter tile letter
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

    /**
     sets letter from string for QU case
     @param letter string of letter takes char at 0
     */
    public void setLetter(String letter) {
        this.letter = letter.charAt(0);
    }

    /**
     returns selected value
     @return if tile is selected
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     sets selection value
     @param selected selection value of tile
     */
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    /**
     overridden to string
     @return string representation of tile
     */
    @Override
    public String toString() {
        if(letter == 'q') return "qu";
        return Character.toString(letter);
    }

}