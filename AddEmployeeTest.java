package com.hrms.testcases;

import com.hrms.pages.AddEmployeePage;
import com.hrms.pages.DashboardPage;
import com.hrms.pages.LoginPage;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddEmployeeTest extends CommonMethods {
    @Test
    public void addEmployee() {
        //login to hrms
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigsReader.getPropertyValue
                ("username"),ConfigsReader.getPropertyValue("password"));
        //navigate to add employee page
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.PIMButton.click();
        dashboardPage.addEmployeeBtn.click();
//        jsClick(dashboardPage.PIMButton);
//        jsClick(dashboardPage.addEmployeeBtn);
        System.out.println(driver.getCurrentUrl());
        // add employee
        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
        sendText(addEmployeePage.firstNameTextBox,"Daria");
        sendText(addEmployeePage.lastNameTextbox,"Denchuk");
        String attributeValue = addEmployeePage.empIDTextbox.getAttribute("value");
        click(addEmployeePage.saveButton);
        //validation
        driver.findElement(By.xpath("//a[text()='Employee List']")).click();
        driver.findElement(By.xpath("//input[@id=\"empsearch_id\"]")).sendKeys(attributeValue);
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
        String actualAttribute =driver.findElement
        //'"+newUser+"'
                (By.xpath("//a[text()= '"+attributeValue+"']")).getAttribute("value");
        System.out.println("attribute value is " + attributeValue + " actual attribute value " + actualAttribute);
        //a[text()='18874']
        //a[text()='Employee List']
        //asertion



    }
}
