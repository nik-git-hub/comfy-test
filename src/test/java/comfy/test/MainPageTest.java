package comfy.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {

    private static final Logger LOG = LoggerFactory.getLogger(MainPageTest.class);

    @BeforeAll
    static void setUp() {
        open("https://comfy.ua");
    }

    @AfterEach
    void clearCookies() {
        clearBrowserCookies();
    }

    @Test
    void shouldReturnItem() {
        String searchItem = "xiaomi";
        LOG.info("starting search of page by request: [{}]", searchItem);

        $("#searchTop").setValue(searchItem).pressEnter();

        Wait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("brand__title")));

        Assertions.assertTrue($(By.className("brand__title")).text().toUpperCase().contains(searchItem.toUpperCase()));
        LOG.info("end search of page by request: [{}]", searchItem);

    }

    @Test
    void shouldSearch() {
        LOG.info("search element");
        String searchString = "samsung";
        $("#searchTop").setValue(searchString).pressEnter();

        Assertions.assertEquals("samsung", searchString);

    }

}
