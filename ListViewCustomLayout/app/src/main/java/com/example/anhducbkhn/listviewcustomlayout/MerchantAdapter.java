package com.example.anhducbkhn.listviewcustomlayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by root on 26/04/2016.
 */


public class MerchantAdapter extends ArrayAdapter<String>{

    String[] names = {};
    String[] ages = {};
    String[] images = {};

    Context context;
    LayoutInflater inflater;

    public MerchantAdapter(Context context, String[] names, String[] ages, String[] images) {
        super(context, R.layout.item_layout);

        this.context = context;
        this.names = names;
        this.ages = ages;
        this.images = images;
    }

    public class ViewHolder
    {
        TextView textView1;
        TextView textView2;
        ImageView imgView;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_layout, null);
        }

        final ViewHolder holder = new ViewHolder();

        holder.textView1 = (TextView)convertView.findViewById(R.id.textView1);
        holder.textView2 = (TextView)convertView.findViewById(R.id.textView2);
        holder.imgView = (ImageView)convertView.findViewById(R.id.imgView);

        //Set data
        holder.textView1.setText(names[position]);
        holder.textView2.setText(ages[position]);

        new Thread() {

            public void run(){
                try {
                    URL url = new URL(images[position]);
                    Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    holder.imgView.setImageBitmap(bmp);

                } catch (Exception ex) {
                    Log.e("Error", ex.toString());
                }
            }
        }.start();

        return convertView;
    }


    @Override
    public int getCount() {
        return names.length;
    }
}
