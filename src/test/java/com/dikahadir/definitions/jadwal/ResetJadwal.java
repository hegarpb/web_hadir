package com.dikahadir.definitions.jadwal;

import org.testng.Assert;

import com.dikahadir.Hooks;
import com.dikahadir.page.JadwalPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResetJadwal {

    private JadwalPage jadwalPage;
    private int jumlahAwal;


    @Given("user login sebagai admin dan berada di halaman jadwal")
    public void navigateToJabatanPage(){
        this.jadwalPage= new JadwalPage(Hooks.getDriver());
        jadwalPage.navigateToJadwalPage();
        jumlahAwal = jadwalPage.getJumlahJadwal();
    }

    @When("user menginputkan {string} dalam field cari berdasarkan nama di halaman jadwal")
    public void inputSearchJadwal(String namaJadwal){
        jadwalPage.inputSearchJadwal(namaJadwal);
        
    }

    @When("user mengklik tombol Search pada halaman jadwal")
    public void clickButtonSearch(){
        jadwalPage.clickSearchJadwal();
        int jumlahHasil = jadwalPage.getJumlahJadwal();
        Assert.assertTrue(jumlahHasil <= jumlahAwal,
            "Jumlah hasil pencarian (" + jumlahHasil + ") tidak lebih sedikit dari jumlah awal (" + jumlahAwal + ")");
    }

    @When("user mengklik tombol Reset setelah melakukan pencarian")
    public void clickButtonReset(){
        jadwalPage.clickResetSearchJadwal();
        jadwalPage.waitUrlToBeDefault();
    }

    @Then("tabel kembali menampilkan semua nama jadwal")
    public void tampilSemuaNamaJadwal(){
        int JumlahReset = jadwalPage.getJumlahJadwal();
        Assert.assertEquals(jumlahAwal, JumlahReset);


    }
    
}
