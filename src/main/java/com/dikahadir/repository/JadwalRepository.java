package com.dikahadir.repository;

import org.openqa.selenium.By;

public class JadwalRepository {
    
    public static By inputSearchJadwal= By.xpath("//input[@placeholder='cari berdasarkan nama']");
    public static By buttonSearchJadwal= By.xpath("//button[normalize-space()='Search']");
    public static By buttonReset= By.xpath("//button[normalize-space()='Reset']");
    public static By buttonTambahJadwal=By.xpath("//button[normalize-space()='Tambahkan']");
    public static By tabelJadwal   = By.xpath("//table[contains(@class,'MuiTable-root')]");

    public static By tableFirstColumn = By.xpath("//table[contains(@class,'MuiTable-root')]//tbody/tr/td[1]");
    
}
