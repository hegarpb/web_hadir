package com.dikahadir.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagementPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locator untuk elemen menu Management
    private final By absenPointMenu = By.xpath("(//p[normalize-space()='Absen Point'])[1]");
    private final By jabatanMenu = By.xpath("//p[normalize-space()='Jabatan']");

    public ManagementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAbsenPointMenu() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(absenPointMenu));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void clickJabatanMenu() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(jabatanMenu));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}