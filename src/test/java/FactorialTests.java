import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTests extends BaseTests{

    FactorialCalculatorPage factorialCalculatorPage;
    String expected;

    @Test(priority = 1, description = "Input Blank and Click Calculate")
    public void blankText() throws InterruptedException {
        factorialCalculatorPage = new FactorialCalculatorPage(driver, wait);
        factorialCalculatorPage.setFactorialNumber("");
        factorialCalculatorPage.clickCalculateButton();

        // User should not be able to input Blanks
        if (!factorialCalculatorPage.isWarningMessageDisplayed()){
            Assert.fail();
        }

    }
    @Test(priority = 2, description = "Input Alphanumeric and Click Calculate")
    public void alphabeticalText() throws InterruptedException {
        factorialCalculatorPage.setFactorialNumber("123abc");
        factorialCalculatorPage.clickCalculateButton();

        // User should not be able to input Alphabetical
        if (!factorialCalculatorPage.isWarningMessageDisplayed()){
            Assert.fail();
        }
    }
    @Test(priority = 3, description = "Input Numeric with Space and Symbols and Click Calculate")
    public void symbolsText() throws InterruptedException {
        factorialCalculatorPage.setFactorialNumber("12 12");
        factorialCalculatorPage.clickCalculateButton();

        // User should not be able to input Spaces between Numbers
        if (!factorialCalculatorPage.isWarningMessageDisplayed()){
            Assert.fail();
        }
    }
    @Test(priority = 4, description = "Input Numeric and Click Calculate")
    public void numericText() throws InterruptedException {
        expected = factorialCalculatorPage.setFactorialNumber("12");
        factorialCalculatorPage.clickCalculateButton();
        //  Thread.sleep(4000);

        // Assert the Result text is the same as the Users Input
        Assert.assertEquals(factorialCalculatorPage.getInputInResult(),
                expected,
                "The Result Text should match with the Users Input");
        // Assert the Result given is Correct
        Assert.assertEquals(factorialCalculatorPage.getFactorialResult(),
                String.valueOf(factorialCalculatorPage.factorialOf(Integer.valueOf(expected))),
                "Result did not Match");
    }
    @Test(priority = 5, description = "Check the Terms & Conditions URL")
    public void termsConditionAccess() {
        factorialCalculatorPage.clickTermsButton();
        if (factorialCalculatorPage.getTermsText() != "This is the terms and conditions document. We are not yet ready with it. Stay tuned!"){
            Assert.fail();
        }

    }
    @Test(priority = 6, description = "Check the Privacy URL")
    public void privacyAccess() {
        factorialCalculatorPage.backToPrevPage();
        factorialCalculatorPage.clickPrivacyButton();
        if (factorialCalculatorPage.getTermsText() != "This is the privacy document. We are not yet ready with it. Stay tuned!"){
            Assert.fail();
        }
    }
}
