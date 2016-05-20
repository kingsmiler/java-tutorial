package com.xman.jwf.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ClassPathResource {

    public static InputStream getAsStream(String name) throws IOException {

        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
        if (stream == null) {
            throw new FileNotFoundException("Can not find out resource with name=" + name);
        }

        return stream;
    }

    public static URL getAsURL(String name) {
        if(name.startsWith("classpath:")) {
            name = name.substring(10);
        }

        URL url = Thread.currentThread().getContextClassLoader().getResource(name);
        if (url == null) {
            throw new RuntimeException("Can not find out resource with name=" + name);
        }

        return url;
    }

    public static String getFilePath(String name) {
        URL url = getAsURL(name);

        return url.getFile().substring(1);
    }
}
