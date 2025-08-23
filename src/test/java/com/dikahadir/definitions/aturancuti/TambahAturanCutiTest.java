package com.dikahadir.definitions.aturancuti;

import com.dikahadir.Hooks;
import com.dikahadir.page.AturanCutiPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class TambahAturanCutiTest {

    private AturanCutiPage aturanCutiPage;

    @Given("user melakukan login dan berada di halaman manajemen Aturan Cuti")
    public void userBeradaDiHalamanTambahAturanCuti() {
        aturanCutiPage = new AturanCutiPage(Hooks.getDriver());
        aturanCutiPage.navigateToAturanCuti();
    }

    @When("user menekan tombol Tambahkan Aturan Cuti")
    public void userClickButtonTambahkanAturan(){
        aturanCutiPage.clickButtonTambahkanAturan();
    }

    @When("user menginput nama aturan cuti {string}")
    public void userMengisiNamaAturanCuti(String namaAturan) {
        aturanCutiPage.inputNamaAturan(namaAturan);
    }

    @When("user menginput Eligible pengaturan cuti {int}")
    public void userMengisiEligiblePengaturanCuti(Integer eligible) {
        aturanCutiPage.inputEligablePengaturan(eligible);
    }

    @When("user menginput tanggal batas sisa cuti {int}")
    public void userMengisiTanggalBatasSisaCuti(int hari) {
        aturanCutiPage.inputTanggalBatasSisaCuti(hari);
    }

    @When("user menginput bulan batas sisa cuti {int}")
    public void userMengisiBulanBatasSisaCuti(int bulan) {
        aturanCutiPage.inputBulanBatasSisaCuti(bulan);
    }

    @When("user menginput maksimal sisa cuti {int}")
    public void userMengisiMaksimalSisaCuti(int maksimal) {
        aturanCutiPage.InputMaksimalSisaCuti(maksimal);
    }

    @When("user menginput jumlah bulan sisa kerja cuti {int}")
    public void userMengisiJumlahBulanKerjaSisaCuti(int jumlah) {
        aturanCutiPage.inputJumlahBulanKerjaSisaCuti(jumlah);
    }

    @When("user menekan tombol Tambahkan pada form tambahkan aturan cuti")
    public void userMenekanTombolTambahkan() {
        aturanCutiPage.clickButtonTambahkan();
    }

    @Then("sistem menampilkan pesan {string}")
    public void aturanCutiBerhasilDitambahkan(String expectedMessage) {
        String actualMessage = aturanCutiPage.getSuccessMessage();
        Assert.assertEquals(actualMessage, expectedMessage, 
            "Pesan sukses tidak sesuai!");
    }
}
