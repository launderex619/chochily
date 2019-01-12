package com.carcavaz.chochilyapp.adapters;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.carcavaz.chochilyapp.R;
import com.carcavaz.chochilyapp.models.PersonalHistoryModel;
import com.carcavaz.chochilyapp.models.PersonalModel;
import com.squareup.picasso.Picasso;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PersonalFragmentAdapter extends RecyclerView.Adapter<PersonalFragmentAdapter.PersonalViewHolder> {

    JSONArray personalModels;

    private int resource;
    private Activity activity;


    public PersonalFragmentAdapter(JSONArray Personals, int resource, Activity activity) {
        this.personalModels = Personals;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PersonalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PersonalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonalViewHolder holder, int position) {
        try {
            JSONObject personal = personalModels.getJSONObject(position);
            PersonalModel personalModel = new PersonalModel(
                    personal.getString("Id"),
                    personal.getString("ImageSrc"),
                    personal.getString("Nombre"),
                    personal.getString("Codigo"),
                    personal.getString("Correo"));

            if(position % 2 == 0)
                holder.personalCard.setCardBackgroundColor(activity.getResources().getColor(R.color.color_orange_dark));
            else
                holder.personalCard.setCardBackgroundColor(activity.getResources().getColor(R.color.color_orange));

            Picasso.get().load(personalModel.getPictureSrc()).into(holder.personalImage);
            holder.usernameCard.setText(personalModel.getUserName());
            holder.personalMovimiento.setText("Entrada: ");
            holder.personalMovimientoTime.setText("5:15 pm");
            // PersonalHistoryModel personalHistoryModel = personalHistoryModels.get(position);


        } catch (JSONException e) {
            e.printStackTrace();
        }



        //modificar para mostrar la informacion
        /*
        holder.options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);
                //transiciones de salida
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity, v, activity.getString(R.string.transitionname_picture)).toBundle());
                }
                else{
                    activity.startActivity(intent);
                }
            }
        });
        */
    }

    @Override
    public int getItemCount() {
        return personalModels.length();
    }


    public class PersonalViewHolder extends RecyclerView.ViewHolder{

        private CardView personalCard;
        private ImageView personalImage;
        private TextView usernameCard;
        private TextView personalMovimiento;
        private TextView personalMovimientoTime;
        private ImageView options;
        private ArrayList<PersonalHistoryModel> personalHistoryModels;

        public PersonalViewHolder(View itemView) {
            super(itemView);

            personalCard = (CardView) itemView.findViewById(R.id.start_personal_cardview);
            personalImage = (ImageView) itemView.findViewById(R.id.start_personal_profile_image);
            usernameCard = (TextView) itemView.findViewById(R.id.item_personal_name);
            personalMovimiento = (TextView) itemView.findViewById(R.id.item_personal_movimiento);
            personalMovimientoTime = (TextView) itemView.findViewById(R.id.item_personal_movimiento_time) ;
            options = (ImageView) itemView.findViewById(R.id.item_personal_editoption) ;
        }
    }
}
