import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Integer.parseInt;

public class TableTest extends BaseTest {

    @BeforeMethod
    public void openPage() {
        driver.get("https://seleniumui.moderntester.pl/table.php");
    }

    @Test
    public void shouldDisplayAllMountains() {
        List<WebElement> mountainsOnPage = driver.findElements(By.cssSelector("tbody>tr"));

        for (WebElement mountain : mountainsOnPage) {
            System.out.println(
                mountain.findElements(By.cssSelector("td")).get(0).getText() + " " +
                    mountain.findElements(By.cssSelector("td")).get(3).getText());
        }
    }

    @Test
    public void shouldDisplayNotAllMountains() {
        List<WebElement> mountainsOnPage = driver.findElements(By.cssSelector("tbody>tr"));

        for (WebElement mountain : mountainsOnPage) {
            int hight = parseInt(mountain.findElements(By.cssSelector("td")).get(3).getText());
            if (hight > 4000) {
                System.out.println(
                    "Szczyt: " + mountain.findElements(By.cssSelector("td")).get(0).getText() + " Pasmo górskie:" +
                        mountain.findElements(By.cssSelector("td")).get(1).getText() + " Kraj:" +
                        mountain.findElements(By.cssSelector("td")).get(2).getText() + " Wysokość:" +
                        mountain.findElements(By.cssSelector("td")).get(3).getText());
            }
        }
    }

    @Test
    public void shouldDisplayMountainsAbove4000m() {
        List<String> mountainsAbove4000m = List.of("Mont Blanc", "Dufourspitze", "Dom", "Weisshorn", "Matterhorn",
            "Finsteaarhorn",
            "Jungfrau",
            "Les Ecrins",
            "Gran Paradiso");
        List<WebElement> mountainsOnPage = driver.findElements(By.cssSelector("tbody>tr"));
        List<Mountain> mountains = new ArrayList<>();

        for (WebElement mountainOnPage : mountainsOnPage) {
            Mountain mountain = new Mountain(mountainOnPage);
            mountains.add(mountain);
        }

        for (Mountain mountain : mountains) {
            if (mountain.getHeight() > 4000) {
                Assert.assertTrue(mountainsAbove4000m.contains(mountain.getPeak()));
            }
        }
    }

    @Test
    public void shouldDisplayMountainsFromItaly() {
        List<String> mountainsFromItaly = List.of("Mont Blanc", "Dufourspitze", "Matterhorn","Gran Paradiso","Monviso");
        List<WebElement> mountainsOnPage = driver.findElements(By.cssSelector("tbody>tr"));
        List<Mountain> mountains = new ArrayList<>();

        for (WebElement mountainOnPage : mountainsOnPage) {
            Mountain mountain = new Mountain(mountainOnPage);
            mountains.add(mountain);
        }

        for (Mountain mountain : mountains) {
            if (mountain.getState().contains("Italy")) {
                Assert.assertTrue(mountainsFromItaly.contains(mountain.getPeak()));
            }
        }
    }
}