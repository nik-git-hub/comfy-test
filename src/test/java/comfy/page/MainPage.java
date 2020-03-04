package comfy.page;

import com.codeborne.selenide.SelenideElement;
import comfy.page.elem.SearchFieldElem;

public class MainPage {
    private SearchFieldElem searchField;

    public MainPage() {
        searchField = new SearchFieldElem();
    }

    public SearchResultPage search(String text) {
        return searchField.search(text);
    }
}
