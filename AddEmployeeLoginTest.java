package com.hrms.testcases;

import com.hrms.pages.AddEmployeePage;
import com.hrms.pages.DashboardPage;
import com.hrms.pages.LoginPage;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelReading;
import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
//import java.util.NoSuchElementException;

public class AddEmployeeLoginTest extends CommonMethods {



    @Test(groups = "smoke")
    public void addEmployeeLoginTest() throws InterruptedException {
// softAssert.assertEquals("hello","hello");

 Assert.assertEquals("hello","hello","Hello to all");

        try {

            int i=1;
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
//
        loginPage.login(ConfigsReader.getPropertyValue("username"),
                ConfigsReader.getPropertyValue("password"));


        // ExcelReading excelReading = new ExcelReading();
//        ExcelReading.openExcel(Constants.EXCELPATH);
//
//        ExcelReading.getSheet("EmployeesData");

//        int rowIndex =ExcelReading.getRowCount();
//        int cellCount =ExcelReading.getColsCount(rowIndex);
//        String cellData=ExcelReading.getCellData(rowIndex,cellCount);
        List<Map<String, String>> newEmployees =
                ExcelReading.excelIntoListMap(Constants.EXCELPATH,"EmployeesData");

        Iterator<Map<String, String>> iterator = newEmployees.iterator();

        while (iterator.hasNext()) {
            click(dashboardPage.menuPIM);
            click(dashboardPage.addEmployeeBtn);
            Map<String, String> mapNewEmployees = iterator.next();
            // value.get("FirstName");
            //Map<String,String> key= newEmployees.get(value).keySet();
//           System.out.println(" Employee First Name is " + value.get("FirstName"));
//           System.out.println("Employee Last Name is " + value.get("LastName"));
            //System.out.println(iterator.toString());
            sendText(addEmployeePage.firstNameTextBox,  mapNewEmployees.get("FirstName"));
            System.out.println("value of the text box is " + addEmployeePage.firstNameTextBox.getAttribute("value"));
            sendText(addEmployeePage.midleNameTextBox, mapNewEmployees.get("MiddleName"));
            sendText(addEmployeePage.lastNameTextbox, mapNewEmployees.get("LastName"));
            sendText(addEmployeePage.chooseFileBtn, mapNewEmployees.get("Picture"));
            if (!addEmployeePage.createLoginCheckbox.isSelected()) {
                addEmployeePage.createLoginCheckbox.click();
            }
            String empID = addEmployeePage.empIDTextbox.getAttribute("value");
            String assignedID = addEmployeePage.empIDTextbox.getAttribute("value");
            sendText(addEmployeePage.userName, mapNewEmployees.get("UserName"));
            sendText(addEmployeePage.password, mapNewEmployees.get("Password"));
            sendText(addEmployeePage.confirmPassword, mapNewEmployees.get("Password"));
            Thread.sleep(1000);
            Select drpDown = new Select(addEmployeePage.statusDropDown);
            //drpDown.selectByValue("Disabled");
            //Thread.sleep(900000000);
            jsClick(addEmployeePage.statusDropDown);
            //jsClick(dashboardPage.addEmployeeBtn);


                if (i% 2 == 0) {
//                    jsClick(drpDown.selectByValue("Enabled"));
//                    drpDown.selectByValue("Enabled");
                    //click(addEmployeePage.optEnabledDD);
                   // addEmployeePage.statusDropDown.click();
                    drpDown.selectByVisibleText("Enabled");
                    System.out.println("ELEMENT is selected  Enabled");
                    i++;
                } else {
                    //drpDown.selectByValue("Disabled");
                    // click(addEmployeePage.optEnabledDD);
                   // addEmployeePage.statusDropDown.click();
                    drpDown.selectByVisibleText("Disabled");
                    System.out.println("ELEMENT is selected  DISABLED");
                    i++;
                }

                click(addEmployeePage.saveEmployeeBtn);

                System.out.println("Record saved ");
                String savedID = driver.findElement
                        //'"+newUser+"'
                                (By.xpath("//input[@id='personal_txtEmployeeId']")).getAttribute("value");
                // (By.xpath("//a[text()= '"+attributeValue+"']")).getAttribute("value");
                System.out.println("assigned id  is " + assignedID + " saved id is " + savedID);
                System.out.println("id selected by text is " + empID);
                String newID = assignedID.concat("A");
                String newID2 = assignedID + "A";

                System.out.println(newID);
                // Assert.(newID2,savedID,"Your assertion failed ");

        }
//    @DataProvider
//    public Object[][] addEmployeeLogin(){
//         Object[][] data=new List<Map<String,String>>;
//        data = ExcelReading.excelIntoListMap(  );
//        return data;;
//    }

        }catch (NoSuchElementException e){
            e.printStackTrace();

        }
    }}

