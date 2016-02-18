package com.kursach.determinator3.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kursach.determinator3.InformaticActivity;
import com.kursach.determinator3.QuestionActivity;
import com.kursach.determinator3.R;
import com.kursach.determinator3.Score;

import java.util.ArrayList;
import java.util.Collections;


public class QuestionFragmentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> answers = new ArrayList<>();
    private String correctAnswer;

    private Score score;

    public QuestionFragmentRecyclerViewAdapter(ArrayList<String> answers, String correctAnswer) {

        //Получение массива ответов
        this.answers.addAll(answers);

        //Получение верного ответа
        this.correctAnswer = correctAnswer;

        //Получение экземпляра класса для ведения счёта
        score = Score.getInstance();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_answer,
                parent, false);
        AnswerViewHolder answerViewHolder = new AnswerViewHolder(view);
        return answerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        AnswerViewHolder answerViewHolder = (AnswerViewHolder) holder;
        answerViewHolder.answerTV.setText(answers.get(position));

        //Назначение слушателя для карточки с ответом
        answerViewHolder.answerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (answers.get(position).equals(correctAnswer)) {
                    ((QuestionActivity) v.getContext()).nextQuestion();
                    score.correctAnswer();
                } else {
                    removeAnswer(position);
                    score.wrongAnswer();
                }

                //Изменение состояния WaveLoadingView
                ((QuestionActivity) v.getContext()).setProgress();
            }
        });
    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    //Удалить вариант в случае неправильного ответа
    public void removeAnswer(int position) {
        answers.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }

    public static class AnswerViewHolder extends RecyclerView.ViewHolder {

        TextView answerTV;

        public AnswerViewHolder(View itemView) {
            super(itemView);
            answerTV = (TextView) itemView.findViewById(R.id.answer_tv);
        }
    }


}
