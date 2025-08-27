package com.juaracoding.hadir.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.hadir.repository.LoginRepo;

public class LoginPage {
    private LoginRepo repo;

    public LoginPage(WebDriver driver){
        repo = new LoginRepo();
        PageFactory.initElements(driver, repo);
    }

    public void setEmail(String value){
        repo.email.sendKeys(value);
    }

    public void setPassword(String value){
        repo.password.sendKeys(value);
    }

    public void clickLoginButton(){
        repo.loginButton.click();
    }

    public void performLogin(){
        setEmail("admin@hadir.com");
        setPassword("MagangSQA_JC@123");
        clickLoginButton();
    }

    public void performLogin(String email, String password){
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }
}
