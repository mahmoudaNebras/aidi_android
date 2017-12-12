package com.nebras.aidi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mahmoudkamal on 8/29/17.
 */

public class ChatFragment extends Fragment {

    private RecyclerView rcChatUsers,rcChats;

    private LinearLayoutManager hLinearLayoutManager,vLinearLayoutManager;
    private List<Object> chats = new ArrayList<>();
    private ChatAdapter chatsAdapter;
    private GeneralAdapter usersAdapter;
    private List<Object> users = new ArrayList<>();
    private EditText etMessage;
    private ImageButton btnSend,btnEmojs;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);




    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_chat,container,false);
       rcChatUsers = (RecyclerView) view.findViewById(R.id.rc_chat_users);
       rcChats = (RecyclerView) view.findViewById(R.id.rc_chat);
       btnEmojs = (ImageButton) view.findViewById(R.id.btn_smiles);
       btnSend = (ImageButton) view.findViewById(R.id.btn_send);
       etMessage = (EditText) view.findViewById(R.id.et_message);


       etMessage.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               if(charSequence.length()>0){
                   btnSend.setEnabled(true);
                   btnSend.setAlpha(1f);
               }else {
                   btnSend.setEnabled(false);
                   btnSend.setAlpha(0.6f);

               }
           }

           @Override
           public void afterTextChanged(Editable editable) {

           }
       });
       btnSend.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(etMessage.getText().toString().length() == 0){
                   Utils.showError(getActivity(),"You Must Type A Message ");
                   return;
               }

               sendMessage(etMessage.getText().toString());
               etMessage.setText("");

           }
       });

        btnSend.setEnabled(false);
        btnSend.setAlpha(0.6f);


        hLinearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true);
       vLinearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
       rcChatUsers.setLayoutManager(hLinearLayoutManager);
       rcChats.setLayoutManager(vLinearLayoutManager);
       rcChats.setHasFixedSize(true);
        users.add(new User("test","https://www.gannett-cdn.com/-mm-/1bc09ac8001ac5cd3ffef4723dba6007dbc8aeda/c=72-0-1947-2500&r=537&c=0-0-534-712/local/-/media/2016/08/10/GreatFalls/B9323321437Z.1_20160810182558_000_GFFFANB82.1-0.jpg",false));
        users.add(new User("test","http://www.mba.hec.edu/var/hec_mba/storage/images/student-life/student-profiles/varad-deshpande/358497-2-eng-GB/Varad-Deshpande_profile_image-HEC-Paris-MBA.jpg",false));
        users.add(new User("test","https://thefederalist.com/wp-content/uploads/2013/12/McMorris.jpg",true));
        users.add(new User("test","https://trevorastonphotography.co.uk/wp-content/gallery/linkedin-profile-photo-teddington-richmond-kingston-surrey/LinkedIn-profile-photo-Teddington-Richmond-Kingston-Surrey-3205.jpg",false));
        users.add(new User("test","http://www.qygjxz.com/data/out/190/6179593-profile-pics.jpg",true));
        chats.add(new ChatItem("hi, Whatsup!",Utils.getCurrentTimeString(),"text"));
        chats.add(new ChatItem("we will do it today!",Utils.getCurrentTimeString(),"text"));
        chats.add(new ChatItem("test test test test ",Utils.getCurrentTimeString(),"text"));



        updateAdapters();




       return view;
    }

    private void sendMessage(String s) {
        chats.add(new ChatItem(s,Utils.getCurrentTimeString(),"text"));
        chatsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void updateAdapters(){


        if(chatsAdapter==null) {
            chatsAdapter = new ChatAdapter(getActivity(), chats, "", "");
            rcChats.setAdapter(chatsAdapter);
        }else {
            chatsAdapter.notifyDataSetChanged();
        }

        if(usersAdapter==null) {
            usersAdapter = new GeneralAdapter(getActivity(), users, "", "");
            rcChatUsers.setAdapter(usersAdapter);
        }else {
            usersAdapter.notifyDataSetChanged();
        }

    }



}
