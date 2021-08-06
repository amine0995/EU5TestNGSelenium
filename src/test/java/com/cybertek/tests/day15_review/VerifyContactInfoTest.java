package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInfoTest extends TestBase {
    /*
    open the chrome
    go to qa1.vytrack
    login as sales manager
    navigate to customers->contacts
    click on email mbrackstone9@example.com
    verify that full time is Mariam Bracstone
    verify that email is mbrackstone9@example.com
    verify that phone number is
     */
    @Test
    public void contactDetailsTest(){
        extentLogger=report.createTest("Contact Info Verification");

        LoginPage loginPage=new LoginPage();

        String username= ConfigurationReader.get("salesmanager_username");
        String password=ConfigurationReader.get("salesmanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("login as a Sales Manager");

        loginPage.login(username,password);

        new DashboardPage().navigateToModule("Customers","Contacts");

        ContactsPage contactsPage=new ContactsPage();

        extentLogger.info("Click on mbrackstone9@example.com");

        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage=new ContactInfoPage();

        String expectedFullName="Mariam Brackstone";
        String actualFullName=contactInfoPage.fullName.getText();
        System.out.println(actualFullName);

        extentLogger.info("verify full name is "+expectedFullName);
        Assert.assertEquals(actualFullName,expectedFullName,"verify fullname");
        extentLogger.info("verify email is mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","verify email");
        extentLogger.info(" verify phone number +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","verify phone number");

        extentLogger.pass("passed");

    }

}
