package zh.romp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {
		public static String getTime(){
			Date date=new Date();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			String date2=format.format(date);
			return date2;
		}
		
}
