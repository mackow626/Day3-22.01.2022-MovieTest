import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePickerTest extends BaseTest {
    List<String> months =
        List.of("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

    @BeforeMethod
    public void openPage() {
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
    }

    @Test
    public void shouldSetDate() {
        setDate(01,03,2020);
        setDate(01,03,2021);
        setDate(01,03,2023);

        String[] datepickers = driver.findElement(By.id("datepicker")).getAttribute("value").split("/");
        Assert.assertEquals(datepickers[0], "03");
        Assert.assertEquals(datepickers[1], "01");
        Assert.assertEquals(datepickers[2], "2023");
    }

    private void setDate(int day, int month, int year) {
        driver.findElement(By.id("datepicker")).click();
        waitForDatePicker();
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    private void setDay(int day) {
        List<WebElement> days = driver.findElements(By.cssSelector("td:not(.ui-datepicker-other-month)"));
        days.get(day - 1).click();
    }

    private void setMonth(int month) {
        int monthIndex = month - 1;
        if (getIndexOfCurrentMonth() > monthIndex) {
            do {
                clickPrev();
            }
            while (getIndexOfCurrentMonth() != monthIndex);
        } else if (getIndexOfCurrentMonth() < monthIndex) {
            do {
                clickNext();
            }
            while (getIndexOfCurrentMonth() != monthIndex);
        }
    }

    private void setYear(int year) {
        if (getCurrentYear() > year) {
            do {
                clickPrev();
            }
            while (getCurrentYear() != year);
        } else if (getCurrentYear() < year) {
            do {
                clickNext();
            }
            while (getCurrentYear() != year);
        }
    }

    private void clickNext() {
        driver.findElement(By.cssSelector("[data-handler=\"next\"]")).click();
    }

    private void clickPrev() {
        driver.findElement(By.cssSelector("[data-handler=\"prev\"]")).click();
    }

    private void waitForDatePicker() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int getCurrentYear() {
        return Integer.parseInt(driver.findElement(By.className("ui-datepicker-year")).getText());
    }

    private int getIndexOfCurrentMonth() {
        for (String month : months) {
            if (month.equals(getCurrentMonth())) {
                return months.indexOf(month);
            }
        }
        return -1;
    }

    private String getCurrentMonth() {
        return driver.findElement(By.className("ui-datepicker-month")).getText();
    }

}
