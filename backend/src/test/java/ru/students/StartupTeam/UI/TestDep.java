package ru.students.StartupTeam.UI;
import org.junit.jupiter.api.Test;

public class TestDep extends Abstract{

    @Test
    public void ft() {
        driver.get (readParam("homePage"));
    }
    @Test
    public void st() {
        driver.get (readParam("weatherPage"));
    }
}
