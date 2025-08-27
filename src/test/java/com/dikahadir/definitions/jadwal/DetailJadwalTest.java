package com.dikahadir.definitions.jadwal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dikahadir.Hooks;
import com.dikahadir.page.JadwalPage;
import com.dikahadir.repository.JadwalRepository;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class DetailJadwalTest {

    private JadwalPage jadwalPage;
    private WebDriver driver;
    private WebDriverWait wait;

    public DetailJadwalTest() {
        this.driver = Hooks.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("user login sebagai admin dan berada di halaman jadwal.")
    public void navigateToJadwalPage(){
        this.jadwalPage = new JadwalPage(driver);
        jadwalPage.navigateToJadwalPage();
    }

    @When("user menekan tombol action pada {string}")
    public void clicButtonAction(String namaJadwal) throws InterruptedException{
        jadwalPage.inputSearchJadwal(namaJadwal);
        jadwalPage.clickSearchJadwal();
        Thread.sleep(2000);
        jadwalPage.clickActionButtonRowPertama();
    }

    @And("user menekan menu detail")
    public void clickMenuDetail(){
        jadwalPage.clickDetailMenu();
    }

    @Then("detail jadwal akan muncul")
    public void displayDetail(){
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                JadwalRepository.detailHariKerja
        ));
        Assert.assertTrue(modal.isDisplayed(), "Modal detail jadwal tidak muncul!");
    }
}
