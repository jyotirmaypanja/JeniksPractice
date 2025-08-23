package com.wiproJuly.LabSession16thAug;

import org.testng.annotations.Test;

public class SmokeTesting {
	@Test(groups = { "Smoke" })
    public void loginTest() {
        System.out.println("Login test executed - belongs to Smoke group");
    }

    @Test(groups = { "Regression" })
    public void paymentTest() {
        System.out.println("Payment test executed - belongs to Regression group");
    }

    @Test(groups = { "Smoke", "Regression" })
    public void logoutTest() {
        System.out.println("Logout test executed - belongs to both Smoke & Regression groups");
    }

}
