package ru.students.StartupTeam.UI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

abstract public class Abstract {

    public static WebDriver driver;

    public static void setUp(){
        driver = new EdgeDriver();
    }

    public static String readParam(String param){
        return ConfProperties.getProperty(param);
    }

    @BeforeEach
    public void init(){
        setUp();
    }
    @AfterEach
    public void initAfter(){
        driver.close();
    }

}
