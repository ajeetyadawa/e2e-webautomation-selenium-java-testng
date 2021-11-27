package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropReader {

	private File propFile;
	private FileInputStream fis; 
	private Properties prop;
	
	public PropReader() throws IOException {
		 propFile = new File(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		 fis =new FileInputStream(propFile);
		 prop = new Properties();
		prop.load(fis);
	}
	
	public String getValue(String key) {
		
	return prop.getProperty(key);
		
	}

	
	
	
}
