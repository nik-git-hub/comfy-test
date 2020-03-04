package comfy.page.elem;

import comfy.page.SearchResultPage;

import static com.codeborne.selenide.Selenide.$;


public class SearchFieldElem {

    public SearchFieldElem() {
    }

    public SearchResultPage search(String text) {
        $("#searchTop").setValue(text).pressEnter();
        return new SearchResultPage();
    }
}
