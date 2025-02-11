package nikitatesting;


import org.example.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

    @Test(description = "Проверяет обычные числа факториала", priority = 1)
    public void testFactorial(){
        Assert.assertEquals(Main.factorial(6), 3);
        Assert.assertEquals(Main.factorial(10), 3_628_880);
    }

    @Test(description = "Проверяет что факториал 0 равен 1", priority = 2)
    public void testFactorial0Equals1(){
        Assert.assertEquals(Main.factorial(0), 1);
    }

    @Test(description = "Проверяет что факториал 0 равен 1", priority = 3)
    public void testFactorial1Equals2(){
        Assert.assertEquals(Main.factorial(1), 1);
    }

}
