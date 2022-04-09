import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Controller {


    /* Input Text to a textbox that has a placeholder xpath where we can recognize is */
    public static void setTextByXpath(WebDriverWait wait, String xpath, String inputText) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).clear();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys(inputText);
    }

    /* Clicking a button that has an xpath on it */
    public static void clickButtonByXpath(WebDriverWait wait, String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    /* Getting a text by Xpath */
    public static String getTextByXpath(WebDriverWait wait, String xpath) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).getText();
    }

    /* Check if a button is displayed, if yes then do something if no then skip.
    it can take abt 1 to 4 seconds so be warned */
    public static boolean isElementDisplayed(WebDriverWait wait, By xpath) {
        try {
            boolean displayed = wait.until(ExpectedConditions.elementToBeClickable(xpath)).isDisplayed();
            System.out.println(displayed);
            return displayed; // Return True
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


