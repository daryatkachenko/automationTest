package test.pages;

import framework.pageobject.RegisterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 01.12.2016.
 */
public class RegisterPageTest extends BaseTest {
    private RegisterPage registerPage;

    @BeforeMethod
    public void before() {
        registerPage = new RegisterPage();
    }

    @Test
    public void openRegisterPagePage(){
        registerPage.open();
        registerPage.checkTitle();
    }

    @Test
    public void checkIsRegisterPageOpened(){
        registerPage.open();
        registerPage.checkIsRegisterPageOpened();
        registerPage.isLogoPresent();
        registerPage.checkFooter();
    }
    }
