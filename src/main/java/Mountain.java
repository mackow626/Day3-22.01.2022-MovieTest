import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Mountain {
    int height;
    String peak;
    List<String> state;
    String mountainRange;

    public Mountain(WebElement row) {
        List<WebElement> mountainDetails = row.findElements(By.cssSelector("td"));
        this.height = Integer.parseInt(mountainDetails.get(3).getText());
        this.peak = mountainDetails.get(0).getText();
        this.state = Arrays.stream(mountainDetails.get(2).getText().split(", ")).toList();
        this.mountainRange = mountainDetails.get(1).getText();
    }

    public int getHeight() {
        return height;
    }

    public String getPeak() {
        return peak;
    }

    public String getMountainRange() {
        return mountainRange;
    }

    public List<String> getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Mountain{" +
            "height=" + height +
            ", peak='" + peak + '\'' +
            ", state='" + state + '\'' +
            ", mountainRange='" + mountainRange + '\'' +
            '}';
    }
}
