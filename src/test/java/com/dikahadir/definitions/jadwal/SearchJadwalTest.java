package com.dikahadir.definitions.jadwal;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dikahadir.Hooks;
import com.dikahadir.page.JadwalPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchJadwalTest {
    private JadwalPage jadwalPage;

    @Given("user melakukan login dan berada di halaman jadwal")
    public void navigateToJadwalPage(){
        this.jadwalPage = new JadwalPage(Hooks.getDriver());
        jadwalPage.navigateToJadwalPage();
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10));
    }

    @When("user menginput {string} pada kolom pencarian")
    public void inputNamaJadwal(String namaJadwal){
        jadwalPage.inputSearchJadwal(namaJadwal);
    }
    @When("user menekan tombol search pada halaman jadwal")
    public void clickTombolSearchJadwal() throws InterruptedException{
        jadwalPage.clickSearchJadwal();
        Thread.sleep(5000);
    }
    @Then("{string} yang dicari user akan ditampilkan")
    public void tampilNamaJadwal(String expectedJadwal){
    List<String> hasil = jadwalPage.getAllJadwal();
    boolean ditemukan = hasil.stream().anyMatch(nama -> nama.equalsIgnoreCase(expectedJadwal));
    Assert.assertTrue(ditemukan,"Nama jadwal '" + expectedJadwal + "' tidak ditemukan di hasil pencarian. Hasil: " + hasil);
    }
    @Then("nama jadwal yang dicari user tidak akan ditampilkan")
    public void TidakAdaNamaAturan() {
    Assert.assertTrue(jadwalPage.isTableEmpty(),
        "Seharusnya tidak ada hasil pencarian, tetapi ditemukan: " + jadwalPage.getAllJadwal());
}
    
}
