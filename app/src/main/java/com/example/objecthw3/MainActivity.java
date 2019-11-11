package com.example.objecthw3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/*
*
* @Author: Alex Rogers
*
* Homework Three
*
* Novemeber 9th 2019
*
*
*Citations at bottom
* */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public Button ButtonArr[][] = new Button[4][4];
    public int Board[][] = new int[4][4];//4x4 array for puzzle board
    public int Correct[][] = new int[4][4];
    public int emptyI;//blank space row
    public int emptyJ;//blank space col

    public ArrayList<Integer> ArrSort;//array for all nums
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        initializeGrid();
        Button Randomizer=  findViewById(R.id.Randomize);
        Randomizer.setOnClickListener(this);


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


        ArrSort = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16));// see citation at bottom
        Collections.shuffle(ArrSort);
        int val =1;
        int index =0 ;
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){//loops to initially randomize, and set listeners to buttons
                Correct[i][j] = val;
                Board[i][j] = ArrSort.get(index);
                if(ArrSort.get(index) == 16){
                    emptyI = i;
                    emptyJ = j;
                }
                ButtonArr[i][j].setText(" " + Board[i][j]);
                if(Board[i][j] == 16){ButtonArr[i][j].setText(" ");}
                ButtonArr[i][j].setOnClickListener(this);
                index++;
                val++;
            }
        }
    }



    public void randomize(){//I've played the puzzle online and have to say my randomize is a lot harder to win with
        Collections.shuffle(ArrSort);//shuffles, see citation
        int index =0 ;
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                Board[i][j] = ArrSort.get(index);
                if(ArrSort.get(index) == 16){
                    emptyI = i;
                    emptyJ = j;
                }
                ButtonArr[i][j].setText(" " + Board[i][j]);
                if(Board[i][j] == 16){ButtonArr[i][j].setText(" ");}
                index++;
            }
        }
    }
    public Boolean isOver(){
        int temp = 0;//counts correct squares
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                if(Correct[i][j] == Board[i][j]){
                    temp++;
                }
            }}
        if(temp ==16){return true;}
        else{return false;}
    }
    public void setCorrect(){
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++) {
                if (Board[i][j] == Correct[i][j]){
                    ButtonArr[i][j].setTextColor(Color.GREEN);
                }
                else{
                    ButtonArr[i][j].setTextColor(Color.RED);
                }

            }}
    }
    public void onClick(View v) {


        Button clicked = (Button)v;
        if (v.getId() == R.id.Randomize) {
            randomize();//random button
        }

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){//iterates through Button and Board arrays
                if(ButtonArr[i][j] == clicked){
                    if((emptyI==i-1) && (emptyJ==j) /* && (i-1) >= 0*/){//check above, no need for out of bounds checking
                        ButtonArr[emptyI][emptyJ].setText(clicked.getText());
                        ButtonArr[i][j].setText(" ");
                        int temp = Board[i][j];
                        Board[i-1][j] = temp;//for win condition
                        Board[i][j] = 16;
                        emptyI = i;
                        emptyJ = j;
                    }
                    if((emptyI==i+1) && (emptyJ==j) /*&& (i+1) <= 4*/){//check below
                        ButtonArr[emptyI][emptyJ].setText(clicked.getText());
                        ButtonArr[i][j].setText(" ");
                        int temp = Board[i][j];
                        Board[i+1][j] = temp;
                        Board[i][j] = 16;
                        emptyI = i;
                        emptyJ = j;
                    }
                    if((emptyI==i) && (emptyJ==j-1) ){//check left
                        ButtonArr[emptyI][emptyJ].setText(clicked.getText());
                        ButtonArr[i][j].setText(" ");
                        int temp = Board[i][j];
                        Board[i][j-1] = temp;
                        Board[i][j] = 16;
                        emptyI = i;
                        emptyJ = j;
                    }
                    if((emptyI==i) && (emptyJ==j+1)){//check right
                        ButtonArr[emptyI][emptyJ].setText(clicked.getText());
                        ButtonArr[i][j].setText(" ");
                        int temp = Board[i][j];
                        Board[i][j+1] = temp;
                        Board[i][j] = 16;
                        emptyI = i;
                        emptyJ = j;
                    }




                }

            }
        }
        //v.invalidate();
        TextView t = findViewById(R.id.textView);//checks if everything is in the right place
        if(isOver()){
            t.setText("You Won");
        }
        setCorrect();
    }
}
/*External CitationDate:      November 10, 2019
 * Problem:  Button Layout
 * Solution: Sierra and Haley advised using a table layout
 */
/*External CitationDate:      November 10, 2019
 * Problem:  ArrayList
 * Source: https://www.geeksforgeeks.org/initialize-an-arraylist-in-java/
 * Solution: I used an array list and shuffled it
 */
/*External CitationDate:      November 10, 2019
 * Problem:  Shuffle the Array List
 * Solution: Mikey mentioned the function when we were discussing how to shuffle for our Euchre Game
 */