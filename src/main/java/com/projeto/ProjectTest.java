package com.projeto;

import com.projeto.exceptions.InvalidAgeException;
import com.projeto.exceptions.InvalidEmailException;
import com.projeto.exceptions.InvalidHeightException;
import com.projeto.exceptions.InvalidNameException;
import com.projeto.utils.Menu;

public class ProjectTest {
    public static void main(String[] args) throws InvalidNameException, InvalidAgeException, InvalidEmailException, InvalidHeightException {
        Menu.mainMenu();
    }
}
