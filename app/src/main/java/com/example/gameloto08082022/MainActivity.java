package com.example.gameloto08082022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textViewOutput, textViewHistory;
    Button btnPlay, btnReset;
    ArrayList<Integer> arrayListNumber;
    Random random;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewOutput  = (TextView) findViewById(R.id.textViewOutput);
        textViewHistory = (TextView) findViewById(R.id.textViewHistory);
        btnPlay         = (Button) findViewById(R.id.BtnPlay);
        btnReset        = (Button) findViewById(R.id.BtnReset);


        arrayListNumber = new ArrayList<>();
        random = new Random();

        //Thêm số vào mảng
        addNumberInArray();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrayListNumber.size()>0) {
                    int index = random.nextInt(arrayListNumber.size());
                    int value = arrayListNumber.get(index);

                    textViewOutput.setText(value + "");
                    if (arrayListNumber.size() == 100) {
                        result += value;
                    } else {
                        result = value + " - " + result;
                    }
                    textViewHistory.setText(result);
                    arrayListNumber.remove(index);
                } else {
                    Toast.makeText(MainActivity.this, "Kết thúc!", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrayListNumber.size() > 0) {
                    arrayListNumber.clear();
                }
                addNumberInArray();
                result = "";
                textViewOutput.setText("");
                textViewHistory.setText("");
            }
        });
    }

    public void addNumberInArray() {
        for (int i = 1; i <= 100; i++) {
            arrayListNumber.add(i);
        }
    }
}