package comfy.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.Wait;

public class SearchResultPage {

    public String getResultItems() {
        return $(By.className("brand__title")).text();
    }

    public void open() {
        Wait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("brand__title")));
    }
}
