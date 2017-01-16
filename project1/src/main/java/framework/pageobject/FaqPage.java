package framework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

/**
 * Created by dt on 05.09.2016.
 */
public class FaqPage extends PageObject {
   private static final String XPATH_FAQ_BUTTON =  "//a[contains(@href, '/faq')]";


    private static final String XPATH_FAQ_1_1 = "//a[contains(@href, '#faq1-1')]";
    private static final String XPATH_FAQ_1_2 ="//a[contains(@href, '#faq1-2')]";
    private static final String XPATH_FAQ_1_3 ="//a[contains(@href, '#faq1-3')]";
    private static final String XPATH_FAQ_1_4 ="//a[contains(@href, '#faq1-4')]";
    private static final String XPATH_FAQ_1_5 ="//a[contains(@href, '#faq1-5')]";
    private static final String XPATH_FAQ_1_6 ="//a[contains(@href, '#faq1-6')]";

    private static final String XPATH_FAQ_2_1 = "//a[contains(@href, '#faq2-1')]";
    private static final String XPATH_FAQ_2_2 ="//a[contains(@href, '#faq2-2')]";
    private static final String XPATH_FAQ_2_3 ="//a[contains(@href, '#faq2-3')]";
    private static final String XPATH_FAQ_2_4 ="//a[contains(@href, '#faq2-4')]";
    private static final String XPATH_FAQ_2_5 ="//a[contains(@href, '#faq2-5')]";

    private static final String XPATH_FAQ_3_1 = "//a[contains(@href, '#faq3-1')]";
    private static final String XPATH_FAQ_3_2 ="//a[contains(@href, '#faq3-2')]";
    private static final String XPATH_FAQ_3_3 ="//a[contains(@href, '#faq3-3')]";
    private static final String XPATH_FAQ_3_4 ="//a[contains(@href, '#faq3-4')]";
    private static final String XPATH_FAQ_3_5 ="//a[contains(@href, '#faq3-5')]";

    private static final String XPATH_FAQ_TITLE_1_1 = "//div[@id='faq1-1']/h3/span";
    private static final String XPATH_FAQ_TITLE_1_2 ="//div[@id='faq1-2']/h3/span";
    private static final String XPATH_FAQ_TITLE_1_3 ="//div[@id='faq1-3']/h3/span";
    private static final String XPATH_FAQ_TITLE_1_4 ="//div[@id='faq1-4']/h3/span";
    private static final String XPATH_FAQ_TITLE_1_5 ="//div[@id='faq1-5']/h3/span";
    private static final String XPATH_FAQ_TITLE_1_6 ="//div[@id='faq1-6']/h3/span";

    private static final String XPATH_FAQ_TITLE_2_1 = "//div[@id='faq2-1']/h3/span";
    private static final String XPATH_FAQ_TITLE_2_2 ="//div[@id='faq2-2']/h3/span";
    private static final String XPATH_FAQ_TITLE_2_3 ="//div[@id='faq2-3']/h3/span";
    private static final String XPATH_FAQ_TITLE_2_4 ="//div[@id='faq2-4']/h3/span";
    private static final String XPATH_FAQ_TITLE_2_5 ="//div[@id='faq2-5']/h3/span";

    private static final String XPATH_FAQ_TITLE_3_1 = "//div[@id='faq3-1']/h3/span";
    private static final String XPATH_FAQ_TITLE_3_2 ="//div[@id='faq3-2']/h3/span";
    private static final String XPATH_FAQ_TITLE_3_3 ="//div[@id='faq3-3']/h3/span";
    private static final String XPATH_FAQ_TITLE_3_4 ="//div[@id='faq3-4']/h3/span";
    private static final String XPATH_FAQ_TITLE_3_5 ="//div[@id='faq3-5']/h3/span";




    public void openFaqPage(){
        WebElement fagButton = driver.findElement(By.xpath(XPATH_FAQ_BUTTON));
        fagButton.click();
    }



    public void openFirstQuestionInSectionAllQuestions(){
        WebElement firstQuestion = driver.findElement(By.xpath(XPATH_FAQ_1_1));
        firstQuestion.click();}
    public void isFirstQuestionInSectionAllQuestionsOpened(){
        driver.findElement(By.xpath(XPATH_FAQ_TITLE_1_1));
    }

    public void openSecondQuestionInSectionAllQuestions(){
        WebElement secondQuestion = driver.findElement(By.xpath(XPATH_FAQ_1_2));
        secondQuestion.click();
    }

    public void isSecondQuestionInSectionAllQuestionsOpened(){
       driver.findElement(By.xpath(XPATH_FAQ_TITLE_1_2));

    }

    public void openThirdQuestionInSectionAllQuestions(){
        WebElement thirdQuestion = driver.findElement(By.xpath(XPATH_FAQ_1_3));
        thirdQuestion.click();
    }
    public void isThirdQuestionInSectionAllQuestionOpened(){
       driver.findElement(By.xpath(XPATH_FAQ_TITLE_1_3));

    }


    public void openFourthQuestionInSectionAllQuestion(){
        WebElement fourthQuestion = driver.findElement(By.xpath(XPATH_FAQ_1_4));
        fourthQuestion.click();
    }

