package com.humanbooster.exception;
import java.io.File;

public class Logger {
    // Project Directory Path
    static final String PWD = System.getProperty("user.dir");
    static final String SEP = System.getProperty("file.separator");
    static final String SRC_PATH = PWD + SEP + "Bibliotheque" + SEP + "src";

    public static void displayLogs(Exception e, boolean debug, int verbose){
        // Switch en fonction du niveau de verbalité souhaité
        switch (verbose){
            // Verbalité Minimum : Erreur uniquement
            case 0 -> {
                System.err.println(e.getMessage());
            }
            // Verbalité intermédiaire : Erreur + Fichiers Perso uniquement
            case 1 -> {
                System.err.println(e.getMessage());
                // Récupère l'arborescence du projet
                File[] files = new File(SRC_PATH).listFiles();
                // Check si le fichier de la StackTrace est un perso ou non
                for(StackTraceElement st : e.getStackTrace()){
                    for (File file : files){
                        if (st.toString().contains(file.getName())) System.err.println(st);
                    }
                }
            }
            // Verbalité Maximum : Erreur + StackTrace complète (ex: inclus les fichiers des frameworks)
            case 2 -> {
                System.err.println(e.getMessage());
                for(StackTraceElement st : e.getStackTrace()){
                    System.err.println(st);
                }
            }
        }
    }
}
