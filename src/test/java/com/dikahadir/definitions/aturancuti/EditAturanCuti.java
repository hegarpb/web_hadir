package com.dikahadir.definitions.aturancuti;

import org.testng.Assert;

import com.dikahadir.Hooks;
import com.dikahadir.page.AturanCutiPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditAturanCuti {
private AturanCutiPage aturanCutiPage;

@Given("user sudah login dan diarahkan ke halaman Aturan Cuti")
public void navigateToAturanCutiPage(){
    this.aturanCutiPage = new AturanCutiPage(Hooks.getDriver());
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
@When("user menekan tombol Simpan pada form tambahkan aturan cuti")
public void clickButtonSimpan(){
    aturanCutiPage.clickButtonSimpanEdit();
}
@Then("sistem akan menampilkan pesan sukses {string}")
public void getPesanSukses(String expectedMessage){
    String actualMessage=aturanCutiPage.getMessageText();
    Assert.assertEquals(actualMessage, expectedMessage,"Validasi Aturan Cuti tidak sesuai!");

}
}
