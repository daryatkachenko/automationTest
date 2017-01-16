package framework.pageobject;


import org.openqa.selenium.By;

public class RegisterPage extends PageObject {
    private static final String CSS_TITLE = "h1";

    public RegisterPage  open(){
        driver.get(PropertyLoader.URL_REGISTER);
        return new RegisterPage ();
    }

    public void checkIsRegisterPageOpened(){
        driver.findElement(By.cssSelector(CSS_TITLE)).getText().matches("Быстрая регистрация");
    }

    public void checkTitle(){

        driver.getTitle().matches("Регистрация в казино");
    }
}