    public void isFourthQuestionInSectionAllQuestionOpened(){
        driver.findElement(By.xpath(XPATH_FAQ_TITLE_1_4));

    }

    public void openFifthQuestionInSectionAllQuestion(){
        WebElement fifthQuestion = driver.findElement(By.xpath(XPATH_FAQ_1_5));
        fifthQuestion.click();
    }

    public void isFifthQuestionInSectionAllQuestionOpened(){
     driver.findElement(By.xpath(XPATH_FAQ_TITLE_1_5));

    }

    public void openSixthQuestionInSectionAllQuestion(){
        WebElement sixthQuestion = driver.findElement(By.xpath(XPATH_FAQ_1_6));
        sixthQuestion.click();
    }

    public void isSixthQuestionInSectionAllQuestionOpened(){
       driver.findElement(By.xpath(XPATH_FAQ_TITLE_1_6));

    }


    public void openFirstQuestionInSectionFinancialQuestions(){
        WebElement firstQuestion = driver.findElement(By.xpath(XPATH_FAQ_2_1));
        firstQuestion.click();
    }

    public void isFirstQuestionInSectionFinancialQuestionsOpened(){
       driver.findElement(By.xpath(XPATH_FAQ_TITLE_2_1));

    }

    public void openSecondQuestionInSectionFinancialQuestions(){
      WebElement secondQuestion = driver.findElement(By.xpath(XPATH_FAQ_2_2));
        secondQuestion.click();
    }

    public void isSecondQuestionInSectionFinancialQuestionsOpened(){
     driver.findElement(By.xpath(XPATH_FAQ_TITLE_2_2));

    }

    public void openThirdQuestionInSectionFinancialQuestions(){
     WebElement thirdQuestion =driver.findElement(By.xpath(XPATH_FAQ_2_3));
        thirdQuestion.click();
    }

    public void isThirdQuestionInSectionFinancialQuestionsOpened(){
       driver.findElement(By.xpath(XPATH_FAQ_TITLE_2_3));

    }

    public void openFourthQuestionInSectionFinancialQuestions(){
        WebElement fourthQuestion =driver.findElement(By.xpath(XPATH_FAQ_2_4));
        fourthQuestion.click();
    }

    public void isFourthQuestionInSectionFinancialQuestionsOpened(){
       driver.findElement(By.xpath(XPATH_FAQ_TITLE_2_4));

    }

    public  void openFifthQuestionInSectionFinancialQuestions(){
        WebElement fifthQuestion = driver.findElement(By.xpath(XPATH_FAQ_2_5));
        fifthQuestion.click();

    }

    public void isFifthQuestionInSectionFinancialQuestionsOpened(){
   driver.findElement(By.xpath(XPATH_FAQ_TITLE_2_5));

    }




    public void openFirstQuestionInSectionTechnicalQuestions(){
    WebElement firstQuestion = driver.findElement(By.xpath(XPATH_FAQ_3_1));
        firstQuestion.click();
    }

    public void isFirstQuestionInSectionTechnicalQuestionsOpened(){
  driver.findElement(By.xpath(XPATH_FAQ_TITLE_3_1));

    }

    public void openSecondQuestionInSectionTechnicalQuestions(){
        WebElement secondQuestion = driver.findElement(By.xpath(XPATH_FAQ_3_2));
        secondQuestion.click();
    }

    public void isSecondQuestionInSectionTechnicalQuestionsOpened(){
        driver.findElement(By.xpath(XPATH_FAQ_TITLE_3_2));

    }

    public void openThirdQuestionInSectionTechnicalQuestions(){
        WebElement thirdQuestion = driver.findElement(By.xpath(XPATH_FAQ_3_3));
        thirdQuestion.click();
    }

    public void isThirdQuestionInSectionTechnicalQuestionsOpened(){
       driver.findElement(By.xpath(XPATH_FAQ_TITLE_3_3));

    }

    public void openFourthQuestionInSectionTechnicalQuestions(){
        WebElement fourthQuestion = driver.findElement(By.xpath(XPATH_FAQ_3_4));
        fourthQuestion.click();
    }
    public void isFourthQuestionInSectionTechnicalQuestionsOpened(){
        driver.findElement(By.xpath(XPATH_FAQ_TITLE_3_4));


    }

    public  void openFifthQuestionInSectionTechnicalQuestions(){
        WebElement fifthQuestion = driver.findElement(By.xpath(XPATH_FAQ_3_5));
        fifthQuestion.click();
    }

    public void isFifthQuestionInSectionTechnicalQuestionsOpened(){
        driver.findElement(By.xpath(XPATH_FAQ_TITLE_3_5));

    }


    public boolean isRulsLinkPresent(){
        try {
            driver.findElement(By.xpath("//a[contains(@href, '/rules')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void isRulsLinkOpened(){
        WebElement rulsLink = driver.findElement(By.xpath("//a[contains(@href, '/rules')]"));
        rulsLink.click();


    }

    public boolean isLinkTrafficSourcesPresent(){
        try {
            driver.findElement(By.xpath("//a[contains(@href, '/traffic-sources')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }


    public void isLinkTrafficSourcesOpened(){
        WebElement linkTrafficSources = driver.findElement(By.xpath("//a[contains(@href, '/traffic-sources')]"));
        linkTrafficSources.click();

    }




}
