package com.juaracoding.hadir.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracoding.hadir.repository.AbsenPointRepo;
import com.juaracoding.hadir.utils.DriverUtil;

public class AbsenPointPage {
    private WebDriver driver;
    private AbsenPointRepo repo;
    private WebDriverWait wait;

    public AbsenPointPage(WebDriver driver) {
        this.driver = driver;
        repo = new AbsenPointRepo();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this.repo);
    }

    // ========================= Submenu =========================

    // klik submenu Absen Point
    public void clikSubMenuAbsenPoint() {
        wait.until(ExpectedConditions.elementToBeClickable(repo.clikSubMenuAbsenPoint)).click();
    }

    // ========================= CRUD =========================

    // klik tambah Absen point
    public void clickTambahAbsenPoint() {
        wait.until(ExpectedConditions.elementToBeClickable(repo.clickTambahAbsenPoint)).click();
    }

    // set nama
    public void setName(String value) {
        repo.name.sendKeys(value);
    }

    // set latitude
    public void setLatitude(double value) {
        repo.latitude.sendKeys(String.valueOf(value));
    }

    // set longitidue
    public void setLongitude(double value) {
        repo.longitude.sendKeys(String.valueOf(value));
    }

    // set maxRadius
    public void setMaxRadius(double value) {
        repo.maxRadius.sendKeys(String.valueOf(value));
    }

    // set description
    public void setDescription(String value) {
        repo.description.sendKeys(value);
    }

    public void clickTambah() {
        repo.tambah.click();
    }

    public void performAbsenPoint() {
        setName("budi");
        setLatitude(-6.1000);
        setLongitude(2000);
        setMaxRadius(30000);
        setDescription("gatau");
        clickTambah();
    }

    public void performAbsenPoint(String name, double latitude, double longitude, double maxRadius,
        String description) {
        setName(name);
        setLatitude(latitude);
        setLongitude(longitude);
        setMaxRadius(maxRadius);
        setDescription(description);
        clickTambah();
    }

     public void performAbsenPointNegative(String name, String latitude, String longitude, String maxRadius,
        String description) {
        if (latitude != null && !latitude.isEmpty()) {
        setLatitude(Double.parseDouble(latitude));
        }

        if (longitude != null && !longitude.isEmpty()) {
        setLongitude(Double.parseDouble(longitude));
        }

        if (maxRadius != null && !maxRadius.isEmpty()) {
        setMaxRadius(Integer.parseInt(maxRadius));
        }

        setDescription(description);
        clickTambah();
    }

    // ========================= Message PopUp =========================

    public String getPopupBerhasilTambahAbsenPoint() {
        WebElement popUp = wait.until(ExpectedConditions.visibilityOf(repo.popupBerhasilTambah));
        return popUp.getText();
    }

    public String getPopupBerhasilHapusAbsenPoint() {
        WebElement popUp = wait.until(ExpectedConditions.visibilityOf(repo.popupBerhasilHapus));
        return popUp.getText();
    }

    public String getPopupBerhasilEditAbsenPoint() {
        WebElement popUp = wait.until(ExpectedConditions.visibilityOf(repo.popupBerhasilEdit));
        return popUp.getText();
    }

    // ========================= Search / Reset =========================

    public void setSearch(String value) {
        WebElement inputNama = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        inputNama.clear();
        inputNama.sendKeys(value);
    }

    public void clickSearch() {
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();

        WebElement button = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[@type='submit' and normalize-space(text())='Search']")));
        js.executeScript("arguments[0].scrollIntoView(true);", button);
        js.executeScript("arguments[0].click();", button);
    }

    public void clickReset() {
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();

        // Tunggu tombol reset clickable
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.btn-reset")));

        // Scroll ke tombol
        js.executeScript("arguments[0].scrollIntoView(true);", button);

        // Klik tombol via JS
        js.executeScript("arguments[0].click();", button);
    }

    public String getSearchBoxText() {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        return input.getAttribute("value");
    }

    // ========================= Table / Row =========================

    public String getDataBarisPertama(String expectedNama) {
        int retries = 3;

        while (retries > 0) {
            try {
                // Tunggu baris pertama muncul
                WebElement firstRow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("tbody.MuiTableBody-root tr:first-child")));

                // Ambil kolom pertama (nama) langsung
                WebElement firstCell = firstRow.findElement(By.cssSelector("td:first-child"));

                // Tunggu sampai teks sesuai (case-insensitive)
                wait.until(driver -> firstCell.getText().equalsIgnoreCase(expectedNama));

                String actualNama = firstCell.getText();
                System.out.println("Nama di baris pertama: " + actualNama);
                return actualNama;

            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                retries--;
                System.out.println("Retrying due to stale element, attempts left: " + retries);
            }
        }

        throw new RuntimeException("Failed to get first row data due to stale element.");
    }

    public void setRowsPerPage(String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // target hidden input
        WebElement inputHidden = driver.findElement(
                By.cssSelector("input.MuiSelect-nativeInput"));

        // set value ke hidden input
        js.executeScript("arguments[0].value='" + value + "';", inputHidden);

        // trigger event change supaya table reload
        js.executeScript(
                "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                inputHidden);

        // tunggu sampai row table berubah sesuai value (atau kurang dari value)
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfElementsToBeLessThan(
                        By.cssSelector("tbody.MuiTableBody-root tr"),
                        Integer.parseInt(value) + 1 // toleransi kalau data kurang dari value
                ));
    }

    public int getTableRowCount() {
        return repo.tableRows.size();
    }

    public boolean verifyRowsPerPage(int expected) {
        int actual = getTableRowCount();
        return actual <= expected;
    }

    public boolean isAbsenPointExist(String nama) {
        int retries = 3;

    while (retries > 0) {
        try {
            // tunggu semua baris tabel muncul
            wait.until(ExpectedConditions.visibilityOfAllElements(repo.tableRows));

            for (WebElement row : repo.tableRows) {
                // ambil kolom nama (misal kolom pertama)
                WebElement namaCell = row.findElement(By.cssSelector("td:first-child"));

                // tunggu teks tersedia
                wait.until(driver -> !namaCell.getText().isEmpty());

                if (namaCell.getText().trim().equalsIgnoreCase(nama)) {
                    return true;
                }
            }

            return false; // jika tidak ada yang cocok

        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            retries--; // retry jika elemen stale
        }
    }

    // jika semua retry gagal karena stale element
    throw new RuntimeException("Failed to verify absen point due to stale element.");
    }

    // ========================= Edit =========================

    public void editAbsenPoint(String value) {
        WebElement editDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description")));
        editDescription.clear();
        editDescription.sendKeys(value);
    }

    public void clikButtonEdit() {
        // Klik logo "more" (SVG) -> pakai Selenium click
        WebElement moreLogo = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg.feather.feather-more-vertical")));
        moreLogo.click();

        // Tunggu menu Edit muncul
        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(@class,'MuiMenuItem-root') and normalize-space(text())='Edit']")));

        // Klik tombol Edit (via JS agar aman)
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
        js.executeScript("arguments[0].click();", editBtn);
    }

    // ========================= Hapus =========================
    public void clickButtonHapus(String nama) {
    // 1. Cari baris yang sesuai nama (di dalam <h6>)
    WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//tr[td/h6[normalize-space(text())='" + nama + "']]")
    ));

    // 2. Klik tombol "more" di baris yang benar
    WebElement moreLogo = row.findElement(By.cssSelector("svg.feather.feather-more-vertical"));
    wait.until(ExpectedConditions.elementToBeClickable(moreLogo));
    moreLogo.click();

    // 3. Tunggu menu Delete muncul
    WebElement hapusBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//li[contains(@class,'MuiMenuItem-root') and normalize-space(text())='Delete']")
    ));
    wait.until(ExpectedConditions.elementToBeClickable(hapusBtn));

    // 4. Klik tombol Delete via JS agar aman jika ada overlay
    ((JavascriptExecutor) DriverUtil.getDriver()).executeScript("arguments[0].click();", hapusBtn);
}

    // ========================= Simpan =========================

    public void buttonSimpan() {
        WebElement clickButtonSimpan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//button[contains(@class,'MuiButton-containedPrimary') and normalize-space(text())='Simpan']")));
        clickButtonSimpan.click();
    }

    // ========================= Confirm =========================

    public void clickYaConfirm() {
        WebElement clickYaButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class,'MuiButton-containedPrimary') and normalize-space(text())='Ya']")));

        clickYaButton.click();
    }

    // ========================= Pagination =========================

   // Klik tombol "Previous Page"
    public void clickPreviousPage() {
    By prevBtn = By.xpath("//button[@title='Go to previous page']");
    WebElement prev = wait.until(ExpectedConditions.elementToBeClickable(prevBtn));
    prev.click();
    waitForTableReload();
    }

    // Klik tombol "Next Page"
    public void clickNextPage() {
    By nextBtn = By.xpath("//button[@title='Go to next page']");
    WebElement next = wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
    next.click();
    waitForTableReload();
    }

    // Utility tunggu table reload (row pertama hadir ulang)
    private void waitForTableReload() {
    By firstRowLocator = By.xpath("//table/tbody/tr[1]/td[1]/h6");
    wait.until(ExpectedConditions.presenceOfElementLocated(firstRowLocator));
    }

    // Ambil data baris pertama kolom pertama
    public String getFirstRowData() {
    By firstRowLocator = By.xpath("//table/tbody/tr[1]/td[1]/h6");
    return wait.until(ExpectedConditions.visibilityOfElementLocated(firstRowLocator))
               .getText();
    }

    // Validasi data berubah setelah klik Next
    public boolean isDataChangedAfterNext() {
    String before = getFirstRowData();
    clickNextPage();

    // Tunggu sampai text row berubah dari 'before'
    wait.until(ExpectedConditions.not(
        ExpectedConditions.textToBe(By.xpath("//table/tbody/tr[1]/td[1]/h6"), before)
    ));

    String after = getFirstRowData();
    return !before.equals(after);
    }

    // Validasi data berubah setelah klik Previous
    public boolean isDataChangedAfterPrevious() {
    String before = getFirstRowData();
    clickPreviousPage();

    wait.until(ExpectedConditions.not(
        ExpectedConditions.textToBe(By.xpath("//table/tbody/tr[1]/td[1]/h6"), before)
    ));

    String after = getFirstRowData();
    return !before.equals(after);
}

    public void clickLastPage(){
    By lastBtn = By.xpath("//button[@title='Go to last page']");
    WebElement lastPage = wait.until(ExpectedConditions.elementToBeClickable(lastBtn));
    lastPage.click();
    waitForTableReload();
}

    public void clickFirstPage(){
    By firstBtn = By.xpath("//button[@title='Go to first page']");
    WebElement lastPage = wait.until(ExpectedConditions.elementToBeClickable(firstBtn));
    lastPage.click();
    waitForTableReload();
    }

    // Ambil URL aktif
    public String getCurrentUrl() {
    return driver.getCurrentUrl();
}

    // Validasi data berubah setelah klik last page
    public boolean isDataChangedAfterLast() {
    String before = getFirstRowData();
    clickLastPage();

    // Tunggu sampai text row berubah dari 'before'
    wait.until(ExpectedConditions.not(
        ExpectedConditions.textToBe(By.xpath("//table/tbody/tr[1]/td[1]/h6"), before)
    ));

    String after = getFirstRowData();
    return !before.equals(after);
}

    // Validasi data berubah setelah klik first page
    public boolean isDataChangedAfterFirst() {
    String before = getFirstRowData();
    clickFirstPage();

    wait.until(ExpectedConditions.not(
        ExpectedConditions.textToBe(By.xpath("//table/tbody/tr[1]/td[1]/h6"), before)
    ));

    String after = getFirstRowData();
    return !before.equals(after);
}

// ========================= Get Massage =========================
    public String getNamaAbsenPointErrorMessage() {
        WebElement errorMessage = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id("name"))
        );
    return errorMessage.getText().trim();
    }

    public String getLatitudeAbsenPointErrorMessage() {
        WebElement errorMessage = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id("latitude"))
        );
    return errorMessage.getText().trim();
    }

    public String getLogitudeAbsenPointErrorMessage() {
        WebElement errorMessage = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id("longitude"))
        );
    return errorMessage.getText().trim();
    }

    public String getMaxRadiusAbsenPointErrorMessage() {
        WebElement errorMessage = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id("max_radius"))
        );
    return errorMessage.getText().trim();
    }





}

