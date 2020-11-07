package edu.kiet.www.myrecyclerexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Integer [] getimage;
    String[] getname;
    Context context;
    public RecyclerViewAdapter(Context context, Integer[] getimage, String[] getname) {
        this.context=context;
        this.getimage=getimage;
        this.getname=getname;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.customlayout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.imageView.setImageResource(getimage[position]);
        holder.name.setText(getname[position]);
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,getname[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return getimage.length;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name;
        CardView cv;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.imageview);
            name=itemView.findViewById(R.id.txtname);
            cv=itemView.findViewById(R.id.mycard);
        }
    }
}
