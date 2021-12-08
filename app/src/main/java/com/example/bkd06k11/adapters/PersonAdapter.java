package com.example.bkd06k11.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bkd06k11.R;
import com.example.bkd06k11.domains.Person;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class PersonAdapter extends ArrayAdapter<Person> {
    ArrayList<Person> persons;

    public PersonAdapter(@NonNull Context context, ArrayList<Person> inputPersons) {
        super(context, 0);
        this.persons = inputPersons;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getViewItem(position, convertView, parent);
    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getViewItem(position, convertView, parent);
    }

    @NonNull
    private View getViewItem(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View cvView = convertView;
        if (cvView == null) {
            cvView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView tvName = cvView.findViewById(R.id.tvName);
        TextView tvAge = cvView.findViewById(R.id.tvAge);
        Person person = persons.get(position);
        tvName.setText(person.getName());
        tvAge.setText(person.getAge());
        return cvView;
    }

    @Override
    public int getCount() {
        return this.persons.size();
    }
}
