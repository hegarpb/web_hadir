package com.dikahadir.definitions.jabatan;

import com.dikahadir.Hooks;
import com.dikahadir.page.JabatanPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ResetSearchLevelJabatanTest {

    private  JabatanPage jabatanPage;

    

    @Given("user sudah login dan diarahkan ke halaman Manajemen Jabatan")
    public void navigasiKeHalamanJabatanResetSearch() {
        this.jabatanPage = new JabatanPage(Hooks.getDriver());
        jabatanPage.navigateToJabatanPage();
        
    }

    @When("user sudah menginput level jabatan dengan level {string}")
    public void inputLevel(String level){
        jabatanPage.inputSearchText(level);
    }

    @When("user menekan tombol search {string}")
    public void lakukanPencarian(String buttonName) {
        jabatanPage.clickSearchJabatan();      
    }

   @When("user menekan tombol {string}")
public void klikTombol(String buttonName) {
    jabatanPage.clickResetSearch();
    jabatanPage.waitForUrlAfterReset();
    
}

  
@Then("semua jabatan yang ditampilkan tidak dalam keadaan terfilter")
public void verifikasiTidakTerfilter() {
    String currentUrl = jabatanPage.getCurrentUrl();
    System.out.println("URL setelah reset: " + currentUrl);

    Assert.assertEquals(
        currentUrl,
        "https://magang.dikahadir.com/management/job-level",
        "URL setelah reset filter tidak sesuai!"
    );
}

}