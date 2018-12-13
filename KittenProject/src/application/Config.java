package application;

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
		mySavePath = retSavePath();
		myHomePath = retHomePath();
		mySettingsPath = retSettingsPath();
	}



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
