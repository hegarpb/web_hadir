package com.dikahadir.definitions.jabatan;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dikahadir.Hooks;
import com.dikahadir.page.JabatanPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TambahJabatanTest {

    private JabatanPage jabatanPage;

    @Given("user sudah login dan berada di halaman Manajemen Jabatan")
    public void navigasiKeHalamanJabatanTambah() {
        this.jabatanPage = new JabatanPage(Hooks.getDriver());
        jabatanPage.navigateToJabatanPage();

        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10));
        jabatanPage.waitForButtonTambahkanVisible();
    }

    @When("user menekan tombol tambahkan")
    public void clickTombolTambahkan() {
        jabatanPage.clickButtonTambahkanJabatan();
    }

    @When("user menginput jabatan dengan nama {string} dan level {string}")
    public void tambahJabatan(String nama, String level) {
        jabatanPage.stepTambahJabatan(nama, level);
    }

    @When("user menekan tombol tambah di form tambah jabatan")
    public void clickTombolFormTambahJababatan() {
        jabatanPage.clickButtonTambahForm();
    }

    @When("user menekan tombol batal di form tambah jabatan")
    public void clickTombolBatal() {
        jabatanPage.clickButtonBatal();
    }

    @Then("form pada tambah jabatan akan tertutup")
    public void formHapusTertutup() {
        boolean isClosed = jabatanPage.waitUntilDeleteFormClosed();
        Assert.assertTrue(isClosed, "Form hapus jabatan seharusnya sudah tertutup");
    }

    @Then("form tambah jabatan akan tertutup")
    public void formTambahTertutup() {

    }

    @Then("sistem menampilkan pesan sukses {string}")
    public void pesanSukses(String expectedMessage) {
        String actualMessage = jabatanPage.getMessageText();
        Assert.assertEquals(actualMessage, expectedMessage,
                "Pesan sukses tidak sesuai!");
    }

    @Then("level jabatan akan di tampilkan {string}")
    public void tampilLevel(String level) throws InterruptedException {
        jabatanPage.inputSearchText(level);
        jabatanPage.clickSearchJabatan();
        Thread.sleep(5000);
        List<String> hasil = jabatanPage.getAllLevel();
        boolean ditemukan = hasil.stream()
                .anyMatch(nama -> nama.equalsIgnoreCase(level));

        Assert.assertTrue(ditemukan,
                "Data Level '" + level + "' tidak ditemukan di tabel. Hasil tabel: " + hasil);

    }

    @Then("sistem menampilkan pesan error {string}")
    public void pesanError(String expectedMessage) {
        String actualMessage = jabatanPage.getMessageText();
        Assert.assertEquals(actualMessage, expectedMessage,
                "Pesan error tidak sesuai!");
    }

    @Then("sistem menampilkan pesan validasi {string} pada field nama jabatan")
    public void validasiNamaJabatan(String expectedMessage) {
        String actualMessage = jabatanPage.getValidationNamaJabatan();
        Assert.assertEquals(actualMessage, expectedMessage,
                "Validasi nama jabatan tidak sesuai!");
    }

    @Then("sistem menampilkan pesan validasi {string} pada field level jabatan")
    public void validasiLevelJabatan(String expectedMessage) {
        String actualMessage = jabatanPage.getValidationLevelJabatan();
        Assert.assertEquals(actualMessage, expectedMessage,
                "Validasi level jabatan tidak sesuai!");
    }
}