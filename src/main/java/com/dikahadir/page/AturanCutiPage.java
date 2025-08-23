package com.dikahadir.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dikahadir.repository.AturanCutiRepository;
import com.dikahadir.repository.JabatanRepository;

public class AturanCutiPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private ManagementPage managementPage;


    private final String defaultUrl = "https://magang.dikahadir.com/management/unit-leave";

    public AturanCutiPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.managementPage = new ManagementPage(driver);
    }

    /** Navigasi ke menu Aturan Cuti */
    public void navigateToAturanCuti(){
        managementPage.navigateToAturanCutiMenu();
        waitUrlToBeDefault();
        waitTableToBeVisible();
    }

    /** Input teks pada field search */
    public void inputSearchText(String value) {
        WebElement searchInput = wait.until(
            ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputSearch));
        searchInput.clear();
        searchInput.sendKeys(value);
    }

    public void inputNamaAturan(String value){
        WebElement inputNamaAturan = wait.until(
            ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputNamaAturanCuti));
            inputNamaAturan.clear();
              inputNamaAturan.sendKeys(value);
        }     

    public void inputEligablePengaturan(String value){
        WebElement inputEligablePengaturan= wait.until(ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputEligiblePengaturanCuti));
        inputEligablePengaturan.clear();
        inputEligablePengaturan.sendKeys(value);
    }

    
    public void inputTanggalBatasSisaCuti(String value){
        WebElement inputTanggalBatasSisaCuti= wait.until(ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputTanggalBatasSisaCuti));
        inputTanggalBatasSisaCuti.clear();
        inputTanggalBatasSisaCuti.sendKeys(value);
    }

    public void inputBulanBatasSisaCuti(String value){
        WebElement inputBulanBatasSisaCuti= wait.until(ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputBulanCuti));
        inputBulanBatasSisaCuti.clear();
        inputBulanBatasSisaCuti.sendKeys(value);
    }

    public void InputMaksimalSisaCuti(String value){
        WebElement inputMaksimalSIsaCuti= wait.until(ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputMaksimalSisaCuti));
        inputMaksimalSIsaCuti.clear();
        inputMaksimalSIsaCuti.sendKeys(value);
    }

    public void inputJumlahBulanKerjaSisaCuti(String value){
        WebElement inputJumlahBulanSisaKerjaCuti= wait.until(ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputJumlahBulanKerjaSisaCuti));
        inputJumlahBulanSisaKerjaCuti.clear();
        inputJumlahBulanSisaKerjaCuti.sendKeys(String.valueOf(value));
    }
    /** Klik tombol search dan tunggu hasil muncul */
    public void clickButtonSearch() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonSearch)));
        waitTableToBeVisible();
    }
    
    public void clickButtonTambahkanAturan(){
         safeClick(wait.until(ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonTambahAturan)));
        waitTableToBeVisible();
    }

    public void clickButtonTambahkan(){
         safeClick(wait.until(ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonTambahkan)));
        waitTableToBeVisible();
    }
    /** Klik tombol reset lalu tunggu field kosong & tabel reload */
    public void clickButtonReset() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonReset)));
        wait.until(d -> driver.findElement(AturanCutiRepository.inputSearch).getAttribute("value").isEmpty());
        waitTableToBeVisible();
    }

    /** Validasi input search kosong */
    public boolean isSearchFieldEmpty() {
        String value = driver.findElement(AturanCutiRepository.inputSearch).getAttribute("value");
        return value == null || value.isEmpty();
    }

    /** Jumlah baris data di tabel (untuk reset test) */
    public int getJumlahAturanCuti() {
        waitTableToBeVisible();
        return driver.findElements(AturanCutiRepository.tableRows).size();
    }

    /** Ambil semua nama aturan cuti (kolom pertama tabel) - untuk search test */
    public List<String> getAllNamaAturan() {
        waitTableToBeVisible();
        List<WebElement> elements = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(AturanCutiRepository.tableFirstColumn)
        );
        return elements.stream()
                .map(el -> el.getText().trim())
                .filter(text -> !text.isEmpty())
                .toList();
    }

    /** Tunggu URL berubah dari yang lama */
    public void waitUrlChanged(String oldUrl) {
        try {
            wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));
            System.out.println("🌐 URL berubah dari: " + oldUrl + " -> " + driver.getCurrentUrl());
        } catch (TimeoutException e) {
            throw new RuntimeException("❌ Timeout: URL tidak berubah setelah aksi.");
        }
    }

    /** Tunggu sampai URL jadi default */
    public void waitUrlToBeDefault() {
        wait.until(ExpectedConditions.urlToBe(defaultUrl));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /** Tunggu tabel terlihat */
    private void waitTableToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.tabelAturanCuti));
    }

     public String getMessageText() {
        WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(AturanCutiRepository.message));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(JabatanRepository.message, "")));
        return messageElement.getText();
    }

    /** Safe click dengan JS fallback */
    private void safeClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
}
