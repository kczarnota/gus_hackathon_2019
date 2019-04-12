package com.example.konrad.gus_hackathon_2019;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.konrad.gus_hackathon_2019.databinding.ActivityRankingBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RankingActivity extends AppCompatActivity {

    ArrayList<Pair<String, Integer>> mListItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRankingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_ranking);

        setTitle("Ranking");
        mListItems.add(new Pair<>("Tomek", 20));
        mListItems.add(new Pair<>("Marek", 100));

        Collections.sort(mListItems, new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                return (o2.second - o1.second);
            }
        });

        binding.rankingList.setAdapter(new ListAdapter(this, R.layout.row_layout, mListItems));
    }

    public class ListAdapter extends ArrayAdapter<Pair<String, Integer>> {

        private int resourceLayout;
        private Context mContext;

        public ListAdapter(Context context, int resource, List<Pair<String, Integer>> items) {
            super(context, resource, items);
            this.resourceLayout = resource;
            this.mContext = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(mContext);
                v = vi.inflate(resourceLayout, null);
            }

            Pair<String, Integer> p = getItem(position);
            if (p != null) {
                TextView tt1 = v.findViewById(R.id.textView);
                TextView tt2 = v.findViewById(R.id.textView2);

                if (tt1 != null) {
                    tt1.setText(p.first);
                }

                if (tt2 != null) {
                    tt2.setText(p.second.toString());
                }
            }

            return v;
        }
    }
}
