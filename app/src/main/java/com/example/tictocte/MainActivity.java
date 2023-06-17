package com.example.tictocte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive = true;
//    player active
//            0 = x
//            1 = o
    int activeplayer = 0;
    int [] gamestate = {2,2,2,2,2,2,2,2,2};

//            state
//            0 = x
//            1 = o
//            2 = Null
    int [][] winposition = {{0,1,2}, {3,4,5}, {6,7,8},
                             {0,3,6}, {1,4,7}, {2,5,8},
                              {0,4,8}, {2,4,6}};
    public void tapon(View view){
        ImageView img = (ImageView)view;
        int tapedimage = Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            gamereset(view);
        }
        if(gamestate[tapedimage] == 2){
            gamestate[tapedimage] = activeplayer;
            if(activeplayer == 0){
                img.setImageResource(R.drawable.red);
                activeplayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");
            }
            else {
                img.setImageResource(R.drawable.o);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");
            }
        }

        for(int[] winpositions: winposition){
            if(gamestate[winpositions[0]] == gamestate[winpositions[1]] &&
                    gamestate[winpositions[1]] == gamestate[winpositions[2]] &&
                    gamestate[winpositions[0]] != 2){
                String win;
                gameactive = false;
                if(gamestate[winpositions[0]] == 0){
                    win = "X's won !";
                }
                else{
                    win = "O's won !";
                }
                TextView status = findViewById(R.id.status);
                status.setText(win);
            }
        }

    }
    public void gamereset(View view){
        gameactive = true;
        activeplayer = 0;
        for(int i = 0; i<gamestate.length; i++){
           gamestate[i] = 2;

        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("Tap to play");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}