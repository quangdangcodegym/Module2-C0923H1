package com.cg.utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String USERNAME_REGEX = "^[A-Za-z][A-Za-z0-9_ ]{7,19}$";
    public static final String DESCRIPTION_REGEX = "^[A-Za-z][A-Za-z0-9_ ]{7,50}$";
//    public static boolean isUsernameValid(String username) {
//        if (username.contains("xxx")) {
//            return false;
//        }
//        return Pattern.matches(USERNAME_REGEX, username);
//    }
//    public static boolean isDescriptionValid(String description) {
//        if (description.contains("xxx")) {
//            return false;
//        }
//        return Pattern.matches(USERNAME_REGEX, description);
//    }
    public static boolean isProductStringValid(String username, String regex) {
        if (username.contains("xxx")) {
            return false;
        }
        return Pattern.matches(regex, username);
    }
}
