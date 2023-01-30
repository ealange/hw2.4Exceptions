package org.example;

public class Main {
    public static void main(String[] args) {
        String login = "l!ange_e_A";
        String password = "qaz_123";
        String passwordConfirm = "qaz_123";
        System.out.println("Hello world!");
    }

    public static boolean acceptThreeParameters(String login, String password, String passwordConfirm) {

        return checkParameterValid(login) && checkParameterValid(password) && checkLoginLength(login);
    }

    public static boolean checkParameterValid(String checkParameter) {
        //проверка параметра на правильность содержания
        //
        if (checkParameter.matches("\\w")) {
            return true;
        }
        System.out.println("введены недопустимые символы: "+ checkParameter);
        return false;
    }

    public static boolean checkLoginLength(String checkLogin) {
        //проверка длины логина
        if (checkLogin.length()>20){
            throw new RuntimeException();
        }
        return false;
    }


}