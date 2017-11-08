package com.example.android.jsouptrail22;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    String scrappedtxt;
    Button btn;
    Document doc;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt= (TextView)findViewById(R.id.text);
        img=(ImageView)findViewById(R.id.image);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new scrap().execute();
            }
        });
    }

    public class scrap extends AsyncTask<Void,Void,Void>{


        @Override
        protected Void doInBackground(Void... params) {
            try{
                doc= Jsoup.connect("https://developer.android.com/guide/components/processes-and-threads.html").get();
            }

            catch (IOException e){e.printStackTrace();}
           // scrappedtxt=doc.title();
          Elements stff2 =doc.select("#Processes , #qv-wrapper , p:nth-child(7)");
             scrappedtxt= stff2.text();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            txt.setText(scrappedtxt);
        }
    }
}
