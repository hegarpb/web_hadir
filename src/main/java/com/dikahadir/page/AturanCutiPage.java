package com.dikahadir.page;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dikahadir.repository.AturanCutiRepository;
import com.dikahadir.repository.JabatanRepository;

public class AturanCutiPage {
    
    private  WebDriver driver;
    private  WebDriverWait wait;
    private ManagementPage managementPage;

    public AturanCutiPage(WebDriver driver){
        this.driver =driver;
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.managementPage = new ManagementPage(driver);
    }

    public void searchAturan(){
           safeClick(wait.until(ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonSearch)));
    }
     public void inputSearchText(String value) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputSearch));
        searchInput.clear();
        searchInput.sendKeys(value);
    }

    public void clickButtonTambahkanJabatan() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonTambahAturan)));
        
    }

       private void safeClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException e) {
            // fallback JS click kalau ketutupan element lain
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    
}
