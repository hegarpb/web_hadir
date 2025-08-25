package com.dikahadir.definitions.aturancuti;

import com.dikahadir.Hooks;
import com.dikahadir.page.AturanCutiPage;
import com.dikahadir.repository.AturanCutiRepository;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;
import java.util.List;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.buttonTambahAturan));
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
        ExpectedConditions.invisibilityOfElementLocated(AturanCutiRepository.formTambahAturan));
    Assert.assertTrue(isFormClosed, "Form Tambahkan Aturan Cuti harusnya sudah tertutup!");
}
    @Then("data aturan cuti {string} ditampilkan di tabel")
    public void tampilDataBaruDItambahkan(String namaAturan) throws InterruptedException{
    aturanCutiPage.inputSearchText(namaAturan);
    aturanCutiPage.clickButtonSearch();
    Thread.sleep(5000);
    List<String> hasil = aturanCutiPage.getAllNamaAturan();
    boolean ditemukan = hasil.stream()
            .anyMatch(nama -> nama.equalsIgnoreCase(namaAturan));

    Assert.assertTrue(ditemukan,
            "Data aturan cuti '" + namaAturan + "' tidak ditemukan di tabel. Hasil tabel: " + hasil);
}
    @Then("muncul pesan validasi pada field kosong")
    public void munculPesanValidasiPadaFieldKosong() {
    if (aturanCutiPage.isElementPresent(AturanCutiRepository.nameError)) {
        Assert.assertEquals(aturanCutiPage.getErrorNamaAturan(), "Nama aturan cuti harus diisi!");
    }

    if (aturanCutiPage.isElementPresent(AturanCutiRepository.tanggalBatasError)) {
        Assert.assertEquals(aturanCutiPage.getErrorTanggalBatas(), "Tanggal batas sisa cuti harus diisi!");
    }

    if (aturanCutiPage.isElementPresent(AturanCutiRepository.maksimalSisaError)) {
        Assert.assertEquals(aturanCutiPage.getErrorMaksimalSisa(), "Maksimal sisa cuti harus diisi!");
    }
}

    }

