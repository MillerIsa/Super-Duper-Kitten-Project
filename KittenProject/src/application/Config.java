package application;

import java.io.File;
import java.net.URL;

/**
 * @deprecated
 * @author Isaiah Miller Date: 12/4/18 makes a config file with paths to
 *         persistent data.
 */
public class Config extends AbstractExportable {
	/**
	 * The path to the config file. This should not change. It is not an exportable property.
	 */
	private String mySourcePath;
	private String mySavePath;
	private String myHomePath;
	private String mySettingsPath;

	/**
	 * Date: 12/5/18
	 * 
	 * @author Isaiah Miller
	 */
	public Config() {
		mySourcePath = retConfigPath();
//		final File sourceFile = new File(mySourcePath);
//		myExporter.importFile(sourceFile);

		mySavePath = retSavePath();
		myHomePath = retHomePath();
		mySettingsPath = retSettingsPath();
	}
	
//	/**
//     * Date:12/10/18
//     * @author Isaiah Miller
//     * Pre: instance fields for home path and Settings path must be valid
//     * Initializes theSettings and theHome from the states specified by the Config instance.
//     */
//    public final void initFromConfig(final ExportableDataAggregate thePersistentData/*final Home theHome, final Settings theSettings*/) {
//    	thePersistentData.importJSON(new File(retPersistPath()));
//    	//    	System.out.println("init home from: " + myHomePath);
////    	final File homeFile = new File(myHomePath);
////    	System.out.println("Home file is: " + myHomePath);
////    	theHome.importJSON(homeFile);
////    	System.out.println("The Home is: " + theHome);
////    	theSettings.importJSON(new File(mySettingsPath));
////    	System.out.println("the Settings is: " + theSettings);
//    }


//	/**
//	 * @author Isaiah Miller
//	 * @return
//	 */
//	public String retySourcePath() {
//		return mySourcePath;
//	}

//	public void setMySourcePath(String mySourcePath) {
//		this.mySourcePath = mySourcePath;
//	}

	public String getMySavePath() {
		return mySavePath;
	}

	public void setMySavePath(String mySavePath) {
		this.mySavePath = mySavePath;
	}

	public String getMyHomePath() {
		return myHomePath;
	}

	public void setMyHomePath(String myHomePath) {
		this.myHomePath = myHomePath;
	}

	public String getMySettingsPath() {
		return mySettingsPath;
	}

	public void setMySettingsPath(String mySettingsPath) {
		this.mySettingsPath = mySettingsPath;
	}

	/**
	 * @deprecated
	 * Date 12/8/18
	 * @author Isaiah Miller
	 * @return
	 */
	public String retSavePath() {
		final URL saveURL = getClass().getResource("save");
//		System.out.println("my URL save path is: " + saveURL.getPath());
		return saveURL.getPath();
	}
	
	/**
	 * @deprecated
	 * Date 12/8/18
	 * @author Isaiah Miller
	 * @return
	 */
	public String retHomePath() {
		final URL homeURL = getClass().getResource("save/home.json");
		return homeURL.getPath();
	}

	/**
	 * Date 12/8/18
	 * @deprecated
	 * @author Isaiah Miller
	 * @return
	 */
	public String retSettingsPath() {
		final URL saveURL = getClass().getResource("save/settings.json");
		return saveURL.getPath();
	}
	
	/**
	 * Date 12/5/18
	 * @deprecated
	 * @author Isaiah Miller
	 * @return The path to source the project configuration from.
	 */
	public String retConfigPath() {
		// path should be src/application/save/config.json
//		new File(getClass().getResource("save").getPath());
		return getClass().getResource("save/config.json").getPath();
	}

	


	/*
	 * Date: 12/8/18
	 * 
	 * @author Isaiah Miller
	 */
	@Override
	public boolean equals(Object other) {
		boolean res;
		if (other == null || other.getClass() != this.getClass()) {
			res = false;
		} else { // check all fields equal (except exporter)
			Config otherConfig = (Config) other;
			final boolean sourceIsSame = mySourcePath.equals(otherConfig.mySourcePath);
			final boolean saveIsSame = mySavePath.equals(otherConfig.mySavePath);
			final boolean settingsIsSame = mySettingsPath.equals(otherConfig.mySettingsPath);
			final boolean homeIsSame = myHomePath.equals(otherConfig.myHomePath);
			res = sourceIsSame && saveIsSame && settingsIsSame && homeIsSame;
		}
		return res;
	}

	/*
	 * Date: 12/8/18
	 * 
	 * @author Isaiah Miller
	 */
	@Override
	public String toString() {
		final String res = "My home path: " + myHomePath + "\nMy Settings Path: " + mySettingsPath + "\nmy Source Path: "
				+ mySourcePath + "\nmy Save Path: " + mySavePath + "\n";
		return res;
	}

}
