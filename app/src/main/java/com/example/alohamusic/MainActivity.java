package com.example.alohamusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button button1, button2;
    MediaPlayer mpUkulele, mpDrums;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.btnUk);
        button2 =findViewById(R.id.btnDrum);
        button1.setOnClickListener(bUkulele);
        button2.setOnClickListener(bDrums);
        mpUkulele= new MediaPlayer();
        mpUkulele= MediaPlayer.create(this,R.raw.ukulele);
        mpDrums= new MediaPlayer();
        mpDrums = MediaPlayer.create(this, R.raw.drum);
        playing=0;
    }
    Button.OnClickListener bUkulele = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v){
            switch (playing)
            {
                case 0:
                    mpUkulele.start();
                    playing =1;
                    button1.setText("Pause Ukulele Song");
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpUkulele.pause();
                    playing=0;
                    button1.setText("Resume Ukulele Song");
                    button2.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };

    Button.OnClickListener bDrums = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpDrums.start();
                    playing = 1;
                    button2.setText("Pause Drum Song");
                    button1.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpDrums.pause();
                    playing = 0;
                    button2.setText("Resume Drum Song");
                    button1.setVisibility(View.VISIBLE);
                    break;
            }
        }

    };

}
