package com.dikahadir.definitions.Jabatan;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir.Hooks;
import com.dikahadir.page.JabatanPage;
import com.dikahadir.page.ManagementPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TambahJabatanTest extends Hooks{

    ManagementPage managementPage;
    JabatanPage jabatanPage = new JabatanPage(driver);
    @Given("user berada di halaman Manajemen Jabatan")
    public void step01(){
        
        jabatanPage.navigateToJabatanPage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Tambahkan']")));

    }
    @When("user menambahkan jabatan dengan nama {string} dan level {string}")
    public void step02(String namaJabatan,String leveljabatan){
          jabatanPage.stepTambahjabatan("SPV2", "2");
    }
    @Then(" sistem menampilkan pesan sukses {string}")
    public void step03(String expectedMessage){
        String actualMessage =jabatanPage.getMessageText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test (priority = 2, description = "Verifikasi penambahan jabatan baru dengan nama jabatan yang sudah ada")
    public void TestTambahJabatanInvalidData1(){
        JabatanPage jabatanPage = new JabatanPage(driver);
        jabatanPage.navigateToJabatanPage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Tambahkan']")));
        
        jabatanPage.stepTambahjabatan("SPV2", "2");
        String expectedMessage = "Gagal Menambahkan Job Level";
        Assert.assertEquals(jabatanPage.getMessageText(), expectedMessage);
        
    }

    @Test (priority = 3, description = "Verifikasi penambahan jabatan baru dengan nama jabatan yang kosong")
    public void TestTambahJabatanInvalidData2(){
        JabatanPage jabatanPage = new JabatanPage(driver);
        jabatanPage.navigateToJabatanPage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Tambahkan']")));
        
        jabatanPage.stepTambahjabatan("", "2");
        String validation=jabatanPage.getValidationNamaJabatan();
        String expectedMessage="Isi isian ini.";
        Assert.assertEquals(validation, expectedMessage);        
    }

    @Test (priority = 4, description = "Verifikasi penambahan jabatan baru dengan level yang kosong")
    public void TestTambahJabatanInvalidData3(){
        JabatanPage jabatanPage = new JabatanPage(driver);
        jabatanPage.navigateToJabatanPage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Tambahkan']")));
        
        jabatanPage.stepTambahjabatan("Marketing", "");
        String validation=jabatanPage.getValidationLevelJabatan();
        String expectedMessage="Isi isian ini.";
        Assert.assertEquals(validation, expectedMessage);        
    }


}