package com.juaracoding.hadir.definitions.absenpoints;

import org.testng.Assert;

import com.juaracoding.hadir.helpers.NavigationHelper;
import com.juaracoding.hadir.pages.AbsenPointPage;
import com.juaracoding.hadir.utils.DriverUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaginationAbsenPointTest {
    AbsenPointPage absenPointPage;

    @Given("Pengguna sudah berada malakukan login dan pengguna di halaman Absen Point")
    public void userIsOnAbsenPointPage(){
        NavigationHelper helper = new NavigationHelper(DriverUtil.getDriver());
        absenPointPage = helper.loginAndGoToAbsenPoint();
    }

    @When("Pengguna klik dropdown dan memilih jumlah data per halaman {string}")
    public void klikDropdownPerPage(String Page){
        absenPointPage.setRowsPerPage(Page);
    }

    @Then("Jumlah Absen point yang ditampilkan per halaman berubah menjadi {int}")
    public void expectedPage(int expected){
        Assert.assertTrue(absenPointPage.verifyRowsPerPage(expected));
    }

    // =====================================================================
    @When("Pengguna klik tombol next")
    public void clikNext() {
        absenPointPage.clickNextPage();
    }

    @And("Pengguna klik tombol previous")
    public void clikProviousPage() {
        absenPointPage.clickPreviousPage();
    }

    @Then("Sistem menampilkan halaman berikutnya dan mendapatkan data dibaris pertama")
    public void getPageNext() {
        Assert.assertTrue(absenPointPage.isDataChangedAfterNext());
    }

    // @And("Sistem menampilkan halaman sebelumnya dan mendapatkan data dibaris pertama")
    // public void getPageProvious() {
    //     Assert.assertTrue(absenPointPage.isDataChangedAfterPrevious());
    // }

    // ==========================================================================
    @When("Pengguna klik tombol last")
    public void clikLastPageIcon(){
        absenPointPage.clickLastPage();
    }

    @And("Pengguna klik tombol first")
    public void clickFirstPageIcon(){
        absenPointPage.clickFirstPage();
    }

    @Then("Sistem menampilkan halaman terakhir serta mendapatkan data dibaris pertama")
    public void getLastPage(){
        Assert.assertTrue(absenPointPage.isDataChangedAfterLast());
    }

    // @And("Sistem menampilkan halaman pertama serta mendapatkan data dibaris pertama")
    // public void getFisrtsPage(){
    //     Assert.assertTrue(absenPointPage.isDataChangedAfterFirst());
    // }

}
