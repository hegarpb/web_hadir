package com.dikahadir.page;

import com.dikahadir.repository.JabatanRepository;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class JabatanPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final ManagementPage managementPage;

    public JabatanPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.managementPage = new ManagementPage(driver);
    }

    // ================== FORM & BUTTON ================== //

    public void clickSearchJabatan() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonSearchJabatan)));
    }

    public void inputSearchText(String value) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.inputSearchText));
        searchInput.clear();
        searchInput.sendKeys(value);
    }

    public void clickResetFilter() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.resetButton)));
    }

    public void clickButtonTambahkanJabatan() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonTambahkanJabatan)));
    }

    public void clickNextPage() {
        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonNextPage));
        safeClick(next);
    }

    public void setNamaJabatan(String value) {
        WebElement namaInput = wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.inputNamaJabatan));
        namaInput.clear();
        namaInput.sendKeys(value);
    }

    public void setLevelJabatan(String value) {
        WebElement levelInput = wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.inputLevelJabatan));
        levelInput.clear();
        levelInput.sendKeys(value);
    }

    public void clickButtonTambahForm() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonTambah)));
    }

    public void clickButtonConfirmDelete() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonConfirmDelete)));
    }

    public void clickButtonCancel() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonCancel)));
    }

    public void clickButtonSimpanEdit() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonSimpanEdit)));
    }

    public void stepTambahJabatan(String namaJabatan, String levelJabatan) {
        setNamaJabatan(namaJabatan);
        setLevelJabatan(levelJabatan);
    }

    // ================== VALIDATION & MESSAGE ================== //

    public String getMessageText() {
        WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(JabatanRepository.message));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(JabatanRepository.message, "")));
        return messageElement.getText();
    }

    public String getValidationNamaJabatan() {
        return driver.findElement(JabatanRepository.inputNamaJabatan).getAttribute("validationMessage");
    }

    public String getValidationLevelJabatan() {
        return driver.findElement(JabatanRepository.inputLevelJabatan).getAttribute("validationMessage");
    }

    public int getRowsCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.tableRows));
        return driver.findElements(JabatanRepository.tableRows).size();
    }

    // ================== FORM CLOSE CHECK ================== //

    public boolean waitUntilDeleteFormClosed() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(JabatanRepository.formHapusJabatan));
    }

    public boolean waitUntilAddFormClosed() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(JabatanRepository.formTambahJabatan));
    }

    public boolean waitUntilFormEditJabatanClosed() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(JabatanRepository.formEditJabatan));
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

  public void clickActionButtonWithPagination(String namaJabatan) {
        boolean found = false;

        while (true) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(JabatanRepository.tableRows));
            wait.until(ExpectedConditions.visibilityOfElementLocated(JabatanRepository.tableContainer));

            List<WebElement> elements = driver.findElements(JabatanRepository.buttonAction(namaJabatan));
            if (!elements.isEmpty()) {
                safeClick(elements.get(0)); // 🔹 pakai safeClick
                found = true;
                break;
            }

            // tombol next
            List<WebElement> nextButtons = driver.findElements(JabatanRepository.buttonNextPage);
            if (nextButtons.isEmpty() || !nextButtons.get(0).isEnabled()) {
                break;
            }
            safeClick(nextButtons.get(0)); // 🔹 pakai safeClick
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(JabatanRepository.tableRows));
        }

        if (!found) {
            throw new RuntimeException("Jabatan dengan nama '" + namaJabatan + "' tidak ditemukan di semua halaman.");
        }
    }
    public void clickFirstRowEditButton() {
    // Tunggu sampai minimal 1 row ada
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(JabatanRepository.tableRows));

    // Ambil row pertama
    WebElement firstRow = driver.findElements(JabatanRepository.tableRows).get(0);

    // Cari tombol edit dalam row tersebut
    WebElement editButton = firstRow.findElement(JabatanRepository.editButtonInRow);

    // Klik tombol edit
    editButton.click();
    System.out.println("✏️ Klik tombol Edit pada row pertama tabel.");
}


