package com.example.sonarpractice.codequality;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String dir = System.getProperty("user.dir");
        Path start = Paths.get(dir);
        CodeAnalyzer analyzer = new CodeAnalyzer();
        analyzer.analyze(start);
        System.out.println("Report:\n" + analyzer.report());
    }
}

class CodeAnalyzer {
    private int files=0, lines=0, comments=0, methods=0, longMethods=0;
    private static final Pattern METHOD = Pattern.compile("\\b(public|private|protected)\\s+.*\\s+\\w+\\s*\\(.*\\)\\s*\\{");
    public void analyze(Path root) throws IOException {
        Files.walk(root).filter(p->p.toString().endsWith(".java")).forEach(p->{
            files++;
            try{
                List<String> all = Files.readAllLines(p);
                lines += all.size();
                for(String s: all){
                    String t = s.trim();
                    if(t.startsWith("//") || t.startsWith("/*") || t.startsWith("*")) comments++;
                    if(METHOD.matcher(t).find()) methods++;
                }
                // simple long method detection: count lines between { and } crude
                String content = String.join("\n", all);
                Matcher m = METHOD.matcher(content);
                while(m.find()){
                    int start = m.start();
                    int brace = content.indexOf('{', start);
                    if(brace>0){
                        int end = findMatchingBrace(content, brace);
                        if(end>brace){
                            int methodLines = content.substring(brace, end).split("\n").length;
                            if(methodLines>20) longMethods++;
                        }
                    }
                }
            }catch(Exception e){}
        });
    }
    private static int findMatchingBrace(String s, int open){
        int depth=0;
        for(int i=open;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='{') depth++;
            else if(c=='}'){ depth--; if(depth==0) return i; }
        }
        return -1;
    }
    public String report(){
        return String.format("files=%d, lines=%d, comments=%d, methods=%d, longMethods=%d", files, lines, comments, methods, longMethods);
    }
}
