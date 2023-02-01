package org.example;

import org.example.exception.WrongLoginException;
import org.example.exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = null;//"Lange_E_A1983";
        String password = "qaz_12.3";
        String passwordConfirm = "qaz_123";
        System.out.println(acceptThreeParameters(login, password, passwordConfirm));
    }

    public static boolean acceptThreeParameters(String login, String password, String passwordConfirm) {
        boolean checkLogin;
        boolean checkLoginLength;
        boolean checkPassword;
        boolean checkPasswordLength;
        boolean checkPasswordMatching;
        try {
            checkLogin = checkParameterValid(login);
            checkPassword = checkParameterValid(password);
            checkLoginLength = checkLoginLength(login);
            checkPasswordLength = checkPasswordLength(password);
            checkPasswordMatching(password, passwordConfirm);
        } catch (WrongLoginException exception) {
            System.out.println(exception.getMessage());
            return false;
        } catch (WrongPasswordException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return checkLogin && checkPassword && checkPasswordLength;

    }

    public static boolean checkParameterValid(String checkParameter) {
        //проверка параметра на правильность содержания
        //проверка на null
        if (checkParameter == null) {
            throw new NullPointerException("Параметр является null");

        }
        //проверка содержания через регулярные выражения
        if (checkParameter.matches("[a-zA-Z_\\d]+")) {
            return true;
        }
        System.out.println("введены недопустимые символы: " + checkParameter);
        return false;
    }

    public static boolean checkLoginLength(String checkLogin) throws WrongLoginException {
        //проверка длины логина
        if (checkLogin.length() > 20) {
            throw new WrongLoginException("Логин слишком длинный");
        }
        return true;
    }

    public static boolean checkPasswordLength(String checkPassword) {
        //проверка длины пароля
        if (checkPassword.length() > 19) {
            System.out.println("Пароль слишком длинный");
            return false;
        }
        return true;
    }

    public static boolean checkPasswordMatching(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) return true;
        throw new WrongPasswordException("введенные пароли не совпадают");
    }
}