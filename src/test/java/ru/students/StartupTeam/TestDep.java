package ru.students.StartupTeam;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestDep {
    WebDriver driver = new EdgeDriver();

    @BeforeEach
    void setup() {

    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    public void ft() {
        driver.get ("https://ya.ru/");
    }
    @Test
    public void st() {
        driver.get ("https://yandex.ru/pogoda/omsk?utm_campaign=informer&utm_content=main_informer&utm_medium=web&utm_source=home&lat=54.989342&lon=73.368212");
    }
}
