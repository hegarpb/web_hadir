// File: src/test/java/com/dikahadir/definitions/jabatan/ResetFilterLevelJabatanTest.java

package com.dikahadir.definitions.jabatan;

import com.dikahadir.Hooks;
import com.dikahadir.page.JabatanPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ResetFilterLevelJabatanTest {

    private JabatanPage jabatanPage;
    private int initialCount;

    // Gunakan constructor untuk menginisialisasi Page Object
    public ResetFilterLevelJabatanTest() {
        // Akses driver melalui metode statis dari kelas Hooks
        this.jabatanPage = new JabatanPage(Hooks.getDriver());
    }

    @Given("user diarahkan ke halaman Manajemen Jabatan")
    public void navigasiKeHalamanJabatan() {
        jabatanPage.navigateToJabatanPage();
        // Simpan jumlah baris awal sebelum filter diterapkan
        initialCount = jabatanPage.getRowsCount();
    }

    @Given("user sudah melakukan pencarian level jabatan dengan level {string}")
    public void lakukanPencarian(String level) {
        jabatanPage.searchLevelJabatan(level);
    }

    @When("user mengklik tombol {string}")
    public void klikTombol(String buttonName) {
        if ("Reset Filter".equalsIgnoreCase(buttonName)) {
            jabatanPage.clickResetFilter();
        } else {
            // Opsional: tambahkan logika untuk tombol lain jika diperlukan
            System.out.println("Tombol tidak dikenali: " + buttonName);
        }
    }

    @Then("semua jabatan yang ditampilkan tidak dalam keadaan terfilter")
    public void verifikasiTidakTerfilter() {
        // Asumsi: Jika filter berhasil di-reset, jumlah item tidak akan nol
        Assert.assertTrue(jabatanPage.getRowsCount() > 0, "Daftar jabatan kosong setelah reset filter.");
        // Anda juga bisa menambahkan verifikasi visual di sini (misalnya, cek apakah input filter sudah kosong)
    }

    @Then("jumlah jabatan yang ditampilkan kembali ke kondisi semula")
    public void verifikasiJumlahKembaliNormal() {
        int resetCount = jabatanPage.getRowsCount();
        Assert.assertEquals(resetCount, initialCount, "Jumlah baris setelah reset tidak kembali ke kondisi awal.");
    }
}