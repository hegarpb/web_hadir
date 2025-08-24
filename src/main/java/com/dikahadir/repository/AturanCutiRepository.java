package com.dikahadir.repository;

import org.openqa.selenium.By;

public class AturanCutiRepository {

    // ==============================
    // Input field
    // ==============================
    public static final By inputSearch = By.xpath("//input[@placeholder='Cari berdasarkan nama']");
    public static final By inputNamaAturanCuti = By.xpath("//input[@id='name']");
    public static final By inputEligiblePengaturanCuti = By.xpath("//input[@id='eligible_leave_total_month']");
   public static final By inputTanggalBatasSisaCuti = By.xpath("//input[@placeholder='d']");
    public static final By inputBulanBatasSisaCuti = By.xpath("//input[@placeholder='m']");
    public static final By inputMaksimalSisaCuti = By.xpath("//input[@id='max_carry_forward']");
    public static final By inputJumlahBulanKerjaSisaCuti = By.xpath("//input[@id='carry_forward_total_month']");

    // ==============================
    // Buttons
    // ==============================
    public static final By buttonReset = By.xpath("//button[normalize-space()='Reset']");
    public static final By buttonSearch = By.xpath("//button[normalize-space()='Search']");
    public static final By buttonTambahAturan = By.xpath("//button[normalize-space()='Tambahkan Aturan Cuti']");
    public static final By buttonTambahkan = By.xpath("//button[normalize-space()='Tambahkan']");
     public static By buttonSimpan= By.xpath("//button[normalize-space()='Simpan']");
     public static By buttonHapus = By.xpath("//button[@type='button' and normalize-space()='Hapus']");


    // ==============================
    // Table
    // ==============================
    public static final By tabelAturanCuti = By.xpath("//table[contains(@class,'MuiTable-root')]");
    public static final By tableRows = By.xpath("//table[contains(@class,'MuiTable-root')]//tbody/tr");
    public static final By tableFirstColumn = By.xpath("//table[contains(@class,'MuiTable-root')]//tbody/tr/td[1]");
    public static By tableContainer = By.xpath("//div[contains(@class,'MuiTableContainer-root')]");
    public static  By message = By.xpath("(//div[@class='MuiSnackbarContent-message css-1w0ym84'])[1]");
}
