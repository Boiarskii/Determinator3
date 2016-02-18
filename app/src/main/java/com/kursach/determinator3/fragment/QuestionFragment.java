package com.kursach.determinator3.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.kursach.determinator3.Question;
import com.kursach.determinator3.QuestionActivity;
import com.kursach.determinator3.adapter.QuestionFragmentRecyclerViewAdapter;
import com.kursach.determinator3.QuestionLab;
import com.kursach.determinator3.R;

import java.util.UUID;


public class QuestionFragment extends Fragment {

    protected Question question;

    protected TextView questionTV;
    protected RecyclerView recyclerView;
    protected ImageView questionIV;


    public QuestionFragment() {

    }

    public static Fragment newInstance(UUID questionId) {
        Bundle args = new Bundle();
        args.putSerializable(QuestionActivity.EXTRA_QUESTION_ID, questionId);
        QuestionFragment questionFragment = new QuestionFragment();
        questionFragment.setArguments(args);
        return questionFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_question, container, false);

        //Получение списка вопросов
        Question question = QuestionLab.getInstance(getContext()).getQuestion((UUID) getArguments().getSerializable(QuestionActivity.EXTRA_QUESTION_ID));


        questionTV = (TextView) v.findViewById(R.id.question_TV);
        questionTV.setText(question.getQuestion());


        QuestionFragmentRecyclerViewAdapter adapter = new QuestionFragmentRecyclerViewAdapter(question.getAnswers(), question.getMainAnswer());

        recyclerView = (RecyclerView) v.findViewById(R.id.answer_RV);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        questionIV = (ImageView) v.findViewById(R.id.question_IV);
        questionIV.setImageDrawable(question.getImage());
        return v;
    }
}
