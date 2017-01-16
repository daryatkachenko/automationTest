package framework.pageobject;

import org.openqa.selenium.By;

/**
 * Created by dt on 01.12.2016.
 */
public class BonusPage extends PageObject {
    private static final String CSS_TITLE = "h1";
    public BonusPage open(){
        driver.get(PropertyLoader.URL_BONUS);
        return new BonusPage();
    }

    public void checkIsBonusPageOpened(){
        driver.findElement(By.cssSelector(CSS_TITLE)).getText().matches("Бонусы в казино Русский Вулкан");
    }

    public void checkTitle(){

        driver.getTitle().matches("Бонусы в казино Русский Вулкан");
    }
}
