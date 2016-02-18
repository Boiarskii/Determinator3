package com.kursach.determinator3;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.UUID;


public class InformaticLab {

    private static InformaticLab instance;
    private Context context;
    private ArrayList<Question> questions;

    private InformaticLab(Context context) {
        this.context = context;
        loadQuestions();
    }

    public static InformaticLab getInstance(Context context) {
        if (instance == null) {
            instance = new InformaticLab(context.getApplicationContext());
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

        ArrayList<String> answers = new ArrayList<>();

        questions = new ArrayList<>();

        answers.add(resources.getString(R.string.answer_processor_1));
        answers.add(resources.getString(R.string.answer_processor_2));
        answers.add(resources.getString(R.string.answer_processor_3));

        questions.add(new Question(resources.getDrawable(R.drawable.processor),
                resources.getString(R.string.informatic_processor),
                resources.getString(R.string.answer_processor_1),
                answers));

        answers.clear();

        answers.add(resources.getString(R.string.answer_loop_1));
        answers.add(resources.getString(R.string.answer_loop_2));
        answers.add(resources.getString(R.string.answer_loop_3));

        questions.add(new Question(resources.getDrawable(R.drawable.loop),
                resources.getString(R.string.informatic_loop),
                resources.getString(R.string.answer_loop_1),
                answers));

        answers.clear();

        answers.add(resources.getString(R.string.answer_vector_1));
        answers.add(resources.getString(R.string.answer_vector_2));
        answers.add(resources.getString(R.string.answer_vector_3));

        questions.add(new Question(resources.getDrawable(R.drawable.vector),
                resources.getString(R.string.informatic_vector),
                resources.getString(R.string.answer_vector_1),
                answers));

        answers.clear();

        answers.add(resources.getString(R.string.answer_oop_1));
        answers.add(resources.getString(R.string.answer_oop_2));
        answers.add(resources.getString(R.string.answer_oop_3));

        questions.add(new Question(resources.getDrawable(R.drawable.oop),
                resources.getString(R.string.informatic_oop),
                resources.getString(R.string.answer_oop_1),
                answers));

        answers.clear();

        answers.add(resources.getString(R.string.answer_pascal_1));
        answers.add(resources.getString(R.string.answer_pascal_2));
        answers.add(resources.getString(R.string.answer_pascal_3));

        questions.add(new Question(resources.getDrawable(R.drawable.pascal),
                resources.getString(R.string.informatic_pascal),
                resources.getString(R.string.answer_pascal_1),
                answers));

        answers.clear();

        answers.add(resources.getString(R.string.answer_algoritm_1));
        answers.add(resources.getString(R.string.answer_algoritm_2));
        answers.add(resources.getString(R.string.answer_algoritm_3));

        questions.add(new Question(resources.getDrawable(R.drawable.algoritm),
                resources.getString(R.string.informatic_algoritm),
                resources.getString(R.string.answer_algoritm_1),
                answers));

        answers.clear();

        answers.add(resources.getString(R.string.answer_ooplang_1));
        answers.add(resources.getString(R.string.answer_ooplang_2));
        answers.add(resources.getString(R.string.answer_ooplang_3));

        questions.add(new Question(resources.getDrawable(R.drawable.ooplang),
                resources.getString(R.string.informatic_ooplang),
                resources.getString(R.string.answer_ooplang_1),
                answers));

        answers.clear();

        answers.add(resources.getString(R.string.answer_array_1));
        answers.add(resources.getString(R.string.answer_array_2));
        answers.add(resources.getString(R.string.answer_array_3));

        questions.add(new Question(resources.getDrawable(R.drawable.array),
                resources.getString(R.string.informatic_array),
                resources.getString(R.string.answer_array_1),
                answers));

        answers.clear();

        answers.add(resources.getString(R.string.answer_assembler_1));
        answers.add(resources.getString(R.string.answer_assembler_2));
        answers.add(resources.getString(R.string.answer_assembler_3));

        questions.add(new Question(resources.getDrawable(R.drawable.assembler),
                resources.getString(R.string.informatic_assembler),
                resources.getString(R.string.answer_assembler_1),
                answers));

        answers.clear();

        answers.add(resources.getString(R.string.answer_coder_1));
        answers.add(resources.getString(R.string.answer_coder_2));
        answers.add(resources.getString(R.string.answer_coder_3));

        questions.add(new Question(resources.getDrawable(R.drawable.coder),
                resources.getString(R.string.informatic_coder),
                resources.getString(R.string.answer_coder_1),
                answers));

        answers.clear();
    }
}
