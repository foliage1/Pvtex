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
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class UsersclosedAdaptersub extends
        RecyclerView.Adapter<UsersclosedAdaptersub.UserViewHolder> {

    private List<User_closed_sub> usersList;

    private static Context context;
    public UsersclosedAdaptersub(Context mContext, List<User_closed_sub> users) {
        this.context = mContext;
        this.usersList = users;

    }


    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.users_row_closed_sub, null);

        // create UserViewHolder

        UserViewHolder userViewHolder = new UserViewHolder(itemLayoutView);

        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder userViewHolder, int position) {

        User_closed_sub singleUser = usersList.get(position);

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

        public User_closed_sub user;

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

                                    int i=Integer.parseInt(user.getCount());
                    if(i>0) {
                        Intent intent = new Intent(context.getApplicationContext(), Homesubinner.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("STRING_I_NEED", user.getFirstName());
                        context.startActivity(intent);
                    }
                    else
                    {
                        Intent intent = new Intent(context.getApplicationContext(), Homeproduct.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("STRING_I_NEED", user.getFirstName());
                        context.startActivity(intent);

                    }





                }
            });


        }

    }


}