package comfy.test;

import com.codeborne.selenide.SelenideElement;
import comfy.page.MainPage;
import comfy.page.SearchResultPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class MainPageTest {

    private static final Logger LOG = LoggerFactory.getLogger(MainPageTest.class);
    private static String url;
    private static MainPage mainPage;

    @BeforeAll
    static void setUp() {
        url = "https://comfy.ua";
        mainPage = new MainPage();
    }

    @BeforeEach
    void openPage() {
        open(url);
    }

    @AfterEach
    void clearCookies() {
        clearBrowserCookies();
    }

    @Test
    void shouldReturnItem() {
        String searchItem = "xiaomi";

        LOG.info("start: search Item: [{}]", searchItem);
        SearchResultPage resultPage = mainPage.search(searchItem);
        resultPage.open();
        Assertions.assertTrue(resultPage.getResultItems().toUpperCase().contains(searchItem.toUpperCase()));
        LOG.info("end: search Item: [{}]", searchItem);
    }

    @Test
    void shouldBeUrlisCorrect() {
        LOG.info("start: checking: url is correct");
        Assertions.assertTrue(url().contains(url));
        LOG.info("end: checking url");
    }

    @Test
    void shouldBeVisibleGoodsList() {
        LOG.info("start: checking: goods list is displayed");
        SelenideElement container = $("#menuContainer");
        Assertions.assertTrue(container.isDisplayed());
        LOG.info("end: checking: goods list is displayed");
    }

    @Test
    void shouldBeFooterOfContacts() {

        String searchElement = "Контакты";
        SearchResultPage resultPage = mainPage.searchFooterElement(1);

        LOG.info("start: search of link: [{}]", searchElement);
        Assertions.assertTrue(resultPage.getResultList().contains(searchElement));
        LOG.info("end: search of link: [{}]", searchElement);
    }

    @Test
    void shouldBeFooterOfServices() {

        String searchElement = "IT-сервис";
        SearchResultPage resultPage = mainPage.searchFooterElement(2);

        LOG.info("start: search of link: [{}]", searchElement);
        Assertions.assertTrue(resultPage.getResultList().contains(searchElement));
        LOG.info("end: search of link: [{}]", searchElement);
    }

    @Test
    void shouldBeFooterHelpForCustomers() {

        String searchElement = "Обмен и возврат товара";
        SearchResultPage resultPage = mainPage.searchFooterElement(3);

        LOG.info("start: search of link: [{}]", searchElement);
        Assertions.assertTrue(resultPage.getResultList().contains(searchElement));
        LOG.info("end: search of link: [{}]", searchElement);
    }

    @Test
    void shouldBeLogoBrands() {
        LOG.info("start: checking: is LogoBrands ");
        List<SelenideElement> logo = $(By.className("logobrands-inner")).findAll(By.className("link-img"));
        Assertions.assertEquals(6, logo.size());
        LOG.info("end: checking LogoBrands");
    }

    @Test
    void shouldBeHeaderLinks() {
        LOG.info("start: checking: is header links");
        List<SelenideElement> headerLinks = $("#headerLinks")
                .findAll(By.className("header-links__link"));
        Assertions.assertEquals(7, headerLinks.size());
        LOG.info("end: checking header links");
    }

    @Test
    void shouldBeHeaderShops() {
        String searchElement = "Магазины";

        LOG.info("start: search of link: [{}]", searchElement);
        List<SelenideElement> headerLinks = $("#headerLinks").$$(By.tagName("span"));
        List<String> links = headerLinks.stream().map(link -> link.getAttribute("data-lbl"))
                .collect(Collectors.toList());
        Assertions.assertTrue(links.contains(searchElement));
        LOG.info("end: search of link: [{}]", searchElement);
    }

    @Test
    void shouldBeHeaderFindOrder() {
        String searchElement = "Найти заказ";

        LOG.info("start: search of link: [{}]", searchElement);
        List<SelenideElement> headerLinks = $("#headerLinks").$$(By.tagName("span"));
        List<String> links = headerLinks.stream().map(link -> link.getAttribute("data-lbl"))
                .collect(Collectors.toList());
        Assertions.assertTrue(links.contains(searchElement));
        LOG.info("end: search of link: [{}]", searchElement);
    }
}

