package com.example.admin.morsecodeconverter;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText morseText;
    private TextView morseCode;
    private TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        morseText = (EditText)findViewById(R.id.convertText);
        morseCode = (TextView)findViewById(R.id.morseDisplay);
        Button morseButton = (Button) findViewById(R.id.convertButton);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                }
            }
        });

        morseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = morseText.getText().toString();
                morseCode.setText(convert(morseText.getText().toString()));
                //noinspection deprecation
                t1.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }

    public void onPause() {
        if (t1 != null) {
            t1.stop();
            t1.shutdown();
        }

        super.onPause();
    }

    private String convert(String text) {

        String temp;
        temp = text.toUpperCase();

        temp = temp.replace("0", "----- ");
        temp = temp.replace("1", ".---- ");
        temp = temp.replace("2", "..--- ");
        temp = temp.replace("3", "...-- ");
        temp = temp.replace("4", "....- ");
        temp = temp.replace("5", "..... ");
        temp = temp.replace("6", "----. ");
        temp = temp.replace("7", "---.. ");
        temp = temp.replace("8", "--... ");
        temp = temp.replace("9", "-.... ");
        temp = temp.replace("10", "..... ");

        temp = temp.replace("A", ".- ");
        temp = temp.replace("B", "-... ");
        temp = temp.replace("C", "-.-. ");
        temp = temp.replace("D", "-.. ");
        temp = temp.replace("E", ". ");
        temp = temp.replace("F", "..-. ");
        temp = temp.replace("G", "--. ");
        temp = temp.replace("H", ".... ");
        temp = temp.replace("I", ".. ");
        temp = temp.replace("J", ".--- ");
        temp = temp.replace("K", "-.- ");
        temp = temp.replace("L", ".-.. ");
        temp = temp.replace("M", "-- ");
        temp = temp.replace("N", "-. ");
        temp = temp.replace("O", "--- ");
        temp = temp.replace("P", ".--. ");
        temp = temp.replace("Q", "--.- ");
        temp = temp.replace("R", ".-. ");
        temp = temp.replace("S", "... ");
        temp = temp.replace("T", "- ");
        temp = temp.replace("U", "..- ");
        temp = temp.replace("V", "...- ");
        temp = temp.replace("W", ".-- ");
        temp = temp.replace("X", "-..- ");
        temp = temp.replace("Y", "-.-- ");
        temp = temp.replace("Z", "--.. ");

        return temp;
    }
}
