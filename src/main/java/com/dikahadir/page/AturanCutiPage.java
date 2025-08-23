package com.dikahadir.page;

import java.time.Duration;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dikahadir.repository.AturanCutiRepository;

public class AturanCutiPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final ManagementPage managementPage;

    public AturanCutiPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.managementPage = new ManagementPage(driver);
    }

    /** 🔍 Input pencarian aturan cuti */
    public void inputSearchText(String value) {
        WebElement searchInput = wait.until(
            ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputSearch)
        );
        searchInput.clear();
        searchInput.sendKeys(value);
    }

    /** 🔎 Klik tombol search */
    public void clickButtonSearch() {
        safeClick(wait.until(
            ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonSearch)
        ));
    }

    /** ➕ Klik tombol Tambahkan Aturan Cuti */
    public void clickButtonTambahkanAturan() {
        safeClick(wait.until(
            ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonTambahAturan)
        ));
    }

    /** 🔒 Safe click dengan scroll + fallback JS click */
    private void safeClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
}
