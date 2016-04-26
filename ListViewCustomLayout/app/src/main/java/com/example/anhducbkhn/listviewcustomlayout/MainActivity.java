package com.example.anhducbkhn.listviewcustomlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] names = {"One", "Two", "Free", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] ages = {"11", "10", "23", "44", "55", "77", "88", "00", "99"};
    String[] images = {
            "http://booknhanh.com/themes/newtheme/assets/images/logo-bn-ns.png",
            "http://booknhanh.com/themes/newtheme/assets/images/logo-bn-ns.png",
            "http://booknhanh.com/themes/newtheme/assets/images/logo-bn-ns.png",
            "http://booknhanh.com/themes/newtheme/assets/images/logo-bn-ns.png",
            "http://booknhanh.com/themes/newtheme/assets/images/logo-bn-ns.png",
            "http://booknhanh.com/themes/newtheme/assets/images/logo-bn-ns.png",
            "http://booknhanh.com/themes/newtheme/assets/images/logo-bn-ns.png",
            "http://booknhanh.com/themes/newtheme/assets/images/logo-bn-ns.png",
            "http://booknhanh.com/themes/newtheme/assets/images/logo-bn-ns.png",
    };

    MerchantAdapter merchantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.lv);
        merchantAdapter = new MerchantAdapter(MainActivity.this, names, ages, images);

        listView.setAdapter(merchantAdapter);
    }
}
