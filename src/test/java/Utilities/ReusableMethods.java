package Utilities;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;

public class ReusableMethods {

    //-----------------ACTIONS----------------//

    public static void actionClick(SelenideElement element) {
        element.click();
    }

    public static void moveToElement(SelenideElement element) {
        element.scrollTo().click();
    }

    //------------------HARD WAIT------------------//

    public static void waitFor(int sec) {
        Selenide.sleep(sec * 1000);
    }

    //--------------Explicit Waits--------------//

    public static SelenideElement waitForVisibility(SelenideElement element, int timeout) {
        return element.shouldBe(visible, Duration.ofSeconds(timeout));
    }

    public static void waitToBeClickable(SelenideElement element, int timeout) {
        element.scrollTo().click();
    }

    public static void waitToBeClickableBy(SelenideElement element, int timeout) {
        element.scrollTo().click();
    }

    //-----------------SendKeys----------------//

    public static void sendData(SelenideElement element, String key) {
        element.sendKeys(key, Keys.ENTER);
    }

    //--------------------SWITCH TO WINDOW----------------//

    public static void switchToNewWindow(SelenideElement element) {
        String mainWindow = Selenide.title();
        element.click();
        Selenide.switchTo().window(mainWindow);
    }

    //--------------SCREENSHOT---------------//

    public static String getScreenshot(String name) throws IOException {
        String date = formatCurrentDate("yyyy_MM_dd&hh_mm_ss");
        File source = Screenshots.takeScreenShotAsFile();
        String target = ".\\test-output\\screenshot" + name + date + ".png";
        File targetFile = new File(target);
        FileUtils.copyFile(source, targetFile);
        return target;
    }

    public static String formatCurrentDate(String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(LocalDateTime.now());
    }
}
