package config;

import org.aeonbits.owner.ConfigFactory;

public class Config {
    public static LoginConfig config = ConfigFactory.create(LoginConfig.class, System.getProperties());
}
