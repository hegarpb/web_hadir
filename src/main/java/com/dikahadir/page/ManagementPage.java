package com.dikahadir.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagementPage {
    private WebDriver driver;
    private By absenPointMenu = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-aqx7sf'][normalize-space()='Absen Point'])[1]");

    public ManagementPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAbsenPointMenu() {
        // Tunggu sampai elemen bisa diklik
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(absenPointMenu));

        // Scroll ke elemen
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", driver.findElement(absenPointMenu));

        // Klik menu Absen Point
        driver.findElement(absenPointMenu).click();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
}
