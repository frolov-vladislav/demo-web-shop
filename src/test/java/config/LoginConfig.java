package config;

import org.aeonbits.owner.Config;
@Config.Sources({"classpath:shop.properties"})

public interface LoginConfig extends Config {
    String userEmail();
    String userPassword();
    String webUrl();
    String apiUrl();
}
