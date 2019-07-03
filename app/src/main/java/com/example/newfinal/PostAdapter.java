package com.example.newfinal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private Context mContext;
    private StringBuffer stringBuffer;
    private JSONArray newjarray;



    public PostAdapter(Context context, JSONArray jsonArray){
        mContext=context;
        //stringBuffer= sb;
        newjarray=jsonArray;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View baseView = View.inflate(mContext, R.layout.phone_data,null);
        PostViewHolder postViewHolder=new PostViewHolder(baseView);

        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PostViewHolder holder, final int position) {
        try {
            final JSONObject newobject = newjarray.getJSONObject(position);
            holder.ivname.setText(newobject.getString("name"));
            holder.ivnumber.setText(newobject.getString("number"));
            holder.ivrow.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    new AlertDialog.Builder(mContext)
                            .setTitle("Confirm Message")
                            .setMessage("연락처를 삭제하시겠습니까?")
                            .setIcon(android.R.drawable.ic_menu_save)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Toast.makeText(mContext.getApplicationContext(),"연락처가 삭제되었습니다",Toast.LENGTH_SHORT).show();
                                    newjarray.remove(position);
                                    data.newJSON=newjarray;
                                    notifyDataSetChanged();
                                    notifyItemRemoved(position);
                                }})
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }})
                            .show();
                    //PostAdapter adapter = new PostAdapter(mContext, newjarray);
                    return true;
                }
            });
        }
        catch(JSONException e){
            e.printStackTrace();
        }
    }


    @Override
    public int getItemCount() {
        return newjarray.length();
    }
}