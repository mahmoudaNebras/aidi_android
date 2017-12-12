package com.nebras.aidi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pixelcan.inkpageindicator.InkPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahmoudkamal on 11/5/17.
 */

public class IntroActivity extends AppCompatActivity {
    private ViewPager pager;
    private InkPageIndicator indicator;
    private Button btnSkip,btnNext,btnJoin;
    private List<Intro> intros = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        intros.add(new Intro("Create New Jobs","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum",R.drawable.ic_logo));
        intros.add(new Intro("join existing jobs","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum",R.drawable.ic_logo));
        intros.add(new Intro("Result","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum",R.drawable.ic_logo));

        pager = (ViewPager) findViewById(R.id.pager);
        indicator = (InkPageIndicator) findViewById(R.id.indicator);
        btnJoin = (Button)findViewById(R.id.btn_join);
        btnNext = (Button)findViewById(R.id.btn_next);
        btnSkip = (Button)findViewById(R.id.btn_skip);

        pager.setAdapter(new IntroPagerIndicator(this,intros));
        indicator.setViewPager(pager);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==2){
                    btnJoin.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.GONE);
                    btnSkip.setVisibility(View.GONE);
                }else {
                    btnJoin.setVisibility(View.GONE);
                    btnNext.setVisibility(View.VISIBLE);
                    btnSkip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }


    public void btnNext(View view) {
        if(pager!=null && pager.getCurrentItem()<intros.size()){
            pager.setCurrentItem(pager.getCurrentItem()+1);
        }
    }

    public void btnSkip(View view) {
       startActivity(new Intent(this,MainActivity.class));
    }


    public void setBtnJoin(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
