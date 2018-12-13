/**
 * Exporter class
 * Authors: Isaiah Miller
 * version 1.0
 * 12/2018
 */

package application;
import java.io.File;
import java.io.IOException;

/*
 * From Third Party Library: Jackson
 * more information can be found at: https://github.com/FasterXML/jackson
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * * Third Party Library: Jackson
 * This library is used extensively in the following class
 * more information can be found at: https://github.com/FasterXML/jackson
 * 
 * @author Isaiah Miller
 *
 */
public class Exporter {
		/**
		 * myMapper
		 */
		private final ObjectMapper myMapper;
		/**
		 * myReader
		 */
		private final ObjectReader myReader;
		/**
		 * myWriter
		 */
		private final ObjectWriter myWriter;
		
		/**
		 * myDestObject
		 */
		private final Object myDestObject;
		
		
		/**
		 * @author Isaiah Miller
		 * must instantiate one of this for a class to use
		 * @param destObject the instance that this exporter
		 *  will write to for import and write from for export
		 */
		public Exporter(Exportable destObject) {
			myMapper = new ObjectMapper();
			myReader = myMapper.readerForUpdating(destObject);
			myWriter = myMapper.writerWithDefaultPrettyPrinter();
			myDestObject = destObject;
		}

	
		/**
		 * @author Isaiah Miller
		 * Imports home data from save file into to this instance.
		 * @param srcFile
		 */
		public void importFile(File srcFile) {
			try {
				myReader.readValue(srcFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


		/**
		 * @author Isaiah Miller
		 * exports the file
		 * @param destFile
		 */
		public void exportFile(File destFile) {
			try {
				myWriter.writeValue(destFile, myDestObject);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
