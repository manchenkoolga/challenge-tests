package util.helpers;

import entities.AdminUser;
import entities.Credentials;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import util.config.ReadConfig;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Helper {

    public static int getRandomIntInRange(int range) {
        return RandomUtils.nextInt(0, range);
    }

    public static String generateRandomChallengeTitle(int length) {
        return "Challenge Title " + RandomStringUtils.randomNumeric(length);
    }

    public static String generateRandomChallengeHashTag(int length) {
        return "#" + RandomStringUtils.randomAlphabetic(length);
    }

    public static String generateRandomChallengeDescription(int length) {
        return "To win this challenge you must jump " + RandomStringUtils.randomNumeric(length) + " times";
    }



    public static String generateRandomNumericWithLength(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static String getOnlyNumbersFromString(String text) {
        return text.replaceAll("[^0-9]", "");
    }

    public static String getImagesPath(String image) {
        return new File(ReadConfig.getConfigProperty("images_path") + image).getAbsolutePath();
    }

    public static DateTimeFormatter setDatePattern(String pattern) {
        return DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
    }

    public static AdminUser getUserCredentials(String user) {
        Credentials credentials = Credentials.getCredentials()
                .stream()
                .filter(cred -> cred.getUser().equals(user))
                .findFirst()
                .orElseThrow(null);
        return new AdminUser(credentials.getEmail(), credentials.getPassword());
    }
}
