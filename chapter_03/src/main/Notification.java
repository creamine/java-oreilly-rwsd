package main;

import java.util.ArrayList;
import java.util.List;

/*
 * The Notification pattern aims to provide a solution for the situation in which you are using too many unchecked exceptions. 
 * The solution is to introduce a domain class to collect errors.
 * The benefit of introducing such a class is that you can now declare 
 * a validator that is able to collect multiple errors in one pass. 
 * This wasn’t possible in the two previous approaches you explored. 
 * Instead of throwing exceptions, you can now simply add messages into the Notification
 */

public class Notification {
    private final List<String> errors = new ArrayList<>();

    public void addError(final String message) {
        errors.add(message);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public String errorMessage() {
        return errors.toString();
    }

    public List<String> getErrors() {
        return this.errors;
    }
}
