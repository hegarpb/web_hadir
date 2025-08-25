package com.dikahadir.definitions.aturancuti;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dikahadir.Hooks;
import com.dikahadir.page.AturanCutiPage;
import com.dikahadir.repository.AturanCutiRepository;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditAturanCutiTest {
private AturanCutiPage aturanCutiPage;
private WebDriverWait wait;


@Given("user sudah login dan diarahkan ke halaman Aturan Cuti")
public void navigateToAturanCutiPage(){
    this.aturanCutiPage = new AturanCutiPage(Hooks.getDriver());
    this.wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10)); 
    aturanCutiPage.navigateToAturanCuti();
    
    // Tunggu tabel siap dipakai
    aturanCutiPage.waitTableUpdated(null);
}

@When("user menekan tombol action pada aturan cuti {string}")
public void clickTombolAction(String namaAturan) throws InterruptedException{
    aturanCutiPage.inputSearchText(namaAturan);
    aturanCutiPage.clickButtonSearch();
    Thread.sleep(5000);
    aturanCutiPage.clickActionButtonRowPertama();
}

@When("user menekan tombol edit pada aturan cuti")
public void editAturanCuti(){
    aturanCutiPage.clickEditMenu();
}
@When("user menginput nama aturan cuti {string} pada form sunting aturan cuti")
public void inputNamaAturanBaru(String namaAturanBaru){
    aturanCutiPage.inputNamaAturan(namaAturanBaru);
}
@When("user menginput Eligible pengaturan cuti {string} pada form sunting aturan cuti")
public void inputEligableBaru(String EligableBaru){
    aturanCutiPage.inputEligablePengaturan(EligableBaru);
}
@When("user menginput tanggal batas sisa cuti {string} pada form sunting aturan cuti")
public void inputTanggalBatasBaru(String tangalBatasBaru){
aturanCutiPage.inputTanggalBatasSisaCuti(tangalBatasBaru);
}
@When("user menginput bulan batas sisa cuti {string} pada form sunting aturan cuti")
public void inputBulanBatasBaru(String bulanBatasBaru){
    aturanCutiPage.inputBulanBatasSisaCuti(bulanBatasBaru);
}
@When ("user menginput maksimal sisa cuti {string} pada form sunting aturan cuti")
public void inputMaksimalSisaCuti(String maksimalSisaBaru){
    aturanCutiPage.InputMaksimalSisaCuti(maksimalSisaBaru);
}
@When("user menginput jumlah bulan kerja sisa cuti {string} pada form sunting aturan cuti")
public void inputBulanKerjaSisa(String bulanKerjaSisaBaru){
    aturanCutiPage.inputJumlahBulanKerjaSisaCuti(bulanKerjaSisaBaru);
}
@When("user menekan tombol Simpan pada form sunting aturan cuti")
public void clickButtonSimpan() {
    aturanCutiPage.clickButtonSimpanEdit();

}
@When("user menekan tombol tutup pada form sunting Aturan Cuti")
public void clickTombolBatal(){
    aturanCutiPage.clickButtonTutup();
}
@Then("sistem akan menampilkan pesan {string}.")
public void getPesanSukses(String expectedMessage){
    String actualMessage=aturanCutiPage.getMessageText();
    Assert.assertEquals(actualMessage, expectedMessage,"Validasi Aturan Cuti tidak sesuai!");

}
@Then("pesan validasi akan muncul pada field kosong")
public void pesanValidasiMunculSaatEditKosong() {
    aturanCutiPage = new AturanCutiPage(Hooks.getDriver());

    if (aturanCutiPage.isElementPresent(AturanCutiRepository.nameError)) {
        Assert.assertEquals(aturanCutiPage.getErrorNamaAturan(), "Nama aturan cuti harus diisi!");
    }

    if (aturanCutiPage.isElementPresent(AturanCutiRepository.tanggalBatasError)) {
        Assert.assertEquals(aturanCutiPage.getErrorTanggalBatas(), "Tanggal batas sisa cuti harus diisi!");
    }

   if (aturanCutiPage.isElementPresent(AturanCutiRepository.maksimalSisaError)) {
        Assert.assertEquals(aturanCutiPage.getErrorMaksimalSisa(), "Maksimal sisa cuti harus diisi!");
    }
    if (aturanCutiPage.isElementPresent(AturanCutiRepository.maksimalSisaError)) {
        Assert.assertEquals(aturanCutiPage.getErrorMaksimalSisa(), "Maksimal sisa cuti harus diisi!");
    }
}

@Then("data aturan cuti {string} ditampilkan di tabel.")
 public void tampilDataBaruDItambahkan(String namaAturanBaru) throws InterruptedException{

    aturanCutiPage.inputSearchText(namaAturanBaru);
    aturanCutiPage.clickButtonSearch();
    Thread.sleep(5000);
    List<String> hasil = aturanCutiPage.getAllNamaAturan();
    boolean ditemukan = hasil.stream()
            .anyMatch(nama -> nama.equalsIgnoreCase(namaAturanBaru));

    Assert.assertTrue(ditemukan,
            "Data aturan cuti '" + namaAturanBaru + "' tidak ditemukan di tabel. Hasil tabel: " + hasil);
}

@Then("form sunting aturan cuti akan tertutup")
public void formEditTutup(){
// Tunggu sampai form/modal sunting hilang
    boolean isFormClosed = wait.until(
        ExpectedConditions.invisibilityOfElementLocated(AturanCutiRepository.formEditAturanCuti)
    );
    Assert.assertTrue(isFormClosed, "Form Sunting Aturan Cuti masih terlihat padahal harusnya sudah tertutup!");
}
}
