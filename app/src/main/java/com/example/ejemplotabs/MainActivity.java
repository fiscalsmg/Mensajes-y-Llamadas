package com.example.ejemplotabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

  //  public class MainActivity extends FragmentActivity {

        FragmentTabHost tabhost;
        TextView tv;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            tv=(TextView)findViewById(R.id.text);

            tabhost= (FragmentTabHost) findViewById(android.R.id.tabhost);
            tabhost.setup(this,
                    getSupportFragmentManager(),android.R.id.tabcontent);
            tabhost.addTab(tabhost.newTabSpec("tab1").setIndicator("Portada"),
                    Tab1.class, null);
            tabhost.addTab(tabhost.newTabSpec("tab2").setIndicator("Llamada"),
                    Tab2.class, null);
            tabhost.addTab(tabhost.newTabSpec("tab3").setIndicator("Mensaje"),
                    Tab3.class, null);
            tabhost.addTab(tabhost.newTabSpec("tab4").setIndicator("Acerca de"),
                    Tab4.class, null);

        }

}
