package com.projeto.utils;

import com.projeto.exceptions.InvalidAgeException;
import com.projeto.exceptions.InvalidEmailException;
import com.projeto.exceptions.InvalidHeightException;
import com.projeto.exceptions.InvalidNameException;

public class Validation {

    public static String isNameValid(String name) throws InvalidNameException {
        if (name.length() > 9) {
            return name;
        } else {
            throw new InvalidNameException("Name must be at least 10 characters");
        }
    }

    public static String isEmailValid(String email) throws InvalidEmailException {
        String regex = "([a-z0-9._-])+@([a-z])+(\\.([a-z])+)+";

        if (email.matches(regex)) {
            FindByEmail.find(email);
            return email;
        } else {
            throw new InvalidEmailException("E-mail in wrong format");
        }
    }

    public static String isAgeValid(String age) throws InvalidAgeException {
        if (Integer.parseInt(age) > 17) {
            return age;
        } else {
            throw new InvalidAgeException("Age must be at least 18");
        }
    }

    public static String isHeightValid(String height) throws InvalidHeightException {
        String regex = "[0-9](,([0-9])+)?";

        if (height.matches(regex)) {
            return height;
        } else {
            throw new InvalidHeightException("Height in wrong format");
        }
    }
}
