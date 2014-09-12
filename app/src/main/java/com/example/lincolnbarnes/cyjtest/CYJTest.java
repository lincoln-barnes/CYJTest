package com.example.lincolnbarnes.cyjtest;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;


public class CYJTest extends Activity {

    MediaPlayer appSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cyjtest);
        blinkText();
        appSong = MediaPlayer.create(CYJTest.this, R.raw.auld_lang_syne_64kb);
        appSong.start();
    }

    private void blinkText() {
        // TODO Auto-generated method stub
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 500;    //in ms
                try {
                    Thread.sleep(timeToBlink);
                } catch (Exception e) {

                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView txt = (TextView) findViewById(R.id.textView);
                        if (txt.getVisibility() == View.VISIBLE) {
                            txt.setVisibility(View.INVISIBLE);
                        } else {
                            txt.setVisibility(View.VISIBLE);
                        }
                        blinkText();
                    }
                });
            }
        }).start();

    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        appSong.release();
        finish();
    }
}

//test