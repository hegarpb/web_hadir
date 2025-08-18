package com.dikahadir;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.dikahadir.page.LoginPage;
import com.dikahadir.utils.DriverUtil;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    

    @BeforeMethod
    public void setUp() {
        // Inisialisasi driver
        driver = DriverUtil.getDriver();
        driver.manage().window().maximize();

        // Buka halaman login
        driver.get("https://magang.dikahadir.com/authentication/login");

        // Lakukan login
        loginPage = new LoginPage(driver);
        loginPage.performLogin("admin@hadir.com","MagangSQA_JC@123");

        // Tunggu sampai menu Management muncul → ganti Thread.sleep dengan WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("(//p[normalize-space()='Management'])[1]")));
        loginPage = new LoginPage(driver);
        loginPage.navigateToManagementBar();
    }

    @AfterMethod
    public void tearDown() {
        DriverUtil.quitDriver();
    }
}
