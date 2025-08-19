package com.dikahadir.repository;

import org.openqa.selenium.By;

public class JabatanRepository {
    public static  By buttonTambahkanJabatan = By.xpath("//button[normalize-space()='Tambahkan']");
    public static  By buttonFilterJabatan = By.xpath("//button[normalize-space()='Search']");
    public static  By resetFilter = By.xpath("(//button[normalize-space()='Reset'])[1]");
    
    public static  By inputFilterText = By.xpath("//input[@id='search']");
    public static  By inputNamaJabatan= By.xpath("//input[@id='name']");
    public static  By inputLevelJabatan = By.xpath("//input[@id='level']");
    public static  By buttonTambah = By.xpath("//button[normalize-space()='Tambah']");
    public static  By message = By.xpath("(//div[@class='MuiSnackbarContent-message css-1w0ym84'])[1]");
    public static  By tampilSearchLevel= By.xpath("//table/tbody/tr/td[2]");
    public static  By tableRows = By.xpath("//table/tbody/tr");

}
