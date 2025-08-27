package com.juaracoding.hadir.definitions.absenpoints;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.juaracoding.hadir.helpers.NavigationHelper;
import com.juaracoding.hadir.pages.AbsenPointPage;
import com.juaracoding.hadir.utils.DriverUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TambahNegativeAbsenPointTest {
    AbsenPointPage absenPointPage;

    @Given("Pengguna sudah login ke aplikasi dan pengguna berada di halaman Absen Point")
    public void userIsOnAbsenPointPage(){
        NavigationHelper helper = new NavigationHelper(DriverUtil.getDriver());
        absenPointPage = helper.loginAndGoToAbsenPoint();
    }

    @And("Pengguna membuka form Tambah Location Point")
    public void clickAddAbsenPoint(){
        absenPointPage.clickTambahAbsenPoint();
    }

    @When("Pengguna mengisi data kosongkan {string}, {string}, {string}, {string}, {string} dan klik tambah")
    public void performAbsenPointWithoutName(String nama, String latitude, String longitude, String radius, String deskripsi) {
        absenPointPage.performAbsenPointNegative(nama, latitude, longitude, radius, deskripsi);
    }
    
    @Then("Sistem menampilkan pesan error {string} pada field Nama")
    public void getMessageName(String expectedMessage){
    WebElement namaInput = DriverUtil.getDriver().findElement(By.id("name"));
    String actualMessage = namaInput.getAttribute("validationMessage");
    
    org.testng.Assert.assertEquals(actualMessage, expectedMessage, 
        "Pesan validasi tidak sesuai!");
    }

    //=============================
    @When("Pengguna mengisi data {string}, kosongkan bagian {string}, {string}, {string}, {string} dan klik tambah")
    public void performAbsenPointWithoutLatitude(String nama, String latitude, String longitude, String radius, String deskripsi){
        absenPointPage.performAbsenPointNegative(nama, latitude, longitude, radius, deskripsi);
    }

    @Then("Sistem menampilkan pesan error {string} pada field Latitude")
    public void getMessageLatitude(String expectedMessage){
    WebElement namaInput = DriverUtil.getDriver().findElement(By.id("latitude"));
    String actualMessage = namaInput.getAttribute("validationMessage");
    
    org.testng.Assert.assertEquals(actualMessage, expectedMessage, 
        "Pesan validasi tidak sesuai!");
    }

    //===========================
    @When("Pengguna mengisi data {string}, {string}, kosongkan bagian {string}, {string}, {string} dan klik tambah")
    public void performAbsenPointWithoutLongitude(String nama, String latitude, String longitude, String radius, String deskripsi){
         absenPointPage.performAbsenPointNegative(nama, latitude, longitude, radius, deskripsi);
    }

    @Then("Sistem menampilkan pesan error {string} pada field Longitude")
    public void getMessageLongitude(String expectedMessage){
    WebElement namaInput = DriverUtil.getDriver().findElement(By.id("longitude"));
    String actualMessage = namaInput.getAttribute("validationMessage");
    
    org.testng.Assert.assertEquals(actualMessage, expectedMessage, 
        "Pesan validasi tidak sesuai!");
    }

    @When("Pengguna mengisi data {string}, {string}, {string}, kosongkan bagian {string}, {string} dan klik tambah")
    public void performAbsenPointWithoutRadius(String nama, String latitude, String longitude, String radius, String deskripsi){
        absenPointPage.performAbsenPointNegative(nama, latitude, longitude, radius, deskripsi);
    }

    @Then("Sistem menampilkan pesan error {string} pada field Radius")
    public void getMassageRadius(String expectedMessage){
        WebElement namaInput = DriverUtil.getDriver().findElement(By.id("max_radius"));
        String actualMessage = namaInput.getAttribute("validationMessage");
    
        org.testng.Assert.assertEquals(actualMessage, expectedMessage, 
        "Pesan validasi tidak sesuai!");
    }
}
