package com.dikahadir.page;

import com.dikahadir.repository.JabatanRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JabatanPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final ManagementPage managementPage;

    
    public JabatanPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.managementPage = new ManagementPage(driver);
    }

    
    public void clickSearchJabatan() {
        wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonSearchJabatan)).click();
    }

    public void inputSearchText(String value) {
        WebElement filterInput = wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.inputSearchText));
        filterInput.clear();
        filterInput.sendKeys(value);
    }

    public void clickResetFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.resetButton)).click();
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

    
    public void stepTambahJabatan(String namaJabatan, String levelJabatan) {
        clickButtonTambahkanJabatan();
        setNamaJabatan(namaJabatan);
        setLevelJabatan(levelJabatan);
        clickButtonTambah();
    }

    
    public String getMessageText() {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.message));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(JabatanRepository.message, "")));
        return messageElement.getText();
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
    
public void searchLevelJabatan(String level) {
    inputSearchText(level);
    clickSearchJabatan();
    
    wait.until(ExpectedConditions.urlContains("level"));
}

    public void navigateToJabatanPage() {
        managementPage.clickJabatanMenu();
    }
    public String getCurrentUrl() {
    return driver.getCurrentUrl();
}
public void waitForUrlToContain(String level) {
    wait.until(ExpectedConditions.urlContains(level));
}
public void waitForUrlAfterReset() {
    wait.until(ExpectedConditions.urlToBe("https://magang.dikahadir.com/management/job-level"));
}
public void waitForTableToBeEmpty() {
    wait.until(ExpectedConditions.numberOfElementsToBe(JabatanRepository.tableRows, 0));
}





}
