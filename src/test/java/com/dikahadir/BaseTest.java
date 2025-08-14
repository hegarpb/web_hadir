package com.dikahadir;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.dikahadir.page.LoginPage;
import com.dikahadir.utils.DriverUtil;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        // Inisialisasi driver
        driver = DriverUtil.getDriver();
        driver.manage().window().maximize();

        // Buka halaman login
        driver.get("https://magang.dikahadir.com/authentication/login");

        // Lakukan login
        loginPage = new LoginPage(driver);
        loginPage.performLogin("admin@hadir.com","MagangSQA_JC@123");
    }

    @AfterClass
    public void tearDown() {
        DriverUtil.quitDriver();
    }
}
