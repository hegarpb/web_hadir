package com.dikahadir;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir.page.JabatanPage;
import com.dikahadir.page.LoginPage;
import com.dikahadir.page.ManagementPage;

public class JabatanTest extends BaseTest{
    LoginPage loginPage;
    ManagementPage managementPage;
    
    @Test(priority = 1, description = "Verifikasi penambahan jabatan baru dengan data valid")
    public void testTambahJabatanBaru() {
        loginPage = new LoginPage(driver);
        loginPage.navigateToManagementBar();
        managementPage = new ManagementPage(driver);
        managementPage.clickJabatanMenu();

        JabatanPage jabatanPage = new JabatanPage(driver);

        // Tunggu hingga tombol "Tambahkan" terlihat, memastikan halaman telah dimuat
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Tambahkan']")));

        // Langkah-langkah untuk menambah jabatan
        jabatanPage.stepTambahjabatan("STEFF", "2");

        // Validasi: pastikan pesan sukses muncul
        String expectedMessage = "Berhasil Menambahkan Job Level";
        Assert.assertEquals(jabatanPage.getMessageText(), expectedMessage, "Isi pesan sukses tidak sesuai.");
    }

    @Test (priority = 2, description = "Verifikasi penambahan jabatan baru dengan nama jabatan yang sudah ada")
    public void negativeTestTambahJabatan(){
        loginPage = new LoginPage(driver);
        loginPage.navigateToManagementBar();
        managementPage = new ManagementPage(driver);
        managementPage.clickJabatanMenu();

        JabatanPage jabatanPage = new JabatanPage(driver);

        // Tunggu hingga tombol "Tambahkan" terlihat, memastikan halaman telah dimuat
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Tambahkan']")));

        // Langkah-langkah untuk menambah jabatan
        jabatanPage.stepTambahjabatan("STEFF", "2");
        String expectedMessage = "Gagal Menambahkan Job Level";
        Assert.assertEquals(jabatanPage.getMessageText(), expectedMessage);
        
    }
}