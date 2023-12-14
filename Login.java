package WorkoutappTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Login {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/gianna/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        //String site = "https://bitfitapp.azurewebsites.net/";
        String site = "http://localhost:3000";
        driver.get(site);
        driver.manage().window().maximize();

        // Click on the login link
        WebElement login = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='LOGIN']")));
        login.click();

        String act_url = driver.getCurrentUrl();
        String desired_url = site + "/login";

        if (act_url.equals(desired_url)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

        // Click on the login button without entering credentials
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        act_url = driver.getCurrentUrl();

        if (act_url.equals(desired_url)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Enter invalid email
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("client1@email.com");

        loginButton.click();
        act_url = driver.getCurrentUrl();

        if (act_url.equals(desired_url)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Enter invalid password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password2");

        loginButton.click();
        act_url = driver.getCurrentUrl();

        if (act_url.equals(desired_url)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Enter valid email and password
        email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("client@email.com");

        loginButton.click();
        act_url = driver.getCurrentUrl();

        if (act_url.equals(desired_url)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("password");

        loginButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        act_url = driver.getCurrentUrl();
        desired_url = site + "/clienthome";

        if (act_url.equals(desired_url)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }


        driver.quit();
    }
}
