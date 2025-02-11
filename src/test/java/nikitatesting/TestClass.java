package nikitatesting;

import org.example.Main;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestClass {

    @Test
    @DisplayName("Тестируем позитивные числа факториала")
    @Order(1)
    public void testFactorial(){
        assertEquals(120, Main.factorial(5));
        assertEquals(720, Main.factorial(6));
    }

    @DisplayName("Тестируем факториал 0")
    @Test
    @Order(2)
    public void testFactorial0Equals1(){
        assertEquals(1, Main.factorial(0));
    }

    @DisplayName("Тестируем факториал 1")
    @Test
    @Order(3)
    public void testFactorial1Equals1(){
        assertEquals(1, Main.factorial(1));
    }
}
