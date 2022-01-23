import org.testng.annotations.Test;

public class MyFirstSeleniumTest extends BaseTest{

    @Test
    public void shouldOpenUrl(){
        driver.get("https://www.wp.pl/");

    }
}
