package com.idoston.adaptivesystem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doston on 12/15/2017.
 */

public class UniversityAdapter extends ArrayAdapter {

    List list = new ArrayList();
    public UniversityAdapter(@NonNull Context context, int resource) {
        super(context, resource);

    }

    public void add(University university){
        list.add(university);
        super.add(university);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {

        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        UniversityHolder universityHolder;
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_university, parent, false);

            universityHolder = new UniversityHolder();

            universityHolder.empty = view.findViewById(R.id.textView0);

            universityHolder.id = view.findViewById(R.id.textView1);
            universityHolder.name = view.findViewById(R.id.textView2);
            universityHolder.ranking = view.findViewById(R.id.textView3);
            universityHolder.fee = view.findViewById(R.id.textView4);
            universityHolder.program = view.findViewById(R.id.textView5);
            universityHolder.city = view.findViewById(R.id.textView6);
            universityHolder.country = view.findViewById(R.id.textView7);
            universityHolder.continent = view.findViewById(R.id.textView8);

            view.setTag(universityHolder);


        } else {
            universityHolder = (UniversityHolder) view.getTag();
        }

        University university = (University)getItem(position);
        universityHolder.id.setText("ID: " + university.getID());
        universityHolder.name.setText("Name: " + university.getName());
        universityHolder.ranking.setText("Ranking: " + university.getRanking());
        universityHolder.fee.setText("Tuition fee: " + university.getTuition());
        universityHolder.program.setText("Study program: " + university.getProgram());
        universityHolder.city.setText("City: " + university.getCity());
        universityHolder.country.setText("Country: " + university.getCountry());
        universityHolder.continent.setText("Continent: " + university.getContinent());

        universityHolder.empty.setText("---- New University -----");

        return view;
    }

    static class UniversityHolder
    {
        TextView id, name, ranking, fee, program, city, country, continent, empty;
    }
}
