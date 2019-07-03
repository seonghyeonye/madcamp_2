package com.example.newfinal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{

    private Context context;

    public Integer[] images = {
            R.mipmap.img1,R.mipmap.img2, R.mipmap.img3, R.mipmap.img4,
            R.mipmap.img5, R.mipmap.img6, R.mipmap.img7, R.mipmap.img8,
            R.mipmap.img9, R.mipmap.img10, R.mipmap.img11, R.mipmap.img12,
            R.mipmap.img13, R.mipmap.img14, R.mipmap.img15, R.mipmap.img16,
            R.mipmap.img17, R.mipmap.img18, R.mipmap.img19, R.mipmap.img20
    };

    public ImageAdapter(Context c){
        context = c;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(350, 450));
        return imageView;
    }
}
