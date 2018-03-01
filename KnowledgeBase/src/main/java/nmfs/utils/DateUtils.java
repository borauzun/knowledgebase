package nmfs.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static Date getDateFromString(String startDateString,String dateFormat) throws ParseException
    {  
		DateFormat df = new SimpleDateFormat(dateFormat); 
	    Date retVal;
	    retVal =  df.parse(startDateString);
	    
	    return retVal;
	    
    }
	public static String getDateInNiceFormat(Date d) // Returns as July 12, 2016
	 {
		DateFormat df = new SimpleDateFormat("MMMMM dd,yyyy");
		String retVal=df.format(d);
		return retVal;
		
	 }
	
	public static String getDateInYYYYmmDDString(Date d)
    {  
	    // Today's date
       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
       String retVal=df.format(d);
       return retVal;
    }
	
	public static String todayStr()
    {  
	    // Today's date
       Date today1 = Calendar.getInstance().getTime(); 
       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
       String today=df.format(today1);
       return today;
    }
	public static Date StringToDate(String sDate1,String format) throws ParseException
	{
		 sDate1="31/12/1998";
		 format="dd/MM/yyyy";
		 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		return date1;
	}
}
