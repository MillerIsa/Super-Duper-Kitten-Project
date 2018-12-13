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
		return getClass().getResource("save/testDataAggregate.json").getPath();
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
	
	@Override
	public String toString() {
		String res = "";
		res += "myHome is: " + myHome;
		res += "\nmySettings is: " + mySettings;
		return res;
	}

}
