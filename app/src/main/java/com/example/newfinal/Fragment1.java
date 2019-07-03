package com.example.newfinal;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Fragment1 extends Fragment {

    RecyclerView recyclerView;

    Context context;
    OnTabItemSelectedListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;

        if (context instanceof OnTabItemSelectedListener) {
            listener = (OnTabItemSelectedListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        if (context != null) {
            context = null;
            listener = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        initUI(rootView);

        return rootView;
    }


    private void initUI(ViewGroup rootView) {


        recyclerView = rootView.findViewById(R.id.plant_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        //LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        //recyclerView.setLayoutManager(layoutManager);
        StringBuffer sb = new StringBuffer();
        //ArrayList<postItem> listItem= new ArrayList<>();
        //String str="[{'name':'NAME','number':'NUMBER'},"+"{'name':'mom','number':'010-2322-2321'},"+"{'name':'dad','number':'010-1111-2222'},"+"{'name':'kim','number':'010-1111-2222'},"+"{'name':'lee','number':'010-1234-5678'}]";
        //JSONArray jarray= new JSONArray("[{'name':'NAME','number':'NUMBER'},"+"{'name':'mom','number':'010-2322-2321'},"+"{'name':'dad','number':'010-1111-2222'},"+"{'name':'kim','number':'010-1111-2222'},"+"{'name':'lee','number':'010-1234-5678'}]");
        try {
            JSONArray jarray= data.newJSON;
            System.out.println(jarray);
            PostAdapter adapter = new PostAdapter(context, jarray);
            recyclerView.setAdapter(adapter);
            for(int i=0; i < jarray.length(); i++){
                JSONObject jObject= jarray.getJSONObject(i);
                String name = jObject.getString("name");
                String number = jObject.getString("number");
                sb.append("NAME:"+name+ "PHONE NB:"+number+"\n");
                // ArrayList<String> newarray= new ArrayList<>() ;
            }
            //recycle.setRecycledViewPool(sb.toString());
            //tv.setText(sb.toString());

        }
        catch(JSONException e){
            e.printStackTrace();
        }

    }

}
