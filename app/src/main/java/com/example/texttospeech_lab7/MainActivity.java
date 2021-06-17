package com.example.texttospeech_lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button button;
    String text;
    TextToSpeech t1;
    TextToSpeech.OnInitListener t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.bt);
        editText = (EditText)findViewById(R.id.et);
        button.setOnClickListener(this);

        t2=new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    t1.setLanguage(Locale.GERMAN);
                    t1.setSpeechRate((float) 0.5);
                }
            }
        };



        t1 = new TextToSpeech(getApplicationContext(), t2);
    }

    @Override
    public void onClick(View v) {
        text=editText.getText().toString();
        t1.speak(text,TextToSpeech.QUEUE_FLUSH, null);
    }
}