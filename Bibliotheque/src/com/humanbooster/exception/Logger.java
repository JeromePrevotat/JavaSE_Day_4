package com.humanbooster.exception;
import java.io.File;

public class Logger {
    static final String PWD = System.getProperty("user.dir");
    static final String SEP = System.getProperty("file.separator");
    static final String SRC_PATH = PWD + SEP + "Bibliotheque" + SEP + "src";

    public static void displayLogs(Exception e, boolean debug, int verbose){
        switch (verbose){
            case 0 -> {
                System.err.println(e.getMessage());
            }
            case 1 -> {
                System.err.println(e.getMessage());
                File[] files = new File(SRC_PATH).listFiles();
                for(StackTraceElement st : e.getStackTrace()){
                    for (File file : files){
                        if (st.toString().contains(file.getName())) System.err.println(st);
                    }
                }
            }
            case 2 -> {
                System.err.println(e.getMessage());
                for(StackTraceElement st : e.getStackTrace()){
                    System.err.println(st);
                }
            }
        }
    }
}
