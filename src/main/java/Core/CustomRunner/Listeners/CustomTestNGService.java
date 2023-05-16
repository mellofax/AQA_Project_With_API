package Core.CustomRunner.Listeners;

import com.epam.reportportal.testng.TestNGService;
import org.testng.ITestResult;
import org.testng.annotations.Test;

/**
 * Custom implementation of com.epam.reportportal.testng.TestNGService
 * which allows to override the logic of test items creation.
 *
 * You can override any method from TestNGService class with ur
 * custom logic. To do this, just copy method signature of original method
 * paste it here and add @Override annotation
 *
 *
 */

public class CustomTestNGService extends TestNGService {

    @Override
    protected String createStepName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName();
    }
}
