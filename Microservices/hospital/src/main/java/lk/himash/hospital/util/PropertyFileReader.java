package lk.himash.hospital.util;

import java.io.FileReader;
import java.util.Properties;

public class PropertyFileReader {

	public static String getPropertyFileData(String propertyKey) {
		Properties p = new Properties();
		String URL = "";
		try {
			String dir = System.getProperty("user.dir");
			FileReader reader = new FileReader(dir + "\\src\\main\\resources\\services.properties");
			p.load(reader);
			URL = p.getProperty(propertyKey);
//			System.out.println(URL);
		} catch (Exception ex) {
			System.out.println("Exception found on | getPropertyFileData() method | PropertyFileReader.class |");
			System.out.println(ex.getMessage());
		}
		return URL;
	}

}
