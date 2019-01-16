package com.carcavaz.chochilyapp.adapters;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.carcavaz.chochilyapp.R;
import com.carcavaz.chochilyapp.constant.Helper;
import com.carcavaz.chochilyapp.models.ProductionCategoryModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductionCategoriesFragmentAdapter extends RecyclerView.Adapter<ProductionCategoriesFragmentAdapter.ProductionViewHolder> {


    private ArrayList<ProductionCategoryModel>  ProductionCategories;
    private int resource;
    private Activity activity;
    private Helper helper = new Helper();


    public ProductionCategoriesFragmentAdapter(ArrayList<ProductionCategoryModel> Categories, int resource, Activity Activity) {
        this.ProductionCategories = Categories;
        this.resource = resource;
        this.activity = Activity;
    }


    @NonNull
    @Override
    public ProductionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ProductionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductionViewHolder holder, int position) {


        //creo un objeto de tipo ProductionCategoryModel
        String Id = ProductionCategories.get(position).getId();
        String ImageSrc = ProductionCategories.get(position).getImageSrc();
        String Nombre = ProductionCategories.get(position).getNombre();
        Long Creacion = ProductionCategories.get(position).getCreacion();
        boolean Activa = ProductionCategories.get(position).isActiva();
        String color = ProductionCategories.get(position).getColor();
        holder.productionCategoryModel = new ProductionCategoryModel(Id, ImageSrc, Nombre, Creacion, Activa, color);

        //asigno los atributos a las vistas correspondientes

        holder.Item.setCardBackgroundColor(Color.parseColor(holder.productionCategoryModel.getColor()));
        Picasso.get().load(holder.productionCategoryModel.getImageSrc()).into(holder.image);
        holder.Name.setText(holder.productionCategoryModel.getNombre());
        holder.Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //llamar al fragment ProductionStage
            }
        });

    }

    @Override
    public int getItemCount() {
        return ProductionCategories.size();
    }

    public class ProductionViewHolder extends RecyclerView.ViewHolder{

        private CardView Item;
        private ImageView image;
        private TextView Name;
        private ProductionCategoryModel productionCategoryModel;


        public ProductionViewHolder(View view) {
            super(view);

            Item = (CardView) view.findViewById(R.id.item_production_category);
            image = (ImageView) view.findViewById(R.id.item_production_category_image);
            Name = (TextView) view.findViewById(R.id.item_production_category_text);
        }
    }
}
