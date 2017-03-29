package com.example.android.tenniscounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.tenniscounter.R;

public class MainActivity extends AppCompatActivity {

    int scorePlayerA = 0;
    int scorePlayerB = 0;
    int gamePlayerA = 0;
    int gamePlayerB = 0;
    int foulsPlayerA = 0;
    int foulsPlayerB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayAdForPlayerA() {
        TextView scoreView = (TextView) findViewById(R.id.player_a_score);
        scoreView.setText("AD");
    }

    public void displayGameForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_game);
        scoreView.setText(String.valueOf(score));
    }

    public void displayFoulsForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_fouls);
        scoreView.setText(String.valueOf(score));
    }

    public void addFoulPlayerA(View view) {
        foulsPlayerA = foulsPlayerA + 1;
        displayFoulsForPlayerA(foulsPlayerA);
    }

    public void addOneForPlayerA(View view) {
        if (scorePlayerA >= 40 && scorePlayerA == scorePlayerB) {
            scorePlayerA = scorePlayerA + 15;
            if (scorePlayerA == 45) {
                scorePlayerA = 40;
            }
            displayAdForPlayerA();
            return;
        }
        scorePlayerA = scorePlayerA + 15;
        if (scorePlayerA == 45) {
            scorePlayerA = 40;
        }
        if (scorePlayerA >= 40 && scorePlayerB >= 40 && (scorePlayerA - scorePlayerB) > 15) {
            gamePlayerA = gamePlayerA + 1;
            displayGameForPlayerA(gamePlayerA);
            resetGame(view);
            return;
        }
        if (scorePlayerB > 40 && scorePlayerA > 40 && scorePlayerB == scorePlayerB) {
            displayForPlayerA(40);
            displayForPlayerB(40);
            return;
        } else if (scorePlayerA > 40 && scorePlayerB != scorePlayerA) {
            gamePlayerA = gamePlayerA + 1;
            displayGameForPlayerA(gamePlayerA);
            resetGame(view);
        }
        displayForPlayerA(scorePlayerA);
    }

    /*
     THIS PART IS FOR THE Player B
     */
    public void displayForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayAdForPlayerB() {
        TextView scoreView = (TextView) findViewById(R.id.player_b_score);
        scoreView.setText("AD");
    }

    public void displayGameForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_game);
        scoreView.setText(String.valueOf(score));
    }

    public void displayFoulsForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_fouls);
        scoreView.setText(String.valueOf(score));
    }

    public void addFoulPlayerB(View view) {
        foulsPlayerB = foulsPlayerB + 1;
        displayFoulsForPlayerB(foulsPlayerB);
    }

    public void addOneForPlayerB(View view) {
        if (scorePlayerB >= 40 && scorePlayerB == scorePlayerA) {
            scorePlayerB = scorePlayerB + 15;
            if (scorePlayerB == 45) {
                scorePlayerB = 40;
            }
            displayAdForPlayerB();
            return;
        }
        scorePlayerB = scorePlayerB + 15;
        if (scorePlayerB == 45) {
            scorePlayerB = 40;
        }
        displayForPlayerB(scorePlayerB);
        if (scorePlayerB >= 40 && scorePlayerA >= 40 && (scorePlayerB - scorePlayerA) > 15) {
            gamePlayerB = gamePlayerB + 1;
            displayGameForPlayerB(gamePlayerB);
            resetGame(view);
            return;
        }
        if (scorePlayerB > 40 && scorePlayerA > 40 && scorePlayerB == scorePlayerB) {
            displayForPlayerA(40);
            displayForPlayerB(40);
            return;
        } else if (scorePlayerB > 40 && scorePlayerB != scorePlayerA) {
            gamePlayerB = gamePlayerB + 1;
            displayGameForPlayerB(gamePlayerB);
            resetGame(view);
        }
    }

    /*
    SCORE AND GAMES RESETTING
     */
    public void resetAll(View v) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
        gamePlayerA = 0;
        gamePlayerB = 0;
        displayGameForPlayerA(gamePlayerA);
        displayGameForPlayerB(gamePlayerB);
        foulsPlayerA = 0;
        foulsPlayerB = 0;
        displayFoulsForPlayerA(foulsPlayerA);
        displayFoulsForPlayerB(foulsPlayerB);
    }

    public void resetGame(View v) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
    }
}