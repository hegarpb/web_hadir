package com.dikahadir.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class JabatanPage {
    private WebDriver driver;
    private ManagementPage managementPage;
    private By buttonTambahkanJabatan = By.xpath("//button[normalize-space()='Tambahkan']");
    private By buttonFilterJabatan = By.xpath("//button[normalize-space()='Search']");
    private By resetFilter = By.xpath("//button[normalize-space()='Reset']");
    private By inputFilterText = By.xpath("//input[@id='search']");
    private By inputNamaJabatan= By.xpath("//input[@id='name']");
    private By inputLevelJabatan = By.xpath("//input[@id='level']");
    private By buttonTambah = By.xpath("//button[normalize-space()='Tambah']");
    private By message = By.xpath("(//div[@class='MuiSnackbarContent-message css-1w0ym84'])[1]");
    private By tampilSearchLevel= By.xpath("//table/tbody/tr/td[2]");

    public JabatanPage (WebDriver driver){
        this.driver =driver;
    }

    public void clickFilterJabatan(){
        driver.findElement(buttonFilterJabatan).click();
    }

    public void inputFilterText(String value){
        driver.findElement(inputFilterText).sendKeys(value);
    }
    public void clickResetFilter(){
        driver.findElement(resetFilter).click();
    }
    public void clickButtonTambahkanJabatan(){
        driver.findElement(buttonTambahkanJabatan).click();
    }

    public void setNamaJabatan(String value){
        driver.findElement(inputNamaJabatan).sendKeys(value);
    }
    
    public void setLevelJabatan(String value){
        driver.findElement(inputLevelJabatan).sendKeys(value);
    }

    public void clickButtonTambah (){
        driver.findElement(buttonTambah).click();
    }

    
    public void stepTambahjabatan(String namaJabatan, String levelJabatan){
        clickButtonTambahkanJabatan();
        setNamaJabatan(namaJabatan);
        setLevelJabatan(levelJabatan);
        clickButtonTambah();
    }
    
    
    public String getMessageText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(message, "")));
        return driver.findElement(message).getText();   
    }

    public List<WebElement> searchLevelJabatan(String level) {
    driver.findElement(inputFilterText).clear();
    driver.findElement(inputFilterText).sendKeys(level);
    driver.findElement(buttonFilterJabatan).click(); 

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tampilSearchLevel));

    return driver.findElements(tampilSearchLevel);
}

    public String getValidationNamaJabatan(){
        return driver.findElement(inputNamaJabatan).getAttribute("validationMessage");
    }

    public String getValidationLevelJabatan(){
        return driver.findElement(inputLevelJabatan).getAttribute("validationMessage");
    }
public void navigateToJabatanPage(){
        managementPage = new ManagementPage(driver);
        managementPage.clickJabatanMenu();
}

}

