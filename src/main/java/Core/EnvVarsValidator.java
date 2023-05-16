package Core;

import Core.Enums.System.ConfigTypes;
import Core.Exceptions.BasePropException;
import Core.Exceptions.EmptyPropException;
import Core.Exceptions.IncorrectPropException;

import java.util.Arrays;
import java.util.HashMap;

public class EnvVarsValidator {

    public static HashMap<String, String> validateEnvVars() throws BasePropException {
        var envVars = new HashMap<String, String>();
        try {
            var configProp = ConfigTypes.valueOf(System.getProperty("config"));
            envVars.put("config", configProp.name());
        } catch (IllegalArgumentException iae) {
            throw new IncorrectPropException("config", Arrays.toString(ConfigTypes.values()));
        } catch (NullPointerException npe) {
            throw new EmptyPropException("config");
        }

        return envVars;
    }
}
