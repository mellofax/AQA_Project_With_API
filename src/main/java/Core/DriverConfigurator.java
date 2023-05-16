package Core;

import Core.ConfigModels.DriverDetails;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverConfigurator {

    public static synchronized void configureSelenide(DriverDetails driverConfig) {
        Configuration.timeout = driverConfig.getTimeout();
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.baseUrl = driverConfig.getAppURL();
        Configuration.browserSize = "1700x1100";
        Configuration.savePageSource = false;
        Configuration.screenshots = true;
        if(Configuration.browser.equals("chrome")) {
            Configuration.browserCapabilities = new DesiredCapabilities();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            Configuration.browserCapabilities = options;
        }
        if(Boolean.valueOf(System.getProperty("Selenoid", "false"))){
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("enableVNC", Boolean.valueOf(System.getProperty("VNC", "true")));
            cap.setCapability("enableVideo", Boolean.valueOf(System.getProperty("VideoRecord", "false")));
            Configuration.browserCapabilities = cap;
            //todo select your selenoid url
            Configuration.remote = "#remote_url";
        }
        Configuration.headless = true;
    }
}
