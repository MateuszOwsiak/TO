package com.mateusz.provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class DataProvider implements IDataProvider{

    private String url;

    public DataProvider(String url){
        this.url = url;
    }
    @Override
    public List<String> getData() throws IOException {
        URL u = new URL(url);
        URLConnection urlConnection = u.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line;
        List<String> codes = new ArrayList<>();
        while((line=bufferedReader.readLine())!=null){
            codes.add(line);
        }
        bufferedReader.close();
        return codes;
    }
}
