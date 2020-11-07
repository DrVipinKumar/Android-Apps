package edu.kiet.www.recyclerviewexample;

import android.content.Context;
import android.content.ReceiverCallNotAllowedException;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    Context context;
    String [] myname;
    int [] myimage;
    public MyRecyclerViewAdapter(Context context, String[] myname, int[] myimage) {
        this.context=context;
        this.myimage=myimage;
        this.myname=myname;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.customrecyclerlayout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyViewHolder holder, final int position) {
        holder.im.setImageResource(myimage[position]);
        holder.tv.setText(myname[position]);
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,myname[position],Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myimage.length;
    }
    class MyViewHolder extends  RecyclerView.ViewHolder{

        ImageView im;
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.myimage);
            tv=itemView.findViewById(R.id.myname);
        }
    }

}
