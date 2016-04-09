package com.kursach.determinator3.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kursach.determinator3.InformaticActivity;
import com.kursach.determinator3.InformaticLab;
import com.kursach.determinator3.Question;
import com.kursach.determinator3.QuestionActivity;
import com.kursach.determinator3.QuestionLab;
import com.kursach.determinator3.R;

import java.util.ArrayList;

public class QuestionRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int CODE_RVFRAGMENT = 0;
    private final int CODE_INFORMATICRVFRAGMENT = 1;

    ArrayList<Question> contents;
    int fragmentCode;

    public QuestionRecyclerViewAdapter(ArrayList<Question> contents, int fragmentCode) {
        this.contents = contents;
        //Это необходимо, чтобы знать к какому Activity переходить по клику на вопрос
        this.fragmentCode = fragmentCode;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_card_question, parent, false);
        QuestionViewHolder questionViewHolder = new QuestionViewHolder(view);
        return questionViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        QuestionViewHolder questionViewHolder = (QuestionViewHolder) holder;
        questionViewHolder.imageViewCV.setImageDrawable(contents.get(position).getImage());
        questionViewHolder.textViewCV.setText(contents.get(position).getQuestion());

        ((QuestionViewHolder) holder).cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                //Если fragmentCode - код RecyclerViewFragment, то запускаем QuestionActivity
                if (fragmentCode == CODE_RVFRAGMENT) {
                    intent = new Intent(v.getContext(), QuestionActivity.class);
                    intent.putExtra(QuestionActivity.EXTRA_QUESTION_ID,
                            QuestionLab.getInstance(v.getContext()).getQuestions().get(position).getId());
                } else
                //Иначе InformaticActivity
                {
                    intent = new Intent(v.getContext(), InformaticActivity.class);
                    intent.putExtra(QuestionActivity.EXTRA_QUESTION_ID,
                            InformaticLab.getInstance(v.getContext()).getQuestions().get(position).getId());
                }

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView textViewCV;
        ImageView imageViewCV;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.questionCardView);
            textViewCV = (TextView) itemView.findViewById(R.id.textView_cv);
            imageViewCV = (ImageView) itemView.findViewById(R.id.imageView_cv);
        }


    }
}
