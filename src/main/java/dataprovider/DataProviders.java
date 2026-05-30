package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="logincredentials")
	public static Object [][] getData()
	{
		Object[][] arr = ExcelUtility.getData("logindetails");
		return arr;
	}
}
