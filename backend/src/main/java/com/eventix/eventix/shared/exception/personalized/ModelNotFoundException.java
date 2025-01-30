package com.eventix.eventix.shared.exception.personalized;

public class ModelNotFoundException extends RuntimeException{
    public ModelNotFoundException() {
        super("The object was not found.");
    }

    public ModelNotFoundException(String message) {
        super(message);
    }

    public ModelNotFoundException(Long idNotFound, String nameModel) {
        super(String.format("The object was not found - id not found: %d - Name Model: %s",
                idNotFound, nameModel));
    }
}
