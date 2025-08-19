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

    // Metode untuk menghentikan driver dan mengambil screenshot. Gunakan @After di sini.
    @After
    public void tearDown(Scenario scenario) {
        try {
            if (driver != null && scenario.isFailed()) {
                // Ambil screenshot hanya jika skenario gagal
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                // Attach ke report Cucumber
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

    // Metode static untuk menyediakan akses driver ke kelas Step Definitions
    public static WebDriver getDriver() {
        return driver;
    }
}