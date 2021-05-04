package no.ntnu.imt3281.sudoku;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class SudokuController {
	
	ResourceBundle messages = ResourceBundle.getBundle("I18N.messages");
	
	Sudoku sudoku = new Sudoku();
	
    @FXML
    private Button Start;
    
    @FXML
    private GridPane gpKing;

    @FXML
    private TextField f0;

    @FXML
    private TextField f1;

    @FXML
    private TextField f2;

    @FXML
    private TextField f3;

    @FXML
    private TextField f4;

    @FXML
    private TextField f5;

    @FXML
    private TextField f6;

    @FXML
    private TextField f7;

    @FXML
    private TextField f8;

    @FXML
    private TextField f9;

    @FXML
    private TextField f10;

    @FXML
    private TextField f11;

    @FXML
    private TextField f12;

    @FXML
    private TextField f13;

    @FXML
    private TextField f14;

    @FXML
    private TextField f15;

    @FXML
    private TextField f16;

    @FXML
    private TextField f17;

    @FXML
    private TextField f18;

    @FXML
    private TextField f19;

    @FXML
    private TextField f20;

    @FXML
    private TextField f21;

    @FXML
    private TextField f22;

    @FXML
    private TextField f23;

    @FXML
    private TextField f24;

    @FXML
    private TextField f25;

    @FXML
    private TextField f26;

    @FXML
    private TextField f27;

    @FXML
    private TextField f28;

    @FXML
    private TextField f29;

    @FXML
    private TextField f30;

    @FXML
    private TextField f31;

    @FXML
    private TextField f32;

    @FXML
    private TextField f33;

    @FXML
    private TextField f34;

    @FXML
    private TextField f35;

    @FXML
    private TextField f36;

    @FXML
    private TextField f37;

    @FXML
    private TextField f38;

    @FXML
    private TextField f39;

    @FXML
    private TextField f40;

    @FXML
    private TextField f41;

    @FXML
    private TextField f42;

    @FXML
    private TextField f43;

    @FXML
    private TextField f44;

    @FXML
    private TextField f45;

    @FXML
    private TextField f46;

    @FXML
    private TextField f47;

    @FXML
    private TextField f48;

    @FXML
    private TextField f49;

    @FXML
    private TextField f50;

    @FXML
    private TextField f51;

    @FXML
    private TextField f52;

    @FXML
    private TextField f53;

    @FXML
    private TextField f54;

    @FXML
    private TextField f55;

    @FXML
    private TextField f56;

    @FXML
    private TextField f57;

    @FXML
    private TextField f58;

    @FXML
    private TextField f59;

    @FXML
    private TextField f60;

    @FXML
    private TextField f61;

    @FXML
    private TextField f62;

    @FXML
    private TextField f63;

    @FXML
    private TextField f64;

    @FXML
    private TextField f65;

    @FXML
    private TextField f66;

    @FXML
    private TextField f67;

    @FXML
    private TextField f68;

    @FXML
    private TextField f69;

    @FXML
    private TextField f70;

    @FXML
    private TextField f71;

    @FXML
    private TextField f72;

    @FXML
    private TextField f73;

    @FXML
    private TextField f74;

    @FXML
    private TextField f75;

    @FXML
    private TextField f76;

    @FXML
    private TextField f77;

    @FXML
    private TextField f78;

    @FXML
    private TextField f79;

    @FXML
    private TextField f80;

    /**
    *	Initiates the sudoku game
    *
    *	- Resets the board in case you want a new game
    *	- Does "randomFunction" 10 times to randomize the board
    *	- Puts the board on the fx and locks the fields with numbers already there
    */
    @FXML
    void startButton(ActionEvent event) {    	
    	Start.setText(messages.getString("startNewGame"));
    	//Start.setPrefWidth(200);
    	int  min=1, max=5, randomX=0, randomY=0;
    	sudoku.resetBoard();
    	sudoku.temp();
    	Random rand = new Random();
    	
    	for (int i=min; i<=10; i++) {
    		int randomFunction = rand.nextInt((max - min) + 1) + min;
    		
    		while (randomX == randomY) {
    			randomX = rand.nextInt((9 - min) + 1) + min;
        		randomY = rand.nextInt((9 - min) + 1) + min;
    		}
    		
    		switch (randomFunction) {
    		case 1:
    			sudoku.replaceNumber(randomX, randomY);
    			break;
    		case 2:
    			sudoku.flipVertical();
    			break;
    		case 3:
    			sudoku.flipHorizontal();
    			break;
    		case 4:
    			sudoku.flipDiagonalLeft();
    			break;
    		case 5:
    			sudoku.flipDiagonalRight();
    			break;
    		default:
    			break;
    		}
    		
    	}
    	int j = 0;
    	
    	for (Node node: gpKing.getChildren()) {
    		if (j<81) {
    			if (sudoku.brett[j] > 0 && sudoku.brett[j] < 10) {
    				((TextField) node).setText(String.valueOf(sudoku.brett[j]));
    				((TextField) node).setDisable(true);
    				((TextField) node).setStyle("-fx-background-color: lightgray;");
    			} else {
    				((TextField) node).setText(null);
    				((TextField) node).setDisable(false);
    				((TextField) node).setStyle("-fx-background-color: white;");
    			}
    			j++;
    		}
    	}
    	
    }
    

	/**
	 * When user presses enter on a field checks content
	 * 
	 * if content is invalid clears field
	 *
	 * valid content gets checked against row column and block
	 * if it exists in any of those puts background color to red
	 * 
	 * lastly checks if input completed the game and sends msg if it is won
	 */
    @FXML
    void onEnter(ActionEvent ae){
		TextField field = (TextField) ae.getSource();
	    Pattern pattern = Pattern.compile("[1-9]{1}");
	    if(field.getText() != null) {
	    if (!pattern.matcher(field.getText()).matches()) {
	    	sudoku.insertCoord(GridPane.getColumnIndex(field), GridPane.getRowIndex(field), 0);
    		field.setStyle("-fx-background-color: white;");
	        field.setText(null);
	    }else {
	    	Integer num = Integer.parseInt(field.getText());
	    	sudoku.insertCoord(GridPane.getColumnIndex(field), GridPane.getRowIndex(field), num);
	    	try {
	    		sudoku.checkColumn(GridPane.getColumnIndex(field), GridPane.getRowIndex(field), num);
	    		sudoku.checkRow(GridPane.getColumnIndex(field), GridPane.getRowIndex(field), num);
	    		sudoku.checkBlock(GridPane.getColumnIndex(field), GridPane.getRowIndex(field), num);
	    		field.setStyle("-fx-background-color: white;");
	    		 
	    	}
	    	catch(BadNumberException e){
	    		field.setStyle("-fx-background-color: red;");
	    	}
	    	if (sudoku.isdone()) {
	    		Stage window = new Stage();
	    		
	    		window.initModality(Modality.APPLICATION_MODAL);
	    		window.setTitle(messages.getString("wonTitle"));
	    		window.setMinWidth(300);
	    		window.setMinHeight(225);
	    		
	    		Label label = new Label();
	    		label.setText("\n" + messages.getString("wonMessage") + messages.getString("wonThumbsUp"));
	    		Button closeButton = new Button(messages.getString("exit"));
	    		closeButton.setOnAction(e -> window.close());
	    		
	    		VBox layout = new VBox(10);
	    		layout.getChildren().addAll(label, closeButton);
	    		layout.setAlignment(Pos.CENTER);
	    		
	    		Scene scene = new Scene(layout);
	    		window.setScene(scene);
	    		window.showAndWait();
	    	}
	    }
	    }
    }
}
