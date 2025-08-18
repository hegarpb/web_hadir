package com.dikahadir.definitions.Jabatan;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir.Hooks;
import com.dikahadir.page.JabatanPage;


public class FilterLevelJabatanTest extends Hooks {
    @Test(priority=1, description="Verifikasi fungsionalitas pencarian jabatan berdasarkan level jabatan yang valid.")
public void searchLevelJabatan() {
    JabatanPage jabatanPage = new JabatanPage(driver);

    jabatanPage.navigateToJabatanPage();

    String expectedLevel = "2";

    List<WebElement> levelCells = jabatanPage.searchLevelJabatan(expectedLevel);   
    Assert.assertTrue(levelCells.size() > 0,expectedLevel);
    
    for (WebElement cell : levelCells) {
        Assert.assertEquals(cell.getText(), expectedLevel);
    }
    
}





    }



    

