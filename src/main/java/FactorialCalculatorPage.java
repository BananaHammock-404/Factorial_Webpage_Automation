import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FactorialCalculatorPage {

    WebDriverWait wait;
    WebDriver driver;

    public FactorialCalculatorPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isHeaderDisplayed() {
        return Controller.isElementDisplayed(wait, By.xpath("//h1[@class='margin-base-vertical text-center']"));
    }

    public boolean isWarningMessageDisplayed() {
        return Controller.isElementDisplayed(wait, By.xpath("//p[contains(text(),'Please enter an integer')]"));
    }

    public String getInputInResult() {
        String numInputted = Controller.getTextByXpath(wait,"//p[@id='resultDiv']");
        return numInputted.substring(17,19);
    }
    public String getFactorialResult() {
        String numInputted = Controller.getTextByXpath(wait,"//p[@id='resultDiv']");
        return numInputted.substring(24);
    }

    public Integer factorialOf(Integer number){
        int i,fact=1;
        for(i=1;i<=number;i++){
            fact=fact*i;
        }
        return fact;
    }

    public String setFactorialNumber(String facNum) {
        Controller.setTextByXpath(wait,"//input[@id='number']",facNum);
        return facNum;
    }

    public void clickCalculateButton() throws InterruptedException {
        Controller.clickButtonByXpath(wait,"//button[@id='getFactorial']");
        Thread.sleep(100);
    }
    public void clickTermsButton() {
        Controller.clickButtonByXpath(wait,"//a[contains(text(),'Terms and Conditions')]");
    }
    public String getTermsText() {
        return Controller.getTextByXpath(wait,"//html//body");
    }
    public void clickPrivacyButton() {
        Controller.clickButtonByXpath(wait,"//a[contains(text(),'Privacy')]");
    }
    public String getPrivacyText() {
        return Controller.getTextByXpath(wait,"//html//body");
    }
    public void backToPrevPage() {
        driver.navigate().back();
    }

}
