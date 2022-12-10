package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursePublishPage {

    WebDriver driver;
    By publishCourseBy = By.id("btnPublish");

    By submitPublishCourseBy = By.id("btnDialogOk");

    public CoursePublishPage(WebDriver driver) {
        this.driver = driver;
    }

    public  void publishCourse(){
        WebElement publishCourseElement = driver.findElement(publishCourseBy);
        publishCourseElement.click();

        WebElement submitPublishCourseElement = driver.findElement(submitPublishCourseBy);
        submitPublishCourseElement.click();
    }

}
