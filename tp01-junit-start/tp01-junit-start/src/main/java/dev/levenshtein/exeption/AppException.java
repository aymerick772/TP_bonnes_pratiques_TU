package dev.levenshtein.exeption;

public class AppException extends RuntimeException {
    public AppException(String message) {
        super(message);
    }
}