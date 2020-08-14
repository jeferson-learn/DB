package com.automationpractice.framework.tools;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.remote.ScreenshotException;

public class Report {
    private static final ExtentReports extent = ReportFactory.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void createTest(String testName){
        ExtentTest extentTest = extent.createTest(testName);
        test.set(extentTest);
    }

    public static void log(Status status, String message){
        test.get().log(status, message);
    }

    public static void log(Status status, String message, MediaEntityModelProvider capture){
        try {
            test.get().log(status, message, capture);
        } catch ( ScreenshotException e){
            test.get().log(status, message + " Não foi capture");
        }
    }

    public static void close(){
        extent.flush();
    }
}
