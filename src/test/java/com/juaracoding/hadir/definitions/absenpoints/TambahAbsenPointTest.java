package com.juaracoding.hadir.definitions.absenpoints;

import org.testng.Assert;

import com.juaracoding.hadir.helpers.NavigationHelper;
import com.juaracoding.hadir.pages.AbsenPointPage;
import com.juaracoding.hadir.utils.DriverUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TambahAbsenPointTest {
    AbsenPointPage absenPointPage;

    @Given("Pengguna sudah melakukan login dan berada di halaman Absen Point")
    public void userIsOnAbsenPointPage() {
       NavigationHelper helper = new NavigationHelper(DriverUtil.getDriver());
       absenPointPage = helper.loginAndGoToAbsenPoint();
    }

    @When("Pengguna klik tombol Tambahkan")
    public void clickAddAbsenPoint() {
      absenPointPage.clickTambahAbsenPoint();
    }

    @And("Pengguna mengisi data {string}, {double}, {double}, {int}, {string} dan klik simpan")
    public void fillAbsenPointData(String nama, double latitude, double longitude, int radius, String deskripsi) {
    absenPointPage.performAbsenPoint(nama, latitude, longitude, radius, deskripsi);
    }

    @Then("Muncul popup konfirmasi {string}")
    public void popupKonfirmasi(String expected) {
        String actual = absenPointPage.getPopupBerhasilTambahAbsenPoint();
        Assert.assertEquals(actual, expected);
    }

    @When("lalu Pengguna klik tombol Tambahkan")
    public void clickAddAbsenPointAgain() {
    absenPointPage.clickTambahAbsenPoint();
    }

     @And("Pengguna mengisi data serupa {string}, {double}, {double}, {int}, {string} dan klik simpan lagi")
    public void performAbsenPointAgain(String nama, double latitude, double longitude, int radius, String deskripsi) {
    absenPointPage.performAbsenPoint(nama, latitude, longitude, radius, deskripsi);
    }

    @Then("Muncul popup konfirmasi bahwa {string}")
    public void popupKonfirmasiAgain(String expected) {
        String actual = absenPointPage.getPopupBerhasilTambahAbsenPoint();
        Assert.assertEquals(actual, expected);
    }

}
