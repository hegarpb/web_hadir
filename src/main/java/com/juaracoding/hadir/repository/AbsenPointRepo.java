package com.juaracoding.hadir.repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AbsenPointRepo {
    // elemen submenu absen point
    @FindBy(xpath = "//p[normalize-space()='Absen Point']")
    public WebElement clikSubMenuAbsenPoint;

    @FindBy(xpath = "//button[normalize-space()='Tambahkan']")
    public WebElement clickTambahAbsenPoint;

    // elemen name
    @FindBy(id = "name")
    public WebElement name;

    // elemen latitude
    @FindBy(id = "latitude")
    public WebElement latitude;

    // elemen longitude
    @FindBy(id = "longitude")
    public WebElement longitude;

    // elemen maksimal radius (Meter)
    @FindBy(id = "max_radius")
    public WebElement maxRadius;

    // elemen description
    @FindBy(id = "description")
    public WebElement description;

    // elemen tambah
    @FindBy(xpath = "//button[normalize-space(.)='Tambah']")
    public WebElement tambah;

    // pesan berhasil
    @FindBy(xpath = "//div[contains(@class,'MuiSnackbarContent-message')]")
    public WebElement popupBerhasilTambah;

    // popup pesan data berhasil dihapus
    @FindBy(xpath = "//div[contains(@class,'MuiSnackbarContent-message') and normalize-space(text())='Berhasil Delete Location Point']")
    public WebElement popupBerhasilHapus;

    // popup pesan data berhasil diedit
    @FindBy(xpath = "//div[contains(@class,'MuiSnackbarContent-message') and normalize-space(text())='Berhasil Edit Location Point']")
    public WebElement popupBerhasilEdit;

    // elemen row page 
    @FindBy(css = "ul.MuiMenu-list[role='listbox'] li")
    public List<WebElement> rowsPerPageOptions;

    // elemen tabel keseluruhan
    @FindBy(css = "tbody.MuiTableBody-root tr")
    public List<WebElement> tableRows;

}
