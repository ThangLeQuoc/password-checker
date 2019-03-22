package com.thanglequoc.passwordreader.main;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;

public class PasswordReader {
    
    private List<String> blackListPasswords;
    
    private String filePath;
    
    public PasswordReader(String filePath) throws IOException {
        // "src/main/resources/Common_Password_List.txt"
        
        File commonPasswordFile = new File(filePath);
        blackListPasswords = FileUtils.readLines(commonPasswordFile, Charsets.UTF_8);
    }
    
    private boolean isPasswordInBlackList(String password) {
        return blackListPasswords.contains(password);
    }
    
    public void attemptToFindPassword(String password) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        boolean found = isPasswordInBlackList(password);
        stopWatch.stop();
        System.out.println("=====================");
        System.out.println("Check result for "+ password);
        System.out.println("Found: "+found);
        System.out.println("Elapsed Time (ms): "+stopWatch.getTime(TimeUnit.MILLISECONDS));
    }
    
    
    
}
