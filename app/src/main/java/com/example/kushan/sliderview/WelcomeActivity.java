package com.example.kushan.sliderview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mPager;
    private int[] layouts = {R.layout.movie_layout,R.layout.train_layout,
            R.layout.flight_layout,R.layout.bus_layout};
    private MpagerAdapter mpagerAdapter;

    private LinearLayout dotLayout;
    private ImageView[] dots;
    private Button btnnext,btnskip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT>=19){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }


        setContentView(R.layout.activity_welcome);

        mPager = (ViewPager)findViewById(R.id.viewPager);
        mpagerAdapter = new MpagerAdapter(layouts,this);
        mPager.setAdapter(mpagerAdapter);

        dotLayout = (LinearLayout)findViewById(R.id.dotLayouts);
        btnnext = (Button)findViewById(R.id.btnnext);
        btnskip = (Button)findViewById(R.id.btnskip);
        btnnext.setOnClickListener(this);
        btnskip.setOnClickListener(this);
        createDots(0);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void createDots(int currentPosition){
        if(dotLayout!=null)
            dotLayout.removeAllViews();

        dots =new ImageView[layouts.length];

        for(int i=0;i<layouts.length;i++){
            dots[i] =new ImageView(this);
            if(i==currentPosition){
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
            }
            else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.default_dots));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            params.setMargins(4,0,4,0);
            dotLayout.addView(dots[i],params);
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case  R.id.btnnext:
                         break;

            case  R.id.btnskip:
                    loadHome();
                         break;

        }

    }

    private void loadHome(){
        startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
        finish();
    }

}
