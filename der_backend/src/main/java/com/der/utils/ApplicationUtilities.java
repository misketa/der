package com.der.utils;

public class ApplicationUtilities {

    public static void validateRequestPageAndSize(int page, int size) {
        if (page < 0 || size < 0) {
            throw new RuntimeException("Page/Size number cannot be less than 0");
        } else if (size > RequestConstants.MAX_PAGE_SIZE) {
            throw new RuntimeException("Max page size exceeded");
        }
    }

    public static void validateId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID: ID must be a positive number.");
        }
    }
}
