package com.example.aneudys.tabs2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    TabHost th;
    VideoView videoView;
    Button btnRegistro;
    TextView tvRegistro;
    EditText etRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        th=(TabHost)findViewById(R.id.th);
        videoView=(VideoView)findViewById(R.id.videoView);
        btnRegistro=(Button)findViewById(R.id.btnRegistro);
        tvRegistro=(TextView)findViewById(R.id.tvRegistro);
        etRegistro=(EditText)findViewById(R.id.etRegistro);


        Uri uri=Uri.parse("https://www.youtube.com/watch?v=yuvIAXd11ag");
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        th.setup();
        TabHost.TabSpec ts1=th.newTabSpec("Tab1");
        ts1.setIndicator("Inicio");
        ts1.setContent(R.id.tab1);
        th.addTab(ts1);


        th.setup();
        TabHost.TabSpec ts2=th.newTabSpec("Tab2");
        ts2.setIndicator("Registro");
        ts2.setContent(R.id.tab2);
        th.addTab(ts2);


        th.setup();
        TabHost.TabSpec ts3=th.newTabSpec("Tab3");
        ts3.setIndicator("Contacto");
        ts3.setContent(R.id.tab3);
        th.addTab(ts3);

    }


   public void onClick(View view){
        String email=etRegistro.getText().toString();

       if(email.isEmpty()){
           tvRegistro.setText("Debe llenar el email");
       }else{
           tvRegistro.setText("Usuario Registrado");
           etRegistro.setText("");
       }
    }
}
