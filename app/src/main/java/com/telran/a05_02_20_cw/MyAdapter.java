package com.telran.a05_02_20_cw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Person> list;

    public MyAdapter() {
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Person("Name " + i, "Phone " + i, "email " + i));
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.my_row, parent,false);
        }
        Person p = list.get(position);
        TextView nameTxt = convertView.findViewById(R.id.nameTxt);
        TextView phoneTxt = convertView.findViewById(R.id.phoneTxt);
        nameTxt.setText(p.name);
        phoneTxt.setText(p.phone);
        return convertView;
    }


    public void add(Person p){
        list.add(1,p);
        notifyDataSetChanged();
    }

    public void remove(){
        list.remove(3);
        notifyDataSetChanged();
    }
}
