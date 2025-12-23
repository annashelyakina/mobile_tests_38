package drivers;

import com.codeborne.selenide.WebDriverProvider;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @NotNull
    @Override
    public WebDriver createDriver(@NotNull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "anna_ds6Jvj");
        caps.setCapability("browserstack.key", "BvFsNCs2kcYFxy1fkBb3");

        // Set URL of the application under test
        caps.setCapability("app", "bs://sample.app");

        // Specify device and os_version for testing
        caps.setCapability("device", "Samsung Galaxy S23");
        caps.setCapability("os_version", "13.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
