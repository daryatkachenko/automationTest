package framework.pageobject;


import org.openqa.selenium.By;

public class VipPage extends PageObject {
    private static final String CSS_TITLE = "h1";
    public VipPage open(){
        driver.get(PropertyLoader.URL_VIP);
        return new VipPage();
    }

    public void checkIsVipPageOpened(){
        driver.findElement(By.cssSelector(CSS_TITLE)).getText().matches("VIP-клуб в «Русском Вулкане»");
    }

    public void checkTitle(){

        driver.getTitle().matches("VIP-клуб в «Русском Вулкане»");
    }
}
