package com.htec.configuration;

import lombok.Getter;
import lombok.Setter;
import org.jeasy.props.annotations.Property;

import static org.jeasy.props.PropertiesInjectorBuilder.aNewPropertiesInjector;

@Getter
@Setter
public class Configuration {

    private static final String CONFIGURATION_FILE_PATH = "config/configuration.properties";

    public Configuration() {
        aNewPropertiesInjector().injectProperties(this);
    }

    @Property(source = CONFIGURATION_FILE_PATH, key = "implicitWaitTime")
    private String implicitWaitTime;
    @Property(source = CONFIGURATION_FILE_PATH, key = "sandbox.url")
    private String sandboxUrl;
    @Property(source = CONFIGURATION_FILE_PATH, key = "sandbox.username")
    private String sandboxUsername;
    @Property(source = CONFIGURATION_FILE_PATH, key = "sandbox.password")
    private String sandboxPassword;

}
