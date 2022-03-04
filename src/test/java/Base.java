import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Base {
protected AndroidDriver driver;
protected WebDriverWait wait;

//before Test Annotation makes a java function to run every time before a TestNG test case
@BeforeTest
protected void createAppiumDriver() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid","5348324453423498");
        capabilities.setCapability("platfromName","Android");
        capabilities.setCapability("appPackage","com.rak");
        capabilities.setCapability("appActivity","com.rak.SplashActivity");

//relative path to apk file
//final File classpathRoot = new File(System.getProperty("user.dir"));
//final File appDir = new File(classpathRoot, "src/test/resources/apps/");
//final File app = new File(appDir, "******.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

        }

//After Test Annotation makes a java function to run every time after a TestNG test case
@AfterTest
public void afterTest(){

        //quit the driver
        driver.quit();
        }

        }