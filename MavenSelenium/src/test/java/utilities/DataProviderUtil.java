package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

	//verbunden mit \src\test\java\LetsKodeItTest\RadioButtonTest.java
	
	@DataProvider(name = "TestData")
	public Object[][] getData() { 
		Object [][] testData = {{"bmwradio"}, {"benzradio"}, {"hondaradio"}};
		return testData;
	}
	
}
