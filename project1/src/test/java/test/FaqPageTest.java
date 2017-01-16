package test;

import framework.pageobject.FaqPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by dt on 12.09.2016.
 */
public class FaqPageTest extends BaseTest{

    private FaqPage fagPage;


    @BeforeMethod
    public void before(){
        fagPage = new FaqPage();
    }



    @Test(priority = 0)
    public void canOpenFagPage(){
        fagPage.openFaqPage();

    }

    @Test
    public void canOpenAllQuestionsInSectionAllQuestions(){
        fagPage.openFaqPage();

        fagPage.openFirstQuestionInSectionAllQuestions();
        fagPage.isFirstQuestionInSectionAllQuestionsOpened();
        driver.navigate().back();

        fagPage.openSecondQuestionInSectionAllQuestions();
        fagPage.isSecondQuestionInSectionAllQuestionsOpened();
        driver.navigate().back();

        fagPage.openThirdQuestionInSectionAllQuestions();
        fagPage.isThirdQuestionInSectionAllQuestionOpened();
        driver.navigate().back();

        fagPage.openFourthQuestionInSectionAllQuestion();
        fagPage.isFourthQuestionInSectionAllQuestionOpened();
        driver.navigate().back();

        fagPage.openFifthQuestionInSectionAllQuestion();
        fagPage.isFifthQuestionInSectionAllQuestionOpened();
        driver.navigate().back();

        fagPage.openSixthQuestionInSectionAllQuestion();
        fagPage.isSixthQuestionInSectionAllQuestionOpened();


    }

    @Test
    public void canOpenAllQuestionInSectionFinancialQuestions(){
        fagPage.openFaqPage();

        fagPage.openFirstQuestionInSectionFinancialQuestions();
        fagPage.isFirstQuestionInSectionFinancialQuestionsOpened();
        driver.navigate().back();

        fagPage.openSecondQuestionInSectionFinancialQuestions();
        fagPage.isSecondQuestionInSectionFinancialQuestionsOpened();
        driver.navigate().back();

        fagPage.openThirdQuestionInSectionFinancialQuestions();
        fagPage.isThirdQuestionInSectionFinancialQuestionsOpened();
        driver.navigate().back();

        fagPage.openFourthQuestionInSectionFinancialQuestions();
        fagPage.isFourthQuestionInSectionFinancialQuestionsOpened();
        driver.navigate().back();

        fagPage.openFifthQuestionInSectionFinancialQuestions();
        fagPage.isFifthQuestionInSectionFinancialQuestionsOpened();
    }


//    @Features("Faq Page")
//    @Stories("open Open All Question In Section Technical Questions")
    @Test
    public  void canOpenAllQuestionsInSectionTechnicalQuestions(){
        fagPage.openFaqPage();

        fagPage.openFirstQuestionInSectionTechnicalQuestions();
        fagPage.isFirstQuestionInSectionTechnicalQuestionsOpened();
        driver.navigate().back();

        fagPage.openSecondQuestionInSectionTechnicalQuestions();
        fagPage.isSecondQuestionInSectionTechnicalQuestionsOpened();
        fagPage.isRulsLinkPresent();
        fagPage.isRulsLinkOpened();
        driver.navigate().back();

        fagPage.openThirdQuestionInSectionTechnicalQuestions();
        fagPage.isThirdQuestionInSectionTechnicalQuestionsOpened();
        driver.navigate().back();

        fagPage.openFourthQuestionInSectionTechnicalQuestions();
        fagPage.isFourthQuestionInSectionTechnicalQuestionsOpened();
        fagPage.isLinkTrafficSourcesPresent();
        fagPage.isLinkTrafficSourcesOpened();
        driver.navigate().back();

        fagPage.openFifthQuestionInSectionTechnicalQuestions();
        fagPage.isFifthQuestionInSectionTechnicalQuestionsOpened();

    }



    }





