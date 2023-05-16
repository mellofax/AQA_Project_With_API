package Steps;

import Pages.LoginPage;
import com.codeborne.selenide.Configuration;

import static Utils.LoggingUtils.log;
import static com.codeborne.selenide.Selenide.*;

public class LoginPageSteps {
    private final LoginPage loginPage;
    public LoginPageSteps() {
        this.loginPage = new LoginPage();
    }

    public static LoginPageSteps openApp() {
        var url = Configuration.baseUrl;
        return openUrl(url);
    }

    private static LoginPageSteps openUrl(String url) {
        log(String.format("Open %s", url));
        open(url);
        return new LoginPageSteps();
    }

    public LoginPageSteps enterUsername(String username) {
        log(String.format("Set username %s", username));
        loginPage.loginField.setValue(username);
        return this;
    }

    public LoginPageSteps enterPassword(String password) {
        log(String.format("Set password %s", password));
        loginPage.passwordField.setValue(password);
        return this;
    }

    public HomePageSteps clickLoginBtn() {
        log("Click on login button");
        loginPage.loginBtn.click();
        return new HomePageSteps();
    }
}
