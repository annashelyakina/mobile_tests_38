package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${launch}.properties",
        "classpath:android.properties"
})

public interface WebDriverConfig extends Config {

    @Key("user")
    String getUser();

    @Key("key")
    String getKey();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOsVersion();

    @Key("app")
    String getApp();

    @Key("remote")
    String getRemoteURL();
}
