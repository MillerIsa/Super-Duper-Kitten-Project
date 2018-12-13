/**
 * FileChooser DIY - Utility class for returning the File specified by the user for import/export
 * Authors: Logan Jenny, Rich Williams, Jake Owens, Isaiah Miller
 * version 1.0
 * 12/2018
 */
package application;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Date: 11/21/18
 * Utility class for returning the File specified by the user for import/export
 * @author Rich Williams
 * @author Isaiah Miller
 */
public final class FileChooserDIY {
	public static final String REL_PATH = "src" + File.separatorChar + "application" + File.separatorChar + "save";

	/**
	 * Date: 11/23/18
	 * @pre:cwd is KittenProject/
	 * @post:User selects a file after being shown a filechooser starting in this
	 *            programs save folder
	 * @return the non-null file specified by the user
	 * @author Rich Williams
	 * @author Isaiah Miller
	 */
	public static File specOpenFile(final Stage theStage) {
		FileChooser fileChooser = chooserForSaveDir();
		fileChooser.setTitle("Open");
		File file = fileChooser.showOpenDialog(theStage);
		return file;
	}

	/**
	 * Date: 11/23/18
	 * @author Isaiah Miller
	 * @pre:cwd is KittenProject/
	 * @post:User selects a file destination after being shown a filechooser
	 *            starting in this programs save folder
	 * @param theStage The stage that the file chooser will block user input on.
	 * @return the non-null file specified by the user
	 */
	public static File specSaveFile(final Stage theStage) {
		FileChooser fileChooser = chooserForSaveDir();
		fileChooser.setTitle("Save");
		File file = fileChooser.showSaveDialog(theStage);
		return file;
	}

	/**
	 * Date: 12/8/18
	 * @author Isaiah Miller
	 * @pre none
	 * @post none
	 * @return A FileChooser that opens in the save folder for the project.
	 */
	private static FileChooser chooserForSaveDir() {
		FileChooser fileChooser = new FileChooser();
		final String userDir = System.getProperty("user.dir");
		final String initDir = userDir + File.separatorChar + REL_PATH;
		fileChooser.setInitialDirectory(new File(initDir));
		return fileChooser;
	}

}