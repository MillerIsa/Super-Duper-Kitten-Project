/**
 * Menu Box Controller
 * Authors: Logan Jenny, Rich Williams, Jake Owens, Isaiah Miller
 * version 1.0
 * 12/2018
 */
package application;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class menuBoxController extends Main {

	/**
	 * mySettings
	 */

	/**
	 * exports file
	 * 
	 * @param event
	 */
	@FXML
	void exportFile(final MouseEvent event) {
		// call File chooser's export method pass the stage
		final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		final File exportDest = FileChooserDIY.specSaveFile(stage);
		if (exportDest != null) {

//			myPersistentData.exportJSON(exportDest);
		}
	}

	/**
	 * import file
	 * 
	 * @param event
	 */
	@FXML
	void importFile(MouseEvent event) {
		final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		final File importDest = FileChooserDIY.specOpenFile(stage);
		if (importDest != null) {
//			myPersistentData.getMySettings().importJSON(importDest);
		}
	}


	

	/**
	 * changes to the edit home screen
	 * 
	 * @param arg0
	 * @throws IOException
	 */
	@FXML
	void openUpdaterView(MouseEvent arg0) throws IOException {
		super.changeScene("edithome.fxml", arg0);


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
	 * unglow
	 * 
	 * @param event
	 */
	@FXML
	void unglow(MouseEvent event) {
		((Node) event.getSource()).setEffect(null);
	}

	/**
	 * closes program
	 * 
	 * @param event
	 */
	@FXML
	void halt(MouseEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
	}
}