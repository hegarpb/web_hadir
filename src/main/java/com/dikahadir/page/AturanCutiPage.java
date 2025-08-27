package com.dikahadir.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dikahadir.repository.AturanCutiRepository;

public class AturanCutiPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private ManagementPage managementPage;

    private String defaultUrl = "https://magang.dikahadir.com/management/unit-leave";

    public AturanCutiPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.managementPage = new ManagementPage(driver);
    }

    // =====================================================
    // 🔹 Navigasi
    // =====================================================
    public void navigateToAturanCuti(){
        managementPage.navigateToAturanCutiMenu();
        waitUrlToBeDefault();
        waitTableToBeVisible();
    }

    // =====================================================
    // 🔹 Input Field
    // =====================================================
    public void inputSearchText(String value) {
        WebElement searchInput = wait.until(
            ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputSearch));
        searchInput.clear();
        searchInput.sendKeys(value);
    }

    public void inputNamaAturan(String value){
        WebElement inputNamaAturan = wait.until(
            ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputNamaAturanCuti));
        inputNamaAturan.clear();
        inputNamaAturan.sendKeys(value);
    }

    public void inputEligablePengaturan(String value){
        WebElement inputEligablePengaturan= wait.until(
            ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputEligiblePengaturanCuti));
        inputEligablePengaturan.clear();
        inputEligablePengaturan.sendKeys(value);
    }

    public void inputTanggalBatasSisaCuti(String value){
        WebElement inputTanggalBatasSisaCuti= wait.until(
            ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputTanggalBatasSisaCuti));
        inputTanggalBatasSisaCuti.clear();
        inputTanggalBatasSisaCuti.sendKeys(value);
    }

    public void inputBulanBatasSisaCuti(String value){
        WebElement inputBulanBatasSisaCuti= wait.until(
            ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputBulanBatasSisaCuti));
        inputBulanBatasSisaCuti.clear();
        inputBulanBatasSisaCuti.sendKeys(value);
    }

    public void InputMaksimalSisaCuti(String value){
        WebElement inputMaksimalSIsaCuti= wait.until(
            ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputMaksimalSisaCuti));
        inputMaksimalSIsaCuti.clear();
        inputMaksimalSIsaCuti.sendKeys(value);
    }

    public void inputJumlahBulanKerjaSisaCuti(String value){
        WebElement inputJumlahBulanSisaKerjaCuti= wait.until(
            ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.inputJumlahBulanKerjaSisaCuti));
        inputJumlahBulanSisaKerjaCuti.clear();
        inputJumlahBulanSisaKerjaCuti.sendKeys(String.valueOf(value));
    }

    // =====================================================
    // 🔹 Buttons
    // =====================================================
    public void clickButtonSearch() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonSearch)));
        waitTableToBeVisible();
    }

    public void clickButtonTambahkanAturan(){
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonTambahAturan)));
        waitTableToBeVisible();
    }

    public void clickButtonTambahkan(){
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonTambahkan)));
        waitTableToBeVisible();
    }

    public void clickButtonReset() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonReset)));
        wait.until(d -> driver.findElement(AturanCutiRepository.inputSearch).getAttribute("value").isEmpty());
        waitTableToBeVisible();
    }

    public void clickButtonSimpanEdit() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonSimpan)));
    }

    public void clickConfirmHapus(){
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonHapus)));
    }

    public void clickButtonTutup(){
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonBatalEdit)));
    }

    public void clickButtonBatal(){
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(AturanCutiRepository.buttonBatal)));
    }

    // =====================================================
    // 🔹 Table Actions (Action Menu: Edit, Delete, View)
    // =====================================================
    public void clickActionButtonRowPertama() {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(AturanCutiRepository.tableRows));
            wait.until(ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.tableContainer));

            WebElement firstRow = driver.findElements(AturanCutiRepository.tableRows).get(0);
            WebElement actionButton = firstRow.findElement(
                By.xpath(".//button[contains(@class,'MuiIconButton')]")
            );

            wait.until(ExpectedConditions.elementToBeClickable(actionButton));

            try {
                actionButton.click();
                System.out.println("✅ Klik berhasil dengan click()");
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", actionButton);
                System.out.println("⚡ Klik berhasil dengan JavaScriptExecutor");
            }
        } catch (Exception e) {
            throw new RuntimeException(" Gagal klik tombol action di row pertama", e);
        }
    }

    public void clickEditMenu() { clickDropdownOption("Edit"); }
    public void clickDeleteMenu() { clickDropdownOption("Delete"); }
    public void clickViewMenu() { clickDropdownOption("View"); }

    private void clickDropdownOption(String optionText) {
        try {
            List<WebElement> menuItems = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@role='menuitem']"))
            );

            for (WebElement item : menuItems) {
                String text = item.getText().trim();
                if (text.equalsIgnoreCase(optionText)) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
                    return;
                }
            }
            throw new RuntimeException("Menu '" + optionText + "' tidak ditemukan di dropdown!");
        } catch (Exception e) {
            printAllDropdownOptions();
            throw new RuntimeException("Gagal klik menu " + optionText + ". Detail: " + e.getMessage(), e);
        }
    }

    public void printAllDropdownOptions() {
        List<WebElement> options = driver.findElements(By.xpath("//li[@role='menuitem']"));
        System.out.println("=== Dropdown Options Found ===");
        for (WebElement option : options) {
            System.out.println("Option: [" + option.getText().trim() + "]");
        }
        System.out.println("=== End of Options ===");
    }

    // =====================================================
    // 🔹 Table Data
    // =====================================================
    public boolean isTableEmpty() {
        return getAllNamaAturan().isEmpty();
    }

    public int getJumlahAturanCuti() {
        waitTableToBeVisible();
        return driver.findElements(AturanCutiRepository.tableRows).size();
    }

    public List<String> getAllNamaAturan() {
        waitTableToBeVisible();
        List<WebElement> elements = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(AturanCutiRepository.tableFirstColumn)
        );
        return elements.stream()
            .map(el -> el.getText().trim())
            .filter(text -> !text.isEmpty() && !text.equalsIgnoreCase("Tidak Ada Data"))
            .toList();
    }

    public void waitTableUpdated(Integer oldRowCount) {
        try {
            wait.until(driver -> {
                int newCount = driver.findElements(By.xpath("//table//tbody/tr")).size();
                if (oldRowCount == null) {
                    return newCount > 0;
                } else {
                    return newCount != oldRowCount && newCount > 0;
                }
            });

            if (oldRowCount == null) {
                System.out.println("✅ Tabel  sudah muncul di halaman.");
            } else {
                System.out.println("🔄 Tabel berhasil reload setelah pindah halaman.");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("❌ Timeout: Tabel tidak muncul/update sesuai harapan.");
        }
    }

    // =====================================================
    // 🔹 Messages & Error Validation
    // =====================================================
    public String getMessageText() {
        WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(AturanCutiRepository.message));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(AturanCutiRepository.message, "")));
        return messageElement.getText();
    }

    public String getErrorNamaAturan() {
        WebElement errorElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.nameError)
        );
        return errorElement.getText();
    }

    public String getErrorTanggalBatas() {
        WebElement errorElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.tanggalBatasError)
        );
        return errorElement.getText();
    }

    public String getErrorMaksimalSisa() {
        WebElement errorElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.maksimalSisaError)
        );
        return errorElement.getText();
    }

    public boolean isElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // =====================================================
    // 🔹 Utils
    // =====================================================
    public boolean isSearchFieldEmpty() {
        String value = driver.findElement(AturanCutiRepository.inputSearch).getAttribute("value");
        return value == null || value.isEmpty();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void waitUrlChanged(String oldUrl) {
        try {
            wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));
            System.out.println("🌐 URL berubah dari: " + oldUrl + " -> " + driver.getCurrentUrl());
        } catch (TimeoutException e) {
            throw new RuntimeException("❌ Timeout: URL tidak berubah setelah aksi.");
        }
    }

    public void waitUrlToBeDefault() {
        wait.until(ExpectedConditions.urlToBe(defaultUrl));
    }

    private void waitTableToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AturanCutiRepository.tabelAturanCuti));
    }

    private void safeClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
}
