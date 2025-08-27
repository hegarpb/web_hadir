package com.dikahadir.runners;
import org.testng.annotations.BeforeSuite;

import com.dikahadir.utils.InternetSpeedUtil;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {
        // "src/test/resources/features/jadwal/SearchJadwal.feature",
        // "src/test/resources/features/jadwal/ResetJadwal.feature",
        // "src/test/resources/features/jadwal/TambahJadwal.feature"
        // "src/test/resources/features/jadwal/DetailJadwal.feature",
        // "src/test/resources/features/jadwal/HapusJadwal.feature"
        "src/test/resources/features/jadwal"

    },
    glue = {
        "com.dikahadir",                  
        "com.dikahadir.definitions.jadwal"
    },
    plugin = {
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "json:target/cucumber-report/cucumber.json"
    }
)
public class RunnerJadwalTest extends AbstractTestNGCucumberTests {
    // @BeforeSuite
    // public void beforeSute() {
    //     boolean speedOK = InternetSpeedUtil.isInternetFastEnough(3);
    //     if (!speedOK) {
    //         System.err.println("[HOOK] Koneksi gagal atau lambat, hentikan eksekusi!");
    //         System.exit(1);
    //     }
    // }
}
