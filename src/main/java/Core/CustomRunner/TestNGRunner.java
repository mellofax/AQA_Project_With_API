package Core.CustomRunner;

import Core.ConfigModels.Config;
import Core.CustomRunner.Listeners.CustomTestNGListener;
import Core.CustomRunner.Listeners.RunnerListener;
import Core.DriverConfigurator;
import Core.DBInterface;
import Core.Enums.System.ConfigTypes;
import org.testng.TestNG;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.util.HashMap;
import java.util.List;

public class TestNGRunner {
    private final TestNG testNg;
    private final HashMap<String, String> envVars;

    public TestNGRunner(HashMap<String, String> envVars) {
        this.envVars = envVars;
        Config launchConfig = loadConfig();
        testNg = new TestNG();
        var suite = System.getProperty("suite", "debug");
        testNg.setTestSuites(List.of(System.getProperty("user.dir").concat("/Suites/").concat(suite).concat(".xml")));
        testNg.addListener(new RunnerListener());
        testNg.addListener(new CustomTestNGListener());
        testNg.setOutputDirectory("target/test-results");
        testNg.setVerbose(3);
        DriverConfigurator.configureSelenide(launchConfig.getDriverDetails());
        DBInterface.configureDBInterface(launchConfig.getDatabaseDetails());
    }

    private Config loadConfig() {
        String path = "";
        if(ConfigTypes.valueOf(envVars.get("config")).equals(ConfigTypes.API))
            path = "/api_config.yaml";
        else if (ConfigTypes.valueOf(envVars.get("config")).equals(ConfigTypes.UI))
            path = "/ui_config.yaml";
        Yaml yaml = new Yaml(new Constructor(Config.class));
        var inputStream = getClass().getResourceAsStream(path);
        return yaml.load(inputStream);
    }

    public void run() {
        this.testNg.run();
    }
}
