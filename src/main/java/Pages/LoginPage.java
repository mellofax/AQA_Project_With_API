package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement pageContainer = $("#root");
    public final SelenideElement loginField = pageContainer.$("#user-name");
    public final SelenideElement passwordField = pageContainer.$("#password");
    public final SelenideElement loginBtn = pageContainer.$("#login-button");
}
