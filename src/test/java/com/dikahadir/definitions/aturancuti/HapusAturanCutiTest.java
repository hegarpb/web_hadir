package com.dikahadir.definitions.aturancuti;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dikahadir.Hooks;
import com.dikahadir.page.AturanCutiPage;
import com.dikahadir.repository.AturanCutiRepository;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HapusAturanCutiTest {
    private AturanCutiPage aturanCutiPage;
    private WebDriverWait wait;

    @Given("user sudah login sebagai admin dan berada di halaman Aturan Cuti.")
    public void navigateToAturanCutiPage(){
    this.aturanCutiPage = new AturanCutiPage(Hooks.getDriver());
    this.wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10)); 
    aturanCutiPage.navigateToAturanCuti();

    aturanCutiPage.waitTableUpdated(null);
    }

    @When ("user menekan tombol action pada nama {string} aturan cuti.")
    public void clickTombolAction(String namaAturan) throws InterruptedException{
        aturanCutiPage.inputSearchText(namaAturan);
        aturanCutiPage.clickButtonSearch();
        Thread.sleep(5000);
        aturanCutiPage.clickActionButtonRowPertama();
    }

    @When("user menekan tombol delete")
    public void clickTombolDelete(){
        aturanCutiPage.clickDeleteMenu();
    }
    
    @When("user menekan tombol hapus")
    public void clickTombolConfirmHapus(){
        aturanCutiPage.clickConfirmHapus();
    }

    @When("user menekan tombol batal")
    public void clickTombolBatal(){
        aturanCutiPage.clickButtonBatal();
    }

    @Then("tidak ada nama aturan cuti yang terhapus")
     public void batalHapus() {
        boolean isFormClosed = wait.until(
            ExpectedConditions.invisibilityOfElementLocated(AturanCutiRepository.confirmDeleteDialog)
        );
        Assert.assertTrue(isFormClosed, "Pesan konfirmasi hapus Aturan Cuti masih terlihat padahal harusnya sudah tertutup!");
    }
    @Then ("pesan {string} akan ditampilkan sistem.")
    public void pesanSistem(String expectedMessage ){
    String actualMessage=aturanCutiPage.getMessageText();
    Assert.assertEquals(actualMessage, expectedMessage,"pesan tidak sesuai!");
    }
}
