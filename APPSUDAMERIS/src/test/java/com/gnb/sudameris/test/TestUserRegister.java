/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnb.sudameris.test;

import com.gnb.sudameris.selendroid.pages.useregister.Register;
import com.gnb.sudameris.selendroid.pages.useregister.RegisterSuccessfully;
import com.gnb.sudameris.selendroid.pages.app.Welcome;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author Jhoan Lopez
 */
public class TestUserRegister {

    AppiumDriver driver;

    @BeforeTest
    @Parameters({"platformName", "platformVersion", "deviceName", "udid", "app", "host"})
    public void setUp(String platformName, String platformVersion, String deviceName, String udid, String app, String host) throws InterruptedException {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", platformName);
            caps.setCapability("platformVersion", platformVersion);
            caps.setCapability("deviceName", deviceName);
            caps.setCapability("udid", udid);
            caps.setCapability("app", System.getProperty("user.dir") + "\\src\\test\\java\\com\\gnb\\sudameris\\app\\" + app);
            URL url = new URL(host);
            if (platformName.toUpperCase().equals("ANDROID")) {
                driver = new AndroidDriver<AndroidElement>(url, caps);
            } else if(platformName.toUpperCase().equals("IOS")) {
                driver = new IOSDriver<IOSElement>(url, caps);
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException ex) {
            System.out.println("Message is: " + ex.getMessage());
        }
    }

    @Test(priority = 0, description = "Open User Register")
    public void welcome() {
        Welcome wlm = new Welcome(driver);
        wlm.doUserRegistration();
    }

    @Test(priority = 1, description = "User register", dataProvider = "UserData")
    public void userRegister(String user) {
        String data[] = user.split(",");
        Register reg = new Register(driver);
        reg.doUserRegistrationInformation(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]));

    }

    @Test(priority = 2, description = "User Register Successfully")
    public void registerSuccessfully() {
        RegisterSuccessfully regs = new RegisterSuccessfully(driver);
        regs.doRegisterSuccessfully();

    }

    @DataProvider(name = "UserData")
    public Object[][] userData() {
        String row = "";
        try (BufferedReader csvReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\test\\java\\com\\gnb\\sudameris\\data\\UserRegister.csv"))) {
            while ((row = csvReader.readLine()) != null) {
                break;
            }
        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        }
        return new Object[][] {{row}};
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
