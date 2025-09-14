package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    public void onTestStart(ITestResult result) {
        logger.info("Test is started - {}", result.getMethod().getMethodName());
        logger.info("Description: {}", result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test is successful - {}", result.getName());
    }

    public void onTestFailure(ITestResult result) {
        logger.error("Test is failed - {}", result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        logger.info("Test is skipped - {}", result.getName());
    }

    public void onStart(ITestContext context) {
        logger.info("Test Suite Started !!!");
    }

    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed !!!");
    }
}
