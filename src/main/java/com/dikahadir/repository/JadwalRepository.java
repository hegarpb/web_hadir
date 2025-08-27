package com.dikahadir.repository;

import org.openqa.selenium.By;

public class JadwalRepository {

    //  ============================
    //   SEARCH & FILTER
    //  ============================
    public static By inputSearchJadwal   = By.xpath("//input[@placeholder='cari berdasarkan nama']");
    public static By buttonSearchJadwal  = By.xpath("//button[normalize-space()='Search']");
    public static By buttonReset         = By.xpath("//button[normalize-space()='Reset']");

    // ============================
    //   TABEL JADWAL
    //  ============================
    public static By tabelJadwal         = By.xpath("//table[contains(@class,'MuiTable-root')]");
    public static By tableFirstColumn    = By.xpath("//table[contains(@class,'MuiTable-root')]//tbody/tr/td[1]");

    //  ============================
    //   FORM TAMBAH / EDIT JADWAL
    //  ============================
    public static By buttonTambahJadwal  = By.xpath("//button[normalize-space()='Tambahkan']");
    public static By dropdownTipeJadwal  = By.id("typeJadwal");
    public static By inputNamaJadwalKerja= By.id("nameJadwal");
    public static By inputHariKerja      = By.xpath("//label[normalize-space()='Hari kerja']/following::input[1]");
    public static By buttonPilihHari     = By.xpath("//label[normalize-space()='Hari kerja']/following::button[1]");
    public static By inputToleransiKeterlambatan = By.xpath("//label[normalize-space()='Toleransi Keterlambatan']/following::input[1]");
    public static By inputLibur          = By.xpath("//div[contains(@class, 'MuiSelect-select') and contains(text(), 'Libur')]");
    public static By pilihanHari         = By.xpath("//ul[@role='listbox']/li");

    //  ============================
    //   CALENDAR / DATE PICKER
    //  ============================
    public static By iconCalendar        = By.xpath("//button[contains(@aria-label,'Choose date')]//*[name()='svg']");
    public static By headerCalendar      = By.xpath("//div[contains(@class,'MuiPickersCalendarHeader-label')]");
    public static By tombolNextMonth     = By.xpath("//button//*[name()='svg' and @data-testid='ArrowRightIcon']/..");
    public static By tombolPrevMonth     = By.xpath("//button//*[name()='svg' and @data-testid='ArrowLeftIcon']/..");

    public static By tanggal(String day) {
        return By.xpath("//div[@role='presentation']//button[@role='gridcell' and normalize-space(text())='" + day + "']");
    }

    //  ============================
    //   MODAL / DIALOG
    // ============================
    public static By alertDialog         = By.id("alert-dialog-slide-title");
    public static By detailHariKerja     = By.xpath("//h2[normalize-space()='Detail Hari Kerja']");
    public static By modalHeader         = By.xpath("//h2[@id='alert-dialog-slide-title' and contains(text(), 'Jumlah Hari Kerja')]");

    //  ============================
    //   BUTTON ACTION
    // ============================
    public static By buttonTambah        = By.xpath("//button[normalize-space()='Tambah']");
    public static By buttonBatal         = By.xpath("//button[normalize-space()='Batal']");
    public static By buttonTerapkan      = By.xpath("//button[normalize-space()='Terapkan']");
    public static By buttonSimpan        = By.xpath("//button[normalize-space()='Simpan']");
    public static By buttonConfirm       = By.xpath("//button[normalize-space()='Ya']");
}