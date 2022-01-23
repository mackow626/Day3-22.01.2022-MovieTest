import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DroppableTest extends BaseTest {

    @BeforeMethod
    public void openPage() {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
    }

    @Test
    public void shouldDrop() {
        //given
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        //when
        actions.dragAndDrop(draggable, droppable).perform();
        //then
        Assert.assertEquals(droppable.getText(), "Dropped!");
    }

    @Test
    public void shouldDrop1() {
        //given
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        //when
        actions
            .clickAndHold(draggable)
            .moveToElement(droppable)
            .release()
            .perform();
        //then
        Assert.assertEquals(droppable.getText(), "Dropped!");
    }

    @Test
    public void shouldDrop2() {
        //given
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        //when
        actions.clickAndHold(draggable)
            .moveByOffset(140,0)
            .release()
            .perform();
        //then
        Assert.assertEquals(droppable.getText(), "Dropped!");
    }
}
