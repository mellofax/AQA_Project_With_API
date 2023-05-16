package Core.APIClient.BookingAPI.Models;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class Booking {
    @SerializedName("firstname")
    public String firstname;

    @SerializedName("firstname")
    public String lastname;

    @SerializedName("totalprice")
    public int totalprice;

    @SerializedName("depositpaid")
    public boolean depositpaid;

    public class Bookingdates {
        @SerializedName("checkin")
        LocalDateTime checkin;
        @SerializedName("checkout")
        LocalDateTime checkout;
    }

    @SerializedName("additionalneeds")
    public String additionalneeds;
}
