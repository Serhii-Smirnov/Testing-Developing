import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Task2Google {
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
        //more test logic  - test might pass or fail at this point

        int pageNumber = 1;
        String keyWord = "кроссовки";

        while (true) {
            try {
                driver.findElement(By.partialLinkText(keyWord));
                break;
            } catch (NoSuchElementException e) {
                try {
                    driver.findElement(By.xpath("//a[@id='pnnext']")).click();
                    pageNumber++;
                }
                catch (NoSuchElementException e1){
                    System.out.println("The last page");
                    break;
                }
            }
        }

        System.out.println("Page number is " + pageNumber);


    }

    @After
    public void tearDown() {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("Task2Google.png"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        driver.quit();
    }
}