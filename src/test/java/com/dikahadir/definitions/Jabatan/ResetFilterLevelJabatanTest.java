package com.dikahadir.definitions.jabatan;

import com.dikahadir.Hooks;
import com.dikahadir.page.JabatanPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ResetFilterLevelJabatanTest {

    private final JabatanPage jabatanPage;

    public ResetFilterLevelJabatanTest() {
        this.jabatanPage = new JabatanPage(Hooks.getDriver());
    }

    @Given("user diarahkan ke halaman Manajemen Jabatan")
    public void navigasiKeHalamanJabatan() {
        jabatanPage.navigateToJabatanPage();
        // Tunggu tabel penuh load, misal minimal 10 baris
        
    }

    @When("user sudah melakukan pencarian level jabatan dengan level {string}")
    public void lakukanPencarian(String level) {
        jabatanPage.searchLevelJabatan(level);
        
    }

   @When("user mengklik tombol {string}")
public void klikTombol(String buttonName) {
    jabatanPage.clickResetFilter();
    jabatanPage.waitForUrlAfterReset();
    
}

  
@Then("semua jabatan yang ditampilkan tidak dalam keadaan terfilter")
public void verifikasiTidakTerfilter() {
    String currentUrl = jabatanPage.getCurrentUrl();
    System.out.println("🔍 URL setelah reset: " + currentUrl);

    Assert.assertEquals(
        currentUrl,
        "https://magang.dikahadir.com/management/job-level",
        "URL setelah reset filter tidak sesuai!"
    );
}

}
