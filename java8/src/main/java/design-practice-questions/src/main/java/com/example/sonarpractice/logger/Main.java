package com.example.sonarpractice.logger;
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.info("This is an info message.");
        logger.error("This is an error message.");
    }
}
class Logger {
    private static final Logger INSTANCE = new Logger();
    private Logger() {}
    public static Logger getInstance(){ return INSTANCE; }
    public void info(String msg){ System.out.println("[INFO] " + msg); }
    public void error(String msg){ System.err.println("[ERROR] " + msg); }
}
