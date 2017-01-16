package test.pages;

import framework.pageobject.PrivacyPolicyPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 30.11.2016.
 */
public class PrivacyPolicyPageTest extends BaseTest {
    private PrivacyPolicyPage privacyPolicyPage;

    @BeforeMethod
    public void before() {
        privacyPolicyPage = new PrivacyPolicyPage();
    }

    @Test
    public void openPrivacyPolicyPage(){
        privacyPolicyPage.open();
        privacyPolicyPage.checkTitle();
    }

    @Test
    public void checkIsPrivacyPageOpened(){
        privacyPolicyPage.open();
        privacyPolicyPage.isPrivacyPolicyPageOpen();
        privacyPolicyPage.isLogoPresent();
        privacyPolicyPage.checkFooter();
    }

}
