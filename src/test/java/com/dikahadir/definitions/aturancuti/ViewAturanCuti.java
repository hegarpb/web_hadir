package com.dikahadir.definitions.aturancuti;

import com.dikahadir.Hooks;
import com.dikahadir.page.AturanCutiPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ViewAturanCuti {
    private AturanCutiPage aturanCutiPage;

    @Given("user login sebagai admin dan diarahkan ke halaman aturan cuti")
    public void navigateKeAturanCutiPage(){
        this.aturanCutiPage = new AturanCutiPage(Hooks.getDriver());
        aturanCutiPage.navigateToAturanCuti();
        // Tunggu tabel muncul
        aturanCutiPage.waitTableUpdated(null);
    }

    @When("user menekan tombol action pada nama {string} cuti")
    public void clickTombolAction(String namaAturan) throws InterruptedException{
        aturanCutiPage.inputSearchText(namaAturan);
        aturanCutiPage.clickButtonSearch();
        Thread.sleep(5000);
        aturanCutiPage.clickActionButtonRowPertama();
    }

    @When("user menekan tombol view")
    public void clickTombolView(){
        aturanCutiPage.clickViewMenu();
    }

    @Then("detail aturan cuti akan tampil")
    public void detailAturanCutiAkanTampil(){
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/management/unit-leave/"));

        String currentUrl = Hooks.getDriver().getCurrentUrl();

        // Validasi URL mengandung path yang benar
        Assert.assertTrue(
            currentUrl.contains("/management/unit-leave/"),
            "URL detail aturan cuti tidak sesuai! Current URL: " + currentUrl
        );
    }
}
