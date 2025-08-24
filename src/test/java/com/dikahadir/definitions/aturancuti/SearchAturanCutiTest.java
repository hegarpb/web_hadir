package com.dikahadir.definitions.aturancuti;

import java.util.List;
import org.testng.Assert;
import com.dikahadir.Hooks;
import com.dikahadir.page.AturanCutiPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchAturanCutiTest {
    private AturanCutiPage aturanCutiPage;

    @Given("user sudah login sebagai admin dan berada di halaman Aturan cuti")
    public void userSudahLoginDanBeradaDiHalamanAturanCuti() {
        this.aturanCutiPage = new AturanCutiPage(Hooks.getDriver());
        this.aturanCutiPage.navigateToAturanCuti();
    }

    @When("user menginput {string} dalam field cari berdasarkan nama")
    public void userInputNamaAturanCuti(String namaAturan) {
        aturanCutiPage.inputSearchText(namaAturan);
       
    }

    @When("user menekan tombol search di halaman aturan cuti")
    public void userKlikTombolSearch() throws InterruptedException {
        aturanCutiPage.clickButtonSearch();
         Thread.sleep(5000);
    
    }
    

   @Then("muncul nama aturan cuti yang dicari {string}")
public void munculNamaAturanCutiYangDicari(String expectedNama) {
    List<String> hasil = aturanCutiPage.getAllNamaAturan();
    boolean ditemukan = hasil.stream().anyMatch(nama -> nama.equalsIgnoreCase(expectedNama));
    Assert.assertTrue(ditemukan,"Nama aturan cuti '" + expectedNama + "' tidak ditemukan di hasil pencarian. Hasil: " + hasil);
}
@Then("tidak muncul nama aturan cuti yang dicari")
public void TidakAdaNamaAturan() {
    Assert.assertTrue(aturanCutiPage.isTableEmpty(),
        "Seharusnya tidak ada hasil pencarian, tetapi ditemukan: " + aturanCutiPage.getAllNamaAturan());
}


}
