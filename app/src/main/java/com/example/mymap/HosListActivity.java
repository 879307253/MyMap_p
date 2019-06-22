package com.example.mymap;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class HosListActivity extends ListActivity implements Runnable {
     String[] list_data = {"one","tow","three"};
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_hos_list);

        List<String>list1=new ArrayList<String>();
        for(int i=1;i<100;i++){
            list1.add("item"+i);
        }

        ListAdapter adapter = new ArrayAdapter<String>(HosListActivity.this,android.R.layout.simple_list_item_1,list1);
        setListAdapter(adapter);

        Thread t=new Thread(this);
        t.start();

        handler=new Handler(){
            public void handleMessage(@NonNull Message msg) {
                if(msg.what==5){
                List<String>list2=(List<String>)msg.obj;
                    ListAdapter adapter = new ArrayAdapter<String>(HosListActivity.this,android.R.layout.simple_list_item_1,list2);
                    setListAdapter(adapter);
                }
                super.handleMessage(msg);
            }
        };
    }


    @Override
    public void run() {
List<String> retList= new ArrayList<String>();
        Document doc = null;
        try {
            Thread.sleep(3000);
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
                retList.add("医生姓名："+name+"   就诊时间："+time);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Message msg = handler.obtainMessage(5);
        msg.obj = retList;
        handler.sendMessage(msg);
        //获取网络数据
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
