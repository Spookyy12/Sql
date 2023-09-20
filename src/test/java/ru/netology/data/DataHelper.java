package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {

    private static final Faker faker = new Faker(new Locale("en"));
    private DataHelper() {
    }

    public static AuthInfo getAuthInfo() {

        return new AuthInfo("vasya", "qwerty123");
    }
    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }
    public static String generateRandomLogin(){
        return faker.name().username();
    }
    public static String generateRandomPass(){
        return faker.internet().password();
    }
    public static AuthInfo generateRandomUser(){
        return new AuthInfo(generateRandomLogin(),generateRandomPass());
    }

    public static VerificationCode generateRandomCode(){
        return new VerificationCode(faker.numerify("######"));
    }
    @Value
    public static class VerificationCode {
        private String code;
    }

    @Value
    public static class CardInfo {
        String cardNumber;
        String testId;
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }
}