package com.design.ws.pinkesh;

/**
 * Created by praveen on 6/29/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;


public class UsersclosedAdapter extends
        RecyclerView.Adapter<UsersclosedAdapter.UserViewHolder> {

    private List<User_closed> usersList;

    private static Context context;

    public UsersclosedAdapter(Context mContext, List<User_closed> users) {
        this.context = mContext;
        this.usersList = users;

    }


    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.users_row_closed, null);

        // create UserViewHolder

        UserViewHolder userViewHolder = new UserViewHolder(itemLayoutView);

        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder userViewHolder, int position) {

        User_closed singleUser = usersList.get(position);

        userViewHolder.user = singleUser;

        userViewHolder.txt_name.setText(singleUser.getFirstName());

      /*  userViewHolder.txt_Bitprice.setText(singleUser.getPhone());
        userViewHolder.txt_mrp.setText(singleUser.getEmailId());

        userViewHolder.txt_cell.setText(usersList.get(position).getCell());

        // Loads the picture
        Picasso.with(context).load(singleUser.getLastName()).into(userViewHolder.img_photo);*/


    }

    // Returns the size
    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        public TextView txt_name;
       /* public TextView txt_cell;
        public TextView txt_Bitprice;
        public TextView txt_mrp;

        public ImageView img_photo;*/

        public User_closed user;

        public UserViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            txt_name = (TextView) itemLayoutView.findViewById(R.id.txt_name);
/*

            txt_cell = (TextView) itemLayoutView.findViewById(R.id.textView7);

            txt_Bitprice = (TextView) itemLayoutView.findViewById(R.id.textView3);

            txt_mrp = (TextView) itemLayoutView.findViewById(R.id.textView5);


            img_photo = (ImageView) itemLayoutView.findViewById(R.id.img_photo);
*/

            itemLayoutView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                      Toast.makeText(view.getContext(), user.getFirstName() + " " + user.getFirstName(), Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(context.getApplicationContext(),Homesub.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("STRING_I_NEED", user.getFirstName());
                    context.startActivity(intent);


                }
            });


        }

    }


}