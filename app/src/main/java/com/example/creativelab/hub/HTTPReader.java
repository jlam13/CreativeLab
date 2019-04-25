package com.example.creativelab.hub;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Networking reference - https://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html
class HTTPReader {
    private static String dataStream = null;

    HTTPReader() {}
    String GetHTTPData(String address) {
        try {
            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null)
                    stringBuilder.append(line);
                dataStream = stringBuilder.toString();
                connection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataStream;
    }
}