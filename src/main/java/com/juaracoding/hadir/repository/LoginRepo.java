package com.juaracoding.hadir.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRepo {
    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//form//button[normalize-space()='Masuk']")
    public WebElement loginButton;
}
