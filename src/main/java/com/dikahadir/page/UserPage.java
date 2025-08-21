package com.dikahadir.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dikahadir.repository.UserRepository;

public class UserPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ====================== Helper Switch ====================== //
    private void setSwitch(By switchLocator, boolean shouldBeOn) {
        WebElement switchElement = driver.findElement(switchLocator);
        boolean isOn = switchElement.isSelected(); // true = ON, false = OFF

        if (isOn != shouldBeOn) {
            switchElement.click(); // toggle biar sesuai target
        }
    }

    public void ensureSwitchOff(By switchLocator) {
        setSwitch(switchLocator, false);
    }

    public void ensureSwitchOn(By switchLocator) {
        setSwitch(switchLocator, true);
    }

    // User Project switch
    public void ensureUserProjectOff() { ensureSwitchOff(UserRepository.userProjectSwitch); }
    public void ensureUserProjectOn()  { ensureSwitchOn(UserRepository.userProjectSwitch); }

    // Active switch
    public void ensureActiveOff() { ensureSwitchOff(UserRepository.activeSwitch); }
    public void ensureActiveOn()  { ensureSwitchOn(UserRepository.activeSwitch); }

    // ====================== Search User ====================== //
    public void setNamaUser(String value){
        WebElement searchInput = wait.until(
            ExpectedConditions.visibilityOfElementLocated(UserRepository.inputSearchUser));
        searchInput.clear();
        searchInput.sendKeys(value);
    }

    public void clickButtonSearchUser() {
        WebElement searchUserButton = wait.until(
            ExpectedConditions.elementToBeClickable(UserRepository.buttonSearchUser));
        searchUserButton.click();
    }

    // Shortcut: search user langsung
    public void searchUser(String username) {
        setNamaUser(username);
        clickButtonSearchUser();
    }

    // ====================== Get Jabatan ====================== //
    public String getJabatanByUsername(String username) {
        WebElement jabatanElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(UserRepository.jabatanByUsername(username)));
        return jabatanElement.getText().trim();
    }
   public void navigateToUserPage() {
    driver.get("https://magang.dikahadir.com/management/user"); // ganti dengan URL halaman user
}
}

