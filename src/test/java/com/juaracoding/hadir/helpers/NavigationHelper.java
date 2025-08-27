package com.juaracoding.hadir.helpers;

import org.openqa.selenium.WebDriver;

import com.juaracoding.hadir.pages.AbsenPointPage;
import com.juaracoding.hadir.pages.DashboardPage;
import com.juaracoding.hadir.pages.LoginPage;
import com.juaracoding.hadir.pages.ShiftingPage;

public class NavigationHelper {
    private WebDriver driver;

    // Default credential (biar reusable dan ga duplikat di step definition)
    private final String DEFAULT_EMAIL = "admin@hadir.com";
    private final String DEFAULT_PASSWORD = "MagangSQA_JC@123";

    public NavigationHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Flow login dengan default credential lalu masuk ke halaman Absen Point
     */
    public AbsenPointPage loginAndGoToAbsenPoint() {
        // buka halaman login
        driver.get("https://magang.dikahadir.com/authentication/login");

        // login pakai default credential
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(DEFAULT_EMAIL, DEFAULT_PASSWORD);

        // akses dashboard
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clikMenuManagement();

        // masuk ke submenu Absen Point
        AbsenPointPage absenPointPage = new AbsenPointPage(driver);
        absenPointPage.clikSubMenuAbsenPoint();

        return absenPointPage;
    }

    /**
     * Flow login dengan default credential lalu masuk ke halaman Shifting
     */
    public ShiftingPage loginAndGoToShifting() {
        // buka halaman login
        driver.get("https://magang.dikahadir.com/authentication/login");

        // login pakai default credential
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(DEFAULT_EMAIL, DEFAULT_PASSWORD);

        // akses dashboard
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clikMenuManagement();

        // masuk ke submenu Shifting
        ShiftingPage shiftingPage = new ShiftingPage(driver);
        shiftingPage.clikSubMenuShifting();

        return shiftingPage;
    }
}