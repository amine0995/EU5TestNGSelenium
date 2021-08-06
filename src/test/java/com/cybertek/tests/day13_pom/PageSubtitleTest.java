package com.cybertek.tests.day13_pom;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /*
    open browser
    login as a driver
    verify that page subtitle is quick launchpad
    fo to activities->calendar events
    verify that page subtitle is Calendar Events

     */

    @Test
    public void test1(){
        LoginPage loginPage=new LoginPage();

        loginPage.loginAsDriver();
//        String username = ConfigurationReader.get("driver_username");
//        String password = ConfigurationReader.get("driver_password");
//
//        loginPage.usernameInput.sendKeys(username);
//        loginPage.passwordInput.sendKeys(password);
//        loginPage.loginBtn.click();

        String expectedSubtitle="Quick Launchpad";

        DashboardPage dashboardPage=new DashboardPage();

        String actualSubTitle= dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubTitle,expectedSubtitle,"Verify subtitle");

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        BrowserUtils.waitFor(2);

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","Verify subtitle Calendar Events");



    }
}
