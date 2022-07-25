package com.bruh.wh_helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class DicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dices);


        Button butt = findViewById(R.id.button);
        EditText text = findViewById(R.id.editTextNumber);

        TextView one = findViewById(R.id.text1);
        TextView two = findViewById(R.id.text2);
        TextView three = findViewById(R.id.text3);
        TextView four = findViewById(R.id.text4);
        TextView five = findViewById(R.id.text5);
        TextView six = findViewById(R.id.text6);
        butt.setOnClickListener(e -> {
            try {
                System.out.println("SOSI");
                int num = Integer.parseInt(text.getText().toString());
                int[] nums = new int[6];
                Random rnd = new Random();
                for (int i = 0; i < num; i++) {
                    nums[rnd.nextInt(6)]++;
                }
                one.setText(nums[0] + "");
                two.setText(nums[1] + "");
                three.setText(nums[2] + "");
                four.setText(nums[3] + "");
                five.setText(nums[4] + "");
                six.setText(nums[5] + "");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
    }
}