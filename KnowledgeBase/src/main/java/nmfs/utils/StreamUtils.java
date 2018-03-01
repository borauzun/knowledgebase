package nmfs.utils;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

public class StreamUtils {
	
//  Inputstream to ByteArray
	public static byte[] StreamToByteArray(InputStream in) throws IOException{
		byte[] bytes = IOUtils.toByteArray(in);
		return bytes;
	}
	
//  Base64 String to ByteArray
	public static byte[] base64ToByteArray(String data) throws Exception {
		  Base64 base64 = new Base64();
		  return Base64.decodeBase64(data);
		 }
	
//  ByteArray to Base64 String
	public static String byteToBase64(byte[] data) {
		  Base64 base64 = new Base64();
		  return base64.encodeBase64String(data);
		 }
	
// Byte Array to InputStream
     public static InputStream ByteArrayToStream(byte[] decodedBytes){
    	 InputStream is = new ByteArrayInputStream(decodedBytes);
    	 return is;
     }	
     
//  write into a file from input stream
     public static void writeToFile(InputStream in) throws IOException{
    	 OutputStream out = new FileOutputStream("/Users/borauzun/Desktop/Copy Bora_Uzun_2016_1.pdf");
    	 byte[] buffer = new byte[1024];
    	 int len;
    	 while ((len = in.read(buffer)) != -1) {
    	     out.write(buffer, 0, len);
    	 }
    	 out.flush();
    	 out.close();
    	 
     }

}
