package com.cybertek.tests.day10_FileUpload;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test
    public  void test1(){
      //  C:\Users\gebruiker\IdeaProjects\EU5TestNGSelenium\src\test\resources\textfile.txt
      //below code shows the name of your operating system
      System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));

      //this line gives you your project location
        System.out.println(System.getProperty("user.dir"));

        //
        String projectPath=System.getProperty("user.dir");
        //
        String filePath="src/test/resources/textfile.txt";
        //full path
        String fullPath=projectPath+"/"+filePath;
        System.out.println(fullPath);




    }
}
