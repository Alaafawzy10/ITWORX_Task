package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    String URL = "https://swinji.azurewebsites.net/account/login";
    By emailBy = By.id("Email");
    By passwordBy = By.id("inputPassword");
    By loginBy = By.id("btnLogin");
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
public void navigateToLoginPage(){
        driver.navigate().to(URL);
}
    public void loginUser(String email, String password){
        WebElement emailElement = driver.findElement(emailBy);
        emailElement.clear();
        emailElement.sendKeys(email);

        WebElement passwordElement = driver.findElement(passwordBy);
        passwordElement.clear();
        passwordElement.sendKeys(password);

        WebElement loginElement = driver.findElement(loginBy);
        loginElement.click();
    }


}
