package Utilities;

import java.util.Date;

public class Demo {

	public static void main(String[] args) {
		
		Date date=new Date();
		String dynamic_pass="aks"+date.getTime();
		System.out.println(dynamic_pass);
	}

}
