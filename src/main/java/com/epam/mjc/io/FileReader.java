package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String word;
            while ((word = bufferedReader.readLine()) != null) {
                String key = word.split(" ")[0];
                String value = word.split(" ")[1];
                switch (key) {
                    case "Name:":
                        profile.setName(value);
                        break;
                    case "Age:":
                        profile.setAge(Integer.parseInt(value));
                        break;
                    case "Email:":
                        profile.setEmail(value);
                        break;
                    case "Phone:":
                        profile.setPhone(Long.parseLong(value));
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return profile;
    }
}
