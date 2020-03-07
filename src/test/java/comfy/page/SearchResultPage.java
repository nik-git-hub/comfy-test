package comfy.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.Wait;

public class SearchResultPage {
    private List<String> resultList;
    private int amountElements;

    public SearchResultPage() {
    }

    public SearchResultPage(List<String> list) {
        this.resultList = list;
    }

    public SearchResultPage(int amount) {
        this.amountElements = amount;
    }

    public String getResultItems() {
        return $(By.className("brand__title")).text();
    }

    public void open() {
        Wait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("brand__title")));
    }

    public List<String> getResultList() {
        return resultList;
    }

    public int getAmountElements() {
        return amountElements;
    }
}
