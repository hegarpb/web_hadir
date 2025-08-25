package com.dikahadir.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dikahadir.repository.JadwalRepository;

public class JadwalPage {
     private  WebDriver driver;
    private  WebDriverWait wait;
    private  ManagementPage managementPage;

    public JadwalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.managementPage = new ManagementPage(driver);
    }


    public void inputSearchJawal(String value){
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(JadwalRepository.inputSearchJadwal));
        searchInput.clear();
        searchInput.sendKeys(value);
    }
     public void clickSearchJadwal() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(JadwalRepository.buttonSearchJadwal)));
    }

    public void clickResetSearchJadwal(){
         safeClick(wait.until(ExpectedConditions.elementToBeClickable(JadwalRepository.buttonReset)));
    }

     public void clickTambahJadwal(){
         safeClick(wait.until(ExpectedConditions.elementToBeClickable(JadwalRepository.buttonTambahJadwal)));
    }
    
 public List<String> getAllJadwal() {
    waitTableToBeVisible();

    List<WebElement> rows = driver.findElements(JadwalRepository.tableFirstColumn);

    if (rows.isEmpty()) {
        return List.of(); // return kosong kalau memang tidak ada data
    }

    return rows.stream()
            .map(el -> el.getText().trim())
            .filter(text -> !text.isEmpty() && !text.equalsIgnoreCase("Tidak Ada Data"))
            .toList();
}


     public boolean isTableEmpty() {
        return getAllJadwal().isEmpty();
    }

     public void navigateToJadwalPage() {
        managementPage.clickJadwalMenu();
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();

    }
private void waitTableToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(JadwalRepository.tabelJadwal));
    }
      private void safeClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
}
