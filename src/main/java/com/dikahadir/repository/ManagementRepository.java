package com.dikahadir.repository;

import org.openqa.selenium.By;

public class ManagementRepository {
    public static By absenPointMenu = By.xpath("(//p[normalize-space()='Absen Point'])[1]");
    public static By jabatanMenu = By.xpath("//p[normalize-space()='Jabatan']");
    public static By aturanCutiMenu= By.xpath("//p[normalize-space()='Aturan Cuti']");
    public static By JadwakMenu= By.xpath("//p[normalize-space()='Jadwal']");
}