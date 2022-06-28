package pages;

import models.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractObjectPage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement loginUsernameInputField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement loginPasswordInputField;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block']")
    private WebElement loginButton;

    @FindBy(linkText = "Create an account")
    private WebElement registerLink;

    public WebElement getLoginUsernameInputField() {
        return loginUsernameInputField;
    }

    public WebElement getLoginPasswordInputField() {
        return loginPasswordInputField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getRegisterLink() {
        return registerLink;
    }

    public void inputFirstName (String name){
        loginUsernameInputField.sendKeys(name);
    }
    public void inputPassword (String password){
        loginPasswordInputField.sendKeys(password);
    }


    public void perfomLoginAcion(Account accountModel){
        inputFirstName(accountModel.getName());
        inputPassword(accountModel.getPassword());
        loginButton.click();
    }
}
