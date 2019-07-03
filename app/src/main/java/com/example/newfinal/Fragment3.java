package com.example.newfinal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class Fragment3 extends Fragment {

    Context context;
    OnTabItemSelectedListener listener;
    ImageView imageViewFood;
    Button selectbutton;
    ImageView selectbutton2;
    Button editbutton;
    Random rng = new Random();
    ArrayList<String> mSelectedItems= data.menu;
    ArrayList<Integer> selectedimage= data.myList;

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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);

        initUI(rootView);

        return rootView;
    }


    private void initUI(final ViewGroup rootView) {
        imageViewFood = rootView.findViewById(R.id.image_food);
        selectbutton = rootView.findViewById(R.id.main_button);
        //imageViewFood.setOnClickListener(new View.OnClickListener(){
        selectbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                selectbutton.setVisibility(View.GONE);
                selectbutton2 = rootView.findViewById(R.id.retry);
                imageViewFood.setImageResource(R.drawable.retry);
                selectbutton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        rollDice(rootView);
                    }
                });
                rollDice(rootView);
            }

        });

        editbutton = rootView.findViewById(R.id.edit);
        editbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                final String menulist[] = data.menulist;
                final int imglist[] = data.imgs;
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
                dialogBuilder.setTitle("Select Food List");
                dialogBuilder.setMultiChoiceItems(menulist, data.checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                                System.out.println(which);
                                if (isChecked) {
                                    System.out.println();
                                    mSelectedItems.add(menulist[which]);
                                    selectedimage.add(data.imgs[which]);
                                } else if (mSelectedItems.contains(menulist[which])) {
                                    mSelectedItems.remove(mSelectedItems.indexOf(menulist[which]));
                                    selectedimage.remove(selectedimage.indexOf(imglist[which]));
                                }
                            }
                        }
                );
                dialogBuilder.setPositiveButton("Done", null);
                AlertDialog dialog =dialogBuilder.create();
                dialog.show();
            }
        });
    }

    private void display(Toast toast){
        toast.setGravity(Gravity.CENTER,0,80);
        ViewGroup view = (ViewGroup) toast.getView();
        view.setBackgroundColor(Color.rgb(222, 123, 93));
        TextView messageText = (TextView) view.getChildAt(0);
        messageText.setTextSize(35);
        toast.show();
    }

    private void rollDice(ViewGroup rootView) {
        int randomNumber = rng.nextInt(mSelectedItems.size())+1;
        Toast menu = Toast.makeText(context.getApplicationContext(), "Today is " + mSelectedItems.get(randomNumber-1) + "!", Toast.LENGTH_SHORT);
        display(menu);
        imageViewFood.setImageResource(selectedimage.get(randomNumber-1));
        System.out.println(randomNumber);
        //imageViewFood.setImageResource(data.imgs[randomNumber-1]);}
    }
}