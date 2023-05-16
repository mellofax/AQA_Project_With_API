package Core.CustomRunner.Listeners;

import Core.Enums.System.TestState;
import Utils.LoggingUtils;
import Utils.ScreenshotUtils;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

public class RunnerListener implements IHookable {
    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);

        if (WebDriverRunner.hasWebDriverStarted()) {
            // Run failure investigation
            if (testResult.getThrowable() != null) {
                try {
                    LoggingUtils.log("CURRENT URL: " + WebDriverRunner.getWebDriver().getCurrentUrl());
                    ScreenshotUtils.makeScreenshot(TestState.FAILED, "WebPage state");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                WebDriverRunner.closeWebDriver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
