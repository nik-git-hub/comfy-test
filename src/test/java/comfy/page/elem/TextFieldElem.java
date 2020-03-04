package comfy.page.elem;

import org.openqa.selenium.WebElement;

public class TextFieldElem {
    private WebElement searchInput;

    public TextFieldElem(WebElement elem) {
        searchInput = elem;
    }

    public void setText(String text) {
        searchInput.sendKeys(text);
    }
}
