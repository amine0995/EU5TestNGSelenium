package com.cybertek.tests.day13_pom;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RepeatOptionsTests extends TestBase {
    /*
    verify radio buttons
    1.open chrome
    2.login as driver
    3.go to activities->calendar events
    4.click on create calendar events
    5.click on repeat
    6.verify that repeat every days is checked
    7.verify that repeat weekday is not checked
     */


    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();

        //Login as driver
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //Click on create calendar events
        //wait for loader mask
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        // Click on repeat
        createCalendarEventsPage.repeat.click();
        //verify that repeat every day is checked

        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"verify repeat days is selected");

        //verify that weekday is not selected
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify weekday is not selected");




        }



     /*
        verify repeat options
        open browser
        login as driver
        go to Activities-->Calendar Events
        Click on repeat checkbox
        verify that repeat options are Daily,Weekly,Monthly,Yearly(in this order)


         */

    @Test
    public void test2(){
        LoginPage loginPage = new LoginPage();
        //Login as driver
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //Click on create calendar events
        //wait for loader mask
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        // Click on repeat
        createCalendarEventsPage.repeat.click();

        Select repeatsDropdown=createCalendarEventsPage.repeatOptionsList();
        //verify that repeat options are Daily,Weekly, Monthly,Yearly
        List<String> expectedList= Arrays.asList("Daily","Weekly","Monthly","Yearly");

        List<String> actualList=new ArrayList<>();

        List<WebElement> actualOptions=repeatsDropdown.getOptions();

        for (WebElement option : actualOptions) {
            //get text of each element and add to actual List
            actualList.add(option.getText());

        }
        //ready method for getting text of list of wen elements
        List<String> actualList2=BrowserUtils.getElementsText(actualOptions);
        //verify that repeat options are Daily,Weekly,Monthly,Yearly(in this order)
        Assert.assertEquals(actualList,expectedList,"Daily,Weekly,Monthly,Yearly");




    }

}

