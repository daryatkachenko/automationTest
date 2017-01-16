package utils;

import org.openqa.selenium.WebElement;

/**
 * Created by dt on 15.11.2016.
 */
public class ControlsHelper {
    public static void fillTextBox(WebElement textBox, String value) {
        if (textBox.isEnabled()) {
            textBox.clear();
            textBox.sendKeys(value);
        }else {
            throw new UnsupportedOperationException("Text box is not enabled");
        }
    }
}
