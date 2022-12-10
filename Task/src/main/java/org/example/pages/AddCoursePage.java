package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AddCoursePage {
    WebDriver driver;
    String URL = "https://swinji.azurewebsites.net/Course#!/add";
    By courseNameBy = By.id("txtCourseName");
    By subjectDropDownBy = By.id("courseSubject");
    By gradeYearLabelBy = By.xpath("//label[@for='courseGrade']");
    By courseGradeDropDownBy = By.xpath("//select[@name='courseGrade']");
    By courseTeacherLabelBy = By.xpath("//label[@id='lblGetSelectedSubjectTeachers']");
    By openSearchTeacherBy = By.xpath("//span[text()='Course Teacher']");
    By teacherNameBy;
    By courseCompletionCriteriaBy;

    By saveCourseBy = By.id("btnSaveAsDraftCourse");

    public AddCoursePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAddCoursePage(){
        driver.navigate().to(URL);
    }

    public void selectCompletionCriteria(String type){
        courseCompletionCriteriaBy = By.xpath("//span[normalize-space()='"+type+"']");
        WebElement courseCompletionCriteriaElement = driver.findElement(courseCompletionCriteriaBy);
        courseCompletionCriteriaElement.click();
    }

    public void selectTeacherName(String teacherName){
        teacherNameBy = By.xpath("//h5[text()='"+teacherName+"']");
        WebElement teacherNameElement = driver.findElement(teacherNameBy);
        teacherNameElement.click();
    }
    public void addBasicCourseInfo(String courseName , String subject, String gradeYearRange , String teacherName , String courseCompletionCriteria){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement courseNameElement = driver.findElement(courseNameBy);
        courseNameElement.sendKeys(courseName);

        WebElement subjectDropDownElement = driver.findElement(subjectDropDownBy);
        Select subjectsElement = new Select(subjectDropDownElement);
        subjectsElement.selectByVisibleText(subject);

     /*   if(GradeYearRange.equalsIgnoreCase("Range")){

        }*/

        WebElement gradeYearLabelElement = driver.findElement(gradeYearLabelBy);
        gradeYearLabelElement.click();

        WebElement gradeYearDropDownElement = driver.findElement(courseGradeDropDownBy);
        Select gradeYearElement = new Select(gradeYearDropDownElement);
        gradeYearElement.selectByVisibleText(gradeYearRange);

        WebElement teacherLabelElement = driver.findElement(courseTeacherLabelBy);
        teacherLabelElement.click();

        WebElement teacherSearchElement = driver.findElement(openSearchTeacherBy);
        teacherSearchElement.click();


        selectTeacherName(teacherName);

        selectCompletionCriteria(courseCompletionCriteria);

        WebElement saveCourseElement = driver.findElement(saveCourseBy);
        saveCourseElement.click();
    }
}
