package com.shiva.timetablemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import com.shiva.timetablemanager.db.Subjects;

import java.util.List;


public class TimetableEditorSubject extends ArrayAdapter<Subjects>{

    private LayoutInflater inflater;
    private int resource;
    private Context c;

    public TimetableEditorSubject(Context context, int resource, List<Subjects> objects) {
        super(context, resource, objects);
        this.c = context;
        this.resource = resource;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(resource, null);
        return v;
    }
}
