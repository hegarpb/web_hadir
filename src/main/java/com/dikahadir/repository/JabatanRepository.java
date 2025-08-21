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
    public static By menuEdit = By.xpath("//li[@role='menuitem' and normalize-space()='Edit']");
    public static By menuDelete = By.xpath("//li[@role='menuitem' and normalize-space()='Delete']");
    public static By buttonSimpanEdit= By.xpath("//button[normalize-space()='Simpan']");
    public static By buttonConfirmDelete= By.xpath("//button[normalize-space()='Ya']");
    public static By buttonCancelDelete= By.xpath("//button[normalize-space()='Tidak']");
    public static By formHapusJabatan=By.xpath("//div[contains(@class,'modal')]//h2[normalize-space()='Hapus Jabatan']");
    public static By formTambahJabatan = By.xpath("//h2[normalize-space()='Tambah Jabatan']");
    public static By buttonNextPage = By.xpath("//*[name()='svg' and @data-testid='KeyboardArrowRightIcon']");
    public static By tableContainer = By.xpath("//div[contains(@class,'MuiTableContainer-root')]");
    public static By loadingSpinner = By.xpath("//div[contains(@class,'MuiCircularProgress-root')]");
    public static By formEditJabatan = By.xpath("//h2[normalize-space()='Edit Jabatan']");


  public static By buttonAction(String namaJabatan) {
    return By.xpath(
        "//table//tr[td[normalize-space()='" + namaJabatan + "']]//button[contains(@class,'MuiButtonBase-root')]"
    );
}

}
