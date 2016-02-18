package com.kursach.determinator3;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.UUID;


public class QuestionLab {
    private static QuestionLab instance;
    private Context context;
    private ArrayList<Question> questions;

    private QuestionLab(Context context) {
        this.context = context;
        loadQuestions();
    }

    public static QuestionLab getInstance(Context context) {
        if (instance == null) {
            instance = new QuestionLab(context.getApplicationContext());
        }
        return instance;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public Question getQuestion(UUID id) {
        for (Question question : questions) {
            if (question.getId().equals(id)) {
                return question;
            }
        }
        return null;
    }

    //Загрузка вопросов
    private void loadQuestions() {
        Resources resources = context.getResources();

        ArrayList<String> answers  = new ArrayList<>();

        questions = new ArrayList<>();

        answers.add(resources.getString(R.string.answer_abdragan_1));
        answers.add(resources.getString(R.string.answer_abdragan_2));
        answers.add(resources.getString(R.string.answer_abdragan_3));

        questions.add(new Question(resources.getDrawable(R.drawable.abdragan),
                resources.getString(R.string.question_abdragan),
                resources.getString(R.string.answer_abdragan_1),
                answers));

        answers.clear();


        answers.add(resources.getString(R.string.answer_ajlibati_1));
        answers.add(resources.getString(R.string.answer_ajlibati_2));
        answers.add(resources.getString(R.string.answer_ajlibati_3));

        questions.add(new Question(resources.getDrawable(R.drawable.ajlibati),
                resources.getString(R.string.question_ajlibati),
                resources.getString(R.string.answer_ajlibati_1),
                answers));

        answers.clear();


        answers.add(resources.getString(R.string.answer_ai_1));
        answers.add(resources.getString(R.string.answer_ai_2));
        answers.add(resources.getString(R.string.answer_ai_3));

        questions.add(new Question(resources.getDrawable(R.drawable.ai),
                resources.getString(R.string.question_ai),
                resources.getString(R.string.answer_ai_1),
                answers));

        answers.clear();


        answers.add(resources.getString(R.string.answer_aidanchiki_1));
        answers.add(resources.getString(R.string.answer_aidanchiki_2));
        answers.add(resources.getString(R.string.answer_aidanchiki_3));

        questions.add(new Question(resources.getDrawable(R.drawable.aidanchiki),
                resources.getString(R.string.question_aidanchiki),
                resources.getString(R.string.answer_aidanchiki_1),
                answers));

        answers.clear();


        answers.add(resources.getString(R.string.answer_aleakish_1));
        answers.add(resources.getString(R.string.answer_aleakish_2));
        answers.add(resources.getString(R.string.answer_aleakish_3));

        questions.add(new Question(resources.getDrawable(R.drawable.aleakish),
                resources.getString(R.string.question_aleakish),
                resources.getString(R.string.answer_aleakish_1),
                answers));

        answers.clear();


        answers.add(resources.getString(R.string.answer_andilshina_1));
        answers.add(resources.getString(R.string.answer_andilshina_2));
        answers.add(resources.getString(R.string.answer_andilshina_3));

        questions.add(new Question(resources.getDrawable(R.drawable.andilishina),
                resources.getString(R.string.question_andilshina),
                resources.getString(R.string.answer_andilshina_1),
                answers));

        answers.clear();


        answers.add(resources.getString(R.string.answer_apofegma_1));
        answers.add(resources.getString(R.string.answer_apofegma_2));
        answers.add(resources.getString(R.string.answer_apofegma_3));

        questions.add(new Question(resources.getDrawable(R.drawable.apofegma),
                resources.getString(R.string.question_apofegma),
                resources.getString(R.string.answer_apofegma_1),
                answers));

        answers.clear();


        answers.add(resources.getString(R.string.answer_arhitrav_1));
        answers.add(resources.getString(R.string.answer_arhitrav_2));
        answers.add(resources.getString(R.string.answer_arhitrav_3));

        questions.add(new Question(resources.getDrawable(R.drawable.arhitrav),
                resources.getString(R.string.question_arhitrav),
                resources.getString(R.string.answer_arhitrav_1),
                answers));

        answers.clear();


        answers.add(resources.getString(R.string.answer_asletok_1));
        answers.add(resources.getString(R.string.answer_asletok_2));
        answers.add(resources.getString(R.string.answer_asletok_3));

        questions.add(new Question(resources.getDrawable(R.drawable.asletok),
                resources.getString(R.string.question_asletok),
                resources.getString(R.string.answer_asletok_1),
                answers));

        answers.clear();


        answers.add(resources.getString(R.string.answer_aiukla_1));
        answers.add(resources.getString(R.string.answer_aiukla_2));
        answers.add(resources.getString(R.string.answer_aiukla_3));

        questions.add(new Question(resources.getDrawable(R.drawable.aiukla),
                resources.getString(R.string.question_aiukla),
                resources.getString(R.string.answer_aiukla_1),
                answers));

        answers.clear();


        answers.add(resources.getString(R.string.answer_badrovati_1));
        answers.add(resources.getString(R.string.answer_badrovati_2));
        answers.add(resources.getString(R.string.answer_badrovati_3));

        questions.add(new Question(resources.getDrawable(R.drawable.badrovati),
                resources.getString(R.string.question_badrovati),
                resources.getString(R.string.answer_badrovati_1),
                answers));

        answers.clear();


        answers.add(resources.getString(R.string.answer_baiduje_1));
        answers.add(resources.getString(R.string.answer_baiduje_2));
        answers.add(resources.getString(R.string.answer_baiduje_3));

        questions.add(new Question(resources.getDrawable(R.drawable.baiduje),
                resources.getString(R.string.question_baiduje),
                resources.getString(R.string.answer_baiduje_1),
                answers));

        answers.clear();


        answers.add(resources.getString(R.string.answer_balentreasiti_1));
        answers.add(resources.getString(R.string.answer_balentreasiti_2));
        answers.add(resources.getString(R.string.answer_balentreasiti_3));

        questions.add(new Question(resources.getDrawable(R.drawable.balentreasiti),
                resources.getString(R.string.question_balentreasiti),
                resources.getString(R.string.answer_balentreasiti_1),
                answers));

        answers.clear();


        answers.add(resources.getString(R.string.answer_berenderiti_1));
        answers.add(resources.getString(R.string.answer_berenderiti_2));
        answers.add(resources.getString(R.string.answer_berenderiti_3));

        questions.add(new Question(resources.getDrawable(R.drawable.berenderiti),
                resources.getString(R.string.question_berenderiti),
                resources.getString(R.string.answer_berenderiti_1),
                answers));

        answers.clear();


        answers.add(resources.getString(R.string.answer_bizii_1));
        answers.add(resources.getString(R.string.answer_bizii_2));
        answers.add(resources.getString(R.string.answer_bizii_3));

        questions.add(new Question(resources.getDrawable(R.drawable.bizii),
                resources.getString(R.string.question_bizii),
                resources.getString(R.string.answer_bizii_1),
                answers));

        answers.clear();
    }
}
