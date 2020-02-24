/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnb.sudameris.selendroid.pages.chrome;

import com.gnb.sudameris.selendroid.util.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.touch.offset.PointOption;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Jhoan Lopez
 */
public class FormPage {

    private AppiumDriver driver;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.widget.EditText")
    private WebElement email;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView/android.view.View[4]/android.widget.Spinner[2]")
    private WebElement element;

    @AndroidFindBy(id = "android:id/button1")
    @iOSFindBy(id = "android:id/button1")
    private MobileElement accept;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView/android.view.View[4]/android.view.View[11]")
    private WebElement check;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView/android.view.View[7]/android.widget.EditText[1]")
    private WebElement name;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView/android.view.View[10]/android.view.View/android.widget.CheckBox")
    private WebElement checkLabel;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView/android.view.View[7]/android.widget.EditText[2]")
    private WebElement id;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView/android.view.View[7]/android.widget.EditText[3]")
    private WebElement id2;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView/android.widget.EditText")
    private WebElement obs;

    public FormPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void doFormPage(String email, int index, String id, String id2, String obs) {
        this.email.sendKeys(email);
        element.click();
        WebElement elementsOpc = (WebElement) driver.findElements(By.id("android:id/text1")).get(index);
        elementsOpc.click();
        accept.click();
        int x = this.obs.getLocation().getX();
        int y = this.obs.getLocation().getY();
        Utility.captureScreenShot(driver, FormPage.class);
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(x, y)).moveTo(PointOption.point(x, y)).release();
        action.perform();
        driver.hideKeyboard();
        this.id.sendKeys(id);
        this.id2.sendKeys(id2);
        this.obs.sendKeys(obs);
        Utility.captureScreenShot(driver, FormPage.class);
    }
}
