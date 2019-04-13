package com.example.konrad.gus_hackathon_2019.game;

import java.io.Serializable;
import java.util.Random;

public class BDLQuestion implements Serializable {
    private String good_ans;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswerA() {
        return answerA;
    }

    public void setAnswerA(int answerA) {
        this.answerA = answerA;
    }

    public int getAnswerB() {
        return answerB;
    }

    public void setAnswerB(int answerB) {
        this.answerB = answerB;
    }

    public int getAnswerC() {
        return answerC;
    }

    public void setAnswerC(int answerC) {
        this.answerC = answerC;
    }

    public static String question_template = "Wartość dla %s w roku %d wynosi: ?";
    private String question;
    private int answerA;
    private int answerB;
    private int answerC;

    private int generateBadValue(int good_val) {
        Random generator = new Random();
        int r = 0;
        while (r == 0 || r == good_val) {
            int rangeMin = good_val - generator.nextInt();
            int rangeMax = good_val + generator.nextInt();
            r = (int) (rangeMin + (rangeMax - rangeMin) * generator.nextDouble());
        }
        return r;
    }

    public String getGood_ans() {
        return good_ans;
    }

    public void setGood_ans(String good_ans) {
        this.good_ans = good_ans;
    }

    public BDLQuestion generateQuestion(String paramName, int year, int good_val) {
        BDLQuestion bdlQuestion = new BDLQuestion();
        bdlQuestion.question = String.format(question_template, paramName, year);

        Random generator = new Random();
        int goodAnswer = generator.nextInt() % 3;

        if (goodAnswer == 0) {
            bdlQuestion.answerA = good_val;
            this.good_ans = "a";
            bdlQuestion.answerB = generateBadValue(good_val);
            bdlQuestion.answerC = generateBadValue(good_val);
        } else if (goodAnswer == 1) {
            this.good_ans = "b";
            bdlQuestion.answerA = generateBadValue(good_val);
            bdlQuestion.answerB = good_val;
            bdlQuestion.answerC = generateBadValue(good_val);
        } else if (goodAnswer == 2) {
            this.good_ans = "c";
            bdlQuestion.answerA = generateBadValue(good_val);
            bdlQuestion.answerB = generateBadValue(good_val);
            bdlQuestion.answerC = good_val;
        }

        return bdlQuestion;
    }
}
