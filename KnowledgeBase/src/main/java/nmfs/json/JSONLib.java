package nmfs.json;
import java.util.UUID;

import org.json.*;
public class JSONLib {
// JSON is simple and easy if no serialization is required
	
	private String inboundOld="";
	private static String inboundNew="{\"header\":{\"technical\":{\"eventTechId\":\"3509ec15-e667-4b02-ab7a-0177eb405d27\",\"originalEventId\":null,\"version\":\"0.1\",\"eventType\":\"AuthorisePayment\",\"timestamp\":\"1508923217642\",\"deviceType\":\"default\",\"browserType\":\"default\",\"country\":\"BE\",\"language\":\"nl\"},\"functional\":{\"connectedUserRef\":\"default\",\"endUserRef\":\"default\",\"connectionRef\":\"default\",\"channelType\":\"default\",\"serviceName\":\"InstantPayments\",\"serviceId\":\"k2cfY6L9vCNSR1T9Fi30gSR34cq41sEmPvZ\",\"transactionId\":\"Y2MSho4ZF1211hC047Xk0YC54R\",\"stageName\":\"default\",\"stageId\":\"b3ae3cb4-cd6d-4212-8c73-64f27a9bf282\",\"bankCode\":\"bnppf\"}},\"payload\":{\"authorisePayment\":{\"party\":{\"accountDetails\":{\"iban\":\"GB20TUCD69747655640858\",\"bic\":\"ICSLGBL1\"}},\"amount\":{\"currency\":\"EUR\",\"value\":\"2900\"}}}}";
	private static String responseNew="{\"header\":{\"technical\":{\"eventTechId\":\"XXXIDXXX\",\"originalEventId\":XXXORIGINALEVENTIDXXX,\"version\":\"0.1\",\"eventType\":\"AuthorisePayment\",\"timestamp\":\"1508923217642\",\"deviceType\":\"default\",\"browserType\":\"default\",\"country\":\"BE\",\"language\":\"nl\"},\"functional\":{\"connectedUserRef\":\"default\",\"endUserRef\":\"default\",\"connectionRef\":\"default\",\"channelType\":\"default\",\"serviceName\":\"InstantPayments\",\"serviceId\":\"k2cfY6L9vCNSR1T9Fi30gSR34cq41sEmPvZ\",\"transactionId\":\"XXXTRANSACTIONXXX\",\"stageName\":\"default\",\"stageId\":\"b3ae3cb4-cd6d-4212-8c73-64f27a9bf282\",\"bankCode\":\"bnppf\"}\r\n   },\r\n\"payload\":{  \"paymentAuthorised\":{  \"party\":{     \"accountDetails\":{\"iban\":\"GB20TUCD69747655640858\",      \"bic\":\"ICSLGBL1\"      }   },\"reservationId\":\"6161616161-61\"}\r\n   }\r\n}";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject(inboundNew);
		// Technical Header
		JSONObject headerObj = obj.getJSONObject("header");
		JSONObject techObj = headerObj.getJSONObject("technical");
		String eventTechId = techObj.getString("eventTechId");
		System.out.println(eventTechId);
	 //	functional header
		JSONObject funcObj = headerObj.getJSONObject("functional");
		String transactionId = funcObj.getString("transactionId");
		System.out.println(eventTechId);
		
		String outMessage = responseNew.replace("XXXORIGINALEVENTIDXXX", "\""+eventTechId+"\"");
		outMessage = outMessage.replace("XXXTRANSACTIONXXX", transactionId);
		UUID uuid = UUID.randomUUID();
		outMessage = outMessage.replace("XXXIDXXX", uuid.toString());
		
		System.out.println(outMessage);
		  
	}
  public static void test1()
  {
	  /*
	  {
		    "name": "Alice",
		    "age": 20,
		    "address": {
		        "streetAddress": "100 Wall Street",
		        "city": "New York"
		    },
		    "phoneNumber": [
		        {
		            "type": "home",
		            "number": "212-333-1111"
		        },{
		            "type": "fax",
		            "number": "646-444-2222"
		        }
		    ]
		}
	  */
	  String str = "{ \"name\": \"Alice\", \"age\": 20 }";
	  JSONObject obj = new JSONObject(str);
	  String n = obj.getString("name");
	  int a = obj.getInt("age");
	  System.out.println(n + " " + a);  // prints "Alice 20"
	  
	  
  }
}
