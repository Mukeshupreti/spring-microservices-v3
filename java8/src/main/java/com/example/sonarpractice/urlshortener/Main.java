package com.example.sonarpractice.urlshortener;

import java.util.*;
import java.security.MessageDigest;

public class Main {
    public static void main(String[] args) throws Exception {
        URLShortenerService s = new URLShortenerService();
        String short1 = s.shorten("https://openai.com/blog/");
        System.out.println("Short: " + short1);
        System.out.println("Expand: " + s.expand(short1));
    }
}

class URLShortenerService {
    private final Map<String,String> codeToUrl = new HashMap<>();
    private final Map<String,String> urlToCode = new HashMap<>();
    public String shorten(String url){
        if(urlToCode.containsKey(url)) return urlToCode.get(url);
        String code = generate(url);
        codeToUrl.put(code, url);
        urlToCode.put(url, code);
        return "http://short/" + code;
    }
    public String expand(String shortUrl){
        String code = shortUrl.substring(shortUrl.lastIndexOf('/')+1);
        return codeToUrl.get(code);
    }
    private String generate(String url){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest((url + System.nanoTime()).getBytes());
            return Base64.getUrlEncoder().withoutPadding().encodeToString(Arrays.copyOf(hash,6));
        }catch(Exception e){ return Integer.toHexString(url.hashCode()); }
    }
}
