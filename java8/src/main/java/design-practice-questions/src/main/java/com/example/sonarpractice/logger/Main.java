package com.example.sonarpractice.logger;

import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getInstance();
        logger.info("Hello info");
        logger.debug("Debugging");
        logger.error("Err occurred");
    }
}

enum Level { DEBUG, INFO, ERROR }

class Logger {
    private static final Logger INSTANCE = new Logger();
    private Level level = Level.INFO;
    private PrintWriter fileWriter = null;
    private Logger(){
        try{
            Properties p = new Properties();
            File f = new File("logger.properties");
            if(f.exists()){
                try(FileInputStream in=new FileInputStream(f)){ p.load(in); }
                String lvl = p.getProperty("level","INFO");
                level = Level.valueOf(lvl);
                String file = p.getProperty("file");
                if(file!=null) fileWriter = new PrintWriter(new FileWriter(file,true), true);
            }
        }catch(Exception e){ /* ignore */ }
    }
    public static Logger getInstance(){ return INSTANCE; }
    public void log(Level lvl, String msg){
        if(lvl.ordinal() < level.ordinal()) return;
        String out = "["+lvl+"] " + msg;
        System.out.println(out);
        if(fileWriter!=null) fileWriter.println(out);
    }
    public void info(String m){ log(Level.INFO,m); }
    public void debug(String m){ log(Level.DEBUG,m); }
    public void error(String m){ log(Level.ERROR,m); }
}
