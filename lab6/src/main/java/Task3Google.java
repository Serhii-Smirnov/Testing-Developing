import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.io.IOException;

public class Task3Google {
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
        driver.get("https://www.google.com/");
        WebElement searchField = driver.findElement(By.cssSelector("body.hp.vasq:nth-child(2) div.ctr-p:nth-child(4) div.jhp.big:nth-child(4) form.tsf.nj:nth-child(5) div.A8SBwf div.RNNXgb:nth-child(2) div.SDkEP div.a4bIc > input.gLFyf.gsfi:nth-child(3)"));
        searchField.clear();
        String wordForSearch = "Puma";
        searchField.sendKeys(wordForSearch);

        driver.findElement(By.name("btnK")).click();

        int pageNumber = 1;
        String keyWord = "кроссовки";

        while (true) {
            try {
                driver.findElement(By.partialLinkText(keyWord));
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("Task3Google_inPage" + pageNumber + ".png"));
                driver.findElement(By.xpath("//a[@id='pnnext']")).click();
                pageNumber++;
            } catch (NoSuchElementException e) {
                System.out.println("The last page");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Page number is " + pageNumber);
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}