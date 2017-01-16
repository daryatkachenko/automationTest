package framework.pageobject;

import org.openqa.selenium.By;

/**
 * Created by dt on 30.11.2016.
 */
public class RulesPage extends PageObject {
    private static final String CSS_TITLE = "h1";
    public RulesPage open(){
        driver.get(PropertyLoader.URL_RULES);
        return new RulesPage();
    }

    public void checkIsRulesPageOpened(){
        driver.findElement(By.cssSelector(CSS_TITLE)).getText().matches("Правила и условия онлайн казино Русский Вулкан");
    }

    public void checkTitle(){
        driver.getTitle().matches("Правила и условия онлайн казино Русский Вулкан");
    }
}
