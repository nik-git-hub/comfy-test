package comfy.page.elem;

import com.codeborne.selenide.SelenideElement;
import comfy.page.SearchResultPage;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;


public class SearchFieldElem {

    public SearchFieldElem() {
    }

    public SearchResultPage search(String text) {
        $("#searchTop").setValue(text).pressEnter();
        return new SearchResultPage();
    }

    public SearchResultPage searchFooterElement(int index) {
        List<String> searchList = $(By.className("footer-navigation")).
                $("div:nth-child(" + index + ")").findAll(By.className("list__item")).texts();
        return new SearchResultPage(searchList);
    }

    public SearchResultPage searchLogoBrands() {
        List<SelenideElement> logo = $(By.className("logobrands-inner")).findAll(By.className("link-img"));
        return new SearchResultPage(logo.size());
    }

    public SearchResultPage searchHeaderLinks() {
        List<SelenideElement> headerLinks = $("#headerLinks")
                .findAll(By.className("header-links__link"));
        return new SearchResultPage(headerLinks.size());
    }

    public SearchResultPage searchHeaderElements() {
        List<SelenideElement> headerLinks = $("#headerLinks").$$(By.tagName("span"));
        List<String> links = headerLinks.stream().map(link -> link.getAttribute("data-lbl"))
                .collect(Collectors.toList());
        return new SearchResultPage(links);
    }
}
