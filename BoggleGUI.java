//REX GODBOUT 
//CS 110
//BOGGLE GUI


//imports for GUI
import javafx.application.Application; 
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.geometry.Pos;


//GUI CLASS
public class BoggleGUI extends Application
{
   private Game game; // the "guts" of the game
   private GridPane grid;  // the board of squares
   private BorderPane mainPane;  // primary layout of application
   private VBox statusPane, endPane;  // place for messages
   private Text status;  
   private Text score;//text elements
   private Text selected;
   private Text wordTested;
   private Text title;
   private HBox buttonPane; 
   private Button exit, newGame, testWord, clearWord;
   
   //CREATE GAME 
   @Override
   public void start(Stage primaryStage) {
      primaryStage.setTitle("BOGGLE by Rex");
      // set up panes
      mainPane = new BorderPane();
      mainPane.setPadding(new Insets(10, 10, 10, 10));
      
      grid = new GridPane();
      grid.setAlignment(Pos.CENTER);
      
      // intialize game 
      game = new Game(); 
      mainPane.setCenter(grid);
      statusPane = new VBox();
      title = new Text("BOGGLE");
      score = new Text("SCORE");
      selected = new Text("Characters selected");
      wordTested = new Text("Words picked!");
      title.setFont(Font.font("Courier New",50));
      score.setFont(Font.font("Arial",14));
      wordTested.setFont(Font.font("Arial",14));
      selected.setFont(Font.font("Arial",14));
      
      
      statusPane.getChildren().add(title);
      statusPane.getChildren().add(score);
      statusPane.getChildren().add(selected);
      statusPane.getChildren().add(wordTested);
      
      statusPane.setAlignment(Pos.CENTER);
      status = new Text("");
      
      statusPane.getChildren().add(status);

      mainPane.setTop(statusPane);
      
      mainPane.setMargin(grid, new Insets(20));
      
      //DRAW BOARD
      drawBoard();
      
      buttonPane = new HBox(40);
      buttonPane.setAlignment(Pos.CENTER);
       
       //clear word button     
      testWord = new Button("TEST WORD");
      testWord.setOnAction( new EventHandler<ActionEvent>() {
         
         public void handle(ActionEvent e)
         {
            if(game.testSelected()) {
            drawBoard();
            } else {
            drawBoard();
            statusPane.getChildren().add(new Text("Word selection is invalid"));
            }
            
         }
       });
      buttonPane.getChildren().add(testWord);
      
      //clear word button
      clearWord = new Button("CLEAR WORD");
      clearWord.setOnAction( new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
            game.clearSelected();
            drawBoard();
                     }
       });
      buttonPane.getChildren().add(clearWord);

       //new game button
      newGame = new Button("NEW GAME");
      newGame.setOnAction( new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
            game = new Game();
            mainPane.setCenter(grid);
            drawBoard();
            status.setText("");
         }
       });
      buttonPane.getChildren().add(newGame);
      
      //end game button
      exit = new Button("END GAME");
      exit.setOnAction( new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
            statusPane.getChildren().clear();
            grid.getChildren().clear(); // clear the board
      
            title.setText("BOGGLE");
            score.setText("SCORE: " + game.getScore());
            wordTested.setText("Words picked: " + game.getWords());
      
            statusPane.getChildren().add(title);
            
            endPane = new VBox();
            endPane.getChildren().add(score);
            endPane.getChildren().add(wordTested);
            
            mainPane.setCenter(endPane);
            
         }
      });
      buttonPane.getChildren().add(exit);

      
      // complete setup
      mainPane.setBottom(buttonPane);
      Scene scene = new Scene(mainPane);
      primaryStage.setScene(scene);
      primaryStage.show();
      
      
   }
   // event handler for user clicking on a tile
   public void handleClick(MouseEvent e)
   {  
      CellPane cp = (CellPane)(e.getSource());
      
      int row = cp.getRow();
      int col = cp.getCol();
       
       
      // add tile to selected tiles or remove last tile from selected
      
       if (game.getSelectedTiles().contains(game.getTile(row,col))){
             game.removeFromSelected(row,col);
             drawBoard();
            
                 
       } else if (!game.isValidSelection(row, col)) {
            drawBoard();
            statusPane.getChildren().add(new Text("letter selection is invalid"));
                       
      }else{
             game.addToSelected(row, col);
             drawBoard();
      }
       
   }   
   // using information from game, create cell panes
   public void drawBoard()
   {
      statusPane.getChildren().clear();
      
      title.setText("BOGGLE");
      score.setText("SCORE: " + game.getScore());
      selected.setText("Characters selected: " + game.getSelectedTiles());
      wordTested.setText("Words picked: " + game.getWords());
      
      statusPane.getChildren().add(title);
      statusPane.getChildren().add(score);
      statusPane.getChildren().add(selected);
      statusPane.getChildren().add(wordTested);
      
      grid.getChildren().clear(); // clear the board
      for (int r = 0; r < 4;r++)
         for (int c = 0; c < 4;c++)
         {  
            CellPane cp = new CellPane(game.getTile(r,c),r,c);
            if (!game.isSelected(r, c)) {
            
               cp.setStyle("-fx-border-color: brown;"
               +"-fx-border-width: 5;"
               + "-fx-font-size: 50;"+ "-fx-font-family: Courier New;"
               + "-fx-background-color: white;");
               
            } else {
            
               cp.setStyle("-fx-border-color: brown;"
               +"-fx-border-width: 5;"
               + "-fx-font-size: 50;"+ "-fx-font-family: Courier New;"
               + "-fx-background-color: grey;");
               
               
            }
            cp.setOnMouseClicked(this::handleClick);
            grid.add(cp,c,r);
         }
            
   }
   //launch game
   public static void main(String [] args) {
      launch(args);
   }
}