package com.example.mymap;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main3Activity extends AppCompatActivity implements Runnable{

    private static final String TAG ="Rate" ;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    Thread t=new Thread(this);
    t.start();
      handler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                if(msg.what==5){
                    String str = (String) msg.obj;
                    Log.i(TAG, "handleMessage: getMessage msg = " + str);

                }
                super.handleMessage(msg);
            }
        };
    }

    @Override
    public void run() {
Log.i(TAG,"run:run()......");
        for(int i=1;i<3;i++){
            Log.i(TAG, "run: i=" + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
        Message msg = handler.obtainMessage(5);
        msg.obj = "Hello from run()";
        handler.sendMessage(msg);
        //获取网络数据
        Bundle bundle = new Bundle();
        Document doc = null;
        try {
            String url = "http://www.wj120.com.cn/myfc/myfc.html";
            doc = Jsoup.connect(url).get();
            Log.i(TAG, "run: " + doc.title());
            Elements tables = doc.getElementsByTag("table");


            Element table10=tables.get(9);

            Elements tds=table10.getElementsByTag("td");
           for(int i=10;i<tds.size();i+=8) {
               Element td1 = tds.get(i);
               Element td2 = tds.get(i + 4);
               Log.i(TAG, "run:td1=" + td1.text());
               Log.i(TAG, "run:td2=" + td2.text());
               String name=td1.text();
               String time=td2.text();
           }

        /*       for(Element td:tds){
                Log.i(TAG,"run:td="+td);

            }
           /* for(Element td:tds){

                Log.i(TAG, "run: td="+td);
                Log.i(TAG, "run: text="+td.text());
                Log.i(TAG, "run: html="+td.html());
            }*/


        } catch (IOException e) {
            e.printStackTrace();
        }}
     /*           URL url = null;
        try {
            url = new URL("http://www.wj120.com.cn/myfc/myfc.html");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            InputStream in = http.getInputStream();

            String html = inputStream2String(in);
            Log.i(TAG, "run: html=" + html);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

    private String inputStream2String(InputStream inputStream) throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream, "gb2312");
        while (true) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0)
                break;
            out.append(buffer, 0, rsz);
        }
        return out.toString();
    }
}
