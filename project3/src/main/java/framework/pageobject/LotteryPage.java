package framework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LotteryPage extends PageObject {
    private static final String CSS_LOTTERY_IMG ="img.all_lotteries_img";

    public LotteryPage open(){
        driver.get(PropertyLoader.URL_LOTTERIES);
        return new LotteryPage();
    }


    public void isLotteryPageBannerPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_LOTTERY_IMG)));
        driver.findElement(By.cssSelector(CSS_LOTTERY_IMG)).isDisplayed();
    }

    public void checkTitle(){
        driver.getTitle().matches("Выгодные лотереи специально для игроков Русского Вулкана");
    }
}
