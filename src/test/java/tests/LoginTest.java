package tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class LoginTest extends BaseClass
{ 
	@Test
	public void googleTest()
	{
        System.out.println("Title: " + driver.getTitle());
    }
}
