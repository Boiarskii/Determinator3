package com.kursach.determinator3;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import com.kursach.determinator3.fragment.QuestionFragment;

import java.util.ArrayList;
import java.util.UUID;

import me.itangqi.waveloadingview.WaveLoadingView;

public class QuestionActivity extends AppCompatActivity {

    public static final String EXTRA_QUESTION_ID = "id";

    protected ViewPager viewPager;
    protected ArrayList<Question> questions;

    protected WaveLoadingView waveLoadingView;

    protected Score score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        setSupportActionBar((Toolbar) findViewById(R.id.my_awesome_toolbar));


        //Получение всех вопросов
        questions = QuestionLab.getInstance(this).getQuestions();

        viewPager = (ViewPager) findViewById(R.id.container);
        wireViewPager();
        setCurrentQuestion();

        score = Score.getInstance();

        waveLoadingView = (WaveLoadingView) findViewById(R.id.waveLoadingView);
        setProgress();

    }

    //Назначение адаптера, описание работы ViewPager'а
    protected void wireViewPager() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Question question = questions.get(position);
                return QuestionFragment.newInstance(question.getId());
            }

            @Override
            public int getCount() {
                return questions.size();
            }
        });
    }

    //назначение текущего фрагмента для ViewPager'а
    protected void setCurrentQuestion() {
        UUID questionId = (UUID) getIntent().getSerializableExtra(EXTRA_QUESTION_ID);
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getId().equals(questionId)) {
                viewPager.setCurrentItem(i);
            }
        }
    }

    public void nextQuestion() {
        if (viewPager.getCurrentItem() + 1 < viewPager.getAdapter().getCount())
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        else {
            finish();
        }

    }

    //Изменение значения у WaveLoadingView
    public void setProgress() {
        waveLoadingView.setProgressValue(score.getWrongPercent());
        waveLoadingView.setCenterTitle(score.getCorrectPercent() + "%");
    }

    @Override
    protected void onDestroy() {
        //сброс очков
        score.resetScore();
        super.onDestroy();
    }
}
