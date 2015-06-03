package com.quickblox.qbpeople.htmlparcer;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.quickblox.qbpeople.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HtmlParser extends Activity {

    // благодоря этому классу мы будет разбирать данные на куски
    public Elements title;
    // то в чем будем хранить данные пока не передадим адаптеру
    public ArrayList<String> titleList = new ArrayList<String>();
    // Listview Adapter для вывода данных
    private ArrayAdapter<String> adapter;
    // List view
    private ListView lv;
    public TextView tv;
    private static final String TAG = "HtmlParser";

    public String getStingFomWeb() {

        StringBuilder  sB = new StringBuilder();

        // определение данных


        // запрос к нашему отдельному поток на выборку данных
        new NewThread().execute();

        for (String str : titleList){
            sB.append(str);

        }
        // Добавляем данные для ListView
        Log.d (TAG, "" + String.valueOf(sB.toString()));
        return sB.toString();

    }

    /** А вот и внутрений класс который делает запросы, если вы не читали статьи у меня в блоге про отдельные
     * потоки советую почитать */
    public class NewThread extends AsyncTask<String, Void, String> {

        // Метод выполняющий запрос в фоне, в версиях выше 4 андроида, запросы в главном потоке выполнять
        // нельзя, поэтому все что вам нужно выполнять - выносите в отдельный тред
        @Override
        protected String doInBackground(String... arg) {

            Document doc;
            try {
                doc = Jsoup.connect("https://sites.google.com/a/injoit.com/insite/employees_info").get();
                title = doc.select(".table");
                titleList.clear();
                for (Element titles : title) {
                    titleList.add(titles.text());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

//            try {
////                AssetManager myAssetManager = getApplicationContext().getAssets();
//
////            File input = new File("emploee_info.html");
//
////                "file:///android_asset/mypage.html"
////                doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
//                doc = Jsoup.connect("file:///android_asset/mypage.html").get();
//
//            Elements elements = doc.select("sites-canvas-main-content");
//            for (Element e : elements) {
//                titleList.add(e.text());
//            }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            return null;
        }

//        @Override
//        protected void onPostExecute(String result) {
//
//            // после запроса обновляем листвью
//            lv.setAdapter(adapter);
//        }
    }
}