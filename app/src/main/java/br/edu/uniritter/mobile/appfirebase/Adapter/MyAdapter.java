package br.edu.uniritter.mobile.appfirebase.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.edu.uniritter.mobile.appfirebase.R;
import br.edu.uniritter.mobile.appfirebase.User;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<User> userArrayList;

    public MyAdapter(Context context) {
        this.context = context;
        this.userArrayList = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        User user = userArrayList.get(position);

        holder.firstName.setText(user.firstName);
        holder.lastName.setText(user.lastName);
        holder.Age.setText(String.valueOf(user.age));

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView firstName, lastName, Age;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById((R.id.tvfirstName));
            lastName = itemView.findViewById((R.id.tvlastName));
            Age = itemView.findViewById((R.id.tvage));

        }
    }
    public void addItem(User user){
        userArrayList.add(user);
        this.notifyDataSetChanged();
    }
}
