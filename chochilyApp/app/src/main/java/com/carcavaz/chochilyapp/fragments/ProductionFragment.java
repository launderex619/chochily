package com.carcavaz.chochilyapp.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.carcavaz.chochilyapp.MainActivity;
import com.carcavaz.chochilyapp.R;
import com.carcavaz.chochilyapp.adapters.ProductionCategoriesFragmentAdapter;
import com.carcavaz.chochilyapp.models.ProductionCategoryModel;
import com.carcavaz.chochilyapp.requests.getProductionCategoriesAsync;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ProductionFragment extends Fragment implements getProductionCategoriesAsync.QueryTaskListener {

    MainActivity ParentActivity;
    getProductionCategoriesAsync getCategoriesAsync = new getProductionCategoriesAsync();
    private RecyclerView picturesRecycler;

    public ProductionFragment() {
    }

    @SuppressLint("ValidFragment")
    public ProductionFragment(MainActivity activity) {
        ParentActivity = activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_production, container, false);

        picturesRecycler = (RecyclerView) view.findViewById(R.id.fragment_production_recyclerview);

        ParentActivity.getSupportFragmentManager().popBackStack();

        getProductionCategories();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(linearLayoutManager);



        return view;
    }

    //conectar a la api para obtener la lista de usuarios, con sus parametros
    public void getProductionCategories(){

        getCategoriesAsync.mListener = this;
        getCategoriesAsync.execute();
    }

    @Override
    public void onQueryProductionStart() {
        ProductionFragment.this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Override
    public void onQueryProductionFinish(String res) {
        final String Res = res;
        if(Res != null)
            ProductionFragment.this.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        JSONArray PoductionCategoriesArray = new JSONArray(Res);

                        ArrayList<ProductionCategoryModel> productionCategoryList = new ArrayList<>();

                        Toast.makeText(getContext(), "" + PoductionCategoriesArray.length(),Toast.LENGTH_LONG).show();

                        //Combierto el json Array a un ArrayList
                        for(int i = 0; i < PoductionCategoriesArray.length(); i++){
                            ProductionCategoryModel productionCategoryModel = new ProductionCategoryModel();

                            productionCategoryModel.setId(PoductionCategoriesArray.getJSONObject(i).getString("Id"));
                            productionCategoryModel.setActiva(PoductionCategoriesArray.getJSONObject(i).getBoolean("Activa"));
                            productionCategoryModel.setImageSrc(PoductionCategoriesArray.getJSONObject(i).getString("ImageSrc"));
                            productionCategoryModel.setColor(PoductionCategoriesArray.getJSONObject(i).getString("Color"));
                            productionCategoryModel.setNombre(PoductionCategoriesArray.getJSONObject(i).getString("Nombre"));
                            productionCategoryModel.setCreacion(PoductionCategoriesArray.getJSONObject(i).getLong("Creacion"));

                            productionCategoryList.add(productionCategoryModel);
                        }

                        //ordena la lista por orden alfabetico

                        /*Collections.sort(productionCategoryList, new Comparator<ProductionCategoryModel>() {
                            @Override
                            public int compare(ProductionCategoryModel data, ProductionCategoryModel list) {
                                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                                return data.getNombre().compareTo(list.getNombre());
                            }
                        });
*/
                        ProductionCategoriesFragmentAdapter pictureAdapterRecyclerView = new ProductionCategoriesFragmentAdapter(productionCategoryList, R.layout.item_production_category, getActivity());
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
