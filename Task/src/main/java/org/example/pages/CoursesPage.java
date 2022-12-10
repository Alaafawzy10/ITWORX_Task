package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class CoursesPage {
    WebDriver driver;
    String URL = "https://swinji.azurewebsites.net/Course#!/list/";
    By addCourseBy = By.xpath("//button[@id='btnListAddCourse']");

    By displayedCoursesBy = By.xpath("//a[@id='lnkListCourseSelcted']");

    By sortedDropDownBy = By.id("CoursesOrderBy");

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCoursesPage(){
        driver.navigate().to(URL);
    }

    public void navigateToAddCoursePage(){

        WebElement addCourseElement = driver.findElement(addCourseBy);
        addCourseElement.click();
    }

    public List <WebElement> getAllCourses(){
        sortedCourses("Creation Date Descending");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        List <WebElement> allCourses = driver.findElements(displayedCoursesBy);
        return allCourses;
    }
    public void sortedCourses(String sortType){
        WebElement sortCoursesDropDownElement = driver.findElement(sortedDropDownBy);
        Select SelectSortCoursesDropDownElement = new Select(sortCoursesDropDownElement);
        SelectSortCoursesDropDownElement.selectByVisibleText(sortType);
    }
    public String verifyCourseExist(String courseTitle){
        for (WebElement element:getAllCourses()){
            if (element.getAttribute("title").equalsIgnoreCase(courseTitle)) return "exist";

        }
        return "not exist";
    }
}
