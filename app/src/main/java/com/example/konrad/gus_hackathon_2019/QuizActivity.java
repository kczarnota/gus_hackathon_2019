package com.example.konrad.gus_hackathon_2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.konrad.gus_hackathon_2019.game.BDLQuestion;

public class QuizActivity extends AppCompatActivity {

    private BDLQuestion question;
    private TextView question_text;
    private Button button_a;
    private Button button_b;
    private Button button_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question = (BDLQuestion) getIntent().getSerializableExtra("question");

        question_text = findViewById(R.id.question_text);
        question_text.setText(question.getQuestion());
        button_a = findViewById(R.id.button_a);
        button_a.setText(String.format("A: %s", question.getAnswerA()));
        if (question.getGood_ans().equals("a"))  {
            button_a.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    goodAnswer();
                }
            });
        }
        button_b = findViewById(R.id.button_b);
        button_b.setText(String.format("B: %s", question.getAnswerB()));
        button_c = findViewById(R.id.button_c);
        button_c.setText(String.format("C: %s", question.getAnswerC()));
    }

    private void goodAnswer() {
    }

    private void badAnswer() {
    }

    public void finish() {
        button_a.setEnabled(false);
        button_b.setEnabled(false);
        button_c.setEnabled(false);
    }

}
