package com.mateusz.view;

import com.mateusz.decoders.Decoder;
import com.mateusz.decoders.IDecoder;
import com.mateusz.provider.DataProvider;
import com.mateusz.provider.IDataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class View implements IView{
    private IDecoder decoder;
    private IDataProvider dataProvider;
    private List<String> codes;
    private Scanner in;
    @Override
    public void view() throws IOException {
        decoder = new Decoder();
        dataProvider = new DataProvider("https://www.ogimet.com/cgi-bin/getsynop?begin=202207270600&end=202207271200&state=Pol");
        codes = new ArrayList<>();
        in = new Scanner(System.in);

        codes = dataProvider.getData();

        String data;
        System.out.print("Podaj date w formacie RRRR-MM-DD: ");
        data = in.nextLine();

        for(String c:codes){
            if(getDate(c).equals(data)){
                decoder.decode(c);
            }
        }
    }
    @Override
    public String getDate(String code){
        List<String>s = new ArrayList<>();
        s = List.of(code.split(","));
        String date = s.get(1)+"-"+s.get(2)+"-"+s.get(3);
        return date;
    }
}
