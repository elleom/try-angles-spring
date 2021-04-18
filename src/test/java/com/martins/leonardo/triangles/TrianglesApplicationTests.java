package com.martins.leonardo.triangles;

import com.martins.leonardo.triangles.models.Triangle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrianglesApplicationTests {


    private Triangle triangle = new Triangle(new Point(), new Point(), new Point());

    @Test
    void contextLoads() {
    }

    static WebDriver driver;

    @BeforeAll
    static void beforeMethod() {

        // set path to chromeDriver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chrome_driver.exe");

        // Initialise driver
        driver = new ChromeDriver();

    }

    @Test
    public void navigateToURL() {

        driver.get("localhost:8080");
        // both pass
        assertEquals(driver.getTitle(), "Try-angles");


    }



    @Test
    void isNotTriangle(){
        assertEquals(false, triangle.isTriangle(100D,200D,100D));
        assertFalse(triangle.isTriangle(100D,200D,400D));
        assertTrue(triangle.isTriangle(100D,200D,200D));
    }

    @Test
    void isEquilateral(){
        assertEquals(true, triangle.isEquilateral(100D, 100D, 100D));
        assertEquals(false, triangle.isEquilateral(150D, 100D, 100D));
    }

    @Test
    void isIsosceles(){
        //all equilateral triangles are isosceles
        assertEquals(true, triangle.isIsosceles(100D, 100D, 100D));
        assertEquals(true, triangle.isIsosceles(100D, 100D, 50D));
        assertFalse(triangle.isEquilateral(150D, 100D, 90D));
    }


}
