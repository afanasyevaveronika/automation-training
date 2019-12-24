package com.epam.ta.test;

import com.epam.ta.model.User;
import com.epam.ta.page.HomePage;
import com.epam.ta.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.ta.util.StringUtils.LOGIN_ERROR_MESSAGE;


public class LoginTest extends CommonConditions {

    @Test(description = "Test for logging with incorrect username and password")
    public void logInWithIncorrectUsernameAndPasswordTest() {
        User userInformation = UserCreator.withIncorrectUsernameAndPassword();
        String errorMessage = new HomePage(driver)
                .openPage()
                .redirectToLoginPage()
                .redirectToLoginPageError(userInformation)
                .getLoginErrorMessage();
        Assert.assertEquals(LOGIN_ERROR_MESSAGE, errorMessage);
    }
}

