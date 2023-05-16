package Core.APIClient.BookingAPI;

import Core.APIClient.BaseAPIClient;
import Core.APIClient.BookingAPI.Models.Booking;
import Core.APIClient.BookingAPI.Models.Bookings;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.with;

public class BookingAPI extends BaseAPIClient {
    private JsonPath response;
    public JsonPath getResponse() {
        return response;
    }

    public  BookingAPI() {
        super("/booking");
    }

    public Bookings[] getBookings() {
        var res = with()
                .spec(requestSpecification)
                .get()
                .then().extract().response().andReturn().asString();
        return new Gson().fromJson(res, Bookings[].class);
    }

    public Booking getBookingById(int id) {
        var res = with()
                .spec(requestSpecification)
                .and().pathParam("id", id)
                .accept(ContentType.ANY)
                .get(Endpoints.bookingById)
                .then().extract().response().andReturn().asString();
        return new Gson().fromJson(res, Booking.class);
    }
}
