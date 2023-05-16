package Tests;

import Core.APIClient.BookingAPI.BookingAPI;
import Datapoviders.HomePageDataproviders;
import Utils.LoggingUtils;
import groovy.transform.ToString;
import org.testng.annotations.Test;

import java.util.HashMap;

import static Steps.LoginPageSteps.openApp;

public class Tests {
    @Test(testName = "Verify items descriptions", groups = "ui",
            dataProviderClass = HomePageDataproviders.class, dataProvider = "Items with descriptions")
    public void description_test(String itemName, String itemDescription) {
        var data = new HashMap<>();
        data.put("username", "standard_user");
        data.put("password", "secret_sauce");
        openApp()
                .enterUsername(data.get("username").toString())
                .enterPassword(data.get("password").toString())
                .clickLoginBtn()
                .verifyItemDescriptionByItemName(itemName, itemDescription);
    }

    @Test(testName = "Gets Bookings", groups = "api")
    public void test_get_bookings() {
        BookingAPI api = new BookingAPI();
        LoggingUtils.log("Bookings count: " + String.valueOf(api.getBookings().length));
    }
}
