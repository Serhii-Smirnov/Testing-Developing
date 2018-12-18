import Context.Buy;
import Context.Filter;
import Context.Order;
import PageObject.CheckOutPage;
import PageObject.LastPage;
import PageObject.ProductPage;
import PageObject.SearchPage;
import Data.WrongDataExeption;
import Data.Data;
import Utills.Screenshot;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static junit.framework.TestCase.assertTrue;
import static Utills.Waiters.thredsleep;

public class TestTask {

    private static WebDriver driver;
    public static String roz_page = "https://rozetka.com.ua/search/?text=%D0%B7%D0%BE%D0%BB%D0%BE%D1%82%D1%8B%D0%B5+%D0%BA%D0%BE%D0%BB%D1%8C%D1%86%D0%B0&class=0&redirected=1";

    @BeforeClass
    public static void SetUp() {
        String exePath = "D:\\КПИ им. Сикорского\\Тестирование\\Add\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Test() {

        SearchPage filteringPage = new SearchPage(driver);
        filteringPage.start(roz_page);

        int minPrice = 100;
        int maxPrice = 2000;

        Filter.set_price(filteringPage, minPrice, maxPrice);
        thredsleep(1000);

       ProductPage choosenProduct = Filter.set_country(filteringPage,"Україна");
       thredsleep(1000);
       System.out.println("no error");
       CheckOutPage checkOutProduct = Buy.Subm_buying_product(choosenProduct);

        LastPage delivery = null;
        try {
            delivery = Order.init_cart(checkOutProduct, new Data());
        }
        catch (WrongDataExeption e){
            e.getMessage();
        }
        assert delivery != null;

        try {
            Screenshot.getscreenshot(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        thredsleep(1000);
        assertTrue(delivery.counter());
    }

    @AfterClass
    public static void SetDown(){ driver.quit(); }
}