package com.github.bingoohuang.springrestclient.provider;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesBaseUrlProvider implements BaseUrlProvider {
    final Properties properties = new Properties();

    public PropertiesBaseUrlProvider() {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("baseUrls.properties");
            properties.load(is);
        } catch (IOException e) {

        }
    }

    @Override
    public String getBaseUrl(Class<?> apiClass) {
        return properties.getProperty(apiClass.getSimpleName());
    }

}
