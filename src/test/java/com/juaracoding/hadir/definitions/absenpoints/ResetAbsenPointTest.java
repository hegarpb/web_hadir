package com.juaracoding.hadir.definitions.absenpoints;

import org.testng.Assert;

import com.juaracoding.hadir.helpers.NavigationHelper;
import com.juaracoding.hadir.pages.AbsenPointPage;
import com.juaracoding.hadir.utils.DriverUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResetAbsenPointTest {
    AbsenPointPage absenPointPage;

    @Given("Pengguna melakukan login dan pegguna sudah berada di halaman Absen Point")
    public void userIsOnAbsenPointPage() {
        NavigationHelper helper = new NavigationHelper(DriverUtil.getDriver());
        absenPointPage = helper.loginAndGoToAbsenPoint();
    }
    
     @When("Masukkan nama {string} pada kolom pencarian")
    public void userInputsName(String nama) {
        absenPointPage.setSearch(nama);
    }

    @And("Klik tombol Reset")
    public void userClicksResetButton() {
        absenPointPage.clickReset();
    }

    @Then("Kolom pencarian kosong")
    public void searchBoxShouldBeEmpty() {
        String actual = absenPointPage.getSearchBoxText();
        Assert.assertEquals(actual, "", "Kolom pencarian seharusnya kosong setelah reset!");
    }
}
