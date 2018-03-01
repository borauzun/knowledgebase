package nmfs.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringUtils {

	public static String getLastCharactersOfaString(String word,int noOfLastLetters)
	{    String retVal="";
		
	     if (word.length() == noOfLastLetters) {
			  return word;
			} else if (word.length() > noOfLastLetters) {
			  retVal= word.substring(word.length() - noOfLastLetters);
			} else {
			       retVal="";
			}
	     return retVal;
	}
	
	
	public static String createGUID()
	{
		return java.util.UUID.randomUUID().toString();
	}
}
