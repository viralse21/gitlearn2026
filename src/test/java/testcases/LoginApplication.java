package testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import base.BaseClass;
import dataprovider.DataProviders;
import pages.DashboardPage;
import pages.LoginPage;

@Listeners(ChainTestListener.class)
public class LoginApplication extends BaseClass
{
	LoginPage login;
	
	DashboardPage dashboard;
	
	@Test(priority = 1,enabled = true,dataProvider="logincredentials",dataProviderClass = DataProviders.class)
	public void loginWithValidCredentials(String user, String pass)
	{
		login=new LoginPage(driver);
		
		dashboard=login.loginToApplication(user,pass);
	
		Assert.assertTrue(dashboard.getWelcomeText().contains("Welcome"),"Login Failed");
	
	}
	
	@Test(dependsOnMethods = "loginWithValidCredentials",priority = 2,enabled = true)
	public void logoutFromApplication()
	{
		dashboard.logoutFromApplication();
		
		Assert.assertTrue(login.isSignUpPresent(),"Logout Failed");
	}
	
	@Test(priority = 3)
	public void verifyFooterLinks()
	{
		int count=login.countFooterLinks();
		
		Assert.assertEquals(count, 4 ,"footer links mismatched");
		
	}
	
	@Test(priority = 3)
	public void verifyNewUserLinks()
	{
		boolean status=login.isSignUpLinkPresent();
		
		Assert.assertTrue(status);
		
	}
	
}
