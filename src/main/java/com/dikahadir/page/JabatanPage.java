package com.dikahadir.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JabatanPage {
    private WebDriver driver;
    private By buttonTambahkanJabatan = By.xpath("//button[normalize-space()='Tambahkan']");
    private By filterJabatan = By.xpath("//button[normalize-space()='Search']");
    private By resetFilter = By.xpath("//button[normalize-space()='Reset']");
    private By inputFilterText = By.xpath("//input[@id='search']");
    private By inputTextNamaJabatan= By.xpath("//input[@id='name']");
    private By inputLevelJabatan = By.xpath("//input[@id='level']");
    private By buttonTambah = By.xpath("//button[normalize-space()='Tambah']");
    private By message = By.xpath("(//div[@class='MuiSnackbarContent-message css-1w0ym84'])[1]");

    public JabatanPage (WebDriver driver){
        this.driver =driver;
    }

    public void clickFilterJabatan(){
        driver.findElement(filterJabatan).click();
    }

    public void inputFilterText(String value){
        driver.findElement(inputFilterText).sendKeys(value);
    }
    public void clickResetFilter(){
        driver.findElement(resetFilter).click();
    }
    public void clickButtonTambahkanJabatan(){
        driver.findElement(buttonTambahkanJabatan).click();
    }

    public void setNamaJabatan(String value){
        driver.findElement(inputTextNamaJabatan).sendKeys(value);
    }
    
    public void setLevelJabatan(String value){
        driver.findElement(inputLevelJabatan).sendKeys(value);
    }

    public void clickButtonTambah (){
        driver.findElement(buttonTambah).click();
    }

    
    public void stepTambahjabatan(String namaJabatan, String levelJabatan){
        clickButtonTambahkanJabatan();
        setNamaJabatan(namaJabatan);
        setLevelJabatan(levelJabatan);
        clickButtonTambah();
    }
    
    

    // Metode baru untuk mendapatkan teks pesan sukses
    public String getMessageText(){
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    // Tunggu hingga elemen pesan terlihat
    wait.until(ExpectedConditions.visibilityOfElementLocated(message));
    
    // Tunggu hingga elemen pesan memiliki teks yang tidak kosong
    wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(message, "")));

    // Sekarang, ambil teks dari elemen yang sudah pasti berisi
    return driver.findElement(message).getText();
    }

}