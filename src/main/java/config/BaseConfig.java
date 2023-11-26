package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseConfig  {

    public static final String MAIN_URL=loadFromPropertiesMain();
    public static final String LOGIN_URL=loadFromPropertiesLogin();
    public static final String REGISTRATION_URL= loadFromPropertiesRegistration();
    public static final String RESET_PASSWORD_URL=loadFromPropertiesReset();
    public static final String REGISTER_PATH=loadFromPropertiesRegister();
    public static final String LOGIN_PATH= loadFromPropertiesLoginPath();
    public static final String USER_PATH= loadFromPropertiesUser();
    public static final String WAIT_SECONDS_TIMEOUT= loadFromPropertiesTime();

    private static String loadFromPropertiesMain() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("BaseConfig.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("props" + props.getProperty("MAIN_URL"));
        return props.getProperty("MAIN_URL");
    }
    private static String loadFromPropertiesLogin() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("BaseConfig.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("props" + props.getProperty("LOGIN_URL"));
        return props.getProperty("LOGIN_URL");
    }
    private static String loadFromPropertiesRegistration() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("BaseConfig.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("props" + props.getProperty("REGISTRATION_URL"));
        return props.getProperty("REGISTRATION_URL");
    }
    private static String loadFromPropertiesReset() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("BaseConfig.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("props" + props.getProperty("RESET_PASSWORD_URL"));
        return props.getProperty("RESET_PASSWORD_URL");
    }
    private static String loadFromPropertiesRegister() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("BaseConfig.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("props" + props.getProperty("REGISTER_PATH"));
        return props.getProperty("REGISTER_PATH");
    }
    private static String loadFromPropertiesLoginPath() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("BaseConfig.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("props" + props.getProperty("LOGIN_PATH"));
        return props.getProperty("LOGIN_PATH");
    }
    private static String loadFromPropertiesUser() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("BaseConfig.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("props" + props.getProperty("USER_PATH"));
        return props.getProperty("USER_PATH");
    }
    private static String loadFromPropertiesTime() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("BaseConfig.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("props" + props.getProperty("WAIT_SECONDS_TIMEOUT"));
        return props.getProperty("WAIT_SECONDS_TIMEOUT");
    }
        }
