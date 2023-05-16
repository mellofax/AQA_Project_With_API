package Steps;

import Pages.HomePage;
import org.testng.Assert;

import static Utils.LoggingUtils.log;

public class HomePageSteps <T>{
    private final HomePage homePage;
    public HomePageSteps() {
        this.homePage = new HomePage();
    }

    public HomePageSteps verifyItemDescriptionByItemName(String itemName, String itemDescription) {
        log(String.format("Verify that item with name %s has description %s", itemName, itemDescription));
        Assert.assertEquals(homePage.getItemByName(itemName).$(".inventory_item_desc").getText(), itemDescription);
        return this;
    }
}
