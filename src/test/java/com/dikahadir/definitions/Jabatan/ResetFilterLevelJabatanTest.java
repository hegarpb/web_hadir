package com.dikahadir.definitions.Jabatan;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir.Hooks;
import com.dikahadir.page.JabatanPage;

import java.time.Duration;
import java.util.List;

public class ResetFilterLevelJabatanTest extends Hooks {
    
    @Test(priority=2, description="Verifikasi fungsionalitas tombol Reset Filter.")
    public void testResetFilter() throws InterruptedException {
        JabatanPage jabatanPage = new JabatanPage(driver);
        
        jabatanPage.navigateToJabatanPage();

        int initialCount = jabatanPage.getRowsCount();
    String expectedLevel = "2";

     jabatanPage.searchLevelJabatan(expectedLevel);   
    
        jabatanPage.clickResetFilter();
        int filteredCount = jabatanPage.getRowsCount();
        Assert.assertTrue(filteredCount > 0);
        jabatanPage.clickResetFilter();
        int resetCount = jabatanPage.getRowsCount();
        Assert.assertEquals(resetCount, initialCount);
        
        
       
        // 5. Verifikasi: Periksa apakah jumlah baris kembali ke jumlah awal
        // int resetRows = jabatanPage.getRowsCount();
        
        // Assert.assertEquals(resetRows, initialRows, "Jumlah baris tidak kembali ke jumlah awal setelah reset filter.");
    }
}