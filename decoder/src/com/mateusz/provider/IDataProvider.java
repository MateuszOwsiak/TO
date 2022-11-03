package com.mateusz.provider;

import java.io.*;
import java.util.List;

public interface IDataProvider {
    public List<String> getData() throws IOException;
    public static String getDataFromFile(boolean automatic,String index) throws IOException {
        if(automatic){
            InputStream input = IDataProvider.class.getResourceAsStream("/automatic.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String found;
            while((found = br.readLine())!=null){
                if(found.contains(index)){
                    return found;
                }
            }
        }
        else{
            InputStream input = IDataProvider.class.getResourceAsStream("/non_automatic.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String found;
            while((found = br.readLine())!=null){
                if(found.contains(index)){
                    return found;
                }
            }
        }
        return null;
    }
}
