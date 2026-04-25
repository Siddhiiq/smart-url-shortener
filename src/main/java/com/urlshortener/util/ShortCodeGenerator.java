package com.urlshortener.util;

import java.util.UUID;

public class ShortCodeGenerator {

    public static String generateShortCode() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}