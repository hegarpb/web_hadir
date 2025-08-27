package com.dikahadir.definitions.jadwal;

import com.dikahadir.Hooks;
import com.dikahadir.page.JadwalPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.util.List;

public class TambahJadwalTest {

    private JadwalPage jadwalPage;

    @Given("user sudah login dan berada di halaman jadwal")
    public void userSudahLoginDanBeradaDiHalamanJadwal() {
        this.jadwalPage = new JadwalPage(Hooks.getDriver());
        jadwalPage.navigateToJadwalPage();
    }

    @When("user menekan tombol Tambahkan pada halaman jadwal")
    public void userMenekanTombolTambahkan() {
        jadwalPage.clickTambahJadwal();
    }

    @And("user memilih menu dropdown tipe jadwal kerja {string}")
    public void userMemilihMenuDropdownTipeJadwalKerja(String tipe) {
        jadwalPage.setTipeJadwal(tipe);
    }

    @And("user menginput tanggal efektif {string} {string} {string}")
    public void userMenginputTanggalEfektif(String hari, String bulan, String tahun) throws InterruptedException {
        jadwalPage.clickIconCalendar();
        jadwalPage.setTanggal(hari, bulan, tahun);
        Thread.sleep(2000);
    }

    @And("user menginput nama jadwal kerja {string}")
    public void userMenginputNamaJadwalKerja(String namaJadwal) {
        jadwalPage.inputNamaJadwal(namaJadwal);
    }

    @And("user menekan tombol hari kerja")
    public void userMenekanTombolHariKerja() {
        jadwalPage.clickButtonHariKerja();
    }

    @And("user mengisi jumlah hari kerja:")
    public void userMengisiJumlahHariKerja() throws InterruptedException {
        jadwalPage.isiSemuaHari();
    }

    @And("user menekan tombol terapkan pada form tambah jadwal")
    public void userMenekanTombolTerapkanPadaFormTambahJadwal() {
        jadwalPage.clickButtonTerapkan();
    }

    @And("user mengisi toleransi keterlambatan {string}")
    public void userMengisiToleransiKeterlambatan(String menit) {
        jadwalPage.inputToleransiTerlambat(menit);
    }

    @And("user menekan tombol tambah")
    public void clickButtonTambah() throws InterruptedException {
        jadwalPage.clickButtonTambah();
    }

    @And("user menekan tombol batal pada modal tambah jadwal")
    public void clickTombolBatal() {
        jadwalPage.clickButtonBatal();
    }

    @Then("muncul pesan {string}")
    public void displayNamaJadwal(String expectedMessage)  {
       String actual = jadwalPage.getPopupMessage();
        Assert.assertEquals(actual, expectedMessage, "Pesan popup tidak sesuai!");
      
    }

    @Then("muncul pesan validasi pada field tipe jadwal {string}")
    public void validasiTipeJadwal(String pesanTipe) {
        String actualMessage = jadwalPage.getValidationTipeJadwal();
        Assert.assertEquals(actualMessage, pesanTipe,
                "pesan Validasi tipe jadwal tidak sesuai!");
    }

    @Then("muncul pesan validasi pada field nama jadwal kerja {string}")
    public void validasiNamaJadwal(String pesanNama)  {
        String actualMessage = jadwalPage.getNativeValidationNamaJadwal();
        Assert.assertEquals(actualMessage, pesanNama,
                "pesan Validasi nama jadwal tidak sesuai!");
    }

    @Then("muncul pesan validasi pada field toleransi keterlambatan {string}")
    public void validasiToleransi(String pesanToleransi) {
        String actualMessage = jadwalPage.getNativeValidationToleransi();
        Assert.assertEquals(actualMessage, pesanToleransi,
                "pesan Validasi toleransi keterlambatan tidak sesuai!");
    }


    @Then("modal tambah jadwal akan tertutup")
    public void modalTambahJadwalTertutup() {
        jadwalPage.modalTutup();
    }
}