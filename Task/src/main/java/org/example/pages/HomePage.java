package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    String URL = "https://swinji.azurewebsites.net/Org#!/Reporting/";

    By navigationBy = By.id("btnMinifyMe");

    By coursesBy = By.id("btnMyCoursesList");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage(){
        driver.navigate().to(URL);
    }
 public void navigateToCourses(){
     WebElement navigationElement = driver.findElement(navigationBy);
     navigationElement.click();

     WebElement coursesElement = driver.findElement(coursesBy);
     coursesElement.click();
}
}
