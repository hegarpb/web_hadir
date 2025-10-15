
package com.dikahadir.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class JabatanPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ManagementPage managementPage;

    // ================= FORM INPUT =================
    private By inputSearchText = By.xpath("//input[@id='search']");
    private By inputNamaJabatan = By.xpath("//input[@id='name']");
    private By inputLevelJabatan = By.xpath("//input[@id='level']");

    // ================= BUTTON =================
    private By buttonTambahkanJabatan = By.xpath("//button[normalize-space()='Tambahkan']");
    private By buttonSearchJabatan = By.xpath("//button[normalize-space()='Search']");
    private By resetButton = By.xpath("(//button[normalize-space()='Reset'])[1]");
    private By buttonTambah = By.xpath("//button[normalize-space()='Tambah']");
    private By buttonSimpanEdit = By.xpath("//button[normalize-space()='Simpan']");
    private By buttonBatal = By.xpath("//button[normalize-space()='Batal']");
    private By buttonConfirmDelete = By.xpath("//button[normalize-space()='Ya']");
    private By buttonCancelDelete = By.xpath("//button[normalize-space()='Tidak']");

    // ================= SNACKBAR / MESSAGE =================
    private By message = By.xpath("(//div[@class='MuiSnackbarContent-message css-1w0ym84'])[1]");

    // ================= TABLE & PAGINATION =================
    private By tableRows = By.xpath("//table/tbody/tr");
    private By tableContainer = By.xpath("//div[contains(@class,'MuiTableContainer-root')]");
    private By tableFirstColumn = By.xpath("//table[contains(@class,'MuiTable-root')]//tbody/tr/td[2]");
    private By buttonNextPage = By.xpath("//button[@aria-label='Go to next page' and not(@disabled)]");
    private By buttonPrevPage = By.xpath("//button[@aria-label='Go to previous page' and not(@disabled)]");
    private By buttonLastPage = By.xpath("//button[@aria-label='Go to last page' and not(@disabled)]");
    private By buttonFirstPage = By.xpath("//button[@aria-label='Go to first page' and not(@disabled)]");

    // ================= MENU / ACTION =================
    private By dropdownMenuItems = By.xpath("//li[@role='menuitem']");
    private By buttonActionRowPertama = By.xpath("//table/tbody/tr[1]//button[contains(@class,'MuiIconButton')]");

    // ================= FORM MODAL =================
    private By formTambahJabatan = By.xpath("//h2[normalize-space()='Tambah Jabatan']");
    private By formEditJabatan = By.xpath("//h2[normalize-space()='Edit Jabatan']");
    private By formHapusJabatan = By.xpath("//div[contains(@class,'modal')]//h2[normalize-space()='Hapus Jabatan']");

    public JabatanPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.managementPage = new ManagementPage(driver);
    }

    // ================== FORM & BUTTON ================== //

    public void clickSearchJabatan() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonSearchJabatan)));
    }

    public void inputSearchText(String value) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchText));
        searchInput.clear();
        searchInput.sendKeys(value);
    }

    public void clickResetSearch() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(resetButton)));
    }

    public void clickButtonTambahkanJabatan() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonTambahkanJabatan)));
    }

    public void clickNextPage() {
        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(buttonNextPage));
        safeClick(next);
    }

    public void setNamaJabatan(String value) {
        WebElement namaInput = wait.until(ExpectedConditions.visibilityOfElementLocated(inputNamaJabatan));
        namaInput.clear();
        namaInput.sendKeys(value);
    }

    public void setLevelJabatan(String value) {
        WebElement levelInput = wait.until(ExpectedConditions.visibilityOfElementLocated(inputLevelJabatan));
        levelInput.clear();
        levelInput.sendKeys(value);
    }

    public By getInputSearchText() {
        return inputSearchText;
    }

    public void waitForSearchInputVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchText));
    }

    public void waitForButtonTambahkanVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonTambahkanJabatan));
    }

    public void clickButtonBatal() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonBatal)));
    }

    public void clickButtonTambahForm() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonTambah)));
    }

    public void clickButtonConfirmDelete() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonConfirmDelete)));
    }

    public void clickButtonCancelDelete() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonCancelDelete)));
    }

    public void clickButtonSimpanEdit() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(buttonSimpanEdit)));
    }

    public void stepTambahJabatan(String namaJabatan, String levelJabatan) {
        setNamaJabatan(namaJabatan);
        setLevelJabatan(levelJabatan);
    }

    // ================== VALIDATION & MESSAGE ================== //

    public String getMessageText() {
        WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(message));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(message, "")));
        return messageElement.getText();
    }

    public String getValidationNamaJabatan() {
        return driver.findElement(inputNamaJabatan).getAttribute("validationMessage");
    }

    public String getValidationLevelJabatan() {
        return driver.findElement(inputLevelJabatan).getAttribute("validationMessage");
    }

    public int getRowsCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableRows));
        return driver.findElements(tableRows).size();
    }

    // ================== FORM CLOSE CHECK ================== //

    public boolean waitUntilDeleteFormClosed() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(formHapusJabatan));
    }

    public boolean waitUntilAddFormClosed() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(formTambahJabatan));
    }

    public boolean waitUntilFormEditJabatanClosed() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(formEditJabatan));
    }

    // ================== NAVIGATION ================== //

    public void navigateToJabatanPage() {
        managementPage.clickJabatanMenu();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void waitForUrlToContain(String level) {
        wait.until(ExpectedConditions.urlContains(level));
    }

    public void waitForUrlAfterReset() {
        wait.until(ExpectedConditions.urlToBe("https://magang.dikahadir.com/management/job-level"));
    }

    // ================== ACTION WITH PAGINATION ================== //

    public void clickActionButtonRowPertama() {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tableRows));
            wait.until(ExpectedConditions.visibilityOfElementLocated(tableContainer));

            WebElement actionButton = wait.until(
                    ExpectedConditions.elementToBeClickable(buttonActionRowPertama));

            try {
                actionButton.click();
            } catch (Exception e) {

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", actionButton);
            }

        } catch (Exception e) {
            throw new RuntimeException(" Gagal klik tombol action di row pertama", e);
        }
    }

    public void clickEditMenu() {
        try {
            List<WebElement> menuItems = wait.until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(dropdownMenuItems));

            for (WebElement item : menuItems) {
                String text = item.getText().trim();
                if (text.equalsIgnoreCase("Edit")) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);

                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
                    return;
                }
            }

            throw new RuntimeException(" Menu 'Edit' tidak ditemukan di dropdown!");

        } catch (Exception e) {
            printAllDropdownOptions();
            throw new RuntimeException(" Gagal klik menu Edit. Detail: " + e.getMessage(), e);
        }
    }

    public void clickDeleteMenu() {
        try {
            List<WebElement> menuItems = wait.until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(dropdownMenuItems));

            for (WebElement item : menuItems) {
                String text = item.getText().trim();
                if (text.equalsIgnoreCase("Delete")) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);

                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
                    return;
                }
            }

            throw new RuntimeException(" Menu 'Delete' tidak ditemukan di dropdown!");

        } catch (Exception e) {
            printAllDropdownOptions();
            throw new RuntimeException(" Gagal klik menu Delete. Detail: " + e.getMessage(), e);
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

    public void clickNextPageButton() {
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(buttonNextPage));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);
        System.out.println("Klik tombol Next Page");
    }

    public void clickPrevPageButton() {
        WebElement prevButton = wait.until(ExpectedConditions.elementToBeClickable(buttonPrevPage));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", prevButton);
        System.out.println("⬅ Klik tombol Previous Page");
    }

    public void clickLastPageButton() {
        WebElement lastBtn = wait.until(ExpectedConditions.elementToBeClickable(buttonLastPage));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", lastBtn);
        System.out.println("Klik tombol Last Page");
    }

    public void clickFirstPageButton() {
        WebElement firstPageBtn = wait.until(ExpectedConditions.elementToBeClickable(buttonFirstPage));
        firstPageBtn.click();
        System.out.println("Klik tombol First Page (halaman awal).");
    }

    public boolean isJabatanExistInTableWithPagination(String nama, String level) {
        while (true) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tableRows));

            List<WebElement> rows = driver.findElements(tableRows);
            for (WebElement row : rows) {
                String cellNama = row.findElement(By.xpath("./td[1]")).getText().trim().replace("\u00A0", " ");
                String cellLevel = row.findElement(By.xpath("./td[2]")).getText().trim().replace("\u00A0", " ");

                if (cellNama.equals(nama) && cellLevel.equals(level)) {
                    return true;
                }
            }

            List<WebElement> nextButtons = driver.findElements(
                    buttonNextPage);
            if (nextButtons.isEmpty()) {
                break;
            }

            safeClick(nextButtons.get(0));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tableRows));
        }
        return false;
    }

    public List<String> getAllLevel() {
        waitTableToBeVisible();
        List<WebElement> elements = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(tableFirstColumn));
        return elements.stream()
                .map(el -> el.getText().trim())
                .filter(text -> !text.isEmpty() && !text.equalsIgnoreCase("Tidak Ada Data"))
                .toList();
    }

    private void waitTableToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableContainer));
    }

    // ================== HELPER ================== //

    private void safeClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void waitTableUpdated(Integer oldRowCount) {
        try {
            wait.until(driver -> {
                int newCount = driver.findElements(tableRows).size();

                if (oldRowCount == null) {
                    return newCount > 0;
                } else {
                    return newCount != oldRowCount && newCount > 0;
                }
            });
        } catch (TimeoutException e) {
            throw new RuntimeException(" Timeout: Tabel tidak muncul/update sesuai harapan.");
        }
    }

    public void waitUrlChanged(String oldUrl) {
        try {
            wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));
        } catch (TimeoutException e) {
            throw new RuntimeException(" Timeout: URL tidak berubah setelah klik pagination.");
        }
    }
}
