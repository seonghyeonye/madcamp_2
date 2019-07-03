package com.example.newfinal;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

public class PostViewHolder extends RecyclerView.ViewHolder {

    public TextView ivname, ivnumber;
    public TableRow ivrow;

    public PostViewHolder(View itemView) {
        super(itemView);
        ivname= itemView.findViewById(R.id.name);
        ivnumber= itemView.findViewById(R.id.phonenumbers);
        ivrow=itemView.findViewById(R.id.rowselect);
    }
}

