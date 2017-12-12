package com.nebras.aidi;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.github.siyamed.shapeimageview.CircularImageView;

import java.util.List;

/**
 * Created by mahmoudkamal on 8/20/17.
 */

public class GeneralAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Object> objectes;


    public GeneralAdapter(Context context, List<Object> objectes, String type, String color) {
        this.context =context;
        this.objectes=objectes;

        setHasStableIds(true);


    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        switch (viewType){

            case Constants.TYPE_JOB:
                return new JobHolder(LayoutInflater.from(context).inflate(R.layout.item_job, parent, false));
            case Constants.TYPE_TOP_GROUPS:
                return new JobHolder(LayoutInflater.from(context).inflate(R.layout.item_top_group, parent, false));

            case Constants.TYPE_CHAT_USER:
                return new ChatUserHolder(LayoutInflater.from(context).inflate(R.layout.item_user_chat, parent, false));

            default:
                    return new JobHolder(LayoutInflater.from(context).inflate(R.layout.item_job, parent, false));

        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)){
            case Constants.TYPE_CHAT_USER:
                User user = (User) objectes.get(position);
                ChatUserHolder chatUserHolder = (ChatUserHolder) holder;
                Glide.with(context).load(user.getImage()).asBitmap().placeholder(R.drawable.placeholder).into(chatUserHolder.imgProfile);
                if(user.isOnline()){
                    chatUserHolder.imgOnline.setBackgroundResource(R.drawable.oval_green);
                }else {
                    chatUserHolder.imgOnline.setBackgroundResource(R.drawable.oval_grey);

                }

                break;


        }



    }

    @Override
    public int getItemCount() {
        return objectes.size();
    }
    @Override
    public long getItemId(int position) {
        return objectes.get(position).hashCode();
    }


    @Override
    public int getItemViewType(int position) {

        if(objectes.get(position) instanceof Job)
            return Constants.TYPE_JOB;
        else if(objectes.get(position) instanceof Group )
            return Constants.TYPE_TOP_GROUPS;
        else if (objectes.get(position) instanceof User)
            return Constants.TYPE_CHAT_USER;


        return Constants.TYPE_JOB;



    }

    public void updateData(List<Object> objects) {
        this.objectes=objects;
        notifyDataSetChanged();
    }




    public class JobHolder extends RecyclerView.ViewHolder {
        //public TextView  tvTitle ,tvTeacherName,tvDescription,tvStarAfter,tvDaysCount,tvDate;
       /// public CircularImageView imgCourse;
       // private View imgOval,layFoter;

        public JobHolder(View view) {
            super(view);
/*

            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            tvTeacherName = (TextView) view.findViewById(R.id.tv_name);
            tvDescription = (TextView) view.findViewById(R.id.tv_description);
            tvStarAfter = (TextView) view.findViewById(R.id.tv_star_after);
            tvDaysCount= (TextView) view.findViewById(R.id.tv_days_count);
            tvDate= (TextView) view.findViewById(R.id.tv_date);

            imgCourse = (CircularImageView) view.findViewById(R.id.img_course);
            imgOval = (View) view.findViewById(R.id.img_oval);
            layFoter = (View) view.findViewById(R.id.lay_course_ad_foter);
*/

        }


    }


    public class GroupHolder extends RecyclerView.ViewHolder {
        //public TextView  tvTitle ,tvTeacherName,tvDescription,tvStarAfter,tvDaysCount,tvDate;
        /// public CircularImageView imgCourse;
        // private View imgOval,layFoter;

        public GroupHolder(View view) {
            super(view);
/*

            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            tvTeacherName = (TextView) view.findViewById(R.id.tv_name);
            tvDescription = (TextView) view.findViewById(R.id.tv_description);
            tvStarAfter = (TextView) view.findViewById(R.id.tv_star_after);
            tvDaysCount= (TextView) view.findViewById(R.id.tv_days_count);
            tvDate= (TextView) view.findViewById(R.id.tv_date);

            imgCourse = (CircularImageView) view.findViewById(R.id.img_course);
            imgOval = (View) view.findViewById(R.id.img_oval);
            layFoter = (View) view.findViewById(R.id.lay_course_ad_foter);
*/

        }


    }



    public class ChatUserHolder extends RecyclerView.ViewHolder {
         public CircularImageView imgProfile;
         private View imgOnline;

        public ChatUserHolder(View view) {
            super(view);



            imgProfile = (CircularImageView) view.findViewById(R.id.img_profile);
            imgOnline = (View) view.findViewById(R.id.img_online);


        }


    }



}
