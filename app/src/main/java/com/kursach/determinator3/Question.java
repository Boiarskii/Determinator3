package com.kursach.determinator3;

import android.graphics.drawable.Drawable;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;


public class Question {
    private UUID id;
    private Drawable image;
    private String question;
    private String mainAnswer;
    private ArrayList<String> answers = new ArrayList<>();

    public Question(Drawable image, String question, String mainAnswer, ArrayList<String> answers) {
        id = UUID.randomUUID();
        this.image = image;
        this.question = question;
        this.mainAnswer = mainAnswer;
        this.answers.addAll(answers);
        Collections.shuffle(this.answers);
    }

    public UUID getId() {
        return id;
    }

    public Drawable getImage() {
        return image;
    }

    public String getQuestion() {
        return question;
    }

    public String getMainAnswer() {
        return mainAnswer;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

}
