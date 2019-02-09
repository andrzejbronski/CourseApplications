import org.jsoup.Jsoup;

import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) throws IOException{

        URL wykop = new URL("https://wykop.pl");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(wykop.openStream(),"UTF-8"));

        StringBuilder stringBuilder = new StringBuilder();

        String tmp = null;

        while ((tmp = bufferedReader.readLine())!=null){
                stringBuilder.append(tmp);
        }
        bufferedReader.close();
      //  System.out.println(stringBuilder.toString());

        Document document = Jsoup.parse(stringBuilder.toString());


       Elements headers = document.select("div.lcontrast.m-reset-margin").select("h2");
        for (Element e:headers){
            System.out.println(e.text());
        }

        }
    }
