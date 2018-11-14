package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Main extends Application {
		public double version = 1.00;
//	    private double xOffset = 0;
//	    private double yOffset = 0;
	    public Home theHome = new Home();

	 @Override
	    public void start(Stage stage) throws Exception {
		 	//stage.initStyle(StageStyle.UNDECORATED); //makes it borderless
		 	stage.setTitle("Kitten-Construction");
		 	stage.getIcons().add(new Image("application/resources/constructlogo.png"));
	        Parent root = (Parent) FXMLLoader.load(getClass().getResource("kittenproject.fxml")); //maybe the issue
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.setResizable(false);
	        stage.show();

//	      //grab your root here
//           root.setOnMousePressed(new EventHandler<MouseEvent>() {
//           @Override
//           public void handle(MouseEvent event) {
//               xOffset = event.getSceneX();
//               yOffset = event.getSceneY();
//           }
//       });
//
//       //move around here
//           root.setOnMouseDragged(new EventHandler<MouseEvent>() {
//           @Override
//           public void handle(MouseEvent event) {
//               stage.setX(event.getScreenX() - xOffset);
//               stage.setY(event.getScreenY() - yOffset);
//           }
//       });
	    }

	 	public void changeScene(String A, MouseEvent event) throws IOException {
	 		Parent newb = FXMLLoader.load(getClass().getResource(A));
	        Scene newbScene = new Scene(newb);
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        //sets new scene
	        window.setScene(newbScene);
	        window.show();
	 	}

	 	public String getVersion() {
	 		return Double.toString(version);
	 	}

	    /**
	     * MAIN GO GO
	     */
	    public static void main(String[] args) {
	    	launch(args);
	    }
}
