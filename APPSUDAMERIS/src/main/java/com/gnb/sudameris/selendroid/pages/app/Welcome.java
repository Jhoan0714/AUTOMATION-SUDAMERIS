/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnb.sudameris.selendroid.pages.app;

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
public class Welcome {

    private AppiumDriver driver;

    @AndroidFindBy(id = "io.selendroid.testapp:id/startUserRegistration")
    @iOSFindBy(id = "io.selendroid.testapp:id/startUserRegistration")
    private MobileElement registration;

    @AndroidFindBy(id = "io.selendroid.testapp:id/buttonStartWebview")
    @iOSFindBy(id = "io.selendroid.testapp:id/buttonStartWebview")
    private MobileElement chrome;

    public Welcome(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void doUserRegistration() {
        Utility.captureScreenShot(driver, Welcome.class);
        registration.click();
    }

    public void doStartWebView() {
        Utility.captureScreenShot(driver, Welcome.class);
        chrome.click();
    }

}
