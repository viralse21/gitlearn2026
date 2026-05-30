package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginApplication_2 extends BaseClass
{
	LoginPage login;
	
	DashboardPage dashboard;
	
	@Test(priority = 1,enabled = true)
	public void loginWithValidCredentials()
	{
		login=new LoginPage(driver);
		
		dashboard=new DashboardPage(driver);
		
		login.loginToApplication_2("admin@email.com","admin@123");
	
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
