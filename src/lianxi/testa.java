package lianxi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class testa {

	/**1488636833050 - 1488636846980
	 * @param args
	 */
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
		    Date d1 = df.parse("2017-03-26 13:31:40");
		    Date d2 = df.parse("2017-03-26 13:31:39");
		    long diff = d1.getTime() - d2.getTime();
		    System.out.println(diff);
		    long days = diff / (1000 * 60 * 60 * 24);
		}
		catch (Exception e)
		{
		}
		System.out.println(getDayEnd());
	}
	
	public static Date getDayEnd() {
          Calendar cal = new GregorianCalendar();
          cal.set(Calendar.HOUR_OF_DAY, 23);
          cal.set(Calendar.MINUTE, 59);
          cal.set(Calendar.SECOND, 59);
          return cal.getTime();
      }
}
