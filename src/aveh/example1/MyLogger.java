package aveh.example1;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
  static private FileHandler fileTxt = null;
  static private SimpleFormatter formatterTxt;

  static private FileHandler fileHTML;
  static private Formatter formatterHTML;

  static public void setup() throws IOException {

    // Get the global logger to configure it
    //Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    Logger logger = Logger.getLogger("");

    //logger.setLevel(Level.INFO);
    //logger.setLevel(Level.CONFIG);
    fileTxt = new FileHandler("Logging.txt");
    fileHTML = new FileHandler("Logging.html");

    // Create txt Formatter
    formatterTxt = new SimpleFormatter();
    fileTxt.setFormatter(formatterTxt);
    logger.addHandler(fileTxt);

    // Create HTML Formatter
    formatterHTML = new MyHtmlFormatter();
    fileHTML.setFormatter(formatterHTML);
    logger.addHandler(fileHTML);

    logger.setLevel(Level.CONFIG);
  }
}
