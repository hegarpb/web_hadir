package com.juaracoding.hadir.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracoding.hadir.utils.DriverUtil;

public class DashboardPage {
    private WebDriver driver;
    @FindBy(xpath = "//p[normalize-space()='Management']")
    private WebElement clikMenuManagement;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clikMenuManagement() {
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(clikMenuManagement)).click();
    }

}
