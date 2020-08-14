package com.automationpractice.framework.tools;

import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;

import java.util.StringTokenizer;

public class Error {
    public static String exception(Status status, String message, Exception exception){
        logError(status, exception);
        Report.log(status, messageBlock(message, exception));

        return exception.getMessage();
    }

    public static String exception(Status status, String message, Exception exception, MediaEntityModelProvider capture){
        logError(status, exception);
        Report.log(status, messageBlock(message, exception), capture);

        return exception.getMessage();
    }

    private static void logError(Status status, Exception exception){
        switch (status){
            case INFO:
                Log.info(exception.getMessage());
                break;
            case WARNING:
                Log.warn(exception.getMessage());
                break;
            case FAIL:
                Log.error(exception.getMessage());
                break;
            default:
                Log.info(exception.getMessage());
                break;
        }
    }

    private static String messageBlock(String message, Exception exception){
        StringTokenizer st = new StringTokenizer(exception.getMessage(), System.getProperty("line.separator"));
        StringBuilder sb = new StringBuilder();

        sb.append("<div class='exception-content'>")
                .append("<span class='exception-log' id='0'>Expandir log de erro</span>")
                .append("<span class='exception-log-text'>");

        while (st.hasMoreTokens()){
            sb.append(st.nextToken() + "<br>");
        }

        sb.append("</span><dir>");

        return message + sb.toString();
    }
}
