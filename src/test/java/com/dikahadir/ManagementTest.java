package com.dikahadir;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir.page.ManagementPage;
import com.dikahadir.utils.DriverUtil;

public class ManagementTest extends BaseTest {
    
    @Test
    public void openManagementMenu() throws InterruptedException {
        // Klik menu Management setelah login berhasil
        loginPage.navigateToManagementBar();
        // Thread.sleep(2000);
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.clickAbsenPointMenu();


        String actual= driver.getCurrentUrl();
        String expected= "https://magang.dikahadir.com/management/location-point";
        Assert.assertEquals(actual, expected);
    }
}
