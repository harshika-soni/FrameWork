package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
	
	
	public String getKeyAndValuePair(String Key) throws IOException {

	FileInputStream fis = new FileInputStream(IPathConstant.filepath);
	Properties pro  = new Properties();
	pro.load(fis);
	
	String Value=pro.getProperty(Key);
	return Value;


	}

}
