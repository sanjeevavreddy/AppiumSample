import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Settings {

    static AppiumDriver driver;

    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        Settings();
    }

    public static void Settings() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability("udid", "5348324453423498");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.settings");
        capabilities.setCapability("appActivity", "com.android.settings.homepage.SettingsHomepageActivity");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 0);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        TouchAction action = new TouchAction(driver);

        driver.findElement(By.id("android:id/title"));
        swipeUntilFound("//*[@text='Developer options']",5);

    }
    public static void swipeUntilFound(String xpath,int count)
    {
        int TempCount=0;
        TouchAction action = new TouchAction(driver);
        boolean flag = true;
        while (flag && TempCount<=count) {
            try {
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                driver.findElement(By.xpath(xpath));
                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
                flag = false;
            } catch (Exception e) {
                System.out.println("Element not found - Swiping");
                action.press(PointOption.point(driver.manage().window().getSize().width / 2, driver.manage().window().getSize().height / 2))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                        .moveTo(PointOption.point(driver.manage().window().getSize().width / 2, 0))
                        .release()
                        .perform();
                TempCount++;
            }
        }
    }
}
