package main;

import java.util.Map;

/*
 * Domain classes allow us to name a concept and restrict the possible behaviors and values 
 * of this concept in order to improve discoverability and reduce the scope for bugs. 
 * As a result, we’ve chosen to model the Document.
 */

public class Document {
    private final Map<String, String> attributes;

    // Only code in the Document Management System should be able to create Documents, 
    // so we keep the constructor package-scoped and restrict access to only the package 
    // that the Document Management System lives in.

    Document(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(final String attributeName) {
        return attributes.get(attributeName);
    }
}
