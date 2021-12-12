package com.hrms.testcases;

import com.hrms.pages.DashboardPage;
import com.hrms.pages.LoginPage;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginTest extends CommonMethods {
    public WebElement element;
    @Test
    public void adminLogin() {

        LoginPage login = new LoginPage();
        sendText(login.usernameBox, ConfigsReader.getPropertyValue("username"));
        sendText(login.passwordBox, ConfigsReader.getPropertyValue("password"));
        click(login.loginBtn);
        //validation
        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed(),
                "Wellcome message is not displayed ");
    }
        @DataProvider
        public Object[][] invalidData () {
            Object[][] data = {
                    {"Admin", "123","Invalid credentials"},
                    {"Admin1", "Hum@nhrm123", "Invalid credentials" },
                    {"James", "", "Password cannot be empty"},
                    {"", "Hum@nhrm123", "Username cannot be empty"} };
            return data;
        }
    @Test
    public void timeStamp(){
        Date date = new Date();
        System.err.println("Philadelphiskoe neponyatnoe Vremya " + date.getTime());
        System.out.println("Philadelphiskoe ponyatnoe Vremya " + date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm--ss");
        System.out.println(sdf.format(date));
    }
        @Test(dataProvider = "invalidData",groups = "regression")
        public void invalidLogin(String username,String password, String message){
            LoginPage login = new LoginPage();
            DashboardPage dashboardPage = new DashboardPage();
            sendText(login.usernameBox, username);
            sendText(login.passwordBox, password);
            click(login.loginBtn);
            //validation
//            JavascriptExecutor jse = (JavascriptExecutor)driver;
//            String script = "return   document.getElementByXPath('//span[@itemprop='telephone']').getText();";
//            String telno1 = ((JavascriptExecutor) driver).executeScript(script).toString();
//            if(message.equals("Invalid credentials")){
//                element=login.messageInvalidCredentials;
//            }
//            if(message =="Password cannot be empty"){
//                element=login.messagePassword;
//            }
//            if(message =="Username cannot be empty"){
//                element=login.messageUserName;
//            }
            element=login.displayedMessage;
           String messageFromAttribute= login.displayedMessage.getText();
            System.out.println("MESSAGE FOR YOU VLAD is " + messageFromAttribute);
            System.out.println(element.getText());
            String elementMessage =element.getAttribute("value");
            //Assert.assertEquals(elementMessage, message, "Wrong MESSAGE");//(elementMessage, message ) ;
            Assert.assertEquals(element.getText(),message,
                    "Incorrect message is displayed ");

        }
}