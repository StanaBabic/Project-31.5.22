import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class Main {
    /*Domaći:
    Napisati dva smoke testa za https://www.telerik.com/support/demos:
    Proveriti da klikom na Desktop odlazimo na tu sekciju
    Proveriti da klikom na Mobile odlazimo na tu sekciju
    Koristiti TestNG, asserte.
    Domaći na git.*/

    private WebDriver driver;
    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\GIT project\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.telerik.com/support/demos");
    }

    @Test
    public void TestDesktopNavigationTag(){
        WebElement desktopNavigationTag=driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]"));
        desktopNavigationTag.click();
        Assert.assertTrue(driver.findElement(By.id("desktop")).getText().contains("Desktop"));
    }
@Test
    public void TestMobileNavigationTag(){
        WebElement mobileNavigationTag= driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]"));
        mobileNavigationTag.click();
        Assert.assertTrue(driver.findElement(By.id("mobile")).getText().contains("Mobile"));
}
    @AfterClass

    public void AfterClass() {
        driver.close();
    }
}

