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

import com.dikahadir.repository.AturanCutiRepository;
import com.dikahadir.repository.JadwalRepository;

public class JadwalPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ManagementPage managementPage;
    private String defaultUrl = "https://magang.dikahadir.com/management/schedule";

    


    public JadwalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.managementPage = new ManagementPage(driver);       
    }

    /* ==============================
       🔹 Navigation & Page Control
    ============================== */
    public void navigateToJadwalPage() {
        managementPage.clickJadwalMenu();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void waitUrlToBeDefault() {
        wait.until(ExpectedConditions.urlToBe(defaultUrl));
    }

    /* ==============================
       🔹 Search & Reset Jadwal
    ============================== */
    public void inputSearchJadwal(String value) {
        WebElement searchInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(JadwalRepository.inputSearchJadwal));
        searchInput.clear();
        searchInput.sendKeys(value);
    }

    public void clickSearchJadwal() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(JadwalRepository.buttonSearchJadwal)));
    }

    public void clickResetSearchJadwal() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(JadwalRepository.buttonReset)));
    }

    /* ==============================
       🔹 Form Input (Tambah/Edit Jadwal)
    ============================== */
    public void clickTambahJadwal() {
        safeClick(wait.until(ExpectedConditions.elementToBeClickable(JadwalRepository.buttonTambahJadwal)));
    }

    public void inputNamaJadwal(String value) {
        WebElement inputNamaJadwal = wait.until(
                ExpectedConditions.visibilityOfElementLocated(JadwalRepository.inputNamaJadwalKerja));
        inputNamaJadwal.clear();
        inputNamaJadwal.sendKeys(value);
    }

   public void setTipeJadwal(String tipe) {
    if (tipe == null || tipe.isBlank()) {
        return;
    }

    WebElement element = wait.until(
        ExpectedConditions.elementToBeClickable(JadwalRepository.dropdownTipeJadwal)
    );
    element.click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(JadwalRepository.dropdownTipeJadwal));

    WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//li[normalize-space()='" + tipe + "']"))
    );
    option.click();

    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("menu-typeJadwal")));
}

    public void clickIconCalendar(){
        WebElement icon = wait.until(
            ExpectedConditions.elementToBeClickable(JadwalRepository.iconCalendar)
    );
    icon.click();
    }

    public void setBulanTahun(String bulan,String tahun){
        

    WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(JadwalRepository.headerCalendar));

    while (true) {
        String text = header.getText();

        if (text.contains(bulan) && text.contains(tahun)) {
            break; 
        }

        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(JadwalRepository.tombolNextMonth));
        next.click();

        header = wait.until(ExpectedConditions.visibilityOfElementLocated(JadwalRepository.headerCalendar
        ));
    }
}

    

 public void setTanggal(String hari, String bulan, String tahun) {
    setBulanTahun(bulan, tahun);

    WebElement day = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//button[@role='gridcell' and normalize-space()='" + hari + "']")));
    day.click();
}

    public void clickButtonHariKerja() {
        WebElement buttonHariKerja = wait.until(
                ExpectedConditions.elementToBeClickable(JadwalRepository.buttonPilihHari));
        buttonHariKerja.click();
    }

    public void clickButtonTerapkan() {
        WebElement buttonTerapkan = wait.until(
                ExpectedConditions.elementToBeClickable(JadwalRepository.buttonTerapkan));
        buttonTerapkan.click();
    }

   public void clickButtonTambah() {
    // Tunggu backdrop benar-benar hilang
    try {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
            By.cssSelector("div.MuiBackdrop-root.MuiModal-backdrop")
        ));
    } catch (TimeoutException e) {
        System.out.println("Backdrop masih terlihat, lanjut pakai JS click...");
    }

    WebElement buttonTambah = wait.until(
        ExpectedConditions.elementToBeClickable(JadwalRepository.buttonTambah)
    );

    try {
        buttonTambah.click();
    } catch (ElementClickInterceptedException e) {
        // Fallback pakai JS click kalau masih ketutupan
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonTambah);
    }
}


public void clickButtonBatal(){
    WebElement buttonBatal = wait.until(
                ExpectedConditions.elementToBeClickable(JadwalRepository.buttonBatal));
        buttonBatal.click();
}

public void modalTutup() {
    try {
        boolean isClosed = wait.until(
            ExpectedConditions.invisibilityOfElementLocated(JadwalRepository.alertDialog)
        );
        if (!isClosed) {
            throw new AssertionError("Modal tambah jadwal masih terbuka!");
        }
    } catch (TimeoutException e) {
        throw new AssertionError("Modal tambah jadwal tidak tertutup dalam waktu yang diharapkan!");
    }
}

