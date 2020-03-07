package comfy.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.Wait;

public class SearchResultPage {
    private List<String> resultList;

    public SearchResultPage() {
    }

    public SearchResultPage(List<String> list) {
        this.resultList = list;
    }

    public String getResultItems() {
        return $(By.className("brand__title")).text();
    }

    public void open() {
        Wait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("brand__title")));
    }

    public SearchResultPage searchFooterElement(int index) {
        List<String> searchList = $(By.className("footer-navigation")).
                $("div:nth-child(" + index + ")").findAll(By.className("list__item")).texts();
        return new SearchResultPage(searchList);
    }

    public List<String> getResultList() {
        return resultList;
    }
}
