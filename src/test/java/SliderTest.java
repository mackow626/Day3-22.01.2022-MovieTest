import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderTest extends BaseTest {

    @Test
    public void shouldSetSlider() {
        //given
        driver.get("https://seleniumui.moderntester.pl/slider.php");
        getSlider().click();

        //when
        setSlider(50);
        //then
        Assert.assertEquals(getSliderValue(),50);
        //when
        setSlider(30);
        //then
        Assert.assertEquals(getSliderValue(),30);
        //when
        setSlider(30);
        //then
        Assert.assertEquals(getSliderValue(),30);
        //when
        setSlider(60);
        //then
        Assert.assertEquals(getSliderValue(),60);
        //when
        setSlider(20);
        //then
        Assert.assertEquals(Integer.parseInt(getText()),20);
    }

    private void setSlider(int endpoint) {
        int sliderStatus = getSliderValue();
        if (sliderStatus < endpoint) {
            moveSlider(endpoint, Keys.ARROW_RIGHT);
        } else if (sliderStatus > endpoint) {
            moveSlider(endpoint, Keys.ARROW_LEFT);
        }
    }

    private int getSliderValue() {
        return Integer.parseInt(getSlider().getText());
    }

    private String getText() {
        return getSlider().getText();
    }

    private WebElement getSlider() {
        return driver.findElement(By.id("custom-handle"));
    }

    private void moveSlider(int endpoint, Keys arrowRight) {
        while (endpoint != getSliderValue()) {
            getSlider().sendKeys(arrowRight);
        }
    }
}
