package com.mateusz;

import java.util.HashMap;
import java.util.Map;

public class Tables {

    public  Map<String,String>station = new HashMap<>();
    public  Map<String,String>rain_group= new HashMap<>();
    public  Map<String,String>station_type= new HashMap<>();
    public Map<String,String>wind_indicator = new HashMap<>();
    public  Map<String,String>cloud_height= new HashMap<>();
    public  Map<String,String>visibility= new HashMap<>();
    public  Map<String,String>global_cloudiness= new HashMap<>();
    public  Map<String,String>wind_direction= new HashMap<>();
    public  Map<String,String>temperature_sign= new HashMap<>();
    public  Map<String,String>atmospheric_pressure= new HashMap<>();
    public Map<Integer,String>fall = new HashMap<>();
    public  Map<String,String>fall_period= new HashMap<>();
    public Map<String,String>past_weather_n = new HashMap<>();
    public Map<String,String>past_weather_a = new HashMap<>();
    public Map<String,String>low_clouds = new HashMap<>();
    public Map<String,String>medium_clouds = new HashMap<>();
    public Map<String,String>high_clouds = new HashMap<>();
    public Tables(){
        station.put("12","Polska");

        wind_indicator.put("0","prędkość wiatru oszacowano w m/s");
        wind_indicator.put("1","prędkość wiatru zmierzono anemometrem w m/s");
        wind_indicator.put("3","prędkość wiatru oszacowano w węzłach");
        wind_indicator.put("4","prędkość wiatru zmierzono anemometrem w węzłach");

        rain_group.put("0","Grupa opadowa w sekcji 1 i 3");
        rain_group.put("1","Grupa opadowa w sekcji 1");
        rain_group.put("2","Grupa opadowa tylko w sekcji 3");
        rain_group.put("3","Grupa opadowa pominięta (opady nie wystąpiły)");
        rain_group.put("4","Grupa opadowa pominięta (nie wykonano pomiarów opadu)");

        station_type.put("1","stacja nieautomatyczna,");
        station_type.put("2","stacja nieautomatyczna");
        station_type.put("3","stacja nieautomatyczna");
        station_type.put("4","stacja automatyczna");
        station_type.put("5","stacja automatyczna");
        station_type.put("6","stacja automatyczna");
        station_type.put("7","stacja automatyczna");

        cloud_height.put("0","od 0 do 50 m");
        cloud_height.put("1","od 50 do 100 m");
        cloud_height.put("2","od 100 do 200 m");
        cloud_height.put("3","od 200 do 300 m");
        cloud_height.put("4","od 300 do 600 m");
        cloud_height.put("5","od 600 do 1000 m");
        cloud_height.put("6","od 1000 do 1500 m");
        cloud_height.put("7","od 1500 do 2000 m");
        cloud_height.put("8","od 2000 do 2500 m");
        cloud_height.put("9","powyżej 2500 m lub brak chmur");
        cloud_height.put("/","wysokość podstawy chmur nieznana");

        visibility.put("00","<0,1 km");visibility.put("11","1,1 km");visibility.put("22","2,2 km");visibility.put("33","3,3 km");visibility.put("44","4,4 km");
        visibility.put("01","0,1 km");visibility.put("12","1,2 km");visibility.put("23","2,3 km");visibility.put("34","3,4 km");visibility.put("45","4,5 km");
        visibility.put("02","0,2 km");visibility.put("13","1,3 km");visibility.put("24","2,4 km");visibility.put("35","3,5 km");visibility.put("46","4,6 km");
        visibility.put("03","0,3 km");visibility.put("14","1,4 km");visibility.put("25","2,5 km");visibility.put("36","3,6 km");visibility.put("47","4,7 km");
        visibility.put("04","0,4 km");visibility.put("15","1,5 km");visibility.put("26","2,6 km");visibility.put("37","3,7 km");visibility.put("48","4,8 km");
        visibility.put("05","0,5 km");visibility.put("16","1,6 km");visibility.put("27","2,7 km");visibility.put("38","3,8 km");visibility.put("49","4,9 km");
        visibility.put("06","0,6 km");visibility.put("17","1,7 km");visibility.put("28","2,8 km");visibility.put("39","3,9 km");visibility.put("50","5,0 km");
        visibility.put("07","0,7 km");visibility.put("18","1,8 km");visibility.put("29","2,9 km");visibility.put("40","4,0 km");visibility.put("56","6 km");
        visibility.put("08","0,8 km");visibility.put("19","1,9 km");visibility.put("30","3,0 km");visibility.put("41","4,1 km");visibility.put("57","7 km");
        visibility.put("09","0,9 km");visibility.put("20","2,0 km");visibility.put("31","3,1 km");visibility.put("42","4,2 km");visibility.put("58","8 km");
        visibility.put("10","1,0 km");visibility.put("21","2,1 km");visibility.put("32","3,2 km");visibility.put("43","4,3 km");visibility.put("59","9 km");
        visibility.put("60","10 km");visibility.put("61","11 km");visibility.put("62","12 km");visibility.put("63","13 km");visibility.put("64","14 km");
        visibility.put("65","15 km");visibility.put("66","16 km");visibility.put("67","17 km");visibility.put("68","18 km");visibility.put("69","19 km");
        visibility.put("70","20 km");visibility.put("71","21 km");visibility.put("72","22 km");visibility.put("73","23 km");visibility.put("74","24 km");
        visibility.put("75","25 km");visibility.put("76","26 km");visibility.put("77","27 km");visibility.put("78","28 km");visibility.put("79","29 km");
        visibility.put("80","30 km");visibility.put("81","35 km");visibility.put("82","40 km");visibility.put("83","45 km");visibility.put("84","50 km");
        visibility.put("85","55 km");visibility.put("86","60 km");visibility.put("87","65 km");visibility.put("88","70 km");visibility.put("89",">70 km");
        visibility.put("90","<0,05 km");visibility.put("91","0,005 km");visibility.put("92","0,2 km");visibility.put("93","0,5 km");visibility.put("94","1 km");
        visibility.put("95","2 km");visibility.put("96","4 km");visibility.put("97","10 km");visibility.put("98","20 km");visibility.put("99",">50 km");
        visibility.put("//","brak danych");

        global_cloudiness.put("0","niebo bezchmurne");
        global_cloudiness.put("1","1/8");
        global_cloudiness.put("2","2/8");
        global_cloudiness.put("3","3/8");
        global_cloudiness.put("4","4/8");
        global_cloudiness.put("5","5/8");
        global_cloudiness.put("6","6/8");
        global_cloudiness.put("7","7/8");
        global_cloudiness.put("8","8/8");
        global_cloudiness.put("9","niebo niewidoczne (zasłonięte mgłą lub innymi zjawiskami meteorologicznymi");
        global_cloudiness.put("/","chmury niewidoczne z powodów innych niż mgła czy inne zjawiska meteorologiczne lub nie prowadzi się obserwacji");

        wind_direction.put("00","cisza");wind_direction.put("08","075-084° ENE");wind_direction.put("16","155-164° SSE");wind_direction.put("24","235-244° WSW");wind_direction.put("32","315-324° NW");
        wind_direction.put("01","005-014° N");wind_direction.put("09","085-094° ES");wind_direction.put("17","165-174° SSE");wind_direction.put("25","245-254° WSW");wind_direction.put("33","325-334° NNW");
        wind_direction.put("02","015-024° NNE");wind_direction.put("10","095-104° ES");wind_direction.put("18","175-184° S");wind_direction.put("26","255-264° WSW");wind_direction.put("34","335-344° NNW");
        wind_direction.put("03","025-034° NNE");wind_direction.put("11","105-114° ESE");wind_direction.put("19","185-194° S");wind_direction.put("27","265-274° W");wind_direction.put("35","345-354° N");
        wind_direction.put("04","035-044° NEE");wind_direction.put("12","115-124° ESE");wind_direction.put("20","195-204° SSW");wind_direction.put("28","275-284° W");wind_direction.put("36","355-004° N");
        wind_direction.put("05","045-054° NEE");wind_direction.put("13","125-134° SEE");wind_direction.put("21","205-214° SSW");wind_direction.put("29","285- 294° WNW");wind_direction.put("99","wiatr zmienny");
        wind_direction.put("06","055-064° ENE ");wind_direction.put("14","135-144° SEE");wind_direction.put("22","215-224° SWS");wind_direction.put("30","295-304° WNW");
        wind_direction.put("07","065-074° ENE ");wind_direction.put("15","145-154° SSE ");wind_direction.put("23","225-234° SW");wind_direction.put("31","305-314° NW");

        temperature_sign.put("0","+");temperature_sign.put("1","-");

        atmospheric_pressure.put("0","wzrost, potem spadek; ciśnienie jest wyższe lub takie samo jak przed trzema godzinami");
        atmospheric_pressure.put("1","wzrost potem stan stały; lub wzrost, potem wzrost wolniejszy; ciśnienie jest wyższe niż przed trzema godzinami");
        atmospheric_pressure.put("2","wzrost równomierny lub nierównomierny; ciśnienie jest wyższe niż przed trzema godzinami");
        atmospheric_pressure.put("3","spadek, potem wzrost; lub stan stały, potem wzrost; lub wzrost, potem wzrost słabszy; ciśnienie jest wyższe niż przed trzema godzinami");
        atmospheric_pressure.put("4","stan stały; ciśnienie jest takie samo jak przed trzema godzinami");
        atmospheric_pressure.put("5","spadek, potem wzrost; ciśnienie jest takie samo lub niższe niż przed trzema godzinami");
        atmospheric_pressure.put("6","spadek, potem stan stały; lub spadek, potem spadek wolniejszy; ciśnienie jest niższe niż przed trzema godzinami");
        atmospheric_pressure.put("7","spadek równomierny lub nierównomierny; ciśnienie jest niższe niż przed trzema godzinami");
        atmospheric_pressure.put("8","wzrost, potem spadek; lub stan stały, potem spadek; lub spadek, potem spadek szybszy; ciśnienie jest niższe niż przed trzema godzinami");

        fall.put(991,"0,1 mm");fall.put(992,"0,2 mm");fall.put(993,"0,3 mm");fall.put(994,"0,4 mm");
        fall.put(995,"0,5 mm");fall.put(996,"0,6 mm");fall.put(997,"0,7 mm");fall.put(998,"0,8 mm");
        fall.put(999,"0,9 mm");
        fall_period.put("1","całkowite opady w ciągu 6 godzin poprzedzających obserwację");
        fall_period.put("2","całkowite opady w ciągu 12 godzin poprzedzających obserwację");
        fall_period.put("3","całkowite opady w ciągu 18 godzin poprzedzających obserwację");
        fall_period.put("4","całkowite opady w ciągu 24 godzin poprzedzających obserwację");
        fall_period.put("5","całkowite opady w ciągu 1 godziny poprzedzającej obserwację");
        fall_period.put("6","całkowite opady w ciągu 2 godzin poprzedzających obserwację");
        fall_period.put("7","całkowite opady w ciągu 3 godzin poprzedzających obserwację");
        fall_period.put("8","całkowite opady w ciągu 9 godzin poprzedzających obserwację");
        fall_period.put("9","całkowite opady w ciągu 15 godzin poprzedzających obserwację");

        past_weather_n.put("0","chmury pokrywają połowę lub mniej nieba");
        past_weather_n.put("1","chmury pokrywały ponad połowę nieba przez część okresu i mniej niż połowę przez pozostałą część okresu");
        past_weather_n.put("2","chmury pokrywały ponad połowę nieba");
        past_weather_n.put("3","wichura pyłowa, wichura piaskowa lub zamieć śnieżna");
        past_weather_n.put("4","mgła, mgła lodowa");
        past_weather_n.put("5","mżawka");
        past_weather_n.put("6","deszcz ciągły");
        past_weather_n.put("7","śnieg lub deszcz ze śniegiem");
        past_weather_n.put("8","deszcz przelotny");
        past_weather_n.put("9","burza");
        past_weather_n.put("/","brak danych");

        past_weather_a.put("0","bez istotnych zjawisk atmosferycznych");
        past_weather_a.put("1","ograniczona widzialność");
        past_weather_a.put("2","zamieć lub wichura piaskowa, ograniczona widzialność");
        past_weather_a.put("3","mgła");
        past_weather_a.put("4","opad");
        past_weather_a.put("5","mżawka");
        past_weather_a.put("6","deszcz");
        past_weather_a.put("7","śnieg");
        past_weather_a.put("8","opad przelotny");
        past_weather_a.put("9","burza");
        past_weather_a.put("/","brak danych");

        low_clouds.put("0","brak");low_clouds.put("1"," Cumulus humilis lub Cumulus fractus (ale nie złej pogody) lub obie chmury razem");low_clouds.put("2","Cumulus mediocris lub congestus występujący sam lub z Cu hum lub Cu fra bądź też ze Stratocumulus");
        low_clouds.put("3","Cumulonimbus calvus");low_clouds.put("4","Stratocumulus cumulogenitus");low_clouds.put("5","Stratocumulus");low_clouds.put("6","Stratus nebulosus lub Stratus fractus (lecz nie złej pogody) lub obie chmury razem");
        low_clouds.put("7","Stratus fractus lub Cumulus fractus (złej pogody) lub obie chmury razem (pannus), zwykle pod Altostratus lub Nimbostratus"); low_clouds.put("8","Cumulus i Stratocumulus");
        low_clouds.put("9"," Cumulonimbus capillatus (często z kowadłem) występujący sam lub z Cumulonimbus calvus, Cumulus, Stratocumulus, Stratus lub pannus");low_clouds.put("/","chmury nie były widoczne");

        medium_clouds.put("0","brak");medium_clouds.put("1","Altostratus translucidus");medium_clouds.put("2","Altostratus opacus lub Nimbostratus");medium_clouds.put("3","Altocumulus translucidus na jednym poziomie");
        medium_clouds.put("4","ławice Altocumulus translucidus, często soczewkowate, ciągle zmieniające się i występujące na jednym lub kilku poziomach");medium_clouds.put("5","Altocumulus translucidus w pasmach, albo jedna lub więcej warstw Altocumulus translucidus lub opacus, stopniowo zaciągająca niebo; te chmury Ac na ogół w całości grubieją");
        medium_clouds.put("6","Altocumulus cumulogenitus");medium_clouds.put("7","Altocumulus translucidus lub opacus w dwóch lub więcej warstwach, lub Altocumulus opacus w pojedynczej warstwie");
        medium_clouds.put("8","Altocumulus castellanus lub floccus");medium_clouds.put("9","Altocumulus na niebie o wyglądzie chaotycznym, na ogół na kilku poziomach");medium_clouds.put("/","chmury nie były widoczne");

        high_clouds.put("0","brak");high_clouds.put("1","Cirrus fibratus lub Cirrus uncinus");high_clouds.put("2","Cirrus spissatus w ławicach lub w postaci poplątanych wiązek, albo Cirrus castellanus lub floccus");
        high_clouds.put("3","Cirrus spissatus cumulonimbogenitus");high_clouds.put("4","Cirrus uncinus lub Cirrus fibratus lub obie te chmury razem");high_clouds.put("5","Cirrus (w pasmach) i Cirrostratus lub sam Cirrostratus stopniowo zaciągający niebo, ale nie wyżej niż 45° nad horyzontem");
        high_clouds.put("6","Cirrus (w pasmach) i Cirrostratus lub sam Cirrostratus stopniowo zaciągający niebo, powyżej niż 45° nad horyzontem, lecz nie pokrywa całkowicie nieba");high_clouds.put("7","Cirrostratus pokrywający całkowicie niebo");
        high_clouds.put("8","Cirrostratus nie zaciągający i nie pokrywający nieba");high_clouds.put("9","Cirrocumulus sam lub przeważający wśród chmur wysokich");high_clouds.put("/","chmury nie były widoczne");
    }

    public  double get_pressure(double pressure){
        if(pressure<1000){
            pressure= (pressure+1000)/10;
        }
        return (pressure/10);
    }

    public double get_temperature(double temperature){
        return temperature/10;
    }
}
