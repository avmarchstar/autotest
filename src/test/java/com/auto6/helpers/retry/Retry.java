package com.auto6.helpers.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
    private int counter = 0;

    @Override
    public boolean retry(ITestResult result) {
        int maxCounter = 2;
        if (counter<maxCounter){
            System.out.println("Retry #"+counter+" test: "+result.getName()+" with status: "+StatusEnam.getStatus(result.getStatus()));
            counter++;
            return true;
        }
        return false;
    }
}