public void clickEditMenu() {
    try {
        // Pastikan semua menu dropdown sudah ada di DOM
        List<WebElement> menuItems = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@role='menuitem']"))
        );

        for (WebElement item : menuItems) {
            String text = item.getText().trim();
            if (text.equalsIgnoreCase("Edit")) {
                // Scroll ke elemen biar benar-benar kelihatan
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);

                // Klik pakai JS langsung
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
                return;
            }
        }

        throw new RuntimeException("❌ Menu 'Edit' tidak ditemukan di dropdown!");

    } catch (Exception e) {
        printAllDropdownOptions(); // debug isi dropdown
        throw new RuntimeException("❌ Gagal klik menu Edit. Detail: " + e.getMessage(), e);
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



    public void clickDeleteMenu() {
        By menuDelete = By.xpath("//ul[contains(@class,'MuiMenu-list')]//li[normalize-space()='Delete']");
        WebElement deleteOption = wait.until(ExpectedConditions.presenceOfElementLocated(menuDelete));
        safeClick(deleteOption); // 🔹 pakai safeClick
    }

    public void clickNextPageButton() {
    WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonNextPage));
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);
    System.out.println("➡️ Klik tombol Next Page");
}   
public void clickPrevPageButton() {
    WebElement prevButton = wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonPrevPage));
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", prevButton);
    System.out.println("⬅️ Klik tombol Previous Page");
}

public void clickLastPageButton() {
    WebElement lastBtn = wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonLastPage));
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", lastBtn);
    System.out.println("⏩ Klik tombol Last Page");
}
public void clickFirstPageButton() {
    WebElement firstPageBtn = wait.until(ExpectedConditions.elementToBeClickable(JabatanRepository.buttonFirstPage));
    firstPageBtn.click();
    System.out.println("⬅️ Klik tombol First Page (halaman awal).");
}


    

    public boolean isJabatanExistInTableWithPagination(String nama, String level) {
        while (true) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(JabatanRepository.tableRows));

            List<WebElement> rows = driver.findElements(JabatanRepository.tableRows);
            for (WebElement row : rows) {
                String cellNama = row.findElement(By.xpath("./td[1]")).getText().trim().replace("\u00A0", " ");
                String cellLevel = row.findElement(By.xpath("./td[2]")).getText().trim().replace("\u00A0", " ");

                if (cellNama.equals(nama) && cellLevel.equals(level)) {
                    return true;
                }
            }

            // cek apakah tombol next masih aktif
            List<WebElement> nextButtons = driver.findElements(
                By.xpath("//button[normalize-space()='Next' and not(@disabled)]")
            );
            if (nextButtons.isEmpty()) {
                break; // sudah di halaman terakhir
            }

            safeClick(nextButtons.get(0)); // 🔹 pakai safeClick
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(JabatanRepository.tableRows));
        }
        return false;
    }

    // ================== HELPER ================== //

    private void safeClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException e) {
            // fallback JS click kalau ketutupan element lain
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

public void waitTableUpdated(Integer oldRowCount) {
    try {
        wait.until(driver -> {
            int newCount = driver.findElements(By.xpath("//table//tbody/tr")).size();

            if (oldRowCount == null) {
                // Mode pertama kali buka halaman: cukup pastikan ada row
                return newCount > 0;
            } else {
                // Mode reload: pastikan jumlah row berubah
                return newCount != oldRowCount && newCount > 0;
            }
        });

        if (oldRowCount == null) {
            System.out.println("✅ Tabel jabatan sudah muncul di halaman.");
        } else {
            System.out.println("🔄 Tabel berhasil reload setelah pindah halaman.");
        }

    } catch (TimeoutException e) {
        throw new RuntimeException("❌ Timeout: Tabel tidak muncul/update sesuai harapan.");
    }
}
public void waitUrlChanged(String oldUrl) {
    try {
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));
        System.out.println("🌐 URL berhasil berubah dari: " + oldUrl + " -> " + driver.getCurrentUrl());
    } catch (TimeoutException e) {
        throw new RuntimeException("❌ Timeout: URL tidak berubah setelah klik pagination.");
    }
}



}