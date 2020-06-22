package com.example.ejemplotabs;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


public class Tab3 extends Fragment {
    TextView tv_mensaje;
    EditText et_escribirMSJ,et_escribeNum;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab3, container, false);
        tv_mensaje=view.findViewById(R.id.text);
        et_escribeNum=view.findViewById(R.id.editText1);
        et_escribirMSJ=view.findViewById(R.id.editText2);

        tv_mensaje.setText("Mensaje");
        tv_mensaje.setTextSize(45);

        Button b=view.findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                //tv_mensaje.setText("Mensaje enviado!! "+et_escribirMSJ.getText().toString());
                enviar_un_Mensaje();

            }
        });
        return view;
    }

    private  void enviar_un_Mensaje(){
        String mensaje = et_escribirMSJ.getText().toString();
        String numero = et_escribeNum.getText().toString();

        if(ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions((Activity) getContext(),
                    new String[]{Manifest.permission.SEND_SMS}, 1);
        }else{
            try {
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(numero,null,mensaje,null,null);
                Toast.makeText(getContext(), "Mensaje Enviado.", Toast.LENGTH_LONG).show();
            }
            catch (Exception e) {
                Toast.makeText(getContext(),"Mensaje NO enviado"+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

    }


}

