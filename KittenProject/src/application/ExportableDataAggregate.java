package application;

import java.io.File;

/**
 * Date: 12/10/18
 * 
 * @author Isaiah Miller
 *
 */
public class ExportableDataAggregate extends AbstractExportable {
	private Home myHome;
	private Settings mySettings;
	private Config myConfig;

	
	/**
	 * Date: 12/10/18
	 * 
	 * @author Isaiah Miller
	 */
	public ExportableDataAggregate() {
	}
	
	
	/**
	 * Date 12/11/18
	 * @author Isaiah Miller
	 */
	public void importJSON() {
		final File src = new File(retPersistPath());
		importJSON(src);
	}
	
	/**
	 * Date 12/11/18
	 * 
	 * @author Isaiah Miller
	 * @return The path to source the project configuration from.
	 */
	public String retPersistPath() {
		// path should be src/application/save/config.json
//		new File(getClass().getResource("save").getPath());
		return getClass().getResource("save/testDataAggregate.json").getPath();
	}
	
	/**
	 * Date: 12/10/18
	 * 
	 * @author Isaiah Miller
	 */
	public ExportableDataAggregate(final Settings theSettings, final Config theConfig, final Home theHome) {
		myHome = theHome;
		mySettings = theSettings;
		myConfig = theConfig;
	}

	/**
	 * Date: 12/10/18
	 * 
	 * @author Isaiah Miller
	 * @return
	 */
	public Home getMyHome() {
		return myHome;
	}

	/**
	 * Date: 12/10/18
	 * 
	 * @author Isaiah Miller
	 * @param myHome
	 */
	public void setMyHome(Home myHome) {
		this.myHome = myHome;
	}

	/**
	 * Date: 12/10/18
	 * 
	 * @author Isaiah Miller
	 * @return
	 */
	public Settings getMySettings() {
		return mySettings;
	}

	/**
	 * Date: 12/10/18
	 * 
	 * @author Isaiah Miller
	 * @param mySettings
	 */
	public void setMySettings(Settings mySettings) {
		this.mySettings = mySettings;
	}

	/**
	 * Date: 12/10/18
	 * 
	 * @author Isaiah Miller
	 * @return
	 */
	public Config getMyConfig() {
		return myConfig;
	}

	/**
	 * Date: 12/10/18
	 * 
	 * @author Isaiah Miller
	 * @param myConfig
	 */
	public void setMyConfig(Config myConfig) {
		this.myConfig = myConfig;
	}
	
	@Override
	public String toString() {
		String res = "";
		res += "myHome is: " + myHome;
		res += "\nmySettings is: " + mySettings;
		res += "\nmyConfig is: " + myConfig;
		return res;
	}

}
