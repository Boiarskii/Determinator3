package com.kursach.determinator3.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;
import com.kursach.determinator3.Question;
import com.kursach.determinator3.QuestionLab;
import com.kursach.determinator3.adapter.QuestionRecyclerViewAdapter;
import com.kursach.determinator3.R;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private ArrayList<Question> contentItems = new ArrayList<>();

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //Получение вопросов
        contentItems = QuestionLab.getInstance(getContext()).getQuestions();

        adapter = new RecyclerViewMaterialAdapter(new QuestionRecyclerViewAdapter(contentItems, 0));
        recyclerView.setAdapter(adapter);

        //Подключение RecyclerView к MaterialViewPager
        MaterialViewPagerHelper.registerRecyclerView(getActivity(), recyclerView, null);

    }
}
