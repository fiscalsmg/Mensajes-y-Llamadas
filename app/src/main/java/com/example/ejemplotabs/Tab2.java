package com.example.ejemplotabs;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


public class Tab2 extends Fragment {

    TextView tv;
    EditText et;
    private static  final  int REQUESt_CALL=1;

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

 

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab2, container, false);
    	tv=(TextView)view.findViewById(R.id.text);
    	et=(EditText)view.findViewById(R.id.editText1);
   
    	tv.setText("Marca a un número");
        tv.setTextSize(45);
        
        Button b=(Button)view.findViewById(R.id.button1);
        
        b.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
              tv.setText("Marcaste!! "+et.getText().toString());
              llamar_a_un_Celular();

			}
        });
        return view;
    }


    public void llamar_a_un_Celular(){
        String numero = et.getText().toString();
        //String numero ="7341693249";
        if(numero.trim().length()>0){
            if(ContextCompat.checkSelfPermission(getContext(),
                    Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions((Activity) getContext(),
                        new String[]{Manifest.permission.CALL_PHONE}, 1);
            }else{
                String dial = "tel:" + numero;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));

            }

        }else{
            Toast.makeText(getContext(), "Ingresa un numero de celular", Toast.LENGTH_SHORT).show();
        }
    }


}

