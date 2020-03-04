package comfy.page.elem;

import com.codeborne.selenide.SelenideElement;

public class ButtonElem {

    private SelenideElement webElement;

    public ButtonElem(SelenideElement webElement) {
        this.webElement = webElement;
    }

    public void click() {
        webElement.click();
    }
}
