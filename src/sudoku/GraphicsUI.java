package sudoku;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class GraphicsUI extends Application {
		Button B = new Button("Solve");
		Button C = new Button("Clear");
		TilePane topbox = new TilePane();
		BorderPane root = new BorderPane();
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("SudokuSolver");

	
		root.setTop(topbox);
		HBox hbox = new HBox();
		root.setBottom(hbox);
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.getChildren().addAll(B, C);

		Scene scene = new Scene(root, 360, 385);

		topbox.setPrefColumns(9);
		topbox.setPrefRows(9);
		final int SIZE = 40;
		int counter = 0;
		for (int i = 0; i < 9; i++) {
			for (int k = 0; k < 9; k++) {
				counter ++;
				
				TextField label = new TextField();
				label.setAlignment(Pos.CENTER);
				label.setPrefSize(SIZE, SIZE);
				
				if (((k < 3 || k > 5) && (i < 3 || i > 5)) || ((i > 2 && i < 6) && (k > 2 && k < 6))) {
					label.setStyle("-fx-border-color : black;" + "-fx-font-size: 16;");

				}
				else{
					label.setStyle("-fx-background-color : pink;" + "-fx-border-color : black;"+ "-fx-font-size: 16;");
				}
				topbox.getChildren().add(label);
				
				
			}
		}
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		
		
		B.setOnAction(event -> {
		//läsa in alla inputs i en array
			//sedan skall denna översättas till barnen i topboxen 
		TextField label = (TextField) topbox.getChildren().get(1);
		System.out.println(label.getText());
		
		});
		
		
		

	}
	
	public Board getFromWindow(){
		int value;
		int[] array = new int[81];
		String text;
		for(int i = 0; i <=81; i++) {
            
            	TextField label = (TextField) topbox.getChildren().get(i);
        		text = label.getText();
        		if(text == ""){
        			text = "0";
        		}
        		value = Integer.parseInt(text);
        		
        		if(value>=0){
        			array[i] = value;	
        		}
        		
            	
                
            }
        Board board = new Board();
        int index = 0;
        for (int i = 0; i < 9; i++) {
			for (int k = 0; k < 9; k++) {
				board.set(k, i, array[index]);
				index++;
			}
        }	
		return board;
	}
	
	public boolean writeToWindow(Board board){
		return false;
		
	}
}

