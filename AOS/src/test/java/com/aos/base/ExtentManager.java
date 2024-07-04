package com.aos.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aos.utils.DateUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	private static ExtentSparkReporter sparkReporter;

	// Method to initialize ExtentReports
	public static ExtentReports getInstance() {
		if (extent == null) {
			sparkReporter = new ExtentSparkReporter("target/extent-reports_"
					+ new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()) + ".html");
			sparkReporter.config().setDocumentTitle("Automation Report");
			sparkReporter.config().setReportName("Test Report");

			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
		}
		return extent;
	}

	// Method to create a new test in the report
	public static ExtentTest createTest(String name, String description) {
		return getInstance().createTest(name, description);
	}

	// Method to flush the reports
	public static void flush() {
		if (extent != null) {
			extent.flush();
		}
	}
}