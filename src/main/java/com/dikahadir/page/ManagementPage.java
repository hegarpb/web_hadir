package com.dikahadir.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagementPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By absenPointMenu = By.xpath("(//p[normalize-space()='Absen Point'])[1]");
    private By jabatanMenu = By.xpath("//p[normalize-space()='Jabatan']");
    private By aturanCutiMenu = By.xpath("//p[normalize-space()='Aturan Cuti']");
    private By jadwalMenu = By.xpath("//p[normalize-space()='Jadwal']");

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

    public void navigateToAturanCutiMenu() {
        WebElement userBarElement = wait.until(ExpectedConditions.elementToBeClickable(aturanCutiMenu));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", userBarElement);
        userBarElement.click();
    }

    public void clickJadwalMenu() {
        WebElement userBarElement = wait.until(ExpectedConditions.elementToBeClickable(jadwalMenu));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", userBarElement);
        userBarElement.click();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}