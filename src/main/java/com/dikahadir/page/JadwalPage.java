package com.dikahadir.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JadwalPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String defaultUrl = "https://magang.dikahadir.com/management/schedule";

    // ============================
    // LOCATORS
    // ============================
    // Search & Filter
    private By inputSearchJadwal = By.xpath("//input[@placeholder='cari berdasarkan nama']");
    private By buttonSearchJadwal = By.xpath("//button[normalize-space()='Search']");
    private By buttonReset = By.xpath("//button[normalize-space()='Reset']");

    // Table
    private By tabelJadwal = By.xpath("//table[contains(@class,'MuiTable-root')]");
    private By tableFirstColumn = By.xpath("//table[contains(@class,'MuiTable-root')]//tbody/tr/td[1]");
    private By tableRows = By.xpath("//table[contains(@class,'MuiTable-root')]//tbody/tr");
    private By tableContainer = By.xpath("//table[contains(@class,'MuiTable-root')]");

    // Form Tambah/Edit
    private By buttonTambahJadwal = By.xpath("//button[normalize-space()='Tambahkan']");
    private By dropdownTipeJadwal = By.id("typeJadwal");
    private By inputNamaJadwalKerja = By.id("nameJadwal");
    private By inputHariKerja = By.xpath("//label[normalize-space()='Hari kerja']/following::input[1]");
    private By buttonPilihHari = By.xpath("//label[normalize-space()='Hari kerja']/following::button[1]");
    private By inputToleransiKeterlambatan = By.xpath("//label[normalize-space()='Toleransi Keterlambatan']/following::input[1]");
    private By inputLibur = By.xpath("//div[contains(@class, 'MuiSelect-select') and contains(text(), 'Libur')]");
    private By pilihanHari = By.xpath("//ul[@role='listbox']/li");

    // Calendar / Date Picker
    private By iconCalendar = By.xpath("//button[contains(@aria-label,'Choose date')]//*[name()='svg']");
    private By headerCalendar = By.xpath("//div[contains(@class,'MuiPickersCalendarHeader-label')]");
    private By tombolNextMonth = By.xpath("//button//*[name()='svg' and @data-testid='ArrowRightIcon']/..");
    private By tombolPrevMonth = By.xpath("//button//*[name()='svg' and @data-testid='ArrowLeftIcon']/..");

    // Buttons
    private By buttonTambah = By.xpath("//button[normalize-space()='Tambah']");
    private By buttonBatal = By.xpath("//button[normalize-space()='Batal']");
    private By buttonTerapkan = By.xpath("//button[normalize-space()='Terapkan']");
    private By buttonSimpan = By.xpath("//button[normalize-space()='Simpan']");
    private By buttonConfirm = By.xpath("//button[normalize-space()='Ya']");

    // Modal / Dialog
    private By alertDialog = By.id("alert-dialog-slide-title");
    private By modalHeader = By.xpath("//h2[@id='alert-dialog-slide-title' and contains(text(), 'Jumlah Hari Kerja')]");

    // Dropdown Menu
    private By dropdownMenuItems = By.xpath("//li[@role='menuitem']");

    // Popup / Snackbar
    private By popupMessage = By.xpath("(//div[contains(@class,'MuiSnackbarContent-message')])[1]");

    // ============================
    // CONSTRUCTOR
    // ============================
    public JadwalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ============================
    // NAVIGATION
    // ============================
    public void navigateToJadwalPage() {
        driver.get(defaultUrl);
    }

    public void waitUrlToBeDefault() {
        wait.until(ExpectedConditions.urlToBe(defaultUrl));
    }

    // ============================
    // SEARCH & RESET
    // ============================
    public void inputSearchJadwal(String value) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchJadwal));
        input.clear();
        input.sendKeys(value);
    }

    public void clickSearchJadwal() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonSearchJadwal)));
    }

    public void clickResetSearchJadwal() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonReset)));
    }

    // ============================
    // FORM INPUT
    // ============================
    public void clickTambahJadwal() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonTambahJadwal)));
    }

    public void inputNamaJadwal(String value) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(inputNamaJadwalKerja));
        input.clear();
        input.sendKeys(value);
    }

    public void setTipeJadwal(String tipe) {
        if (tipe == null || tipe.isBlank()) return;
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownTipeJadwal));
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='" + tipe + "']")));
        option.click();
        wait.until(ExpectedConditions.invisibilityOf(option));
    }

    public void clickIconCalendar() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(iconCalendar)));
    }

    public void setBulanTahun(String bulan, String tahun) {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(headerCalendar));
        while (!header.getText().contains(bulan) || !header.getText().contains(tahun)) {
            safeClick(wait.until(ExpectedConditions.elementToBeClickable(tombolNextMonth)));
            header = wait.until(ExpectedConditions.visibilityOfElementLocated(headerCalendar));
        }
    }

    public void setTanggal(String hari, String bulan, String tahun) {
        setBulanTahun(bulan, tahun);
        WebElement day = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@role='gridcell' and normalize-space()='" + hari + "']")));
        day.click();
    }

    public void clickButtonHariKerja() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonPilihHari)));
    }

    public void clickButtonTerapkan() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonTerapkan)));
    }

    public void clickButtonTambah() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonTambah)));
    }

    public void clickButtonBatal() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonBatal)));
    }

    public void clickButtonSimpan() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonSimpan)));
    }

    public void clickButtonConfirm() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonConfirm)));
    }

    public void inputToleransiTerlambat(String menit) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(inputToleransiKeterlambatan));
        input.clear();
        input.sendKeys(menit);
    }

    public boolean isElementModalHeaderVisible() {
        try {
            return driver.findElement(modalHeader).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void isiSemuaHari() throws InterruptedException {
        List<WebElement> daftarInputLibur = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(inputLibur));
        int index = 1;
        for (WebElement libur : daftarInputLibur) {
            libur.click();
            List<WebElement> pilihan = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(pilihanHari));
            if (index < pilihan.size()) {
                pilihan.get(index).click();
            }
            Thread.sleep(1000);
            index++;
        }
    }

    public void displayNamaJadwal(String nama) {
        inputSearchJadwal(nama);
        clickSearchJadwal();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(tableFirstColumn, nama));
    }

    // ============================
    // TABLE HANDLING
    // ============================
    public List<String> getAllJadwal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tabelJadwal));
        List<WebElement> rows = driver.findElements(tableFirstColumn);
        return rows.stream()
                .map(WebElement::getText)
                .filter(t -> !t.isEmpty() && !t.equalsIgnoreCase("Tidak Ada Data"))
                .toList();
    }

    public boolean isTableEmpty() {
        return getAllJadwal().isEmpty();
    }

    // ============================
    // DROPDOWN ACTION MENU
    // ============================
    public void clickActionButtonRowPertama() {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tableRows));
            WebElement firstRow = driver.findElements(tableRows).get(0);
            WebElement actionButton = firstRow.findElement(By.xpath(".//button[contains(@class,'MuiIconButton')]"));
            safeClick(actionButton);
        } catch (Exception e) {
            throw new RuntimeException("Gagal klik tombol action di row pertama", e);
        }
    }

    public void clickEditMenu() { clickDropdownOption("Edit"); }
    public void clickDeleteMenu() { clickDropdownOption("Delete"); }
    public void clickDetailMenu() { clickDropdownOption("Detail"); }

    private void clickDropdownOption(String optionText) {
        List<WebElement> menuItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dropdownMenuItems));
        for (WebElement item : menuItems) {
            if (item.getText().trim().equalsIgnoreCase(optionText)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
                return;
            }
        }
        throw new RuntimeException("Menu '" + optionText + "' tidak ditemukan!");
    }

    // ============================
    // POPUP / SNACKBAR
    // ============================
    public String getPopupMessage() {
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(popupMessage));
        return popup.getText().trim();
    }

    // ============================
    // VALIDATION
    // ============================
    public String getValidationNamaJadwal() {
        return getValidationMessage(inputNamaJadwalKerja);
    }

    public String getValidationToleransi() {
        return getValidationMessage(inputToleransiKeterlambatan);
    }

    public String getValidationTipeJadwal() {
        return getValidationMessage(dropdownTipeJadwal);
    }

    private String getValidationMessage(By locator) {
        WebElement element = driver.findElement(locator);
        return (String)((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", element);
    }

    // ============================
    // MODAL
    // ============================
    public void modalTutup() {
        try {
            boolean isClosed = wait.until(
                ExpectedConditions.invisibilityOfElementLocated(alertDialog)
            );
            if (!isClosed) {
                throw new AssertionError("Modal tambah/edit jadwal masih terbuka!");
            }
        } catch (TimeoutException e) {
            throw new AssertionError("Modal tambah/edit jadwal tidak tertutup dalam waktu yang diharapkan!");
        }
    }

    // ============================
    // UTILITY
    // ============================
    private void safeClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
    public int getJumlahJadwal() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(tabelJadwal));
    List<WebElement> rows = driver.findElements(tableFirstColumn);
    // Hitung yang valid (tidak kosong dan bukan "Tidak Ada Data")
    return (int) rows.stream()
            .map(WebElement::getText)
            .filter(t -> !t.isEmpty() && !t.equalsIgnoreCase("Tidak Ada Data"))
            .count();
}
}
