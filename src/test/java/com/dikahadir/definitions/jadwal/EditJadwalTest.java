package com.dikahadir.definitions.jadwal;

import java.util.List;
import org.testng.Assert;

import com.dikahadir.Hooks;
import com.dikahadir.page.JadwalPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditJadwalTest {

    private JadwalPage jadwalPage;

    public EditJadwalTest() {
        this.jadwalPage = new JadwalPage(Hooks.getDriver());
    }

    @Given("user login sebagai admin dan ada di halaman jadwal")
    public void userSudahLoginDanBeradaDiHalamanJadwal() {
        jadwalPage.navigateToJadwalPage();
    }

    @When("user menekan tombol action pada nama jadwal {string}.")
    public void clickTombolAction(String namaJadwal) throws InterruptedException {
        jadwalPage.displayNamaJadwal(namaJadwal);
        Thread.sleep(1000);
        jadwalPage.clickActionButtonRowPertama();
    }

    @And("user memilih menu edit")
    public void clickMenuEdit() {
        jadwalPage.clickEditMenu();
    }

    @And("user memilih menu dropdown tipe jadwal kerja. {string}")
    public void setTipeJadwal(String tipeJadwal) {
        jadwalPage.setTipeJadwal(tipeJadwal);
    }

    @And("user menginput tanggal efektif. {string} {string} {string}")
    public void setTanggal(String hari, String bulan, String tahun) {
        jadwalPage.clickIconCalendar();
        jadwalPage.setTanggal(hari, bulan, tahun);
    }

    @And("user menginput nama jadwal kerja. {string}")
    public void inputNamaJadwal(String namaJadwalBaru) throws InterruptedException {
        jadwalPage.inputNamaJadwal(namaJadwalBaru);
        Thread.sleep(3000);
    }

    @And("user menekan tombol hari kerja.")
    public void clickHariKerja() {
        jadwalPage.clickButtonHariKerja();
    }

    @And("user mengisi jumlah hari kerja.")
    public void isiHariKerja() throws InterruptedException {
        jadwalPage.isiSemuaHari();
    }

    @And("user menekan tombol terapkan pada form tambah jadwal.")
    public void clickTerapkan() {
        jadwalPage.clickButtonTerapkan();
    }

    @And("user mengisi toleransi keterlambatan {string}.")
    public void isiToleransi(String menit) {
        jadwalPage.inputToleransiTerlambat(menit);
    }

    @And("user menekan tombol simpan.")
    public void clickSimpan() {
        jadwalPage.clickButtonSimpan();
    }

    @And("user menekan tombol batal pada modal edit jadwal")
    public void clickTombolBatal() {
        jadwalPage.clickButtonBatal();
    }

    @Then("sistem akan menampilkan pesan popup {string}.")
    public void getPesanBerhasil(String expectedMessage) {
        String actual = jadwalPage.getPopupMessage();
        Assert.assertEquals(actual, expectedMessage, "Pesan popup tidak sesuai!");
    }

    @Then("nama jadwal yang sudah di edit akan muncul dalam tabel  {string}.")
    public void displayNamaBaru(String namaJadwalBaru) throws InterruptedException {
        jadwalPage.displayNamaJadwal(namaJadwalBaru);
        Thread.sleep(3000);
        List<String> hasil = jadwalPage.getAllJadwal();
        Assert.assertTrue(hasil.contains(namaJadwalBaru),
                "Nama jadwal tidak ditemukan dalam tabel!");
    }

    @Then("muncul pesan validasi pada field tipe jadwal {string}.")
    public void validasiTipeJadwal(String expectedMessage) {
        String actualMessage = jadwalPage.getValidationTipeJadwal();
        Assert.assertEquals(actualMessage, expectedMessage,
                "Pesan Validasi tipe jadwal tidak sesuai!");
    }

    @Then("muncul pesan validasi pada field nama jadwal kerja {string}.")
    public void validasiNamaJadwal(String expectedMessage) throws InterruptedException {
        String actualMessage = jadwalPage.getValidationNamaJadwal();
        Assert.assertEquals(actualMessage, expectedMessage,
                "Pesan Validasi nama jadwal tidak sesuai!");
    }

    @Then("muncul pesan validasi pada field toleransi keterlambatan {string}.")
    public void validasiToleransi(String expectedMessage) {
        String actualMessage = jadwalPage.getValidationToleransi();
        Assert.assertEquals(actualMessage, expectedMessage,
                "Pesan Validasi toleransi keterlambatan tidak sesuai!");
    }

    @Then("modal edit jadwal akan tertutup")
    public void modalEditJadwalTertutup() {
        jadwalPage.modalTutup();
    }
}
