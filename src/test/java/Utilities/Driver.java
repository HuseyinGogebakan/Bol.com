package Utilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Driver {


    public static void setup() {
        String browser = ConfigurationReader.getProperty("browser");

        // Set browser-specific configuration
        switch (browser) {
            case "chrome":
                Configuration.browser = "chrome";
                break;
            case "firefox":
                Configuration.browser = "firefox";
                break;
            case "safari":
                Configuration.browser = "safari";
                break;
            case "edge":
                Configuration.browser = "edge";
                break;
            case "ie":
                Configuration.browser = "ie";
                break;
        }

        openURL(ConfigurationReader.getProperty("url"));
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    public static void openURL(String url) {
        open(url);
    }

    public static void teardown() {
        closeWebDriver();
    }
}


