import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public static AppiumDriver driver;

    CreateTaskPage createTaskPage;
    TaskListPage taskListPage;

    public static void Android_setUp() throws MalformedURLException {
        DesiredCapabilities caps =new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("deviceName","HUAWEI P40 Lite");
        caps.setCapability("appPackage","com.jeffprod.todo");
        caps.setCapability("appActivity","com.jeffprod.todo.ActivityMain");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
    }


    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}