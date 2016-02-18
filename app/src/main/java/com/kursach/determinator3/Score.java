package com.kursach.determinator3;


import android.util.Log;

public class Score {

    private int wrongAnswers = 0;
    private int totalAnswers = 0;

    private static Score ourInstance = new Score();

    public static Score getInstance() {
        return ourInstance;
    }

    private Score() {
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public int getTotalAnswers() {
        return totalAnswers;
    }

    //Ответ был верным
    public void correctAnswer() {
        ++totalAnswers;
    }

    //Ответ был неверным
    public void wrongAnswer() {
        ++totalAnswers;
        ++wrongAnswers;
    }

    //Получить процент неправильных ответов
    public int getWrongPercent() {
        if (totalAnswers == 0) {
            return 100;
        }
        return (int) ((((float) wrongAnswers) / ((float) totalAnswers)) * 100);
    }

    //Получить процент правильных ответов
    public int getCorrectPercent() {
        return 100 - getWrongPercent();
    }

    //Сброс очков
    public void resetScore() {
        wrongAnswers = 0;
        totalAnswers = 0;
    }
}
