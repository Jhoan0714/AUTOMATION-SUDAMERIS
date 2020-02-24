/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnb.sudameris.selendroid.pages.useregister;

import com.gnb.sudameris.selendroid.util.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Jhoan Lopez
 */
public class Register {

    private AppiumDriver driver;

    @AndroidFindBy(id = "io.selendroid.testapp:id/inputUsername")
    @iOSFindBy(id = "io.selendroid.testapp:id/inputUsername")
    private MobileElement username;

    @AndroidFindBy(id = "io.selendroid.testapp:id/inputEmail")
    @iOSFindBy(id = "io.selendroid.testapp:id/inputEmail")
    private MobileElement email;

    @AndroidFindBy(id = "io.selendroid.testapp:id/inputPassword")
    @iOSFindBy(id = "io.selendroid.testapp:id/inputPassword")
    private MobileElement password;

    @AndroidFindBy(id = "io.selendroid.testapp:id/inputName")
    @iOSFindBy(id = "io.selendroid.testapp:id/inputName")
    private MobileElement name;

    @AndroidFindBy(id = "io.selendroid.testapp:id/input_preferedProgrammingLanguage")
    @iOSFindBy(id = "io.selendroid.testapp:id/input_preferedProgrammingLanguage")
    private MobileElement programmingLanguage;

    @AndroidFindBy(id = "io.selendroid.testapp:id/input_adds")
    @iOSFindBy(id = "io.selendroid.testapp:id/input_adds")
    private MobileElement add;

    @AndroidFindBy(id = "io.selendroid.testapp:id/btnRegisterUser")
    @iOSFindBy(id = "io.selendroid.testapp:id/btnRegisterUser")
    private MobileElement register;

    public Register(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void doUserRegistrationInformation(String username, String email, String password, String name,int index) {
        driver.hideKeyboard();
        this.username.sendKeys(username);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.name.clear();
        this.name.sendKeys(name);
        programmingLanguage.click();
        MobileElement language = (MobileElement) driver.findElements(By.id("android:id/text1")).get(index);
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOf(language));
        language.click();
        add.click();
        Utility.captureScreenShot(driver, Register.class);
        register.click();

    }
}
