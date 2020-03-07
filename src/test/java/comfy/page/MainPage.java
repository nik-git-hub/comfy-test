package comfy.page;

import comfy.page.elem.SearchFieldElem;

public class MainPage {
    private SearchFieldElem searchField;
    private SearchResultPage resultPage;

    public MainPage() {
        searchField = new SearchFieldElem();
    }

    public SearchResultPage search(String text) {
        return searchField.search(text);
    }

    public SearchResultPage searchFooterElement(int index) {
        return new SearchResultPage().searchFooterElement(index);
    }

}
