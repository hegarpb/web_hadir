package com.dikahadir.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dikahadir.repository.ManagementRepository;

import java.time.Duration;

public class ManagementPage {

    private  WebDriver driver;
    private  WebDriverWait wait;

    

    public ManagementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAbsenPointMenu() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ManagementRepository.absenPointMenu));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void clickJabatanMenu() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ManagementRepository.jabatanMenu));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

     public void navigateToUserBar(){
        WebElement userBarElement = wait.until(ExpectedConditions.elementToBeClickable(ManagementRepository.userBar));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", userBarElement);
    userBarElement.click();

    // Tunggu sampai field search user muncul → tanda halaman User sudah terbuka
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        com.dikahadir.repository.UserRepository.inputSearchUser
    ));
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}