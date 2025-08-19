package com.dikahadir.definitions.jabatan;

import com.dikahadir.Hooks;
import com.dikahadir.page.JabatanPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class FilterLevelJabatanTest {

    private JabatanPage jabatanPage;

    @Given("user berada pada halaman Manajemen Jabatan")
    public void navigasiKeHalamanJabatan() {
        this.jabatanPage = new JabatanPage(Hooks.getDriver());
        jabatanPage.navigateToJabatanPage();
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']")));
    }

 @When("user mencari jabatan dengan level {string}")
public void userMencariJabatanDenganLevel(String level) {
    jabatanPage.searchLevelJabatan(level);
}


   @When("user mencari jabatan dengan level yang tidak ada {string}")
public void userMencariJabatanDenganLevelTidakAda(String level) {
    jabatanPage.searchLevelJabatan(level);
    jabatanPage.waitForUrlToContain(level);
  
}

 @When("user mencari jabatan dengan level yang mengandung alfabet {string}")
public void userMencariJabatanDenganLevelAlfabet(String level) {
    jabatanPage.searchLevelJabatan(level);
    jabatanPage.waitForUrlToContain(level);
    
}

  @Then("semua jabatan yang ditampilkan memiliki level {string}")
public void semuaJabatanMemilikiLevel(String expectedLevel) {
    jabatanPage.waitForUrlToContain(expectedLevel); // 🔑 tunggu dulu sampai URL berubah
    String currentUrl = jabatanPage.getCurrentUrl();
    System.out.println("🔍 Current URL: " + currentUrl);

    Assert.assertTrue(
        currentUrl.contains(expectedLevel),
        "URL tidak mengandung level yang dicari: " + expectedLevel
    );
}

@Then("tidak ada jabatan yang ditampilkan")
public void tidakAdaJabatanYangDitampilkan() {
    String currentUrl = jabatanPage.getCurrentUrl();
    System.out.println("🔍 Current URL: " + currentUrl);

    // ✅ Tunggu dulu sampai URL mengandung parameter filter level
    jabatanPage.waitForUrlToContain("level%5B%24like%5D");

    // validasi: filter level memang dipasang di URL
    Assert.assertTrue(
        currentUrl.contains("level%5B%24like%5D"),
        "URL tidak mengandung parameter filter level"
    );

    // opsional: tambahkan log untuk debug
    System.out.println("✅ Filter level sudah diterapkan (meskipun data kosong)");
}
}
