package com.dikahadir.repository;

import org.openqa.selenium.By;

public class UserRepository {

    public static By inputSearchUser = By.xpath("//input[@id='search']");
    public static By buttonSearchUser= By.xpath("//button[normalize-space()='Search']");
    public static By activeSwitch = By.xpath("//h5[normalize-space()='Active']/following::input[@type='checkbox'][1]");
    public static By userProjectSwitch = By.xpath("//h5[normalize-space()='User Project']/following::input[@type='checkbox'][1]");
    public static By jabatanByUsername(String username) {
        return By.xpath("//tr[.//a[normalize-space()='" + username + "']]//h6");
    }

    
}
