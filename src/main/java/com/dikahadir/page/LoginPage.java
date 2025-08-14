package com.dikahadir.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    private WebDriver driver;
    private By email = By.id("email");
    private By password = By.id("password");
    private By buttonLogin= By.cssSelector("button[type='submit']");
    private By managementBar = By.xpath("//p[normalize-space()='Management']");
    

    
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String value){
        driver.findElement(email).sendKeys(value);
    }
    
    public void setPassword(String value){
        driver.findElement(password).sendKeys(value);
    }

    public void clickButtonLogin(){
        driver.findElement(buttonLogin).click();
    }

    public void navigateToManagementBar(){
        driver.findElement(managementBar).click();
    }

  

    public void performLogin(String email, String password){
        setEmail(email);
        setPassword(password);
        clickButtonLogin();

    }
    
}
