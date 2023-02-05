package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {

    public static final String ACCEPT_COOKIE = "//button[@data-testid='cookie-policy-manage-dialog-accept-button'][2]";

    public static final String REGISTRATION_FORM_BUTTON = "//a[@data-testid='open-registration-form-button']";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://facebook.com");

        WebElement acceptCookie = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(ACCEPT_COOKIE)));
        acceptCookie.click();


        WebElement registrationButton = driver.findElement(By.xpath(REGISTRATION_FORM_BUTTON));
        registrationButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        WebElement birthdayDaySelect = driver.findElement(By.name("birthday_day"));
        Select selectDay = new Select(birthdayDaySelect);
        selectDay.selectByValue("13");

        WebElement birthdayMonthSelect = driver.findElement(By.name("birthday_month"));
        Select selectMonth = new Select(birthdayMonthSelect);
        selectMonth.selectByValue("10");

        WebElement birthdayYearSelect = driver.findElement(By.name("birthday_year"));
        Select selectYear = new Select(birthdayYearSelect);
        selectYear.selectByValue("1994");
    }
}
