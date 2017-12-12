package com.nebras.aidi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.siyamed.shapeimageview.CircularImageView;

import java.util.List;

/**
 * Created by mahmoudkamal on 8/20/17.
 */

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Object> objectes;


    public ChatAdapter(Context context, List<Object> objectes, String type, String color) {
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

            case Constants.TYPE_CHAT_LEFT:
                return new ChatHolder(LayoutInflater.from(context).inflate(R.layout.chats_item_left, parent, false));
            case Constants.TYPE_CHAT_RIGHT:
                return new ChatHolder(LayoutInflater.from(context).inflate(R.layout.chats_item_right, parent, false));

                default:
                    return new ChatHolder(LayoutInflater.from(context).inflate(R.layout.chats_item_left, parent, false));

        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        ChatItem chatItem = (ChatItem) objectes.get(position);

        ChatHolder chatHolder = (ChatHolder) holder;
        chatHolder.tvMessage.setText(chatItem.getMessage());
        chatHolder.tvDate.setText(Utils.getDurationfromNow(chatItem.getTimestamp()));




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

        if(position%2==0)
            return Constants.TYPE_CHAT_LEFT;
        else
            return Constants.TYPE_CHAT_RIGHT;




    }

    public void updateData(List<Object> objects) {
        this.objectes=objects;
        notifyDataSetChanged();
    }






    public class ChatHolder extends RecyclerView.ViewHolder {
        public TextView tvMessage ,tvDate;
         public CircularImageView imgProfile;
         //private View imgOval,layFoter;

        public ChatHolder(View view) {
            super(view);

            tvMessage = (TextView) view.findViewById(R.id.tv_message);
            tvDate = (TextView) view.findViewById(R.id.tv_date);
            imgProfile = (CircularImageView) view.findViewById(R.id.img_profile);



        }


    }


}
