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
import com.kursach.determinator3.InformaticLab;
import com.kursach.determinator3.Question;
import com.kursach.determinator3.R;
import com.kursach.determinator3.adapter.QuestionRecyclerViewAdapter;

import java.util.ArrayList;


public class InformaticRecyclerViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private ArrayList<Question> contentItems = new ArrayList<>();

    public static InformaticRecyclerViewFragment newInstance() {
        return new InformaticRecyclerViewFragment();
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
        contentItems = InformaticLab.getInstance(getContext()).getQuestions();

        adapter = new RecyclerViewMaterialAdapter(new QuestionRecyclerViewAdapter(contentItems, 1));
        recyclerView.setAdapter(adapter);

        //Подключение RecyclerView к MaterialViewPager
        MaterialViewPagerHelper.registerRecyclerView(getActivity(), recyclerView, null);

    }

}
