package com.kursach.determinator3;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.kursach.determinator3.fragment.InformaticFragment;
import com.kursach.determinator3.fragment.QuestionFragment;

import java.util.ArrayList;
import java.util.UUID;

import me.itangqi.waveloadingview.WaveLoadingView;

public class InformaticActivity extends QuestionActivity {

    public static final String EXTRA_QUESTION_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        setSupportActionBar((Toolbar) findViewById(R.id.my_awesome_toolbar));

        //получение вопросов
        questions = InformaticLab.getInstance(this).getQuestions();

        viewPager = (ViewPager) findViewById(R.id.container);
        wireViewPager();
        setCurrentQuestion();

        score = Score.getInstance();

        waveLoadingView = (WaveLoadingView) findViewById(R.id.waveLoadingView);
        setProgress();

    }

    //Назначение адаптера, описание работы ViewPager'а
    @Override
    protected void wireViewPager() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Question question = questions.get(position);
                return InformaticFragment.newInstance(question.getId());
            }

            @Override
            public int getCount() {
                return questions.size();
            }
        });
    }
}
