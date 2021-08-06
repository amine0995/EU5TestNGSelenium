package com.cybertek.tests.day14_extendReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class extentDemoTest {
    //this class is used for starting nad building reports
    ExtentReports report;
    // this class is used to html report file
    ExtentHtmlReporter htmlReporter;
    //this will define a test, enables adding logs,authors,test steps
    ExtentTest extentLogger;




    @BeforeMethod
    public void setup(){
        //initialize class
        report= new ExtentReports();

        //create a report path
        String projectPath=System.getProperty("user.dir");
        String path=projectPath+"/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter=new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));




    }
    @Test
    public void test1(){
      //give name to current test
      extentLogger=report.createTest("TC123 Login as Driver Test");

      //test steps
        extentLogger.info("open chrome browser");

        extentLogger.info("go to the url");

        extentLogger.info("Enter driver username password ");

        extentLogger.info("click login");

        extentLogger.info("verify logged in");

        //pass()-->marks the test case as passed
        extentLogger.pass("TC123 is passed");




    }
    @AfterMethod
    public void teardown(){
        //this is when the report is actually created
        report.flush();
    }




}
