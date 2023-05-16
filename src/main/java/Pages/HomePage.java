package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement pageContainer = $("#root");

    public final ElementsCollection items = pageContainer.$$(".inventory_item");

    public SelenideElement getItemByName(String name) {
        return items.findBy(Condition.text(name));
    }
}
