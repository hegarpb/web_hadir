package com.juaracoding.hadir.definitions.absenpoints;

import org.testng.Assert;

import com.juaracoding.hadir.helpers.NavigationHelper;
import com.juaracoding.hadir.pages.AbsenPointPage;
import com.juaracoding.hadir.utils.DriverUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditAbsenPointTest {
    AbsenPointPage absenPointPage;

    @Given("Pengguna sudah melakukan login dan pengguna berada di halaman Absen Point")
    public void userIsOnAbsenPointPage(){
        NavigationHelper helper = new NavigationHelper(DriverUtil.getDriver());
        absenPointPage = helper.loginAndGoToAbsenPoint();
    }

    @And("Absen point {string} sudah ada")
    public void verifyDataAbsenPoint(String nama){
        absenPointPage.setSearch(nama);
        absenPointPage.clickSearch();
        boolean exists = absenPointPage.isAbsenPointExist(nama);
        Assert.assertTrue(exists, "Absen point " + nama + " tidak ditemukan!");
    }

    @When("Pengguna mencari absen point {string}")
    public void searchAbsenPoint(String Nama){
        absenPointPage.setSearch(Nama);
        absenPointPage.clickSearch();
    }

    @And("Pengguna klik ikon titik tiga pada absen point dan memilih opsi Edit")
    public void clikEdit(){
        absenPointPage.clikButtonEdit();
    }

    @And("Pengguna mengubah deskripsi menjadi {string}")
    public void editDescription(String Deskripsi ){
        absenPointPage.editAbsenPoint(Deskripsi);
    }

    @And("Pengguna klik tombol Simpan")
    public void clickSaveData(){
        absenPointPage.buttonSimpan();
    }

    @Then("Muncul popup konfirmasi menandakan {string}")
    public void getPopupMessage(String expected){
        String actual = absenPointPage.getPopupBerhasilEditAbsenPoint();
        Assert.assertEquals(actual, expected, "Pesan popup tidak sesuai!");
}
}
