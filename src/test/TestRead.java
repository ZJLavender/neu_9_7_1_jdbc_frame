package test;

import com.neu.util.ReadProperties;

public class TestRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver=
				ReadProperties.getInstance()
				.getProperty("driver");
		System.out.println(driver);
	}

}
