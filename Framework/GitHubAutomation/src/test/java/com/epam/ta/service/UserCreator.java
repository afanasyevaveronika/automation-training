package com.epam.ta.service;

import com.epam.ta.model.User;

public class UserCreator {

    public static final String TEST_DATA_USER_INCORRECT_USERNAME = "testdata.user.username";
    public static final String TEST_DATA_USER_INCORRECT_PASSWORD = "testdata.user.password";

    public static User withIncorrectUsernameAndPassword(){
        return new User(TestDataReader.getTestData(TEST_DATA_USER_INCORRECT_USERNAME),
                TestDataReader.getTestData(TEST_DATA_USER_INCORRECT_PASSWORD));
    }
}
