package com.example.nikhilreddy.serenitysoundsapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btPremam,btPove;
    MediaPlayer mpPremam, mpPove;
    int playStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btPremam = (Button)findViewById(R.id.btnPremam);
        btPove = (Button)findViewById(R.id.btnPove);
        mpPremam = new MediaPlayer();
        mpPove = new MediaPlayer();

        btPremam.setOnClickListener(oclPremam);
        btPove.setOnClickListener(oclPove);

        mpPremam = MediaPlayer.create(this,R.raw.premam);
        mpPove = MediaPlayer.create(this,R.raw.pove);

        playStatus = 0;

    }

    Button.OnClickListener oclPremam = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playStatus)
            {
                case 0:
                    mpPremam.start();
                    playStatus = 1;
                    btPremam.setText("Pause Premam Song");
                    btPove.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpPremam.stop();
                    playStatus = 0;
                    btPremam.setText("Play Premam Song");
                    btPove.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };

    Button.OnClickListener oclPove = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playStatus)
            {
                case 0:
                    mpPove.start();
                    playStatus = 1;
                    btPove.setText("Pause Pove Song");
                    btPremam.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpPove.stop();
                    playStatus = 0;
                    btPove.setText("Play Pove Song");
                    btPremam.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };

}
