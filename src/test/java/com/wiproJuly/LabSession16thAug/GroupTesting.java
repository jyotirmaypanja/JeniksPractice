package com.wiproJuly.LabSession16thAug;

import org.testng.annotations.Test;

public class GroupTesting {
	@Test(groups = { "Sanity" })
    public void createUser() {
        System.out.println("createUser executed - Sanity");
    }

    @Test(groups = { "Regression" })
    public void updateUser() {
        System.out.println("updateUser executed - Regression");
    }

    @Test(groups = { "Sanity", "Regression" })
    public void deleteUser() {
        System.out.println("deleteUser executed - Sanity & Regression");
    }

    @Test(groups = { "Smoke" })
    public void viewUser() {
        System.out.println("viewUser executed - Smoke");
    }

}
