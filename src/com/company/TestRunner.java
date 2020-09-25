package com.company;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        Result result= JUnitCore.runClasses(PetClinicTest.class);
        System.out.println(result.wasSuccessful());
        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }
    }
}
