package com.wiproJuly.LabSession18thAug;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListners implements ITestListener{
	@Override		
    public void onFinish(ITestContext arg0) {					
 
	 System.out.println("The testcase execution is completed using selenium testng  ");
    }		
 
 
    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
 
    	 System.out.println("The testcase execution is completed with few issues using selenium testng ");
    }		
 
    @Override		
    public void onTestFailure(ITestResult arg0) {	
    	 System.out.println("The testcase execution is failed  using selenium testng");
    }		
 
    @Override		
    public void onTestSkipped(ITestResult arg0) {					
    	 System.out.println("The testcase execution is skipped  using selenium testng");	
    }		
 
    @Override		
    public void onTestStart(ITestResult arg0) {					
    	 System.out.println("The testcase execution is started using selenium testng");
    }		
 
    @Override		
    public void onTestSuccess(ITestResult arg0) {	
    	 System.out.println("The testcase execution is completed successfully using selenium testng");
    }		
 
 
}
	


