package com.dikahadir.page;

import com.dikahadir.repository.JabatanRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class JabatanPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final ManagementPage managementPage;

    // Konstruktor
    public JabatanPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.managementPage = new ManagementPage(driver);
    }

    // Metode Aksi
    public void clickFilterJabatan() {
        wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonFilterJabatan)).click();
    }

    public void inputFilterText(String value) {
        WebElement filterInput = wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.inputFilterText));
        filterInput.clear();
        filterInput.sendKeys(value);
    }

    public void clickResetFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.resetFilter)).click();
    }

    public void clickButtonTambahkanJabatan() {
        wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonTambahkanJabatan)).click();
    }

    public void setNamaJabatan(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.inputNamaJabatan)).sendKeys(value);
    }

    public void setLevelJabatan(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.inputLevelJabatan)).sendKeys(value);
    }

    public void clickButtonTambah() {
        wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonTambah)).click();
    }

    // Metode Komposit (menggabungkan beberapa langkah)
    public void stepTambahJabatan(String namaJabatan, String levelJabatan) {
        clickButtonTambahkanJabatan();
        setNamaJabatan(namaJabatan);
        setLevelJabatan(levelJabatan);
        clickButtonTambah();
    }

    // Metode Verifikasi (assertion di level Page Object)
    public String getMessageText() {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.message));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(JabatanRepository.message, "")));
        return messageElement.getText();
    }

    public List<WebElement> searchLevelJabatan(String level) {
        inputFilterText(level);
        clickFilterJabatan();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(JabatanRepository.tampilSearchLevel));
        return driver.findElements(JabatanRepository.tampilSearchLevel);
    }

    public String getValidationNamaJabatan() {
        return driver.findElement(JabatanRepository.inputNamaJabatan).getAttribute("validationMessage");
    }

    public String getValidationLevelJabatan() {
        return driver.findElement(JabatanRepository.inputLevelJabatan).getAttribute("validationMessage");
    }

    public int getRowsCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.tableRows));
        return driver.findElements(JabatanRepository.tableRows).size();
    }
    
    public List<WebElement> getFilteredJobLevels() {
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // Tunggu sampai row tabel muncul
    wait.until(driver -> driver.findElements(JabatanRepository.tampilSearchLevel).size() > 0);
    return driver.findElements(JabatanRepository.tampilSearchLevel);
}


    public void navigateToJabatanPage() {
        managementPage.clickJabatanMenu();
    }
}