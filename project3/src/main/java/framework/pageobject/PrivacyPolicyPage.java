package framework.pageobject;

import org.openqa.selenium.By;

/**
 * Created by dt on 28.11.2016.
 */
public class PrivacyPolicyPage extends PageObject {

    private static final String CSS_TITLE = "h1";

    public PrivacyPolicyPage open(){
        driver.get(PropertyLoader.URL_PRIVACY_POLICY);
        return new PrivacyPolicyPage();
    }

    public void isPrivacyPolicyPageOpen(){
        driver.findElement(By.cssSelector(CSS_TITLE)).getText().matches("Политика конфиденциальности");
    }

    public void checkTitle(){
        driver.getTitle().matches("Политика конфиденциальности казино Русский Вулкан");
    }
}
