package com.example.anhducbkhn.showimagefromurl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imgView);

        new Thread(){
            public void run() {
                try {

                    URL url = new URL("http://booknhanh.com/themes/newtheme/assets/images/logo-bn-ns.png");
                    bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    handler.sendMessage(handler.obtainMessage(0));
                } catch (Exception ex) {
                    Log.e("Error ", ex.toString());
                }
            }
        }.start();
    }

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0:
                    if(bmp!=null) imageView.setImageBitmap(bmp);
                    break;
                default:
                    break;
            }
        };
    };
}
