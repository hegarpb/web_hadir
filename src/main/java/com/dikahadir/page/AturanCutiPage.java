package com.dikahadir.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AturanCutiPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private ManagementPage managementPage;

    private String defaultUrl = "https://magang.dikahadir.com/management/unit-leave";

     // ==============================
    // Input fields
    // ==============================
    private By inputSearch = By.xpath("//input[@placeholder='Cari berdasarkan nama']");
    private By inputNamaAturanCuti = By.xpath("//input[@id='name']");
    private By inputEligiblePengaturanCuti = By.xpath("//input[@id='eligible_leave_total_month']");
    private By inputTanggalBatasSisaCuti = By.xpath("//input[@placeholder='d']");
    private By inputBulanBatasSisaCuti = By.xpath("//input[@placeholder='m']");
    private By inputMaksimalSisaCuti = By.xpath("//input[@id='max_carry_forward']");
    private By inputJumlahBulanKerjaSisaCuti = By.xpath("//input[@id='carry_forward_total_month']");

    // ==============================
    // Buttons
    // ==============================
    private By buttonReset = By.xpath("//button[normalize-space()='Reset']");
    private By buttonSearch = By.xpath("//button[normalize-space()='Search']");
    private By buttonTambahAturan = By.xpath("//button[normalize-space()='Tambahkan Aturan Cuti']");
    private By buttonTambahkan = By.xpath("//button[normalize-space()='Tambahkan']");
    private By buttonSimpan = By.xpath("//button[normalize-space()='Simpan']");
    private By buttonHapus = By.xpath("//button[@type='button' and normalize-space()='Hapus']");
    private By buttonBatalEdit = By.xpath("//button[@type='button' and normalize-space()='Tutup']");
    private By buttonBatal = By.xpath("//button[normalize-space()='Batal']");

    // ==============================
    // Messages / Popups
    // ==============================
    private By pesanKonfirmasi = By.xpath(
        "//p[contains(@class,'MuiTypography-body1') and contains(text(),'Apakah anda yakin')]"
    );
    private By message = By.xpath(
        "(//div[@class='MuiSnackbarContent-message css-1w0ym84'])[1]"
    );

    // ==============================
    // Table
    // ==============================
    private By tabelAturanCuti = By.xpath("//table[contains(@class,'MuiTable-root')]");
    private By tableRows = By.xpath("//table[contains(@class,'MuiTable-root')]//tbody/tr");
    private By tableFirstColumn = By.xpath("//table[contains(@class,'MuiTable-root')]//tbody/tr/td[1]");
    private By tableContainer = By.xpath("//div[contains(@class,'MuiTableContainer-root')]");

    // ==============================
    // Form
    // ==============================
    private By formEditAturanCuti = By.xpath("//h2[normalize-space()='Sunting Aturan Cuti']");
    private By confirmDeleteDialog= By.xpath("//p[contains(@class,'MuiTypography-body1') and contains(text(),'Apakah anda yakin')]");
    private By formTambahAturan= By.xpath("//h2[normalize-space()='Tambahkan Aturan Cuti']");

    // ==============================
    // Menu
    // ==============================
    private By editMenu          = By.xpath("//li[@role='menuitem' and contains(.,'Edit')]");
    private By deleteMenu        = By.xpath("//li[@role='menuitem' and contains(.,'Delete')]");
    private By dropdownMenuItems = By.xpath("//li[@role='menuitem']");
    private By buttonActionRowPertama = By.xpath("//table/tbody/tr[1]//button[contains(@class,'MuiIconButton')]");
    // ==============================
    // Validation Errors
    // ==============================
    private By nameError = By.xpath(
        "//p[@id='name-helper-text' and contains(text(),'Nama aturan cuti harus diisi!')]"
    );
    private By tanggalBatasError = By.xpath(
        "//p[contains(text(),'Tanggal batas sisa cuti harus diisi!')]"
    );
    private By maksimalSisaError = By.xpath(
        "//p[contains(text(),'Maksimal sisa cuti harus diisi!')]"
    );

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonTambahAturan));
        waitUrlToBeDefault();
        waitTableToBeVisible();
    }

    // =====================================================
    // 🔹 Input Field
    // =====================================================
    public void inputSearchText(String value) {
        WebElement searchInput = wait.until(
            ExpectedConditions.visibilityOfElementLocated(inputSearch));
        searchInput.clear();
        searchInput.sendKeys(value);
    }

    public void inputNamaAturan(String value){
        WebElement inputNamaAturan = wait.until(
            ExpectedConditions.visibilityOfElementLocated(inputNamaAturanCuti));
        inputNamaAturan.clear();
        inputNamaAturan.sendKeys(value);
    }

    public void inputEligablePengaturan(String value){
        WebElement inputEligablePengaturan= wait.until(
            ExpectedConditions.visibilityOfElementLocated(inputEligiblePengaturanCuti));
        inputEligablePengaturan.clear();
        inputEligablePengaturan.sendKeys(value);
    }

    public void inputTanggalBatasSisaCuti(String value){
    WebElement inputElement = wait.until(
        ExpectedConditions.visibilityOfElementLocated(inputTanggalBatasSisaCuti));
    inputElement.clear();
    inputElement.sendKeys(value);
}


   public void inputBulanBatasSisaCuti(String value){
    WebElement inputElement = wait.until(
        ExpectedConditions.visibilityOfElementLocated(inputBulanBatasSisaCuti));
    inputElement.clear();
    inputElement.sendKeys(value);
}


    public void InputMaksimalSisaCuti(String value){
        WebElement inputMaksimalSIsaCuti= wait.until(
            ExpectedConditions.visibilityOfElementLocated(inputMaksimalSisaCuti));
        inputMaksimalSIsaCuti.clear();
        inputMaksimalSIsaCuti.sendKeys(value);
    }

    public void inputJumlahBulanKerjaSisaCuti(String value){
        WebElement inputJumlahBulanSisaKerjaCuti= wait.until(
            ExpectedConditions.visibilityOfElementLocated(inputJumlahBulanKerjaSisaCuti));
        inputJumlahBulanSisaKerjaCuti.clear();
        inputJumlahBulanSisaKerjaCuti.sendKeys(String.valueOf(value));
    }

    // =====================================================
    // 🔹 Buttons
    // =====================================================
    public void clickButtonSearch() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonSearch)));
        waitTableToBeVisible();
    }

    public void clickButtonTambahkanAturan(){
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonTambahAturan)));
        waitTableToBeVisible();
    }

    public void clickButtonTambahkan(){
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonTambahkan)));
        waitTableToBeVisible();
    }

    public void clickButtonReset() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonReset)));
        wait.until(d -> driver.findElement(inputSearch).getAttribute("value").isEmpty());
        waitTableToBeVisible();
    }

    public void clickButtonSimpanEdit() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonSimpan)));
    }

    public void clickConfirmHapus(){
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonHapus)));
    }

    public void clickButtonTutup(){
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonBatalEdit)));
    }

    public void clickButtonBatal(){
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonBatal)));
    }

    // =====================================================
    // 🔹 Table Actions (Action Menu: Edit, Delete, View)
    // =====================================================
    public void clickActionButtonRowPertama() {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tableRows));
            wait.until(ExpectedConditions.visibilityOfElementLocated(tableContainer));

            WebElement firstRow = driver.findElements(tableRows).get(0);
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
                ExpectedConditions.presenceOfAllElementsLocatedBy(dropdownMenuItems)
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
        List<WebElement> options = driver.findElements(dropdownMenuItems);
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
        return driver.findElements(tableRows).size();
    }

    public List<String> getAllNamaAturan() {
        waitTableToBeVisible();
        List<WebElement> elements = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(tableFirstColumn)
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
        WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(message));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(message, "")));
        return messageElement.getText();
    }

    public String getErrorNamaAturan() {
        WebElement errorElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(nameError)
        );
        return errorElement.getText();
    }

    public String getErrorTanggalBatas() {
        WebElement errorElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(tanggalBatasError)
        );
        return errorElement.getText();
    }

    public String getErrorMaksimalSisa() {
        WebElement errorElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(maksimalSisaError)
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
    public boolean isNameErrorVisible() {
    return isElementPresent(nameError);
}

public boolean isTanggalBatasErrorVisible() {
    return isElementPresent(tanggalBatasError);
}

public boolean isMaksimalSisaErrorVisible() {
    return isElementPresent(maksimalSisaError);
}


    // =====================================================
    // 🔹 Utils
    // =====================================================
    public boolean isSearchFieldEmpty() {
        String value = driver.findElement(inputSearch).getAttribute("value");
        return value == null || value.isEmpty();
    }
    public boolean isFormEditClosed() {
    return wait.until(ExpectedConditions.invisibilityOfElementLocated(formEditAturanCuti));
}

public boolean isConfirmDeleteDialogClosed() {
    return wait.until(ExpectedConditions.invisibilityOfElementLocated(confirmDeleteDialog));
}

public boolean isFormTambahClosed() {
    return wait.until(ExpectedConditions.invisibilityOfElementLocated(formTambahAturan));
}

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void waitUrlChanged(String oldUrl) {
        try {
            wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));
            System.out.println("🌐 URL berubah dari: " + oldUrl + " -> " + driver.getCurrentUrl());
        } catch (TimeoutException e) {
            throw new RuntimeException("Timeout: URL tidak berubah setelah aksi.");
        }
    }

    public void waitUrlToBeDefault() {
        wait.until(ExpectedConditions.urlToBe(defaultUrl));
    }

    private void waitTableToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tabelAturanCuti));
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