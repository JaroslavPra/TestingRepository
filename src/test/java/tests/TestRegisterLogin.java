package tests;

import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import utilities.FileReaderUtils;

import java.io.IOException;
import java.util.List;

public class TestRegisterLogin extends BaseTest {

    RegisterPage registerPage;
    LoginPage loginPage;

    /**
     * <p>Test Register</p>
     * <ol>
     * <li>Open web application
     * <li>Navigate to register page
     * <li>Fill fields with valid data
     * <li>Click register
     * </ol>
     */

    @Test
    public void testRegister() throws IOException, InterruptedException {
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        List<String> formData = FileReaderUtils.getTestData("src/test/resources/firstAccount.txt");
        Account accountObject = new Account(formData);
        loginPage.getRegisterLink().click();
        registerPage.perfomRegisterAcion(accountObject);
    }

    /**
     * <p>Test Register</p>
     * <ol>
     * <li>Open web application
     * <li>Check fields for login
     * <li>Fill fields with valid data
     * <li>Click login
     * </ol>
     */

    @Test
    public void testLogin() throws IOException {
        loginPage = new LoginPage(driver);
        List<String> formData = FileReaderUtils.getTestData("src/test/resources/firstAccount.txt");
        Account accountObject = new Account(formData);
        Assert.assertTrue(loginPage.getLoginUsernameInputField().isEnabled(),"Username input field is not enabled");
        Assert.assertTrue(loginPage.getLoginUsernameInputField().isDisplayed(), "Username input field is not visible");
        Assert.assertTrue(loginPage.getLoginPasswordInputField().isEnabled(),"Password input field is not enabled");
        Assert.assertTrue(loginPage.getLoginPasswordInputField().isDisplayed(), "Password input field is not visible");
        Assert.assertTrue(loginPage.getLoginButton().isEnabled(),"Login button is not enabled");
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed(), "Login button is not visible");
        Assert.assertTrue(loginPage.getRegisterLink().isEnabled(),"Register link is not enabled");
        Assert.assertTrue(loginPage.getRegisterLink().isDisplayed(), "Register link is not visible");
        loginPage.perfomLoginAcion(accountObject);
    }

}
