package com.dikahadir.definitions.aturancuti;

import com.dikahadir.Hooks;
import com.dikahadir.page.AturanCutiPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TambahAturanCutiTest {

    private AturanCutiPage aturanCutiPage;
    private WebDriverWait wait;

    @Given("user melakukan login dan berada di halaman manajemen Aturan Cuti")
    public void userBeradaDiHalamanTambahAturanCuti() {
        this.aturanCutiPage = new AturanCutiPage(Hooks.getDriver());
        this.wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10)); 
        aturanCutiPage.navigateToAturanCuti();
    }

    @When("user menekan tombol Tambahkan Aturan Cuti")
    public void userClickButtonTambahkanAturan(){
        aturanCutiPage.clickButtonTambahkanAturan();
    }

    @When("user menginput nama aturan cuti {string}")
    public void userMengisiNamaAturanCuti(String namaAturan) {
        aturanCutiPage.inputNamaAturan(namaAturan);
    }

    @When("user menginput Eligible pengaturan cuti {string}")
    public void userMengisiEligiblePengaturanCuti(String eligible) {
        aturanCutiPage.inputEligablePengaturan(eligible);
    }

    @When("user menginput tanggal batas sisa cuti {string}")
    public void userMengisiTanggalBatasSisaCuti(String hari) {
        aturanCutiPage.inputTanggalBatasSisaCuti(hari);
    }

    @When("user menginput bulan batas sisa cuti {string}")
    public void userMengisiBulanBatasSisaCuti(String bulan) {
        aturanCutiPage.inputBulanBatasSisaCuti(bulan);
    }

    @When("user menginput maksimal sisa cuti {string}")
    public void userMengisiMaksimalSisaCuti(String  maksimal) {
        aturanCutiPage.InputMaksimalSisaCuti(maksimal);
    }

    @When("user menginput jumlah bulan sisa kerja cuti {string}")
    public void userMengisiJumlahBulanKerjaSisaCuti(String jumlah) {
        aturanCutiPage.inputJumlahBulanKerjaSisaCuti(jumlah);
    }

    @When("user menekan tombol Tambahkan pada form tambahkan aturan cuti")
    public void userMenekanTombolTambahkan() {
        aturanCutiPage.clickButtonTambahkan();
    }

    @When ("user menekan tombol tutup pada form tambahkan aturan cuti")
    public void clickButtonTutup(){
        aturanCutiPage.clickButtonTutup();
    }

    @Then("sistem menampilkan pesan {string}")
    public void aturanCutiBerhasilDitambahkan(String expectedMessage) {
        String actualMessage = aturanCutiPage.getMessageText();
        Assert.assertEquals(actualMessage, expectedMessage, 
            "Pesan sukses tidak sesuai!");
    }

    @Then("form tambah aturan cuti akan tertutup")
    public void tutupFormTambahAturan(){
         boolean isFormClosed = wait.until(
        ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h2[normalize-space()='Tambahkan Aturan Cuti']"))
    );
    Assert.assertTrue(isFormClosed, "Form Tambahkan Aturan Cuti masih terlihat padahal harusnya sudah tertutup!");
}
    }

