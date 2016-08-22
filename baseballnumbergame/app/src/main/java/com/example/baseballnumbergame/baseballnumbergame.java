package com.example.baseballnumbergame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;
import java.util.Scanner;

public class baseballnumbergame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseballnumbergame);
    }

    public void start(View v) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        int r = rd.nextInt(9) + 1;
        int s = sc.nextInt(9) + 1;

        int com[] = new int[3];
        int user[] = new int[3];
        for (int i = 0; i < 3; i++) {
            com[i] = rd.nextInt(3);//com에 넣어줌
        }
        for (int j = 0; j < 3; j++) {
            user[j] = sc.nextInt(3);//user에 넣어줌
        }
        int st = 0, ball = 0, out = 0;// st,ball,out값 선언
        if (com[1] == user[1] && com[2] == user[2] && com[3] == user[3]) {
            st++;
        }
        for (int w = 0; w < 3; w++) {
            for (int t = 0; t < 3; t++) {
                if (user[w] == com[t]) {
                    ball++;

                }
            }
        }
        if (com[1]!=user[1]&& com[2] != user[2] && com[3] != user[3]) {
            out++;
        }
    }

    public void go(View v) {


    }
}