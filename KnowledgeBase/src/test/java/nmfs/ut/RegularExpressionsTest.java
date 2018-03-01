package nmfs.ut;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import org.hamcrest.Matcher;
import org.junit.Test;

public class RegularExpressionsTest {

	@Test
	public void test1() {
		String pattern = "\\d\\d\\d([,\\s])?\\d\\d\\d\\d";
        String s= "1233323322";
        assertFalse(s.matches(pattern));
        
	}
	@Test
	public void test2() {
		String pattern = "\\d\\d\\d([,\\s])?\\d\\d\\d\\d";
        String s= "1233323322";
        assertTrue(s.matches(pattern));
        
	}
	@Test
	public void test3() {
		String pattern = "\\d\\d\\d([,\\s])?\\d\\d\\d\\d";
        String s = "123 3323";
         assertTrue(s.matches(pattern));
	}

	  @Test
	    public void test4() {
	        String s= "1233";
	        assertTrue(test(s));
	       
	    }
	  @Test
	    public void test5() {
		    String s= "000h";
	        assertTrue(test(s));
	        
	    }
	  @Test
	    public void test6() {
	        String s = "99900234";
	        assertTrue(test(s));
	    }

 public static boolean test (String s){
	        Pattern pattern = Pattern.compile("\\d{3}");
	        java.util.regex.Matcher matcher = pattern.matcher(s);
	        if (matcher.find()){
	            return true;
	        }
	        return false;
	    }

}
