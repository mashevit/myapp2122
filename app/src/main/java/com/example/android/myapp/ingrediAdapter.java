package com.example.android.myapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.myapp.database.Dish;
import com.example.android.myapp.database.Mitzrahnames;

import java.util.List;

public class ingrediAdapter extends RecyclerView.Adapter<ingrediAdapter.ingrediAdapterViewHolder> {
    ingrediAdapter.ingrediAdapterOnClickHandler mClickHandler;
    Context mContext;

    int pos1=-1,pos2=-1,pos3=-1;
    int mod=1;
    private List<Mitzrahnames> mDish;

    @NonNull
    @Override
    public ingrediAdapter.ingrediAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        int layoutId=R.layout.ingredi_holder;
        View view = LayoutInflater.from(mContext).inflate(layoutId, parent, false);

        view.setFocusable(true);

        return new ingrediAdapter.ingrediAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ingrediAdapter.ingrediAdapterViewHolder holder, int position) {
        if(mDish!=null&& position<mDish.size()) {
            // int s = mDish == null ? 0 : mDish.size();
            //if (mDish == null && (position == pos1 || position == pos2 || position == pos3)) {
//todo: arrenge here
            holder.myTextView.setText(mDish.get(position).getIngredientname());
     /*        if (s != 0 && mDish != null && (position < s)) {
                int pos = position == 0 ? 0 : position - 1;
                if (pos != 0) {
                    Dish dish = mDish.get(position - 1);
                    String name = dish.getDishname();
                    holder.myTextView.setText(name);
                }
            }*/
        }

        else holder.myTextView.setText("general ");

    }

    public interface ingrediAdapterOnClickHandler {
        void onClick(long date);
    }

    public ingrediAdapter(@NonNull Context context, ingrediAdapter.ingrediAdapterOnClickHandler clickHandler) {
        mContext = context;
        mClickHandler = clickHandler;
        //  mUseTodayLayout = mContext.getResources().getBoolean(R.bool.use_today_layout);
    }




    @Override
    public int getItemCount() {
        return 25;
    }

    class ingrediAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView myTextView;


        ingrediAdapterViewHolder(View itemView) {
            super(itemView);
            myTextView= itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
          /*  int adapterPosition = getAdapterPosition();
            if(mod==1) {pos1=adapterPosition;mod++;}
            else if (mod==2){pos2=adapterPosition;mod++;}
            else if (mod ==3){pos3=adapterPosition;mod=1;}
            //mClickHandler.onClick(adapterPosition);
            notifyDataSetChanged();*/
        }
    }
    public List<Mitzrahnames> getingreds() {
        return mDish;
    }

    /**
     * When data changes, this method updates the list of taskEntries
     * and notifies the adapter to use the new values on it
     */
    public void setingreds(List<Mitzrahnames> Dishes) {
        mDish = Dishes;
        notifyDataSetChanged();
    }
}
