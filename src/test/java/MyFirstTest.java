import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyFirstTest {
    @BeforeMethod
    public void before(){
        System.out.println("Run before each test");
    }

    @Test
    public void firstTest() {
        System.out.println("to jest moj pierwszy test");
    }

    @Test
    public void additionTest() {
        Assert.assertEquals(add(2, 3), 5);
    }

    @Test
    public void multiplicationTest() {
        Assert.assertEquals(multiply(2, 3), 10);
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}
