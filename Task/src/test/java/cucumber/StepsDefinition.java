package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StepsDefinition {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CoursesPage coursesPage;
    AddCoursePage addCoursePage;
    CoursePublishPage coursePublishPage;

    @Before
    public void Before(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        coursesPage = new CoursesPage(driver);
        addCoursePage = new AddCoursePage(driver);
        coursePublishPage = new CoursePublishPage(driver);
    }
    @After
    public void After(){
     driver.quit();
    }
    @Given("I login with {string} and {string}")
    public void iLoginWithAnd(String email, String password) {
        loginPage.navigateToLoginPage();
        loginPage.loginUser(email,password);
    }

    @When("Navigate to the courses Page")
    public void navigateToTheCoursesPage() {
        homePage.navigateToCourses();
    }

    @And("Publish new course with basic info {string} , {string} , {string} , {string} , {string}")
    public void publishNewCourseWithBasicInfo(String courseName , String subject, String gradeYearRange , String teacherName , String courseCompletionCriteria) {
         coursesPage.navigateToAddCoursePage();
         addCoursePage.addBasicCourseInfo(courseName,subject,gradeYearRange,teacherName,courseCompletionCriteria);
         coursePublishPage.publishCourse();
    }

    @Then("Validate That the {string} is displayed Successfully on the courses Page")
    public void validateThatTheIsDisplayedSuccessfullyOnTheCoursesPage(String courseName) {
        coursesPage.navigateToCoursesPage();
        Assert.assertEquals(coursesPage.verifyCourseExist(courseName),"exist");
    }

}
