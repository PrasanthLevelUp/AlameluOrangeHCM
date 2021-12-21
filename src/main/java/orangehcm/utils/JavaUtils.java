package orangehcm.utils;

import java.util.Date;


public class JavaUtils {
	
	public static long randonnumber() {
		Date date = new Date();
		return date.getTime();
	}

}
