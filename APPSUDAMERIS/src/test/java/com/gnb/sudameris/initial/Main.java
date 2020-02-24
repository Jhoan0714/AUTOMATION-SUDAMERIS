/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnb.sudameris.initial;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;

/**
 *
 * @author Jhoan Lopez
 */
public class Main {

    public static void main(String[] args) {
        List<String> file = new ArrayList<>();
        file.add(System.getProperty("user.dir") + "\\TestNG.xml");
        TestNG testNG = new TestNG();
        testNG.setTestSuites(file);
        testNG.run();
    }
}
