package org.testrunner;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.mavendemo.Sample;
import org.mavendemo.TestCases;

public class RunnerClass {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(Sample.class, TestCases.class);

		boolean wasSuccessful = result.wasSuccessful();

		if (wasSuccessful) {
			System.out.println("Test Succesfull : " + wasSuccessful);
		} else {
			List<Failure> failuresList = result.getFailures();
			for (Failure a : failuresList) {
				String message = a.getMessage();
				System.out.println(message);
			}
		}
	}
}
