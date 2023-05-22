
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class DebetcardTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {

        System.setProperty("webdriver.edge.driver", "C:\\tmp\\msedgedriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver = new EdgeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void test() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Болдырев Анатолий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79086118185");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        Assertions.assertEquals(expected, actual);

    }
}

