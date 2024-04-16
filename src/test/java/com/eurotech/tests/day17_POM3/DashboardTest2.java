package com.eurotech.tests.day17_POM3;

import com.eurotech.Pages.DashboardPage;
import com.eurotech.Pages.LoginPage;
import com.eurotech.Pages.PostPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest2 extends TestBase {


    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    PostPage postPage = new PostPage();

    @Test
    public void verifyList() {

        /*
        Go to http://www.eurotech.study/
        Login with teacher credentials
        Verify log in successfully
        verify following menu
                      Edit Profile
                      Add Experience
                      Add Education
         */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        String actualText = dashboardPage.welcomeMessage.getText();
        String expectedText = "Welcome Teacher";
        Assert.assertEquals(actualText,expectedText,"Verify that login in successfully");


        List<String> expectedList = new ArrayList<>();
        expectedList.add("Edit Profile");
        expectedList.add("Add Experience");
        expectedList.add("Add Education");

        List<String> actualList = new ArrayList<>();

//        for (WebElement list  : dashboardPage.dashboardList) {
//            actualList.add(list.getText());
//            System.out.println("list.getText() = " + list.getText());
//
//        }
//        System.out.println("expectedList = " + expectedList);
//        System.out.println("actualList = " + actualList);
//        Assert.assertEquals(actualList,expectedList);
//
//
//        ///2 way
//        List<WebElement> dashboardList = dashboardPage.dashboardList;
//        for (WebElement element : dashboardList) {
//            actualList.add(element.getText());
//        }

        //3 way
        Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.dashboardList),expectedList);

    }

    @Test
    public void logout() {

        /**
         Go to http://www.eurotech.study/
         Login with teacher credentials
         Navigate to My Account and navigate to My Posts and verify that submit button is true and visible then
         Navigate to Log Out and verify that log out successfully
         */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        String expectedText= "Welcome Teacher";
        String actualText = dashboardPage.welcomeMessage.getText();
        Assert.assertTrue(actualText.contains(expectedText));

        //1 way navigate to My Account
      //  dashboardPage.navigateMenu("My Account");

        //2 way navigate to My Account
        BrowserUtils.hover(dashboardPage.myAccount);

        dashboardPage.navigateSubMenu("My Posts");

        //1 way for verification
        BrowserUtils.verifyElementDisplayed(postPage.submitBtn);


        // 2 way for verification
        BrowserUtils.waitForVisibility(postPage.submitBtn,10);
        Assert.assertTrue(postPage.submitBtn.isDisplayed());


        //1 way
        String expectedTextSubmitBtn = "Submit";
        String actualTextSubmitBtn= postPage.submitBtn.getAttribute("value");

        Assert.assertEquals(actualTextSubmitBtn,expectedTextSubmitBtn);


        //2 way for text
        Assert.assertEquals(postPage.submitBtn.getAttribute("value"),"Submit");

        BrowserUtils.hover(dashboardPage.myAccount);
        dashboardPage.navigateSubMenu("Logout");


        Assert.assertTrue(driver.getCurrentUrl().contains("login"));


    }

    @Test
    public void postComment() {
        /*
         Go to http://www.eurotech.study/
         Login with teacher credentials
         Navigate to My Account and navigate to My Posts
         Fill the title and post area
         Click submit button
         Verify that post saved successfully
         */


        //10 min
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        BrowserUtils.hover(dashboardPage.myAccount);
        dashboardPage.navigateSubMenu("My Posts");

//        postPage.titleInput.sendKeys("Page Object Model");
//        postPage.postInput.sendKeys("POM is best applicable for the applications which contain multiple pages. Each of which has fields which can be uniquely referenced with respect to the page. ");
//
//        postPage.submitBtn.click();
        postPage.postComment();
        Assert.assertEquals(postPage.postCreatedMessage.getText(),"Post Created");



    }
}
