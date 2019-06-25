package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HomePage;
import framework.webPages.LoginPage;
import org.testng.Assert;

/**
 * Created by mohammadmuntakim.
 */
public class LoginSD {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @Given("^I am on home page$")
    public void iAmOnHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Facebook - Log In or Sign Up", "Invalid Home Page");
    }

    @When("^I enter (.+) into (username|password|firstname|lastname|mobile number|new password) text fields on home screen$")
    public void enterDataIntoTextFields(String value, String textFields) {

        switch (textFields) {
            case "username":
                homePage.enterEmail(value);
                break;
            case "password":
                homePage.enterPassword(value);
                break;
            case "firstname":
                homePage.enterFirstName(value);
                break;
            case "lastname":
                homePage.enterLastName(value);
                break;
            case "mobile number":
                homePage.enterMobileNumber(value);
                break;
//            case "new password":
//                homePage.clickOnNewPassword(value);
//                break;
        }
    }

    @When("^I click on (login|submit) button on home screen$")
    public void clickOnLoginButton(String button) {

        switch (button) {
            case "login":
                homePage.clickOnLoginButton();
                break;
            case "submit":
                //Implement Create account object
                break;
        }
    }

    @Then("^I Click on new password text fields on home screen$")
    public void clickOnNewPassword(String value) {
        switch (value) {
            case "newPassword":
                homePage.clickOnNewPassword(value);
                break;
        }
    }


    @Then("^I enter (.+) (invalidEmail|submit) into email text field on home screen$")
    public void enterDataIntoTextField (String value, String textFields) {
        switch (textFields) {
            case "invalidEmail":
                homePage.enterInvalidEmail(value);
                break;
        }


    }

    @Then("^I verify that i am on invalid login page$")
    public void verifyInvalidLoginPage() {
        Assert.assertEquals(loginPage.getPageHeader(), "Log Into Facebook");
    }

    @Then("^I verify invalid signup error message$")
    public void verifySignUpErrorMessage() {
        Assert.assertEquals(homePage.getErrorMessage(), "Invalid signup");
    }

    @Then("^I verify that signup button is disable at homepage$")
    public void verifyDisableSignupButton() {
        Assert.assertFalse(homePage.isSignupButtonEnable(), "Signup button should be disable");
    }

    @Then("^I verify that i am an invalid login page$")
    public void iVerifyInvalidLoginPage() {
        Assert.assertEquals(loginPage.getPageHeader(),"Log Into Facebook");
    }

    @Then("^I see number (\\d+) in text field$")
    public void iSeeNumberInTextField(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }
}
