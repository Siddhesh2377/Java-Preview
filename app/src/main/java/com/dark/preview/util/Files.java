package com.dark.preview.util;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Files {

    public static String readAss(AssetManager assetManager, String path) {
        try {
            InputStream inputStream = assetManager.open(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            String text = stringBuilder.toString();
            reader.close();
            inputStream.close();
            return text;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

}
