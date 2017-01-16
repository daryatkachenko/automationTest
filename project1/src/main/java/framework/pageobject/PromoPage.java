package framework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by dt on 05.09.2016.
 */
public class PromoPage extends PageObject{



    public PromoPage open(){
        driver.findElement(By.xpath("//div[2]/ul/li[2]/a")).click();
        return new PromoPage();
    }

    public void clickAddPromo(){
        driver.findElement(By.cssSelector("a.btn.btn-add-link")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='landing_page']/div[2]/div[2]/img")));
    }


    public void addVulkanPromo(){
        driver.findElement(By.xpath("//div[@id='landing_page']/div[2]/div[2]/img")).click();

    }

    public void addGaminatorPromo(){
        driver.findElement(By.xpath("//div[@id='casino']/div[2]/div[2]/img")).click();

    }

    public void addNamePromo(){
        driver.findElement(By.cssSelector("#link_name")).clear();
        driver.findElement(By.cssSelector("#link_name")).sendKeys("testAddPromo");
    }

    public void clickSavePromo(){
        driver.findElement(By.cssSelector("button.btn.btn-save")).click();
    }
}
