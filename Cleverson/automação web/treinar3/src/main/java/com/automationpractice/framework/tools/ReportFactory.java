package com.automationpractice.framework.tools;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportFactory {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy-hh'h'mm'm's's'");
    private static final LocalDateTime localDateTime = LocalDateTime.now();
    private static final String ldtString = dateTimeFormatter.format(localDateTime);

    private static final String REPORT_NAME = "Report_" + ldtString + ".html";
    private static final String REPORT_PATH = System.getProperty("user.dir") + File.separator + "reports" + File.separator + REPORT_NAME;

    private static ExtentReports extent;

    protected static synchronized ExtentReports getInstance(){
        if (extent==null){
            createInstance();
        }
        return extent;
    }

    private static ExtentReports createInstance(){
        reportDirectory();

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(REPORT_PATH);
        htmlReporter.config().setDocumentTitle("AutomationPractice");
        htmlReporter.config().setReportName("Automação");
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setTheme(Theme.DARK);

        StringBuilder css = new StringBuilder();
        css.append(".exception-content { float: left; width: 100%; color: #ef5350; }")
                .append(".exception-log { float: left; width: 100%; cursor: pointer; }")
                .append(".exception-log-text { float: left; width: 100%; max-height: 250px; margin-top: 5px; }")
                .append(".exception-log-text { display: none; overflow-y: scroll; }");
        htmlReporter.config().setCSS(css.toString());
        StringBuilder js = new StringBuilder();
        js.append("$(document).on('click', '.exception-log', function() {")
                .append("if ($(this).attr('id').match(0)) {")
                .append("$(this).attr('id', 1);")
                .append("$('.exception-log-text').css('display', 'block');")
                .append("} else {")
                .append("$(this).attr('id', 0);")
                .append("$('.exception-log-text').css('display', 'none');")
                .append("}")
                .append("});");
        htmlReporter.config().setJS(js.toString());

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }

    private static void reportDirectory(){
        File reportDirectory = new File(System.getProperty("user.dir") + File.separator + "reports");
        File reportDirectoryImage = new File(System.getProperty("user.dir") + File.separator + "reports");

        if (!reportDirectory.exists()){
            reportDirectory.mkdir();
        }
        if (!reportDirectoryImage.exists()){
            reportDirectoryImage.mkdir();
        }
    }
}
