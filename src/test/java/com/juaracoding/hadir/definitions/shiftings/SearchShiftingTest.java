package com.juaracoding.hadir.definitions.shiftings;

import org.testng.Assert;

import com.juaracoding.hadir.helpers.NavigationHelper;
import com.juaracoding.hadir.pages.HeaderPage;
import com.juaracoding.hadir.pages.ShiftingPage;
import com.juaracoding.hadir.utils.DriverUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchShiftingTest {
    ShiftingPage shiftingPage;
    HeaderPage headerPage;

    @Given("Pengguna sudah login dan berada di halaman Shifting")
    public void userIsOnShiftingPage(){
        NavigationHelper helper = new NavigationHelper(DriverUtil.getDriver());
        shiftingPage = helper.loginAndGoToShifting();
    }

    @When("Masukkan nama {string} yang valid pada kolom pencarian Shifting")
    public void userInputsValidName(String nama){
        headerPage = new HeaderPage(DriverUtil.getDriver());
        headerPage.setSearch(nama);
    }

    @And("pengguna klik tombol Search")
    public void userClicksSearchButton(){
        headerPage.clickSearch();
    }

    @Then("Shifting {string} muncul di baris pertama")
    public void shiftingAppearsInFirstRow(String expected){
        String actualNama = shiftingPage.getDataBarisPertama(expected);
        Assert.assertEquals(actualNama, expected, "Nama di baris pertama tidak sesuai!");
    }


}
