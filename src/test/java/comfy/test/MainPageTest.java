package comfy.test;

import com.codeborne.selenide.SelenideElement;
import comfy.page.MainPage;
import comfy.page.SearchResultPage;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

        LOG.info("start: search of link: [{}]", searchElement);
        SearchResultPage resultPage = mainPage.searchFooterElement(1);
        Assertions.assertTrue(resultPage.getResultList().contains(searchElement));
        LOG.info("end: search of link: [{}]", searchElement);
    }

    @Test
    void shouldBeFooterOfServices() {
        String searchElement = "IT-сервис";

        LOG.info("start: search of link: [{}]", searchElement);
        SearchResultPage resultPage = mainPage.searchFooterElement(2);
        Assertions.assertTrue(resultPage.getResultList().contains(searchElement));
        LOG.info("end: search of link: [{}]", searchElement);
    }

    @Test
    void shouldBeFooterHelpForCustomers() {
        String searchElement = "Обмен и возврат товара";

        LOG.info("start: search of link: [{}]", searchElement);
        SearchResultPage resultPage = mainPage.searchFooterElement(3);
        Assertions.assertTrue(resultPage.getResultList().contains(searchElement));
        LOG.info("end: search of link: [{}]", searchElement);
    }

    @Test
    void shouldBeLogoBrands() {
        LOG.info("start: checking: is LogoBrands ");
        SearchResultPage resultPage = mainPage.searchLogoBrands();
        Assertions.assertEquals(6, resultPage.getAmountElements());
        LOG.info("end: checking LogoBrands");
    }

    @Test
    void shouldBeHeaderLinks() {
        LOG.info("start: checking: is header links");
        SearchResultPage resultPage = mainPage.searchHeaderLinks();
        Assertions.assertEquals(7, resultPage.getAmountElements());
        LOG.info("end: checking header links");
    }

    @Test
    void shouldBeHeaderShops() {
        String searchElement = "Магазины";

        LOG.info("start: search of link: [{}]", searchElement);
        SearchResultPage resultPage = mainPage.searchHeaderElements();
        Assertions.assertTrue(resultPage.getResultList().contains(searchElement));
        LOG.info("end: search of link: [{}]", searchElement);
    }

    @Test
    void shouldBeHeaderFindOrder() {
        String searchElement = "Найти заказ";

        LOG.info("start: search of link: [{}]", searchElement);
        SearchResultPage resultPage = mainPage.searchHeaderElements();
        Assertions.assertTrue(resultPage.getResultList().contains(searchElement));
        LOG.info("end: search of link: [{}]", searchElement);
    }
}
