package com.dikahadir.definitions.jabatan;

import com.dikahadir.Hooks;
import com.dikahadir.page.JabatanPage;
import com.dikahadir.repository.JabatanRepository;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SearchLevelJabatanTest {

    private JabatanPage jabatanPage;

    @Given("user sudah melakukan login dan berada pada halaman Manajemen Jabatan")
    public void navigasiKeHalamanJabatanSearch() {
        this.jabatanPage = new JabatanPage(Hooks.getDriver());
        jabatanPage.navigateToJabatanPage();
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.buttonSearchJabatan));
    }

    @When("user menginput {string} pada field {string}")
    public void inputSearch(String level,String inputText){
        jabatanPage.inputSearchText(level);
    }

 @When("user menekan tombol search setelah menginput {string}")
public void userMencariJabatanDenganLevel(String level) {
    jabatanPage.clickSearchJabatan();
    jabatanPage.waitForUrlToContain(level);
    
}

  @Then("semua jabatan yang ditampilkan memiliki level {string}")
public void semuaJabatanMemilikiLevel(String expectedLevel) {
    jabatanPage.waitForUrlToContain(expectedLevel); 
    String currentUrl = jabatanPage.getCurrentUrl();

    Assert.assertTrue(currentUrl.contains(expectedLevel));
}

@Then("tidak ada jabatan yang ditampilkan")
public void tidakAdaJabatanYangDitampilkan() {
    String currentUrl = jabatanPage.getCurrentUrl();
    System.out.println("🔍 Current URL: " + currentUrl);

    jabatanPage.waitForUrlToContain("level%5B%24like%5D");

    Assert.assertTrue(currentUrl.contains("level%5B%24like%5D"));

}
}
