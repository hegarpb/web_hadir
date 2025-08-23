package com.dikahadir.definitions.jabatan;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dikahadir.Hooks;
import com.dikahadir.page.JabatanPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaginationTest {
    private JabatanPage jabatanPage;

    @Given("user sudah login dan berada di halaman manajemen jabatan")
    public void navigateToJabatanPage() {
        this.jabatanPage = new JabatanPage(Hooks.getDriver());
        jabatanPage.navigateToJabatanPage();
        jabatanPage.waitTableUpdated(null); // tunggu tabel pertama kali muncul
    }

    @When("user menekan tombol selanjutnya")
    public void clickButtonSelanjutnya() {
        jabatanPage.clickNextPageButton();
    }
    @When("user menekan tombol kembali ke halaman awal")
public void clickFirstPage() {
    jabatanPage.clickFirstPageButton();
}
 @When("user menekan tombol sebelumnya")
    public void clickButtonSebelumnya() {
        jabatanPage.clickPrevPageButton();
    }
    @When("user menekan tombol ke halaman terakhir")
public void keHalamanTerakhir(){
    jabatanPage.clickLastPageButton();
}

    @Then("halaman akan berpindah ke halaman berikutnya")
    public void halamanBerpindahKeHalamanBerikutnya() {
        String currentUrl = Hooks.getDriver().getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));

        String newUrl = Hooks.getDriver().getCurrentUrl();
        Assert.assertTrue(newUrl.contains("page="),
                "❌ URL tidak berubah ke halaman berikutnya. Current: " + newUrl);
    }

   

    @Then("halaman akan berpindah ke halaman sebelumnya")
public void halamanBerpindahKeHalamanSebelumnya() {
    String oldUrl = jabatanPage.getCurrentUrl();
    jabatanPage.waitUrlChanged(oldUrl);

    String newUrl = jabatanPage.getCurrentUrl();
    Assert.assertTrue(newUrl.contains("page="),
        "❌ URL tidak berubah ke halaman sebelumnya. Current: " + newUrl);
}


@Then("halaman akan berpindah ke halaman terakhir")
    public void halamanTerakhir(){
String oldUrl = jabatanPage.getCurrentUrl();
        jabatanPage.waitUrlChanged(oldUrl);

        String newUrl = jabatanPage.getCurrentUrl();
        Assert.assertTrue(newUrl.contains("page="),
                "❌ URL tidak berubah ke halaman terakhir. Current: " + newUrl);
    }

    @Then("halaman akan berpindah ke halaman awal")
public void halamanAwal() {
    String oldUrl = jabatanPage.getCurrentUrl();
    jabatanPage.waitUrlChanged(oldUrl);

    String newUrl = jabatanPage.getCurrentUrl();
    Assert.assertTrue(newUrl.contains("page=") || newUrl.endsWith("/jabatan"),
            "❌ URL tidak berubah ke halaman awal. Current: " + newUrl);
}
}


