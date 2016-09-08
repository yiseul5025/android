package com.example.baseballnumbergame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class baseballnumbergame extends AppCompatActivity implements View.OnClickListener {

    EditText n1, n2, n3;

    int cnt = 1, z, i, st = 0, j, ball = 0, out = 0, c[] = new int[3], u[] = new int[3], cs[] = new int[9];
    String ui[] = new String[3];
    Random rd = new Random();
    TextView textview, cn1, cn2, cn3, cn4, cn5, cn6, cn7, cn8, cn9;
    Toast toast1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_baseballnumbergame);
        Button ne = (Button) findViewById(R.id.ne);
        ne.setOnClickListener(this);

        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(this);

        for (i = 0; i < 3; i++) {
            c[i] = rd.nextInt(9);

        }
        while (true) {
            for (i = 0; i < 3; i++) {
                c[i] = rd.nextInt(9);
                if (c[0] == c[1] || c[0] == c[2] || c[1] == c[2]) {
                    i--;
                } else
                    break;
            }
            break;
        }
        for (i = 0; i < 3; i++) {
            Log.i("c[i]", "" + c[i]);
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {

        textview = (TextView) findViewById(R.id.cntt);
        textview.setText(cnt + "회");
        n1 = (EditText) findViewById(R.id.a);

        n2 = (EditText) findViewById(R.id.b);

        n3 = (EditText) findViewById(R.id.c);

        ui[0] = n1.getText().toString();
        ui[1] = n2.getText().toString();
        ui[2] = n3.getText().toString();

        u[0] = Integer.parseInt(ui[0]);//입력 받은 값
        u[1] = Integer.parseInt(ui[1]);
        u[2] = Integer.parseInt(ui[2]);

        switch (v.getId()) {
            case R.id.start:

                if(u[0]==0||u[1]==0||u[2]==0){
                    toast1=Toast.makeText(this,"값을 입력하세요",Toast.LENGTH_LONG);
                    break;
                }
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        Log.i("u[" + i + "]", "" + u[i]);
                        if (c[i] == u[i]) {
                            st++;
                            break;

                        }
                        else if (c[i] != u[i] && c[i] == u[j]) {
                            ball++;

                        }
                    }
                }


                out = 3 - (st + ball);
                Log.i("st", "" + st);
                Log.i("ball", "" + ball);
                Log.i("out", "" + out);
                textview = (TextView) findViewById(R.id.cn1);
                textview.setText("st:"+st+",ball:"+ball+",out:"+out);
                cnt++;//도전 횟수
        }
        switch (v.getId()) {
            case R.id.ne:
                finish();
                n1.setText(null);
                n2.setText(null);
                n3.setText(null);
                Intent in = new Intent(this, baseballnumbergame.class);
                startActivity(in);
        }







        if (st == 3) {
            toast1 = Toast.makeText(this, "Win!!!", Toast.LENGTH_LONG);
            toast1.show();
        } else if (cnt == 9) {
            toast1 = Toast.makeText(this, "your Loser", Toast.LENGTH_LONG);
        } else {
            toast1 = Toast.makeText(this, "re play", Toast.LENGTH_LONG);
        }
        st = 0;
        ball = 0;
        out = 0;
    }


}






