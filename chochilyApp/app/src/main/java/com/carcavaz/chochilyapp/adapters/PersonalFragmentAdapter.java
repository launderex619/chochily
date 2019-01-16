package com.carcavaz.chochilyapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.carcavaz.chochilyapp.R;
import com.carcavaz.chochilyapp.constant.Helper;
import com.carcavaz.chochilyapp.models.PersonalHistoryModel;
import com.carcavaz.chochilyapp.models.PersonalModel;
import com.squareup.picasso.Picasso;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.ArrayList;

public class PersonalFragmentAdapter extends RecyclerView.Adapter<PersonalFragmentAdapter.PersonalViewHolder> {

    JSONArray personalModels;

    private int resource;
    private Activity activity;
    private Helper helper = new Helper();


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
    public void onBindViewHolder(@NonNull final PersonalViewHolder holder, int position) {
        try {
            JSONObject personal = personalModels.getJSONObject(position);
            JSONArray personalHistory = personal.getJSONArray("PersonalHistory");

            for (int i = 0; i < personalHistory.length(); i++){
                PersonalHistoryModel historyModel = new PersonalHistoryModel(
                        personalHistory.getJSONObject(i).getString("Id"),
                        personalHistory.getJSONObject(i).getString("Propietario"),
                        personalHistory.getJSONObject(i).getString("Accion"),
                        personalHistory.getJSONObject(i).getLong("Hora")
                );
                holder.personalHistoryModels.add(historyModel);
            }

            //ordena la lista de mayor a menor (de la fecha mas reciente a la mas antigua
            Collections.sort(holder.personalHistoryModels, new Comparator<PersonalHistoryModel>() {
                @Override
                public int compare(PersonalHistoryModel data, PersonalHistoryModel list) {
                    // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                    return data.getHora() > list.getHora() ? -1 : (data.getHora() < list.getHora()) ? 1 : 0;
                }
            });

            holder.personalModel = new PersonalModel(
                    personal.getString("Id"),
                    personal.getString("ImageSrc"),
                    personal.getString("Nombre"),
                    personal.getString("Codigo"),
                    personal.getString("Correo"),
                    holder.personalHistoryModels
            );

            if(position % 2 == 0)
                holder.personalCard.setCardBackgroundColor(activity.getResources().getColor(R.color.color_orange_dark));
            else
                holder.personalCard.setCardBackgroundColor(activity.getResources().getColor(R.color.color_orange));

            String LastAction = holder.personalModel.getHistoryModel().get(0).getAccion() + " ";
            Long LastActionTime = holder.personalModel.getHistoryModel().get(0).getHora();



            Picasso.get().load(holder.personalModel.getPictureSrc()).into(holder.personalImage);
            holder.usernameCard.setText(holder.personalModel.getUserName());
            holder.personalMovimiento.setText(LastAction);
            holder.personalMovimientoTime.setText(helper.ConvertLongToDate(LastActionTime));
            holder.options.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] text = new String[holder.personalModel.getHistoryModel().size()];
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);

                    for(int i = 0; i < holder.personalModel.getHistoryModel().size();i++)
                        text[i] = holder.personalModel.getHistoryModel().get(i).getAccion() + " <<" + helper.ConvertLongToDate(holder.personalModel.getHistoryModel().get(i).getHora()) + ">>";

                    builder.setTitle(holder.personalModel.getUserName());

                    builder.setItems(text, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
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
        private ArrayList<PersonalHistoryModel> personalHistoryModels = new ArrayList<>();
        private PersonalModel personalModel;


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
