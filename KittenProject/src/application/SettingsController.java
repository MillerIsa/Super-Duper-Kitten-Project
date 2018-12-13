/**
 * Settings Page Controller
 * Authors: Logan Jenny, Rich Williams, Jake Owens, Isaiah Miller
 * version 1.0
 * 12/2018
 */
package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/*
 * should contain an instance of Settings
 * Should contain an instance of FileChooserDIY which it will pass 
 * the settings instance to
 */
public class SettingsController {
	/**
	 * mySettings
	 */
	final Settings mySettings;
	/**
	 * myNameField
	 */
	@FXML
	TextField myNameField;
	/**
	 * myEmailField
	 */
	@FXML
	TextField myEmailField;

	/**
	 * sets the settings
	 * @param theSettings
	 */
	public SettingsController(final Settings theSettings) {
		mySettings = theSettings;
	}

	
	/**
	 * @author Isaiah Miller
	 * Called by JavaFX to initialize this controller
	 * after the constructor is called
	 */
	@FXML
	private void initialize() {
		// initialize text Field contents
		if (mySettings.getMyName() != null) {
			myNameField.setText(mySettings.getMyName());
		}
		if (mySettings.getMyEmailAddress() != null) {
			myEmailField.setText(mySettings.getMyEmailAddress());
		}
	}

	/**
	 * save settings
	 * @param event
	 */
	@FXML
	private void saveSettings(final MouseEvent event) {
		// save settings from the text fields to model object
		mySettings.setMyName(myNameField.getText());
		mySettings.setMyEmailAddress(myEmailField.getText());
		// close window
		((Stage) myNameField.getScene().getWindow()).close();
	}

}
