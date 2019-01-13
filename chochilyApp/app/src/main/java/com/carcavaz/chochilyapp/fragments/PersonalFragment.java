package com.carcavaz.chochilyapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.carcavaz.chochilyapp.R;
import com.carcavaz.chochilyapp.adapters.PersonalFragmentAdapter;
import com.carcavaz.chochilyapp.constant.ConstantValues;
import com.carcavaz.chochilyapp.models.PersonalModel;
import com.carcavaz.chochilyapp.requests.getAllPersonalAsync;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends Fragment implements getAllPersonalAsync.QueryTaskListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager LayoutManager;
    private getAllPersonalAsync allPersonalAsync = new getAllPersonalAsync();
    private RecyclerView picturesRecycler;



    public PersonalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personal, container, false);
        showToolbar(getResources().getString(R.string.start_personal), true, view);
        picturesRecycler = (RecyclerView) view.findViewById(R.id.fragment_personal_recyclerview);


        //manejador del re
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(linearLayoutManager);
        getUsers();
        return view;
    }

    //conectar a la api para obtener la lista de usuarios, con sus parametros
    public void getUsers(){


        allPersonalAsync.mListener = this;
        allPersonalAsync.execute();


    }


    public void showToolbar(String title, boolean upButton, View view){
        //pendiente
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.color_white));
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public void onQueryStart() {
        PersonalFragment.this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Override
    public void onQueryFinish(String res) {
        final String Res = res;
        if(Res != null)
            PersonalFragment.this.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        JSONArray PersonalArray = new JSONArray(Res);
                        Toast.makeText(getContext(), "" + PersonalArray.length(),Toast.LENGTH_LONG).show();
                        PersonalFragmentAdapter pictureAdapterRecyclerView = new PersonalFragmentAdapter(PersonalArray, R.layout.item_personal, getActivity());
                        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        else{
            //implementar mensaje de no hay conexion
        }
    }
}
