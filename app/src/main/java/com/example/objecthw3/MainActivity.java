package com.example.objecthw3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public Button ButtonArr[][] = new Button[4][4];
    public int Board[][] = new int[4][4];
    public int Correct[][] = new int[4][4];
    public int emptyI;
    public int emptyJ;

    public ArrayList<Integer> ArrSort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        initializeGrid();
    }
    public void initializeGrid(){
        ButtonArr[0][0] = findViewById(R.id.button);
        ButtonArr[0][1] = findViewById(R.id.button2);
        ButtonArr[0][2] = findViewById(R.id.button3);
        ButtonArr[0][3] = findViewById(R.id.button4);
        ButtonArr[1][0] = findViewById(R.id.button5);
        ButtonArr[1][1] = findViewById(R.id.button6);
        ButtonArr[1][2] = findViewById(R.id.button7);
        ButtonArr[1][3] = findViewById(R.id.button8);
        ButtonArr[2][0] = findViewById(R.id.button9);
        ButtonArr[2][1] = findViewById(R.id.button10);
        ButtonArr[2][2] = findViewById(R.id.button11);
        ButtonArr[2][3] = findViewById(R.id.button12);
        ButtonArr[3][0] = findViewById(R.id.button13);
        ButtonArr[3][1] = findViewById(R.id.button14);
        ButtonArr[3][2] = findViewById(R.id.button15);
        ButtonArr[3][3] = findViewById(R.id.button16);

        ArrSort = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16));
        Collections.shuffle(ArrSort);
        int val =1;
        int index =0 ;
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                Correct[i][j] = val;
                Board[i][j] = ArrSort.get(index);
                if(ArrSort.get(index) == 16){
                    emptyI = i;
                    emptyJ = j;
                }
                ButtonArr[i][j].setText(" " + Board[i][j]);
                ButtonArr[0][0].setOnClickListener(this);
                index++;
                val++;
            }
        }
    }
    public void validMove(int i, int j){

    }
    public void randomize(){
        Collections.shuffle(ArrSort);
        int index =0 ;
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                Board[i][j] = ArrSort.get(index);
                if(ArrSort.get(index) == 16){
                    emptyI = i;
                    emptyJ = j;
                }
                index++;
            }
        }
    }
    public void onClick(View v) {
        //call randomize method
        if (v.getId() == R.id.Randomize) {
            randomize();
        }
        Button clickedButt = (Button)v;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(ButtonArr[i][j] == clickedButt){



                }

            }
        }

    }
}
