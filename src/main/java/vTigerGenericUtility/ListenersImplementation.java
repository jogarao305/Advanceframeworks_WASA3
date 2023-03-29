package vTigerGenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	    String methodName = result.getMethod().getMethodName();
	    System.out.println(methodName+" "+ " Execution Started");
	    
	   test = report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	    String methodName = result.getMethod().getMethodName();
	    test.log(Status.PASS, methodName+"---PASS");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();
		  String methodName = result.getMethod().getMethodName();
		  test.log(Status.SKIP, methodName+"---FAILED");
		  test.log(Status.INFO, result.getThrowable());
		String ScreenshotName = methodName+"---"+jutil.getSystemDateInFormat();
		
		try {
			String path = wutil.takeScreenshot(BaseClass.Sdriver, ScreenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	    String methodName = result.getMethod().getMethodName();
	    test.log(Status.SKIP, methodName+"---SKIPPED");
	    test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		 System.out.println(" Suite Execution Started");
		 
		 ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-" +new JavaUtility().getSystemDateInFormat()+".html");
		 htmlReport.config().setDocumentTitle("vtiger Execution Reports");
		 htmlReport.config().setTheme(Theme.DARK);
		 htmlReport.config().setReportName("VTIGER EXECUTION REPORT");
		 
		 report = new ExtentReports();
		 report.attachReporter(htmlReport);
		 report.setSystemInfo("Base URL", "http://localhost:8888");
		 report.setSystemInfo("Base Browser", "chrome");
		 report.setSystemInfo("Reporter Name", "jogarao");
		 
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		 System.out.println(" Suite Execution Finished");
		 report.flush();
	}
	
	
	

}
