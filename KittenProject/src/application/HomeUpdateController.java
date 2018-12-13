/**
 * Home Update Controller
 * Authors: Logan Jenny, Rich Williams, Jake Owens, Isaiah Miller
 * version 1.0
 * 12/2018
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * @editor Isaiah Miller
 *
 */
public class HomeUpdateController extends Main implements Initializable {
	/**
	 * menuButton
	 */
	@FXML
	MenuButton menuButton;
	/**
	 * electricBill
	 */
	@FXML
	TextField electricBill;

	/**
	 * xOffset
	 */
	private double xOffset = 0;
	/**
	 * yOffset
	 */
	private double yOffset = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.fxml.Initializable#initialize(java.net.URL,
	 * java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// init
		// initialize all values to home values
		// grunt work below
		electricBill.setText("" + theHome.getMyElectricBill());
		electricBill.setText("" + myMainHome.getMyElectricBill());
	}

	/**
	 * updates home
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void update(MouseEvent event) throws IOException {
		changeScene("list.fxml", event);
		// change back to project list and update home values.
		// grunt work below
	}

	/**
	 * back
	 * 
	 * @param arg0
	 * @throws IOException
	 */
	@FXML
	void back(MouseEvent arg0) throws IOException {
		changeScene("list.fxml", arg0);
	}

	/**
	 * closes program
	 * 
	 * @param event
	 */
	@FXML
	void halt(MouseEvent event) {
		Platform.exit();
	}

	/**
	 * glow
	 * 
	 * @param event
	 */
	@FXML
	void hoverGlow(MouseEvent event) {
		((Node) event.getSource()).setEffect(new Glow(0.8));
	}

	/**
	 * glow
	 * 
	 * @param event
	 */
	@FXML
	void hoverShadow(MouseEvent event) {
		((Node) event.getSource()).setEffect(new Shadow(0.8, null));
	}

	/**
	 * unglow
	 * 
	 * @param event
	 */
	@FXML
	void unglow(MouseEvent event) {
		((Node) event.getSource()).setEffect(null);
	}

	/**
	 * opens about page
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void about(MouseEvent event) throws IOException {
		Stage stage = new Stage();
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle("About");
		stage.getIcons().add(new Image("application/resources/constructlogo.png"));
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("aboutPage.fxml")); // maybe the issue
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

		// movability section
		// grab your root here
		root.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});

		// move around here
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				stage.setX(event.getScreenX() - xOffset);
				stage.setY(event.getScreenY() - yOffset);
			}
		});
	}
}
