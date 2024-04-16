package com.eurotech.tests.day16_POM2;

import com.eurotech.Pages.DashboardPage;
import com.eurotech.Pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void dashboardMenu() {

             /*
        Task
        Go to http://www.eurotech.study/
        Login with teacher credentials
        Get the text of the dashboard and verify following menu
                      Developers
                      All Posts
                      My Account
         */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();

        String expectedText ="Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in successfully");

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Developers");
        expectedList.add("All Posts");
        expectedList.add("My Account");

        ArrayList<String> actualList1 = new ArrayList<>();
        //1 way

        List<WebElement> dashboardMenu = dashboardPage.menuList;
        for (WebElement menu : dashboardMenu) {
            System.out.println("menu.getText() = " + menu.getText());
        }

        // 2 way
        for (WebElement element : dashboardPage.menuList) {
            System.out.println("element.getText() = " + element.getText());
            actualList1.add(element.getText());
        }

        Assert.assertEquals(actualList1,expectedList);

        // 3 way
        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.menuList);
        Assert.assertEquals(actualList,expectedList);


    }

    @Test
    public void navigateMenu() {


        /*
        Go to http://www.eurotech.study/login
        Login with teacher credentials
        Navigate to All Posts menu and verify url is http://eurotech.study/posts
        Navigate to Developers menu and verify url is http://eurotech.study/profiles

         */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();

        String expectedText ="Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in successfully");


        dashboardPage.allPosts.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/posts");

        dashboardPage.developers.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/profiles");


    }

    @Test
    public void navigate2() {

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();

        String expectedText ="Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in successfully");

        dashboardPage.navigateMenu("All Posts");
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/posts");

        dashboardPage.navigateMenu("Developers");
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/profiles");
    }

    @Test
    public void navigate3() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();

        String expectedText ="Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in successfully");

        BrowserUtils.hover(dashboardPage.myAccount);
        dashboardPage.navigateSubMenu("My Posts");


    }

}
