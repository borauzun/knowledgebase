package nmfs.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import nmfs.spring.beans.Vehicle;

public class SpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config-anyname.xml");
		
		Vehicle v1=(Vehicle) context.getBean("myCar1");
		v1.getModel();
		
		Vehicle v2=(Vehicle) context.getBean("myBike1");

	}

}