public void clickButtonSimpan(){
     WebElement buttonSimpan = wait.until(
                ExpectedConditions.elementToBeClickable(JadwalRepository.buttonSimpan));
        buttonSimpan.click();
}

    public void clickButonYa(){
        WebElement buttonConfirm = wait.until(
                ExpectedConditions.elementToBeClickable(JadwalRepository.buttonConfirm));
        buttonConfirm.click();
    }

    public void inputToleransiTerlambat(String menit) {
    WebElement waktu = wait.until(
            ExpectedConditions.elementToBeClickable(JadwalRepository.inputToleransiKeterlambatan));
    
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waktu);
    waktu.clear();
    waktu.sendKeys(menit);
}

   public boolean isElementModalHeaderVisible() {
    try {
        WebElement element = driver.findElement(JadwalRepository.modalHeader);
        return element.isDisplayed();
    } catch (NoSuchElementException e) {
        return false;
    }
   }

   public List<WebElement> getDaftarInputLibur() {
    List<WebElement> daftarInputLibur = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(JadwalRepository.inputLibur));
    return daftarInputLibur;
   }

   public void clickLiburListbox(int index) {
    List<WebElement> daftarInputLibur = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(JadwalRepository.pilihanHari));
    daftarInputLibur.get(index).click();
   }

    public void isiSemuaHari()  {
        byte index = 1;

        try {
            
            for (WebElement element: getDaftarInputLibur()) {
                element.click();
                clickLiburListbox(index);
                Thread.sleep(2000);
                index++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
}


    /* ==============================
       🔹 Table Handling
    ============================== */
    public List<String> getAllJadwal() {
        waitTableToBeVisible();
        List<WebElement> rows = driver.findElements(JadwalRepository.tableFirstColumn);

        if (rows.isEmpty()) {
            return List.of();
        }

        return rows.stream()
                .map(el -> el.getText().trim())
                .filter(text -> !text.isEmpty() && !text.equalsIgnoreCase("Tidak Ada Data"))
                .toList();
    }

    public int getJumlahJadwal() {
        waitTableToBeVisible();
        return driver.findElements(AturanCutiRepository.tableRows).size();
    }

    public boolean isTableEmpty() {
        return getAllJadwal().isEmpty();
    }

    /* ==============================
       🔹Tombol Action
    ============================== */
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
                System.out.println(" Klik berhasil dengan click()");
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
    public void clickDetailMenu() { clickDropdownOption("Detail"); }

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
            throw new RuntimeException(" Menu '" + optionText + "' tidak ditemukan di dropdown!");
        } catch (Exception e) {
            printAllDropdownOptions();
            throw new RuntimeException(" Gagal klik menu " + optionText + ". Detail: " + e.getMessage(), e);
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


    /* ==============================
       🔹 Popup / Snackbar
    ============================== */
   public String getPopupMessage() {
    WebElement popup = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(//div[contains(@class,'MuiSnackbarContent-message')])[1]")
        )
    );
    return popup.getText().trim();
}


  public String getValidationNamaJadwal() {
    wait.until(ExpectedConditions.presenceOfElementLocated(JadwalRepository.inputNamaJadwalKerja)).getAttribute("validationMessage");
    return driver.findElement(JadwalRepository.inputNamaJadwalKerja).getAttribute("validationMessage");
}


public String getValidationToleransi() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(JadwalRepository.inputToleransiKeterlambatan)).getAttribute("validationMessage");
    return driver.findElement(JadwalRepository.inputToleransiKeterlambatan).getAttribute("validationMessage");
    }
    public String getValidationTipeJadwal() {
    WebElement hiddenInput = driver.findElement(JadwalRepository.dropdownTipeJadwal);
    return (String) ((JavascriptExecutor) driver).executeScript(
            "return arguments[0].validationMessage;", hiddenInput
    );
}



    /* ==============================
       🔹 Utility
    ============================== */
    private void waitTableToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(JadwalRepository.tabelJadwal));
    }

    private void safeClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void displayNamaJadwal(String value) {
    wait.until(ExpectedConditions.invisibilityOfElementLocated(JadwalRepository.modalHeader));

    inputSearchJadwal(value);
    clickSearchJadwal();

    wait.until(ExpectedConditions.textToBePresentInElementLocated(
        JadwalRepository.tableFirstColumn, value
    ));
}


}
