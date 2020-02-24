/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnb.sudameris.selendroid.pages.chrome;

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
public class WebBrowser {

    private AppiumDriver driver;

    @AndroidFindBy(id = "io.selendroid.testapp:id/spinner_webdriver_test_data")
    @iOSFindBy(id = "io.selendroid.testapp:id/spinner_webdriver_test_data")
    private MobileElement view;

    public WebBrowser(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void doWebViewInteraction(int index) {
        view.click();
        MobileElement pageOpc = (MobileElement) driver.findElements(By.id("android:id/text1")).get(index);
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOf(pageOpc));
        Utility.captureScreenShot(driver, WebBrowser.class);
        pageOpc.click();
        
    }
}
