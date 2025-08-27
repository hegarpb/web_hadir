package com.juaracoding.hadir.definitions.absenpoints;

import org.testng.Assert;

import com.juaracoding.hadir.helpers.NavigationHelper;
import com.juaracoding.hadir.pages.AbsenPointPage;
import com.juaracoding.hadir.utils.DriverUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HapusAbsenPointTest {
    AbsenPointPage absenPointPage;
    String namaAbsen;

    @Given("Pengguna sudah melakukan login dan pengguna sudah di halaman Absen Point")
    public void userInOnAbsenPointPage(){
        NavigationHelper helper = new NavigationHelper(DriverUtil.getDriver());
        absenPointPage = helper.loginAndGoToAbsenPoint();
    }

    @When("Pengguna mencari atau search absen point {string}")
    public void searchAbsenPoint(String nama){
        this.namaAbsen = nama;
        absenPointPage.setSearch(nama);
        absenPointPage.clickSearch();
    }

    @And("Pengguna klik ikon titik tiga di sebelah kanan dan memilih opsi Hapus")
    public void clikHapus(){
        absenPointPage.clickButtonHapus(namaAbsen);
    }

    @And("Pengguna konfirmasi penghapusan")
    public void confirmationHapus(){
        absenPointPage.clickYaConfirm();
    }

    @Then("Pengguna mendapatkan popup {string}")
    public void getPopupMessage(String expected){
        String actual = absenPointPage.getPopupBerhasilHapusAbsenPoint();
        Assert.assertEquals(actual, expected, "Pesan popup tidak sesuai!");
    }
}
