package com.dikahadir.repository;

import org.openqa.selenium.By;

public class AturanCutiRepository {

    // ==============================
    // Input field
    // ==============================
    public static final By inputSearch = By.xpath("//input[@placeholder='Cari berdasarkan nama']");
    public static final By inputNamaAturanCuti = By.xpath("//input[@id='name' and @placeholder='Nama Aturan Cuti']");
    public static final By inputEligiblePengaturanCuti = By.xpath("//input[@id='eligible_leave_total_month' and @placeholder='Eligible Pengaturan Cuti']");
    public static final By inputTanggalBatasSisaCuti = By.xpath("//input[@id='mui-51' and @placeholder='d']");
    public static final By inputBulanCuti = By.xpath("//input[@id='mui-52' and @placeholder='m']");
    public static final By inputMaksimalSisaCuti = By.xpath("//input[@id='max_carry_forward' and @placeholder='Maksimal Sisa Cuti']");
    public static final By inputJumlahBulanKerjaSisaCuti = By.xpath("//input[@id='carry_forward_total_month' and @placeholder='Jumlah Bulan Kerja Sisa Cuti']");

    // ==============================
    // Buttons
    // ==============================
    public static final By buttonReset = By.xpath("//button[normalize-space()='Reset']");
    public static final By buttonSearch = By.xpath("//button[normalize-space()='Search']");
    public static final By buttonTambahAturan = By.xpath("//button[normalize-space()='Tambahkan Aturan Cuti']");
    public static final By buttonTambahkan = By.xpath("//button[normalize-space()='Tambahkan']");

    // ==============================
    // Table
    // ==============================
    public static final By tabelAturanCuti = By.xpath("//table[contains(@class,'MuiTable-root')]");
    public static final By tableRows = By.xpath("//table[contains(@class,'MuiTable-root')]//tbody/tr");
    public static final By tableFirstColumn = By.xpath("//table[contains(@class,'MuiTable-root')]//tbody/tr/td[1]");

    public static  By message = By.xpath("(//div[@class='MuiSnackbarContent-message css-1w0ym84'])[1]");
}
