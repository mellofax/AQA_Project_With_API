package Core.CustomRunner.Listeners;

import com.epam.reportportal.testng.BaseTestNGListener;
import com.epam.reportportal.testng.ITestNGService;
import com.epam.reportportal.utils.MemoizingSupplier;

import java.util.function.Supplier;

/**
 * Custom implementation of com.epam.reportportal.testng.ReportPortalTestNGListener
 *
 * In order to use custom implementation instead of default class, you
 * need to add this listener to testNG instance in Core.CustomRunner.TestNGRunner
 * and disable (if it's present) default implementation
 */

public class CustomTestNGListener extends BaseTestNGListener {

    public static final Supplier<ITestNGService> SERVICE = new MemoizingSupplier<>(CustomTestNGService::new);

    public CustomTestNGListener() {
        super(SERVICE.get());
    }
}
