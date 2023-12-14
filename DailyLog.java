package WorkoutappTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DailyLog {
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

        // Enter valid email and password
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("client@email.com");


        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
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

        WebElement dailyLogButton = driver.findElement(By.xpath("//a[text()='Daily Log']"));
        dailyLogButton.click();

        act_url = driver.getCurrentUrl();
        desired_url = site + "/dailylog";

        if (act_url.equals(desired_url)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

        //Fill out daily log without giving all fields
        WebElement logButton = driver.findElement(By.xpath("//button[@type='submit']"));
        logButton.click();

        //Try placing text in fields
        // Enter invalid email
        WebElement water = driver.findElement(By.name("water"));
        water.sendKeys("e");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement calorie = driver.findElement(By.name("calorie"));
        calorie.sendKeys("e");

        WebElement mood = driver.findElement(By.name("mood"));
        mood.sendKeys(Keys.ARROW_RIGHT);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Clear water
        water = driver.findElement(By.name("water"));
        water.clear();

        logButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Add int for water
        water = driver.findElement(By.name("water"));
        water.sendKeys(String.valueOf(20));

        logButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Clear calorie
        calorie = driver.findElement(By.name("calorie"));
        calorie.clear();

        logButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Add int for calorie
        calorie = driver.findElement(By.name("calorie"));
        calorie.sendKeys(String.valueOf(1500));

        logButton.click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("pass");

        driver.quit();
    }
}
