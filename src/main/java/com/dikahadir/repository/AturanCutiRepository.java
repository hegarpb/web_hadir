package com.dikahadir.repository;

import org.openqa.selenium.By;

public class AturanCutiRepository {

    // ==============================
    // Input fields
    // ==============================
    public static By inputSearch = By.xpath("//input[@placeholder='Cari berdasarkan nama']");
    public static By inputNamaAturanCuti = By.xpath("//input[@id='name']");
    public static By inputEligiblePengaturanCuti = By.xpath("//input[@id='eligible_leave_total_month']");
    public static By inputTanggalBatasSisaCuti = By.xpath("//input[@placeholder='d']");
    public static By inputBulanBatasSisaCuti = By.xpath("//input[@placeholder='m']");
    public static By inputMaksimalSisaCuti = By.xpath("//input[@id='max_carry_forward']");
    public static By inputJumlahBulanKerjaSisaCuti = By.xpath("//input[@id='carry_forward_total_month']");

    // ==============================
    // Buttons
    // ==============================
    public static By buttonReset = By.xpath("//button[normalize-space()='Reset']");
    public static By buttonSearch = By.xpath("//button[normalize-space()='Search']");
    public static By buttonTambahAturan = By.xpath("//button[normalize-space()='Tambahkan Aturan Cuti']");
    public static By buttonTambahkan = By.xpath("//button[normalize-space()='Tambahkan']");
    public static By buttonSimpan = By.xpath("//button[normalize-space()='Simpan']");
    public static By buttonHapus = By.xpath("//button[@type='button' and normalize-space()='Hapus']");
    public static By buttonBatalEdit = By.xpath("//button[@type='button' and normalize-space()='Tutup']");
    public static By buttonBatal = By.xpath("//button[normalize-space()='Batal']");

    // ==============================
    // Messages / Popups
    // ==============================
    public static By pesanKonfirmasi = By.xpath(
        "//p[contains(@class,'MuiTypography-body1') and contains(text(),'Apakah anda yakin')]"
    );
    public static By message = By.xpath(
        "(//div[@class='MuiSnackbarContent-message css-1w0ym84'])[1]"
    );

    // ==============================
    // Table
    // ==============================
    public static By tabelAturanCuti = By.xpath("//table[contains(@class,'MuiTable-root')]");
    public static By tableRows = By.xpath("//table[contains(@class,'MuiTable-root')]//tbody/tr");
    public static By tableFirstColumn = By.xpath("//table[contains(@class,'MuiTable-root')]//tbody/tr/td[1]");
    public static By tableContainer = By.xpath("//div[contains(@class,'MuiTableContainer-root')]");

    // ==============================
    // Form
    // ==============================
    public static By formEditAturanCuti = By.xpath("//h2[normalize-space()='Sunting Aturan Cuti']");
    public static By confirmDeleteDialog= By.xpath("//p[contains(@class,'MuiTypography-body1') and contains(text(),'Apakah anda yakin')]");
    public static By formTambahAturan= By.xpath("//h2[normalize-space()='Tambahkan Aturan Cuti']");

    // ==============================
    // Menu
    // ==============================
    public static By editMenu          = By.xpath("//li[@role='menuitem' and contains(.,'Edit')]");
    public static By deleteMenu        = By.xpath("//li[@role='menuitem' and contains(.,'Delete')]");
    public static By dropdownMenuItems = By.xpath("//li[@role='menuitem']");
    public static By buttonActionRowPertama = By.xpath("//table/tbody/tr[1]//button[contains(@class,'MuiIconButton')]");
    // ==============================
    // Validation Errors
    // ==============================
    public static By nameError = By.xpath(
        "//p[@id='name-helper-text' and contains(text(),'Nama aturan cuti harus diisi!')]"
    );
    public static By tanggalBatasError = By.xpath(
        "//p[contains(text(),'Tanggal batas sisa cuti harus diisi!')]"
    );
    public static By maksimalSisaError = By.xpath(
        "//p[contains(text(),'Maksimal sisa cuti harus diisi!')]"
    );
}
