package com.dikahadir.definitions.jadwal;

import org.testng.Assert;

import com.dikahadir.Hooks;
import com.dikahadir.page.JadwalPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HapusJadwalTest {

    private JadwalPage jadwalPage;

    @Given("user melakukan login sebagai admin dan berada di halaman Jadwal")
    public void navigateToJadwalPage(){
        this.jadwalPage = new JadwalPage(Hooks.getDriver());
        jadwalPage.navigateToJadwalPage();
    }
    @When("user menekan tombol action pada {string}.")
    public void clickTombolAction(String namaJadwal) throws InterruptedException{
        jadwalPage.inputSearchJadwal(namaJadwal);
        jadwalPage.clickSearchJadwal();
        jadwalPage.clickActionButtonRowPertama();
        Thread.sleep(3000);
    }

    @When("user menekan tombol delete pada menu dropdown")
    public void clickTombolDelete(){
        jadwalPage.clickDeleteMenu();
    }

    @When("user menekan tombol Ya pada pesan konfirmasi dialog")
    public void confirmDialog(){
        jadwalPage.clickButtonConfirm();
    }

    @Then("nama jadwal akan terhapus dari tabel dan sistem akan menpilkan pesan {string}")
    public void getMessagePopup(String expectedMessage){
        String actual= jadwalPage.getPopupMessage();
        Assert.assertEquals(actual, expectedMessage);
    }
}
