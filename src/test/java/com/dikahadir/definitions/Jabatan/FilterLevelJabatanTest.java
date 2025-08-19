package com.dikahadir.definitions.jabatan;

import com.dikahadir.Hooks;
import com.dikahadir.page.JabatanPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class FilterLevelJabatanTest {

    private JabatanPage jabatanPage;
    private List<WebElement> filteredJobLevels;

    @Given("user berada pada halaman Manajemen Jabatan")
    public void navigasiKeHalamanJabatan() {
        this.jabatanPage = new JabatanPage(Hooks.getDriver());
        jabatanPage.navigateToJabatanPage();
    }

    @When("user mencari jabatan dengan level {string}")
    public void userMencariJabatanDenganLevel(String level) {
        // gunakan method dari JabatanPage
        filteredJobLevels = jabatanPage.searchLevelJabatan(level);
    }

   @Then("semua jabatan yang ditampilkan memiliki level {string}")
public void semuaJabatanMemilikiLevel(String expectedLevel) {
    List<WebElement> filteredJobLevels = jabatanPage.getFilteredJobLevels();

    Assert.assertFalse(filteredJobLevels.isEmpty(),
            "Tidak ada jabatan dengan level '" + expectedLevel + "' yang ditemukan.");

    for (WebElement cell : filteredJobLevels) {
        String actualLevel = cell.getText().trim();
        Assert.assertEquals(actualLevel, expectedLevel,
                "Level jabatan tidak cocok. Seharusnya: '" + expectedLevel + "', tapi ditemukan: '" + actualLevel + "'.");
    }
}
}