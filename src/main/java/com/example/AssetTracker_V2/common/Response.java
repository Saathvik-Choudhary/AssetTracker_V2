package com.example.AssetTracker_V2.common;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class representing a response object, extending the base ValueObject class.
 */
public abstract class Response extends ValueObject {

    /**
     * A list representing error messages in case the operation encounters issues.
     */
    private List<String> errors;

    /**
     * A message associated with the response.
     */
    private String message;

    /**
     * Gets the list of error messages, if any.
     *
     * @return The list of error messages or null if no errors occurred.
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * Adds an error message to the list of errors.
     *
     * @param error The error message to be added.
     */
    public void addError(String error) {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(error);
    }

    /**
     * Gets the message associated with the response.
     *
     * @return The message associated with the response.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message associated with the response.
     *
     * @param message The message to be associated with the response.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Checks if there are any errors in the response.
     *
     * @return True if there are errors, false otherwise.
     */
    public boolean hasErrors() {
        return !CollectionUtils.isEmpty(errors);
    }
}