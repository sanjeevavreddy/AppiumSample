package StepDefs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {

    static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    private static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
    String SCREENSHOT="Step_";
    static int count = 0;

    public void startAppiumServer()
    {
        service.start();
    }
    public void stopAppiumServer()
    {
        service.stop();
    }

    public void createDriverInstance() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("udid", "MAAIGF0004268TJ");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage", "com.amazon.avod.thirdpartyclient");
        desiredCapabilities.setCapability("appActivity", "com.amazon.avod.client.activity.HomeScreenActivity");

        this.driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities));
        driver().manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
    }

    public void closeDriverInstance()
    {
        driver().quit();

    }

    public AndroidDriver driver() {
        return this.driver.get();
    }

    public void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot)this.driver.get()).getScreenshotAs(OutputType.FILE);
        count++;
        File trg = new File(System.getProperty("user.dir")+"Reports/"+SCREENSHOT+ count +".png");
        FileUtils.copyFile(scrFile,trg);
    }
}
