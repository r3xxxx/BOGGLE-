//REX GODBOUT
//CS110
//CELL PANE CLASS

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.text.Font; 
import javafx.scene.shape.Shape;
import javafx.scene.paint.ImagePattern;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.IllegalArgumentException;

//CELL PANE CLASS
public class CellPane extends HBox
{

   
   private int row; // cell knows it's row/col location
   private int col;
  
  /**
      Constructor for Cell Pane class 
      @param r for row 
      @param c for col
   */
   public CellPane(Tile tile, int r, int c)
   {
      this.setStyle("-fx-border-color: brown;"
               +"-fx-border-width: 5;"
               + "-fx-font-size: 50;"+ "-fx-font-family: Courier New;"
               + "-fx-background-color: white;");
      
      
      this.setPrefSize(100,100);
      row = r;
      col = c;
      setCell(tile.toString());
      
      this.setAlignment(Pos.CENTER);
      
      
      
   }
   /**
      gets row 
      @return row  
   */
   public int getRow()
   {
      return row;
   }
   /**
      gets col 
      @return col  
   */
   public int getCol()
   {
      return col;
   }
   /**
      sets cell 
      @param ch
      @return ch to set cell   
   */
   public void setCell(String ch)
   {
      
      this.getChildren().add(new Text(ch));       
       
   }
   



}