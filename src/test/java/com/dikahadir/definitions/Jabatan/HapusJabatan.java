package com.dikahadir.definitions.jabatan;


import org.testng.Assert;

import com.dikahadir.Hooks;
import com.dikahadir.page.JabatanPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HapusJabatan {
     private JabatanPage jabatanPage;

    @Given("user sudah login sebagai admin dan berada di halaman Manajemen jabatan")
    public void navigasiKeHalamanJabatanEdit() {
        this.jabatanPage = new JabatanPage(Hooks.getDriver());
        jabatanPage.navigateToJabatanPage();
        jabatanPage.waitTableUpdated(null);
        
    }
    @When("user mengklik tombol action pada jabatan {string}")
    public void clickTombolAction(String namaJabatan){
        jabatanPage.clickActionButtonWithPagination(namaJabatan);
    }
    @When("user mengklik tombol delete pada menu dropdown")
    public void clickMenuDelete(){
        jabatanPage.clickDeleteMenu();
    }

    @When("user mengklik tombol Ya pada form hapus jabatan")
    public void clickButtonConfirmDelete(){
        jabatanPage.clickButtonConfirmDelete();
    }

    @When("user mengklik tombol Batal pada form hapus jabatan")
    public void clickButtonCancelDelete(){
        jabatanPage.clickButtonCancel();
    }
    
    @Then("pesan sukses {string} akan diatmpilkan sistem")
    public void pesanSukses(String expectedMessage){
        String actualMessage = jabatanPage.getMessageText();
        Assert.assertEquals(actualMessage,expectedMessage, "Pesan sukses tidak sesuai");
    } 

      @Then("pesan gagal {string} akan diatmpilkan sistem")
    public void pesanGagal(String expectedMessage){
        String actualMessage = jabatanPage.getMessageText();
        Assert.assertEquals(actualMessage,expectedMessage, "Pesan sukses tidak sesuai");
    } 
    @Then("form pada hapus jabatan akan tertutup")
public void formHapusTertutup() {
    boolean isClosed = jabatanPage.waitUntilDeleteFormClosed();
    Assert.assertTrue(isClosed, "Form hapus jabatan seharusnya sudah tertutup");
}
}
