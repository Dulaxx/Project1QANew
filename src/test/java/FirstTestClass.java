import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestClass {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void test1(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        System.out.println("Login success");

    }

    @Test
    public void test2(){
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.xpath("//a[@id=\"logout_sidebar_link\"]")).click();
        System.out.println("Log out success");
    }

    @Test
    public void test3(){
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Test
    public void test4(){
        driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
        //why class is not working?
    }

    @AfterTest
    public void result(){
        driver.close();
        driver.quit();
    }


}
