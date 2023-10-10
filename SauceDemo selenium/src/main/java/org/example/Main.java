package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class LoginTest {

    public static void main(String[] args) {
        // Set the path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver.exe");

        // Initialize a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the website in Chrome
        driver.get("https://www.saucedemo.com/");

        // Find the username input field and type the username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Find the password input field and type the password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Wait for the burger menu icon to be clickable
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement burgerMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));

        // Click the burger menu icon
        burgerMenu.click();

        // Sleep for 2 seconds (to keep the menu open)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find and click the "x" button on the burger menu to close it
        WebElement closeButton = driver.findElement(By.id("react-burger-cross-btn"));
        closeButton.click();

        // Verify if the Products page is displayed
        if (burgerMenu.isDisplayed()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed.");
        }

        // Close the browser
        driver.quit();
    }
}
