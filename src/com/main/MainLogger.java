package com.main;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import aveh.example1.MyLogger;



public class MainLogger {
    //private static Logger LOGGER = Logger.getLogger("InfoLogging");
    /**not hard code*/
    private static final Logger LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName() );
    //private final Logger fLogger=Logger.getLogger(this.getClass().getPackage().getName());
    /**hard code*/
    //private final static Logger LOGGER = Logger.getLogger(MainLogger.class.getName());


    public void doSomeThingAndLog() {
        // Image here some real work

        // Now we demo the logging

        // Set the LogLevel to Severe, only severe Messages will be written
        LOGGER.setLevel(Level.SEVERE);
        LOGGER.severe("Info Log");
        LOGGER.warning("Info Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Really not important");

        // Set the LogLevel to Info, severe, warning and info will be written
        // Finest is still not written
        LOGGER.setLevel(Level.INFO);
        LOGGER.severe("Info Log");
        LOGGER.warning("Info Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Really not important");
      }


    public static void main(String[] args) {
        /*LoggerTest.init();
        LOGGER.info("Logging an INFO-level message");

        LOGGER.log(Level.INFO, "message 1");
        LOGGER.log(Level.SEVERE, "message 2");
        LOGGER.log(Level.FINE, "message 3");
        LoggerTest2.thing();*/

        /*MainLogger tester = new MainLogger();
        try {
          MyLogger.setup();
        } catch (IOException e) {
          e.printStackTrace();
          throw new RuntimeException("Problems with creating the log files");
        }
        tester.doSomeThingAndLog();*/

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {

          // This block configure the logger with handler and formatter
          fh = new FileHandler("MyLogFile.log", true);
          logger.addHandler(fh);
          logger.setLevel(Level.ALL);
          SimpleFormatter formatter = new SimpleFormatter();
          fh.setFormatter(formatter);

          // the following statement is used to log any messages
          logger.log(Level.WARNING,"My first log");

        } catch (SecurityException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }

    }
}
