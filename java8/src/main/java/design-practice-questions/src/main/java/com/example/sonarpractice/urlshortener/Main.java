package com.example.sonarpractice.urlshortener;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("URL Shortener demo:");
        UrlShortener s = new UrlShortener();
        String shortUrl = s.shorten("https://example.com/very/long/url");
        System.out.println("Short: " + shortUrl);
        System.out.println("Expand: " + s.expand(shortUrl));
    }
}
class UrlShortener {
    private final Map<String,String> map = new HashMap<>();
    private final Map<String,String> rev = new HashMap<>();
    private int counter = 1;
    public String shorten(String url) {
        if (rev.containsKey(url)) return rev.get(url);
        String code = Integer.toHexString(counter++);
        map.put(code, url);
        rev.put(url, code);
        return "http://short/" + code;
    }
    public String expand(String shortUrl) {
        String code = shortUrl.substring(shortUrl.lastIndexOf('/')+1);
        return map.get(code);
    }
}
