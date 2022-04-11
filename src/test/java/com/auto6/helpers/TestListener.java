package com.auto6.helpers;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {
    private Logger log = Logger.getLogger(this.getClass());
    private String format ="Test %s: %s with parameters %s";

    @Override
    public void onTestStart(ITestResult result) {
        log.info(getLogText("Started", result));
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(getLogText("Passed", result));
    }
    @Override
    public void onTestFailure(ITestResult result) {
        log.info(getLogText("Failed", result));
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        log.info(getLogText("Skipped", result));
    }

    private String getLogText(String status, ITestResult result){
        return String.format(format, status, result.getName(), Arrays.toString(result.getParameters()));
    }
}
