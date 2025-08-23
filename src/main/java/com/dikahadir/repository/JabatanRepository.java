package com.dikahadir.repository;

import org.openqa.selenium.By;

public class JabatanRepository {
    public static  By buttonTambahkanJabatan = By.xpath("//button[normalize-space()='Tambahkan']");
    public static  By buttonSearchJabatan = By.xpath("//button[normalize-space()='Search']");
    public static  By resetButton = By.xpath("(//button[normalize-space()='Reset'])[1]");
    public static  By inputSearchText = By.xpath("//input[@id='search']");
    public static  By inputNamaJabatan= By.xpath("//input[@id='name']");
    public static  By inputLevelJabatan = By.xpath("//input[@id='level']");
    public static  By buttonTambah = By.xpath("//button[normalize-space()='Tambah']");
    public static  By message = By.xpath("(//div[@class='MuiSnackbarContent-message css-1w0ym84'])[1]");
    public static  By tampilSearchLevel= By.xpath("//table/tbody/tr/td[2]");
    public static  By tableRows = By.xpath("//table/tbody/tr");
    public static By editMenu = By.xpath("//li[@role='menuitem' and contains(.,'Edit')]");
    public static By deleteMenu = By.xpath("//li[@role='menuitem' and contains(.,'Delete')]");
    public static By dropdownMenuItems = By.xpath("//li[@role='menuitem']");


    public static By buttonSimpanEdit= By.xpath("//button[normalize-space()='Simpan']");
    public static By buttonConfirmDelete= By.xpath("//button[normalize-space()='Ya']");
    public static By buttonCancel= By.xpath("//button[normalize-space()='Tidak']");
    public static By formHapusJabatan=By.xpath("//div[contains(@class,'modal')]//h2[normalize-space()='Hapus Jabatan']");
    public static By formTambahJabatan = By.xpath("//h2[normalize-space()='Tambah Jabatan']");
    public static By buttonNextPage = By.xpath("//button[@aria-label='Go to next page' and not(@disabled)]");
    public static By buttonNextPageDisabled = By.xpath("//button[@aria-label='Go to next page' and @disabled]");
    public static By buttonPrevPage = By.xpath("//button[@aria-label='Go to previous page' and not(@disabled)]");
    public static By buttonPrevPageDisabled = By.xpath("//button[@aria-label='Go to previous page' and @disabled]");
    public static By buttonLastPage = By.xpath("//button[@aria-label='Go to last page' and not(@disabled)]");
    public static By buttonLastPageDisabled = By.xpath("//button[@aria-label='Go to last page' and @disabled]");
    public static By buttonFirstPage = By.xpath("//button[@aria-label='Go to first page' and not(@disabled)]");
    public static By buttonFirstPageDisabled = By.xpath("//button[@aria-label='Go to first page' and @disabled]");
    public static By tableContainer = By.xpath("//div[contains(@class,'MuiTableContainer-root')]");
    public static By loadingSpinner = By.xpath("//div[contains(@class,'MuiCircularProgress-root')]");
    public static By formEditJabatan = By.xpath("//h2[normalize-space()='Edit Jabatan']");

public static By editButtonInRow = By.xpath(".//button[@aria-label='Edit']");

  public static By buttonAction(String namaJabatan) {
    return By.xpath(
        "//table//tr[td[normalize-space()='" + namaJabatan + "']]//button[contains(@class,'MuiButtonBase-root')]"
    );
}

}