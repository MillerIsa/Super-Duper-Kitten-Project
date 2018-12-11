package application;

import java.io.File;
import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

//observe this with an export controller
public class menuBoxController extends Main {
	// needs a reference to ExportableDataAggregate

//	final Settings mySettings;
//	final ExportableDataAggregate myPersistentData;

//	/**
//	 * Date:11/30/18
//	 * 
//	 * @author Isaiah Miller
//	 * @param theSettings
//	 * @param thePersistentData
//	 */
//	public menuBoxController(/* final Settings theSettings, */ final ExportableDataAggregate thePersistentData) {
////		mySettings = theSettings;
//		myPersistentData = thePersistentData;
//	}

	@FXML
	void exportFile(final MouseEvent event) {
		// call File chooser's export method pass the stage
//		System.out.println("exportButton");
		final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		final File exportDest = FileChooserDIY.specSaveFile(stage);
		System.out.println("exporting all persistent data");
		if (exportDest != null) {
			
//			myPersistentData.exportJSON(exportDest);
		}
	}

	@FXML
	void importFile(MouseEvent event) {
		System.out.println("importButton");
		final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		final File importDest = FileChooserDIY.specOpenFile(stage);
		if (importDest != null) {
//			myPersistentData.getMySettings().importJSON(importDest);
		}
	}

//	/**
//	 * @author Isaiah Miller Opens the Settings view for modifying settings.
//	 * @throws IOException
//	 */
//	@FXML
//	void openSettingsView(MouseEvent event) throws IOException {
//		// open settings view, pass settings object
//
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(getClass().getResource("Settings.fxml"));
//		loader.setControllerFactory(new Callback<Class<?>, Object>() {
//			@Override
//			public Object call(Class<?> aClass) {
//				return new SettingsController(myPersistentData.getMySettings());
//			}
//		});
//
//		Stage stage = new Stage();
//		stage.setTitle("Settings");
//		stage.getIcons().add(new Image("application/resources/constructlogo.png"));
//
//		Parent root = (Parent) loader.load();
//		Scene scene = new Scene(root);
//		stage.setScene(scene);
//		stage.setResizable(false);
//		stage.show();
//	}

	@FXML
	void openUpdaterView(MouseEvent arg0) throws IOException {
		super.changeScene("edithome.fxml", arg0);

//     void openUpdaterView(MouseEvent event) throws IOException {
// 		changeScene("homeUpdaterPage.fxml", event);

	}

	@FXML
	void hoverGlow(MouseEvent event) {
		((Node) event.getSource()).setEffect(new Glow(0.8));
	}

	@FXML
	void unglow(MouseEvent event) {
		((Node) event.getSource()).setEffect(null);
	}

	@FXML
	void halt(MouseEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
	}
}