import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Task1Rozetka {
    static WebDriver driver;
    @Before
    public void setUp() {
        String exePath = "D:\\КПИ им. Сикорского\\Тестирование\\Add\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void aTest() {
        driver.get("https://rozetka.com.ua/bicycles/c83884/");
        driver.findElement(By.xpath("//*[@id='price[min]']")).sendKeys("12000");
        driver.findElement(By.xpath("//*[@id='submitprice']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='reset_filterprice']")));
        if (driver.findElement(By.xpath("//*[@id='price[min]']")).getAttribute("value").compareTo("12000") != 0)
        {
            System.out.println("Test failed");
        }
        List<WebElement> prices = driver.findElements(By.xpath("//*[@class='g-price-uah']"));
        for (WebElement element:prices) {
            if (Integer.valueOf(element.getText().replaceAll("[^0-9]", "")) < 10000)
            {
                System.out.println("Test failed");
                break;
            }
        }

    }
    @After
    public void tearDown()  {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("Rozetka.png"));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        driver.quit();
    }
}
