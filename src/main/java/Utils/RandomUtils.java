package Utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

public class RandomUtils {

//    private static final String EMAIL_SUFFIX = "@lpglobal.testinator.com";
    private static final String EMAIL_SUFFIX = "@mailinator.com";
    private static final String AQA_PREFIX = "autoqa";

    public static String generateRandomString(int length, boolean useLetters, boolean useNumbers) {
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public static String generateRandomUrl() {
        return "https://" + generateRandomString(5, true, false) + ".com";
    }

    public static String generateRandomString() {
        return generateRandomString(5, true, false);
    }

    public static String generateRandomPass() {
        return "RSA" + generateRandomString(4, true, false).toLowerCase(Locale.ROOT) +
                generateRandomString(4, false, true) +
                ")@!";
    }

    public static String generateRandomAQAName() {
        return AQA_PREFIX + generateRandomString(6, false, true);
    }

    public static String generateRandomEmail() {
        return AQA_PREFIX + "." + generateRandomString(7, true, false).toLowerCase(Locale.ROOT) + EMAIL_SUFFIX;
    }
}
