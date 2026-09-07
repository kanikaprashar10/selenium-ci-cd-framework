package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class LoginTest extends BaseClass {

    @Test
    public void loginTest() {

        System.out.println("========Running Login Test========");

        System.out.println();
        
        String title = driver.getTitle();

        System.out.println("Title =======" + title+"===========");
        
        System.out.println();

        Assert.assertTrue(title.contains("Google"));
    }
}