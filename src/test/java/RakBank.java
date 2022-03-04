import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
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

public class RakBank {

    static AppiumDriver driver;

    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        openRakbank();
    }

    public static void openRakbank() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability("udid", "5348324453423498");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.rak");
        capabilities.setCapability("appActivity", "com.rak.SplashActivity");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 0);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        TouchAction action = new TouchAction(driver);
//        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Proceed to Login button']")).click();
//        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='User ID field']")).sendKeys("HAYAMS");
//        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Password field']")).sendKeys("rakbank123");
//        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Login button']")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Menu Icon title']")).click();


        driver.findElementByAccessibilityId("Proceed to Login button").click();
        driver.findElementByAccessibilityId("User ID field").sendKeys("HAYAMS");
        driver.findElementByAccessibilityId("Password field").sendKeys("rakbank123");
        driver.findElementByAccessibilityId("Login button").click();
        WebElement MenuIcon = driver.findElementByAccessibilityId("Menu Icon title");
        Thread.sleep(1000);
        MenuIcon.click();
        driver.findElementByAccessibilityId("Menu Icon title").click();
        driver.findElementByAccessibilityId("DiscoverApply menu").click();
        driver.findElementByAccessibilityId("Accounts option").click();
        driver.findElementByAccessibilityId("Gold Account option").click();
        driver.findElementByAccessibilityId("Apply Now button").click();
        driver.findElementByAccessibilityId("Gold Account opening title");
        driver.findElementByAccessibilityId("Circle").click();
        driver.findElementByAccessibilityId("Circle Selected");
        System.out.println(driver.findElement(By.xpath("//*[@content-desc='Confirm Information title']//following::android.widget.ScrollView")).getSize().height);
        System.out.println(driver.findElement(By.xpath("//*[@content-desc='Confirm Information title']//following::android.widget.ScrollView")).getSize().width);


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
