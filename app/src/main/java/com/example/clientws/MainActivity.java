package com.example.clientws;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    TextView txtFluxJSON;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFluxJSON=(TextView)findViewById(R.id.textDataws);
    }
    @Override
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL urlService=new URL("http://localhost:8080/Mycontact/rest/lesContact/getContact/0");
                    HttpURLConnection urlCnx =(HttpURLConnection) urlService.openConnection();
                    urlCnx.setRequestMethod("GET");
                    InputStream in = new BufferedInputStream(urlCnx.getInputStream());
                    Scanner sc=new Scanner(in);



                    Gson gson=new GsonBuilder().create();
                    final Contact leContact =gson.fromJson(sc.nextLine(), Contact.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            txtFluxJSON.setText(leContact.toString());
                            Log.i("contact FromWEBSERvice",leContact.toString());
                        }
                    });
                } catch (Exception e) {e.printStackTrace();}
            }
        }).start();
    }
}

