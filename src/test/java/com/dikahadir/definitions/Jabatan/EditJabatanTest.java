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
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']")));
    }

  @When("user menekan tombol action pada jabatan {string}")
public void MenekanTombolAction(String namaJabatan) {
    jabatanPage.clickActionButtonWithPagination(namaJabatan);
}
    @When("user menekan tombol edit pada menu dropdown")
    public void MemilihMenuEdit() {
    jabatanPage.clickEditMenu();
}


    @When("user mengubah nama jabatan menjadi {string}")
    public void MengubahNama(String namaBaru) {
        jabatanPage.setNamaJabatan(namaBaru);
    }

    @When("user mengubah level jabatan menjadi {string}")
    public void MengubahNamaDanLevel(String levelBaru) {
        jabatanPage.setLevelJabatan(levelBaru);
    }
    

    @When("user menekan tombol simpan")
    public void penggunaMenekanTombolSimpan() {
        jabatanPage.clickButtonSimpanEdit();
    }

    @When ("user menekan tombol batal pada form edit jabatan")

    @Then("sistem akan menampilkan pesan {string}")
    public void sistemMenampilkanPesan(String expectedMessage) throws InterruptedException {
        String actualMessage = jabatanPage.getMessageText();
        Assert.assertEquals(actualMessage, expectedMessage, "Pesan sukses tidak sesuai");
        Thread.sleep(10000);
    }


     @Then("pesan validasi {string} akan muncul pada field nama jabatan")
    public void validasiNamaJabatan(String expectedMessage){
        String actualMessage = jabatanPage.getValidationNamaJabatan();
        Assert.assertEquals(actualMessage, expectedMessage, 
            "Validasi nama jabatan tidak sesuai!");
    }

    @Then("pesan validasi {string} akan muncul pada field level jabatan")
    public void validasiLevelJabatan(String expectedMessage){
        String actualMessage = jabatanPage.getValidationLevelJabatan();
        Assert.assertEquals(actualMessage, expectedMessage, 
            "Validasi level jabatan tidak sesuai!");
    }

    @Then("form pada edit jabatan akan tertutup")
    public void formEditTertutup() {
    boolean isClosed = jabatanPage.waitUntilFormEditJabatanClosed();
    Assert.assertTrue(isClosed, "Form hapus jabatan seharusnya sudah tertutup");
}
}