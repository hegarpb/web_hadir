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
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.inputSearchText));
        searchInput.clear();
        searchInput.sendKeys(value);
    }

    public void clickResetFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.resetButton)).click();
    }

    public void clickButtonTambahkanJabatan() {
        wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonTambahkanJabatan)).click();
    }

   public void SetNamaJabatan(String value) {
    WebElement namaInput = wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.inputNamaJabatan));
    namaInput.clear();
    namaInput.sendKeys(value);
}
public void SetLevelJabatan(String value) {
    WebElement levelInput = wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.inputLevelJabatan));
    levelInput.clear();
    levelInput.sendKeys(value);
}

    
    public void clickButtonTambahForm() {
        wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonTambah)).click();
    }
    public void clickButtonConfirmDelete(){
         wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonConfirmDelete)).click();
    }
    public void clickButtonCancelDelete(){
        wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonCancelDelete)).click();
    }
    
    public void stepTambahJabatan(String namaJabatan, String levelJabatan) {
        
        SetNamaJabatan(namaJabatan);
        SetLevelJabatan(levelJabatan);
        
    }

    
    public String getMessageText() {
        WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(JabatanRepository.message));
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

    public boolean isDeleteFormClosed() {
    return driver.findElements(JabatanRepository.formHapusJabatan).isEmpty();
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



public void clickActionButton() {
    wait.until(ExpectedConditions.elementToBeClickable(
        JabatanRepository.buttonAction
    )).click();
}
 public void clickEditMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(
            JabatanRepository.menuEdit
        )).click();
    }
public void clickDeleteMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(
            JabatanRepository.menuDelete
        )).click();
    }
    public void editJabatan() {
        clickActionButton();
        clickEditMenu();
    }
     public void deleteJabatan() {
        clickActionButton();
        clickDeleteMenu();
    }
    public void clickButtonSimpanEdit() {
    wait.until(ExpectedConditions.elementToBeClickable(
        JabatanRepository.buttonSimpanEdit
    )).click();
}
    


}
