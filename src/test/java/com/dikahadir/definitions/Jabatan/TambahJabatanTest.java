package com.dikahadir.definitions.jabatan;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dikahadir.Hooks;
import com.dikahadir.page.JabatanPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TambahJabatanTest {

    private JabatanPage jabatanPage;

    @Given("user berada di halaman Manajemen Jabatan")
    public void navigasiKeHalamanJabatan(){
        // Inisialisasi setelah Hooks.getDriver() siap
        this.jabatanPage = new JabatanPage(Hooks.getDriver());
        jabatanPage.navigateToJabatanPage();

        // Tunggu tombol Tambahkan muncul
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Tambahkan']")));
    }

    @When("user menambahkan jabatan dengan nama {string} dan level {string}")
    public void tambahJabatan(String nama, String level) {
        jabatanPage.stepTambahJabatan(nama, level);
    }

    @Then("sistem menampilkan pesan sukses {string}")
    public void pesanSukses(String expectedMessage){
        String actualMessage = jabatanPage.getMessageText();
        Assert.assertEquals(actualMessage, expectedMessage, 
            "Pesan sukses tidak sesuai!");
    }

    @Then("sistem menampilkan pesan error {string}")
    public void pesanError(String expectedMessage){
        String actualMessage = jabatanPage.getMessageText();
        Assert.assertEquals(actualMessage, expectedMessage, 
            "Pesan error tidak sesuai!");
    }

    @Then("sistem menampilkan pesan validasi {string} pada field nama jabatan")
    public void validasiNamaJabatan(String expectedMessage){
        String actualMessage = jabatanPage.getValidationNamaJabatan();
        Assert.assertEquals(actualMessage, expectedMessage, 
            "Validasi nama jabatan tidak sesuai!");
    }

    @Then("sistem menampilkan pesan validasi {string} pada field level jabatan")
    public void validasiLevelJabatan(String expectedMessage){
        String actualMessage = jabatanPage.getValidationLevelJabatan();
        Assert.assertEquals(actualMessage, expectedMessage, 
            "Validasi level jabatan tidak sesuai!");
    }
}
