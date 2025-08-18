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
    protected static WebDriver driver;
    protected static LoginPage loginPage;

    @Before
    public void setUp() {
        // Inisialisasi driver
        driver = DriverUtil.getDriver();
        driver.manage().window().maximize();

        // Buka halaman login
        driver.get("https://magang.dikahadir.com/authentication/login");

        // Lakukan login
        loginPage = new LoginPage(driver);
        loginPage.performLogin("admin@hadir.com","MagangSQA_JC@123");

        // Tunggu sampai menu Management muncul
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(//p[normalize-space()='Management'])[1]")));

        // Navigasi ke Management
        loginPage.navigateToManagementBar();
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            // Ambil screenshot
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // Attach ke report Cucumber
            scenario.attach(screenshot, "image/png", scenario.getName());
        } catch (Exception e) {
            System.out.println("Gagal mengambil screenshot: " + e.getMessage());
        } finally {
            // Tutup driver
            DriverUtil.quitDriver();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
