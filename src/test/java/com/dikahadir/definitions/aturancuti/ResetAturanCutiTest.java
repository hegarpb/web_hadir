package com.dikahadir.definitions.aturancuti;

import com.dikahadir.Hooks;
import com.dikahadir.page.AturanCutiPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class ResetAturanCutiTest {
    private AturanCutiPage aturanCutiPage;
    private int jumlahAwal;

    @Given("user login sebagai admin dan berada di halaman Aturan cuti")
    public void userSudahLoginDanBeradaDiHalamanAturanCuti() {
       this.aturanCutiPage = new AturanCutiPage(Hooks.getDriver());
        this.aturanCutiPage.navigateToAturanCuti();
        jumlahAwal = aturanCutiPage.getJumlahAturanCuti();
    }

    @When("user menginputkan {string} dalam field cari berdasarkan nama")
    public void userInputNamaAturanCuti(String namaAturan) {
        aturanCutiPage.inputSearchText(namaAturan);
    }

    @When("user mengklik tombol search di halaman aturan cuti")
    public void userKlikTombolSearch() {
        aturanCutiPage.clickButtonSearch();
        int jumlahHasil = aturanCutiPage.getJumlahAturanCuti();
        Assert.assertTrue(jumlahHasil <= jumlahAwal,
            "Jumlah hasil pencarian (" + jumlahHasil + ") tidak lebih sedikit dari jumlah awal (" + jumlahAwal + ")");
    }

    @When("user mengklik tombol Reset")
    public void userKlikTombolReset() {
        aturanCutiPage.clickButtonReset();
        aturanCutiPage.waitUrlToBeDefault();
    }

    @Then("tabel kembali menampilkan semua aturan cuti")
    public void tabelKembaliMenampilkanSemuaAturanCuti() {
        int jumlahReset = aturanCutiPage.getJumlahAturanCuti();
        Assert.assertEquals(jumlahReset, jumlahAwal,
            "Jumlah aturan cuti setelah reset (" + jumlahReset + ") tidak sama dengan jumlah awal (" + jumlahAwal + ")");

        Assert.assertTrue(aturanCutiPage.isSearchFieldEmpty(),
            "Field search seharusnya kosong setelah reset, tapi masih ada nilainya.");

        String currentUrl = aturanCutiPage.getCurrentUrl();
        String expectedUrl = "https://magang.dikahadir.com/management/unit-leave";
        Assert.assertEquals(currentUrl, expectedUrl,
            "URL setelah reset tidak sesuai. Diharapkan: " + expectedUrl + " tapi: " + currentUrl);
    }
}
