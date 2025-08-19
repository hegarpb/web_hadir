package com.dikahadir;

import com.dikahadir.page.LoginPage;
import com.dikahadir.utils.DriverUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {

    private static WebDriver driver;
    private static LoginPage loginPage;

    // Metode untuk memulai driver dan login. Gunakan @Before di sini.
    @Before
    public void setUp() {
        
        driver = DriverUtil.getDriver();
        driver.manage().window().maximize();

        
        driver.get("https://magang.dikahadir.com/authentication/login");

        
        loginPage = new LoginPage(driver);
        loginPage.performLogin("admin@hadir.com","MagangSQA_JC@123");

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(//p[normalize-space()='Management'])[1]")));

        
        loginPage.navigateToManagementBar();
    }

    
    @After
    public void tearDown(Scenario scenario) {
        try {
            if (driver != null && scenario.isFailed()) {
                
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } catch (Exception e) {
            System.out.println("Gagal mengambil screenshot: " + e.getMessage());
        } finally {
            // Tutup driver
            if (driver != null) {
                DriverUtil.quitDriver();
            }
        }
    }

   
    public static WebDriver getDriver() {
        return driver;
    }
}