package com.thanglequoc.passwordreader.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.thanglequoc.passwordreader.main.PasswordReader;

public class PasswordReaderTest {
    
    private PasswordReader passwordReader;
    
    @Before
    public void setUp() {
        String filePath = "src/main/resources/Common_Password_List.txt";
        try {
            passwordReader = new PasswordReader(filePath);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
    
    @Test
    public void testFindPassword_ExistCase() {
        List<String> passwordsUnderTest = Arrays.asList("fuckyouthoang","trangloveduy","chienneymar123","hoangtubuon","hoangthuylinh","coquenmotnguoi07","hainhinhanh");
        for (String pswd: passwordsUnderTest) {
            passwordReader.attemptToFindPassword(pswd);
            
        }
    }
    
    @Test
    public void testFindPassword_NonExistCase() {
        List<String> passwordsUnderTest = Arrays.asList("notexist","rangloveduy123","chienneyakwejfmar123","hoan@#@#gtubuon","hoa__jfweifewngthuylinh","coquen@#K@Jmotnguoi07","haiaksdjfksanhinhanh");
        for (String pswd: passwordsUnderTest) {
            passwordReader.attemptToFindPassword(pswd);
            
        }
    }
    
    
    
    
}
