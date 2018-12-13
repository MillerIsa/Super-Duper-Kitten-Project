package application;

import java.io.File;

/**
 * 12/10/18
 * @author Isaiah Miller
 *
 */
public class AbstractExportable implements Exportable {
	final Exporter myExporter;
	
	public AbstractExportable() {
		myExporter = new Exporter(this);
	}
	
	/**
	 * Date: 12/10/18
	 * @author Isaiah Miller
	 */
	public void exportJSON(File destFile) {
		myExporter.exportFile(destFile);
	}
	
	/**
	 * Date: 12/10/18
	 * @author Isaiah Miller
	 */
	public void importJSON(File srcFile) {
		myExporter.importFile(srcFile);
	}
}
