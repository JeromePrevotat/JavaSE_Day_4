package com.humanbooster.exercices;

import java.util.Map;

public class ErrorHandler {
    public static void handleConstructorArgs(Map<String, Object> args) throws IllegalArgumentException {
        args.forEach((k,v) -> {
            if (k.equals("isbn") && (v.equals("") || v == null)) throw new IllegalArgumentException("Error: ISBN cannot not be Empty");
            if (k.equals("titre") && (v.equals("") || v == null)) throw new IllegalArgumentException("Error: Titre cannot not be Empty");
            if (k.equals("dispo") && (v == null)) throw new IllegalArgumentException("Error: Dispo must be true or false");
        });
    }
}
