package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.*;

import java.time.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        String uname = "standard_user";
        String password = "secret_sauce";
        login(driver, uname, password);
    }

    public static void login(ChromeDriver driver, String uname, String password) throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys(uname);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();
//        String next = "//*[@class='']"
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"about_sidebar_link\"]"))).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        WebElement sort = driver.findElement((By.className("product_sort_container")));
        Select selectSort = new Select(sort);
        selectSort.selectByValue("lohi");
        Thread.sleep(1000);
        driver.findElement(By.id("item_2_title_link")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("remove-sauce-labs-onesie")).click();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("back-to-products")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("shopping_cart_container")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("first-name")).sendKeys("Afi");
        driver.findElement(By.id("last-name")).sendKeys("NaN");
        driver.findElement(By.id("postal-code")).sendKeys("11111");
        Thread.sleep(1000);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("finish")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("back-to-products")).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(1000);
        driver.close();
    }
}