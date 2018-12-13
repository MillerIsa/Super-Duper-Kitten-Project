/**
 * Main Page Controller
 * Authors: Logan Jenny, Rich Williams, Jake Owens, Isaiah Miller
 * version 1.0
 * 12/2018
 */
package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class mainPageController extends Main {
	/**
	 * menuButton
	 */
	@FXML MenuButton menuButton;
    /**
     * xOffset
     */
    private double xOffset = 0;
    /**
     * yOffset
     */
    private double yOffset = 0;


	/**
	 * changes scene to the project list view
	 * @param event
	 * @throws IOException
	 */
	@FXML
    public void moveOn(MouseEvent event) throws IOException {
		//Sound.sounds[0].play();   // LET UR INNER CAT OUT
		changeScene("list.fxml", event);
    }
  
    /**
     * closes the program
     * @param event
     */
    @FXML
    void halt(MouseEvent event) {
        Platform.exit();
    }
    
    /**
     * glow
     * @param event
     */
    @FXML
    void hoverShadow(MouseEvent event) {
        ((Node) event.getSource()).setEffect(new Shadow(0.8, null));
    }
    
    /**
     * unglow
     * @param event
     */
    @FXML
    void unglow(MouseEvent event) {
        ((Node) event.getSource()).setEffect(null);
    }

    /**
     * opens about page
     * @param event
     * @throws IOException
     */
    @FXML
    void about(MouseEvent event) throws IOException {
    	Stage stage = new Stage();
    	stage.initStyle(StageStyle.UNDECORATED);
    	stage.setTitle("About");
	 	stage.getIcons().add(new Image("application/resources/constructlogo.png"));
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("aboutPage.fxml")); //maybe the issue
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
	      //grab your root here
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        }
    });

    //move around here
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        }
    });
    }
}