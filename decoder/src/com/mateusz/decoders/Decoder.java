package com.mateusz.decoders;

import com.mateusz.Tables;
import com.mateusz.provider.IDataProvider;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Decoder implements IDecoder{


    public Map<Integer,Boolean> segments = new HashMap<>();
    @Override
    public List<String> split(String code) {
        String buff = "";
        List<String>codes = new ArrayList<>();
        segments.clear();

        for(int i=0; i<code.length(); i++){
           if(code.charAt(i) == ',' || code.charAt(i)==' '){
               if(buff.equals("333"))
                   break;
               codes.add(buff);
               buff="";
           }
           else if(code.charAt(i)=='=') {
                codes.add(buff);
               break;
           }
           else{
               buff+=code.charAt(i);
           }
        }
        codes.add("=");

        segments.put(6,false);segments.put(7,false);segments.put(8,false);segments.put(9,false);

        for(int i=16; i<codes.size(); i++){
            if(codes.get(i).charAt(0)=='6'){
                segments.replace(6,true);
            }
            if(codes.get(i).charAt(0)=='7'){
                segments.replace(7,true);
            }
            if(codes.get(i).charAt(0)=='8'){
                segments.replace(8,true);
            }
            if(codes.get(i).charAt(0)=='9'){
                segments.replace(9,true);
            }
        }
        return codes;
    }



    @Override
    public void decode(String code) throws IOException {

        System.out.println("===============================================================================================");

        List<String>codes = this.split(code);

        Tables table = new Tables();
        String buff ="";
        System.out.println("Data: "+codes.get(1)+"-"+codes.get(2)+"-"+codes.get(3));
        System.out.println("Godzina obserwacji: "+Integer.parseInt(String.valueOf(codes.get(7).charAt(2))+String.valueOf(codes.get(7).charAt(3))));
        System.out.println("Wskaźnik wiatru: "+table.wind_indicator.get(String.valueOf(codes.get(7).charAt(4))));
        buff = String.valueOf(codes.get(8).charAt(0))+String.valueOf(codes.get(8).charAt(1));
        System.out.println("Kraj: "+ table.station.get(buff)+" Nr stacji: "+codes.get(8).charAt(2)+codes.get(8).charAt(3)+codes.get(8).charAt(4));
        buff="";
        buff = String.valueOf(codes.get(9).charAt(3))+String.valueOf(codes.get(9).charAt(4));
        System.out.println("Grupa opadowa: "+table.rain_group.get(String.valueOf(codes.get(9).charAt(0))));
        System.out.println("Typ stacji: "+table.station_type.get(String.valueOf(codes.get(9).charAt(1)))+" Wysokość względna podstawy najniższych chmur: "+table.cloud_height.get(String.valueOf(codes.get(9).charAt(2)))+" Widzialność w kierunku poziomym: "+table.visibility.get(buff));
        buff = "";
        System.out.println("Zachmurzenie ogólne: "+table.global_cloudiness.get(String.valueOf(codes.get(10).charAt(0))) + " Kierunek wiatru rzeczywistego: "+table.wind_direction.get(String.valueOf(codes.get(10).charAt(1))+String.valueOf(codes.get(10).charAt(2))));
        System.out.println("Prędkość wiatru rzeczywistego: "+codes.get(10).charAt(3)+codes.get(10).charAt(4)+" węzłów");
        System.out.println("Temperatura powietrza: "+table.temperature_sign.get(String.valueOf(codes.get(11).charAt(1)))+table.get_temperature(Double.parseDouble(String.valueOf(codes.get(11).charAt(2))+String.valueOf(codes.get(11).charAt(3))+String.valueOf(codes.get(11).charAt(4)))));
        System.out.println("Temperatura punktu rosy: "+table.temperature_sign.get(String.valueOf(codes.get(12).charAt(1)))+table.get_temperature(Double.parseDouble(String.valueOf(codes.get(12).charAt(2))+String.valueOf(codes.get(12).charAt(3))+String.valueOf(codes.get(12).charAt(4)))));

        System.out.println("Ciśnienie atmosferyczne na poziomie stacji: "+table.get_pressure(Double.parseDouble(String.valueOf(codes.get(13).charAt(1))+String.valueOf(codes.get(13).charAt(2))+String.valueOf(codes.get(13).charAt(3))+ String.valueOf(codes.get(13).charAt(4))))+" hPa");
        System.out.println("Ciśnienie atmosferyczne na poziomie morza: "+table.get_pressure(Double.parseDouble(String.valueOf(codes.get(14).charAt(1))+String.valueOf(codes.get(14).charAt(2))+String.valueOf(codes.get(14).charAt(3))+ String.valueOf(codes.get(14).charAt(4))))+" hPa");

        System.out.println("Tendencja ciśnienia atmosferycznego: "+table.atmospheric_pressure.get(String.valueOf(codes.get(15).charAt(1)))+" Zmiany ciśnienia: "+Double.parseDouble(String.valueOf(codes.get(15).charAt(2))+String.valueOf(codes.get(15).charAt(3))+String.valueOf(codes.get(15).charAt(4)))/10+" hPa");

        int index_seven = 16;
        int index_eight = 16;
        int index_nine = 16;

        if(this.segments.get(6)) {
            String rr = String.valueOf(codes.get(16).charAt(1)) + String.valueOf(codes.get(16).charAt(2)) + String.valueOf(codes.get(16).charAt(3));
            if (rr == "///") {
                System.out.println("Suma opadów: opadu nie mierzono");
            } else {
                double rrr = Integer.parseInt(rr);
                if (rrr == 0) {
                    System.out.println("Suma opadów: brak opadu");
                } else if (rrr > 0 && rrr <= 988) {
                    System.out.println("Suma opadów: " + rrr + " mm");
                } else if (rrr == 989) {
                    System.out.println("Suma opadów: " + rrr + "mm lub więcej");
                } else if (rrr == 990) {
                    System.out.println("Suma opadów: ślad opadu");
                } else if (rrr >= 991 && rrr <= 999) {
                    System.out.println("Suma opadów: "+table.fall.get(rrr));
                }
            }
            System.out.println("Czas trwania okresu opadu: "+table.fall_period.get(String.valueOf(codes.get(16).charAt(4))));
            index_seven++;index_eight++;index_nine++;
        }
        if(this.segments.get(7)){
            if(codes.get(9).charAt(1)=='1' || codes.get(9).charAt(1)=='2' || codes.get(9).charAt(1)=='3'){
                System.out.println("Pogoda bieżąca: "+ IDataProvider.getDataFromFile(false,String.valueOf(codes.get(index_seven).charAt(1))+String.valueOf(codes.get(index_seven).charAt(2))));
                System.out.println("Pogoda ubiegła: "+ table.past_weather_n.get(String.valueOf(codes.get(index_seven).charAt(3))));
            }
            else{
                System.out.println("Pogoda bieżąca: "+ IDataProvider.getDataFromFile(true,String.valueOf(codes.get(index_seven).charAt(1))+String.valueOf(codes.get(index_seven).charAt(2))));
                System.out.println("Pogoda ubiegła: "+ table.past_weather_a.get(String.valueOf(codes.get(index_seven).charAt(3))));
            }
            index_nine++;
            index_eight++;
        }
        if(this.segments.get(8)) {
            System.out.println("Wielkość zachmurzenia (okanty): " + codes.get(index_eight).charAt(1));
            System.out.println("Chmury niskie: " + table.low_clouds.get(String.valueOf(codes.get(index_eight).charAt(2))));
            System.out.println("Chmury średnie: " + table.medium_clouds.get(String.valueOf(codes.get(index_eight).charAt(3))));
            System.out.println("Chmury wysokie: " + table.high_clouds.get(String.valueOf(codes.get(index_eight).charAt(4))));
            index_nine++;
        }
        if(this.segments.get(9)){
            System.out.println("Godzina obserwacji: "+codes.get(index_nine).charAt(1)+codes.get(index_nine).charAt(2)+":"+codes.get(index_nine).charAt(3)+codes.get(index_nine).charAt(4));
        }
        System.out.println("===============================================================================================");
    }
}
