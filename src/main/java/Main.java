import Core.CustomRunner.TestNGRunner;
import Core.EnvVarsValidator;

public class Main {
    public static void main(String[] args) {
        try {
            var envVars = EnvVarsValidator.validateEnvVars();
            new TestNGRunner(envVars).run();
            System.exit(0);
        } catch (Exception ipe) {
            ipe.printStackTrace();
            System.exit(1);
        }
    }
}