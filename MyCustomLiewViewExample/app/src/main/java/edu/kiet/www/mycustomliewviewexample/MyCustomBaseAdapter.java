package edu.kiet.www.mycustomliewviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class MyCustomBaseAdapter extends BaseAdapter {

    Context context;
    int listofimage[];
    String listofname[];
    LayoutInflater inflater;
    public MyCustomBaseAdapter(Context context, int[] listofimage, String[] listofname) {
        this.context=context;
        this.listofimage=listofimage;
        this.listofname=listofname;
    }

    @Override
    public int getCount() {
        return listofimage.length;
    }

    @Override
    public Object getItem(int i) {
        return listofname[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View myview;
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        myview =inflater.inflate(R.layout.mylistviewlayout,parent,false);
        ImageView im;
        TextView tv;
        im=myview.findViewById(R.id.imageView);
        tv=myview.findViewById(R.id.textView);
        im.setImageResource(listofimage[i]);
        tv.setText(listofname[i]);
        return myview;
    }
}
