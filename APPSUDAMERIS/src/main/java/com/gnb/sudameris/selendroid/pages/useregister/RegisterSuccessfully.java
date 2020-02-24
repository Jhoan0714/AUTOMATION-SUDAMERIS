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
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Jhoan Lopez
 */
public class RegisterSuccessfully {

    private AppiumDriver driver;

    @AndroidFindBy(id = "io.selendroid.testapp:id/buttonRegisterUser")
    @iOSFindBy(id = "io.selendroid.testapp:id/buttonRegisterUser")
    private MobileElement register;

    public RegisterSuccessfully(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void doRegisterSuccessfully() {
        Utility.captureScreenShot(driver, RegisterSuccessfully.class);
        register.click();
    }
}
