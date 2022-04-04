package com.auto4.helpers;

import org.testng.annotations.DataProvider;

public class DP {

    @DataProvider(name = "p_credentials")
    private static Object [][] m_credentials(){
        return new Object[][] {
                {"","","Epic sadface: Username is required"},
                {"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out."},
                {"standard_user","","Epic sadface: Password is required"},
                {"incorrect","incorrect","Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
