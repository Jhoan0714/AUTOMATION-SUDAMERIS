/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnb.sudameris.selendroid.util;

import io.appium.java_client.AppiumDriver;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 *
 * @author Jhoan Lopez
 */
public class Utility {

    public static void captureScreenShot(AppiumDriver driver, Class cls) {
        try {
            // Take screenshot and store as a file format            
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("Evidencias\\" + cls.getSimpleName() + "_" + new Exception().getStackTrace()[1].getMethodName() + "_" + System.currentTimeMillis() + ".png"));
        } catch (IOException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
