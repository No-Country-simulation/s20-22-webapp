package com.eventix.eventix.shared.exception.personalized;

public class RegistryAlreadyExistsException extends RuntimeException {
    public RegistryAlreadyExistsException() {
        super("The action cannot be performed, the registry already exists.");
    }

    public RegistryAlreadyExistsException(String nameRegistry) {
        super(String.format("The action cannot be performed, the registry already exists. - %s", nameRegistry));
    }
}
