package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class LoginTest extends BaseClass {

    @Test
    public void loginTest() {

        System.out.println("========Running Login Test========");

        String title = driver.getTitle();

        System.out.println("Title =======" + title+"===========");

        Assert.assertTrue(title.contains("Google"));
    }
}