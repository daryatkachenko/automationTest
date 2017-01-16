package test.pages;

import framework.pageobject.RulesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

/**
 * Created by dt on 30.11.2016.
 */
public class RulesPageTest extends BaseTest {
    private RulesPage rulesPage;

    @BeforeMethod
    public void before() {
        rulesPage = new RulesPage();
    }

    @Test
    public void openPrivacyPolicyPage(){
        rulesPage.open();
        rulesPage.checkTitle();
    }

    @Test
    public void checkIsPrivacyPageOpened(){
        rulesPage.open();
        rulesPage.checkIsRulesPageOpened();
        rulesPage.isLogoPresent();
        rulesPage.checkFooter();
    }
}
