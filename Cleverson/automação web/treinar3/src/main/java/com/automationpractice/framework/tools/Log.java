package com.automationpractice.framework.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    private static final Logger logger = LoggerFactory.getLogger("Framework");

    public static void info(String text){
        logger.info(text);
    }
    public static void info(String text, Object... arguments){
        logger.info(text);
    }
    public static void error(String text){
        logger.info(text);
    }
    public static void error(String text, Object... arguments){
        logger.info(text);
    }
    public static void warn(String text){
        logger.info(text);
    }
    public static void warn(String text, Object... arguments){
        logger.info(text);
    }
    public static void debug(String text){
        logger.info(text);
    }
    public static void debug(String text, Object... arguments){
        logger.info(text);
    }
}
