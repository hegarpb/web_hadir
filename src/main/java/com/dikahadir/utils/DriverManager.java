package com.dikahadir.utils;

import java.io.FileReader;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
public class DriverManager {
    private WebDriver driver;

    public DriverManager (){
        
        driver=new FirefoxDriver();
        driver.manage().window().maximize(); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void quitDriver(){
        driver.quit();
    }
    
}
