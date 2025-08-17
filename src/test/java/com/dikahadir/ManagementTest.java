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
        
        // Thread.sleep(2000);
        ManagementPage managementPage = new ManagementPage(driver);
        managementPage.clickJabatanMenu();
        Thread.sleep(5000);


        
    }
}
