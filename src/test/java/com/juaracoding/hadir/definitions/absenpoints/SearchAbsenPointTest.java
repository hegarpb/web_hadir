package com.juaracoding.hadir.definitions.absenpoints;

import org.testng.Assert;
import com.juaracoding.hadir.helpers.NavigationHelper;
import com.juaracoding.hadir.pages.AbsenPointPage;
import com.juaracoding.hadir.pages.HeaderPage;
import com.juaracoding.hadir.utils.DriverUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchAbsenPointTest {
    AbsenPointPage absenPointPage;
    HeaderPage headerPage;

    // ---------------- Scenario: Search Absen Point ----------------
    @Given("Pengguna sudah login dan berada di halaman Absen Point")
    public void userIsOnAbsenPointPage() {
        NavigationHelper helper = new NavigationHelper(DriverUtil.getDriver());
        absenPointPage = helper.loginAndGoToAbsenPoint();
    }

    @When("Masukkan nama {string} yang valid pada kolom pencarian")
    public void userInputsValidName(String nama) {
        headerPage = new HeaderPage(DriverUtil.getDriver());
        headerPage.setSearch(nama);
    }

    @And("Klik tombol Search")
    public void userClicksSearchButton() {
        headerPage.clickSearch();
    }

    @Then("Absen point {string} muncul di baris pertama")
    public void absenPointAppearsInFirstRow(String expected) {
        String actualNama = absenPointPage.getDataBarisPertama(expected);
        Assert.assertEquals(actualNama, expected, "Nama di baris pertama tidak sesuai!");
    }
}
