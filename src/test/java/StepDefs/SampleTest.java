package StepDefs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SampleTest {
    static AppiumDriver driver = null;
    static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
    static int count=0;
    public static void main(String[] args) {
        try {
            service.start();

            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("platformVersion", "13.7");
            capabilities.setCapability("location", "NA-US-BOS");
            capabilities.setCapability("resolution", "1242x2688");
            capabilities.setCapability("manufacturer", "Apple");
            capabilities.setCapability("model", "iPhone-XS Max");



            capabilities.setCapability("app", "PUBLIC:Skiply354.ipa");
//            capabilities.setCapability("app", "PUBLIC:Skiply_1.7.0_80343.apk");

            capabilities.setCapability("autoGrantPermissions", true);

            capabilities.setCapability("securityToken", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI3MmNiZjljMS0zZDZlLTRiNmMtOThmOC02MWJhOWZlNDJjZDgifQ.eyJpYXQiOjE2MTgyMTkxODMsImp0aSI6IjMxNzEwNjYzLThjMDMtNDA4Zi1hNjIzLTQ4NTJkYTU2YjM4ZCIsImlzcyI6Imh0dHBzOi8vYXV0aDMucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL3Jha2JhbmstcHVibGljLXBlcmZlY3RvbW9iaWxlLWNvbSIsImF1ZCI6Imh0dHBzOi8vYXV0aDMucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL3Jha2JhbmstcHVibGljLXBlcmZlY3RvbW9iaWxlLWNvbSIsInN1YiI6IjJiYjJkNzRjLTNhZDAtNDM0YS1hN2VhLTkyZjMxZTJjNjlmYyIsInR5cCI6Ik9mZmxpbmUiLCJhenAiOiJvZmZsaW5lLXRva2VuLWdlbmVyYXRvciIsIm5vbmNlIjoiYzhhMTI4ZDMtYWJiOS00ZmJhLTg0YTUtMTBmZmQxMDIyMTZlIiwic2Vzc2lvbl9zdGF0ZSI6ImFiMTI1NzA0LTgyYWUtNDViMS05YTkwLWI4ZDA5OWYwYTc5ZCIsInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIGVtYWlsIHByb2ZpbGUifQ.DkmrGNx5-yAgCkya0n11vPZIQ0qB2fKIFQhTLBaVCqs");


            driver = new AppiumDriver(new URL("https://rakbank-public.perfectomobile.com/nexperience/perfectomobile/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            takeScreenShot();
            driver.findElement(By.xpath("//*[@name=\" Update Now\"]")).click();


//            takeScreenShot();
//            driver.findElement(By.xpath("//*[@text=\"Login\"]")).click();
//
//            takeScreenShot();
//
//            driver.findElement(By.xpath("//*[@content-desc=\"test-login-email-input-id\"]")).sendKeys("testskiply@gmail.com");
//            driver.findElement(By.xpath("//*[@content-desc=\"test-login-password-input-id\"]")).sendKeys("Test1234$");
//
//            takeScreenShot();
//
//            driver.findElement(By.xpath("//*[@content-desc=\"test-login-submit-button-id\"]//*[@text=\"Login\"]")).click();
//            driver.findElement(By.xpath("//*[@text=\"Profile\"]")).click();
//
//            takeScreenShot();

        } catch (Exception e) {
            System.out.println("Test Failed"+e);
        }

        finally {
            driver.quit();
            service.stop();
        }


    }
    public static void takeScreenShot() throws IOException {
        TakesScreenshot takesScreenshot = driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File trg = new File(".\\Screenshots\\Sample"+count+".png");
        FileUtils.copyFile(src,trg);
        count=count+1;
    }


}
