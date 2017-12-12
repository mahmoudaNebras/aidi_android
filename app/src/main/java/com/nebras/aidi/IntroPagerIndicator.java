package com.nebras.aidi;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mahmoudkamal on 11/5/17.
 */

public class IntroPagerIndicator extends PagerAdapter {
    private List<Intro> intros;
    private Context context;

    public IntroPagerIndicator(Context context, List<Intro> intros) {
        this.context=context;
        this.intros=intros;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_step_1,container,false);
        Intro intro =intros.get(position);
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_step_title);
        TextView tvDescription = (TextView) view.findViewById(R.id.tv_step_description);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_step);
        imageView.setImageResource(intro.getImage());
        tvDescription.setText(intro.getDescriptiopn());
        tvTitle.setText(intro.getTitle());

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return intros.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
