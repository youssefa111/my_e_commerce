package com.youssefhussien.my_e_commerce.core.utils;


import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertJsonFileToJsonObject {

   static public JSONObject read(String filePath) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return new JSONObject(content);
    }

     public JSONObject reads(String filePath) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return new JSONObject(content);
    }
}
