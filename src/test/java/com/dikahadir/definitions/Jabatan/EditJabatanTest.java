package com.dikahadir.definitions.jabatan;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dikahadir.Hooks;
import com.dikahadir.page.JabatanPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditJabatanTest {
    private JabatanPage jabatanPage;

    @Given("user sudah login dan user berada di halaman Manajemen Jabatan")
    public void navigasiKeHalamanJabatanEdit() {
        this.jabatanPage = new JabatanPage(Hooks.getDriver());
        jabatanPage.navigateToJabatanPage();
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']")));
    }

  @When("user menekan tombol action pada jabatan")
public void penggunaMenekanTombolAction() {
    jabatanPage.clickActionButton();
}
    @When("user menekan tombol edit pada menu dropdown")
    public void penggunaMemilihMenuEdit() {
    jabatanPage.clickEditMenu();
}

    @When("user mengubah nama jabatan menjadi {string} dan level {string}")
   public void penggunaMengubahNamaDanLevel(String namaBaru, String levelBaru) {
        jabatanPage.SetNamaJabatan(namaBaru);
        jabatanPage.SetLevelJabatan(levelBaru);
    }

     @When("user mengubah nama jabatan menjadi {string}")
   public void penggunaMengubahNama(String namaBaru) {
        jabatanPage.SetNamaJabatan(namaBaru);
    }
    

    @When("user menekan tombol simpan")
    public void penggunaMenekanTombolSimpan() {
        jabatanPage.clickButtonSimpanEdit();
    }

    @Then("sistem akan menampilkan pesan sukses {string}")
    public void sistemMenampilkanPesanSukses(String expectedMessage) {
        String actualMessage = jabatanPage.getMessageText();
        Assert.assertEquals(actualMessage, expectedMessage, "Pesan sukses tidak sesuai");
    }
}