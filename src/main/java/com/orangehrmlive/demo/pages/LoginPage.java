package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='txtUsername']")
    WebElement username;
    @FindBy(xpath = "//input[@id='txtPassword']")
    WebElement password;
    @FindBy(xpath = "//input[@id='btnLogin']")
    WebElement loginButton;
    @FindBy(xpath = "//a[contains(text(),'Welcome test first name')]")
    WebElement verifyWelcome;
    @FindBy(xpath = "//img[@alt='OrangeHRM']")
    WebElement verifyLogo;
    @FindBy(id = "welcome")
    WebElement clickOnWelcome;
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement clickOnLogout;



    public void setUsername(String name){
        Reporter.log("Entering username :" +username+ " in the usernameField :" +username.toString() + "<br>");
        sendTextToElement(username, name);
    }
    public void setPassword(String psw){
        Reporter.log("Entering password :" +password+ " in the passwordField :" +password.toString() + "<br>");
        sendTextToElement(password,psw);
    }
    public void setLoginButton() {
        Reporter.log("click on login button" +username);
        clickOnElement(loginButton);
    }
    public void setVerifyPanel(){
        verifyText("Welcome test first name",verifyWelcome,"Welcome sra not displayed");

    }

    private void verifyText(String welcome_test_first_name, WebElement verifyWelcome, String welcome_sra_not_displayed) {
    }

    public void setVerifyLogo(){
        Boolean logoPresent = verifyLogo.isDisplayed();
        Assert.assertTrue(logoPresent, "Logo Present");

        /*Boolean p = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", logoClick);
        if (p) {
            System.out.println("Logo present");
        } else {
            System.out.println("Logo not present");
        }*/
    }
    public void setClickWelcome(){
        clickOnElement(clickOnWelcome);
    }
    public void setClickLogout(){
        mouseHoverToElementAndClick(clickOnLogout);
    }






}
