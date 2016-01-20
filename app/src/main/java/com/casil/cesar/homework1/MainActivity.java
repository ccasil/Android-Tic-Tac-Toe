package com.casil.cesar.homework1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String xo = "X";
    private String[][] grid = new String [3][3];
    private boolean endGame = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Switch between X and O
    private String changeXO(String xo){
        if(xo == "X"){
            xo = "O";
        }else if (xo == "O"){
            xo = "X";
        }
        return xo;
    }

    // Check if the array is full or not
    private boolean arrayEmpty(String [][] grid){
        for(int i =0; i < 3;i++){
            for(int j =0; j <3; j++){
                if(grid[i][j] == null){
                    return false;
                }
            }
        }
        return true;
    }

    public void clickBoard ( View view){
        if(!endGame){
            int check = view.getId();
            ImageButton button = (ImageButton)findViewById(check);
            if (xo =="X") {
                button.setImageResource(R.drawable.cross);
            }else if(xo == "O") {
                button.setImageResource(R.drawable.circle);
            }
            // Check each button pressed and change the text to X or O
            if((check == R.id.imageButton00)){
                grid[0][0] = xo;
                button.setTag(xo);
                xo = changeXO(xo);
                button.setEnabled(false);
            }else if (check == R.id.imageButton01){
                grid[0][1] = xo;
                button.setTag(xo);
                xo = changeXO(xo);
                button.setEnabled(false);
            }else if (check == R.id.imageButton02){
                grid[0][2] = xo;
                button.setTag(xo);
                xo = changeXO(xo);
                button.setEnabled(false);
            }else if (check == R.id.imageButton10){
                grid[1][0] = xo;
                button.setTag(xo);
                xo = changeXO(xo);
                button.setEnabled(false);
            }else if (check == R.id.imageButton11){
                grid[1][1] = xo;
                button.setTag(xo);
                xo = changeXO(xo);
                button.setEnabled(false);
            }else if (check == R.id.imageButton12){
                grid[1][2] = xo;
                button.setTag(xo);
                xo = changeXO(xo);
                button.setEnabled(false);
            }else if (check == R.id.imageButton20){
                grid[2][0] = xo;
                button.setTag(xo);
                xo = changeXO(xo);
                button.setEnabled(false);
            }else if (check == R.id.imageButton21){
                grid[2][1] = xo;
                button.setTag(xo);
                xo = changeXO(xo);
                button.setEnabled(false);
            }else if (check == R.id.imageButton22){
                grid[2][2] = xo;
                button.setTag(xo);
                xo = changeXO(xo);
                button.setEnabled(false);
            }
            for(int i = 0; i < 3 ; i++){
                // Compare columns and check if straight Xs or Os
                if(grid[i][0] != null && grid[i][1] != null && grid[i][2] !=null){
                    if(grid[i][0].compareTo(grid[i][1]) == 0 && grid[i][0].compareTo(grid[i][2]) == 0){
                        if(i == 0){
                            button = (ImageButton) findViewById(R.id.imageButton00);
                            button.setBackgroundColor(Color.YELLOW);
                            button = (ImageButton) findViewById(R.id.imageButton01);
                            button.setBackgroundColor(Color.YELLOW);
                            button = (ImageButton) findViewById(R.id.imageButton02);
                            button.setBackgroundColor(Color.YELLOW);

                        }else if(i == 1){
                            button = (ImageButton) findViewById(R.id.imageButton10);
                            button.setBackgroundColor(Color.YELLOW);
                            button = (ImageButton) findViewById(R.id.imageButton11);
                            button.setBackgroundColor(Color.YELLOW);
                            button = (ImageButton) findViewById(R.id.imageButton12);
                            button.setBackgroundColor(Color.YELLOW);

                        }else if(i == 2){
                            button = (ImageButton) findViewById(R.id.imageButton20);
                            button.setBackgroundColor(Color.YELLOW);
                            button = (ImageButton) findViewById(R.id.imageButton21);
                            button.setBackgroundColor(Color.YELLOW);
                            button = (ImageButton) findViewById(R.id.imageButton22);
                            button.setBackgroundColor(Color.YELLOW);

                        }
                        TextView text = (TextView) findViewById(R.id.endText);
                        text.setText("      " + grid[i][0] + "  Wins!  ");
                        endGame = true;
                    }
                }
                // Compare row and check if straight Xs or Os
                if(grid[0][i] != null && grid[1][i] != null && grid[2][i] !=null) {
                    if (grid[0][i].compareTo(grid[1][i]) == 0 && grid[0][i].compareTo(grid[2][i]) == 0) {
                        if(i == 0){
                            button = (ImageButton) findViewById(R.id.imageButton00);
                            button.setBackgroundColor(Color.YELLOW);
                            button = (ImageButton) findViewById(R.id.imageButton10);
                            button.setBackgroundColor(Color.YELLOW);
                            button = (ImageButton) findViewById(R.id.imageButton20);
                            button.setBackgroundColor(Color.YELLOW);

                        }else if(i == 1){
                            button = (ImageButton) findViewById(R.id.imageButton01);
                            button.setBackgroundColor(Color.YELLOW);
                            button = (ImageButton) findViewById(R.id.imageButton11);
                            button.setBackgroundColor(Color.YELLOW);
                            button = (ImageButton) findViewById(R.id.imageButton21);
                            button.setBackgroundColor(Color.YELLOW);

                        }else if(i == 2){
                            button = (ImageButton) findViewById(R.id.imageButton02);
                            button.setBackgroundColor(Color.YELLOW);
                            button = (ImageButton) findViewById(R.id.imageButton12);
                            button.setBackgroundColor(Color.YELLOW);
                            button = (ImageButton) findViewById(R.id.imageButton22);
                            button.setBackgroundColor(Color.YELLOW);

                        }
                        TextView text = (TextView) findViewById(R.id.endText);
                        text.setText("      " + grid[0][i] + "  Wins!  ");
                        endGame = true;
                    }
                }
            }

            //Special Case for Diagonals
            if(grid[0][0] != null && grid[1][1] != null && grid[2][2] != null){
                if (grid[0][0].compareTo(grid[1][1]) == 0 && grid[0][0].compareTo(grid[2][2]) == 0) {
                    button = (ImageButton) findViewById(R.id.imageButton00);
                    button.setBackgroundColor(Color.YELLOW);
                    button = (ImageButton) findViewById(R.id.imageButton11);
                    button.setBackgroundColor(Color.YELLOW);
                    button = (ImageButton) findViewById(R.id.imageButton22);
                    button.setBackgroundColor(Color.YELLOW);
                    TextView text = (TextView) findViewById(R.id.endText);
                    text.setText("      " + grid[1][1] + "  Wins!  ");
                    endGame = true;
                }
            }
            if(grid[0][2] != null && grid[1][1] != null && grid[2][0] != null){
                if (grid[0][2].compareTo(grid[1][1]) == 0 && grid[0][2].compareTo(grid[2][0]) == 0) {
                    button = (ImageButton) findViewById(R.id.imageButton02);
                    button.setBackgroundColor(Color.YELLOW);
                    button = (ImageButton) findViewById(R.id.imageButton11);
                    button.setBackgroundColor(Color.YELLOW);
                    button = (ImageButton) findViewById(R.id.imageButton20);
                    button.setBackgroundColor(Color.YELLOW);
                    TextView text = (TextView) findViewById(R.id.endText);
                    text.setText("      " + grid[1][1] + "  Wins!  ");
                    endGame = true;
                }
            }

            // Check if array is full and no winners
            if(arrayEmpty(grid) && !endGame){
                TextView text = (TextView) findViewById(R.id.endText);
                text.setText("      Tie!       ");
                endGame = true;
            }

        }
    }
    public void newGame(View v) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
