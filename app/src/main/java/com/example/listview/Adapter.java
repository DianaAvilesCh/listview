package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderDatos> {

    List<Usuario> listUser;
    Context Ctx;

    public Adapter(Context mCtx, List<Usuario> listuser) {
        this.listUser = listuser;
        Ctx=mCtx;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        Usuario usuario = listUser.get(position);

        holder.textViewName.setText(usuario.getNombre());
        holder.textViewMail.setText(usuario.getEmail());
        holder.textViewURLAvatar.setText(usuario.getWebsite());

        Glide.with(Ctx)
                .load(usuario.getUrlavatar())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView textViewName, textViewURLAvatar, textViewMail;
        ImageView imageView;

        public ViewHolderDatos(View itemView) {
            super(itemView);

            textViewName= itemView.findViewById(R.id.txtName);
            textViewURLAvatar = itemView.findViewById(R.id.txtAvatar);
            textViewMail = itemView.findViewById(R.id.txtMail);
            imageView = itemView.findViewById(R.id.imgAvatar);
        }

//        TextView dato;
//
//        public ViewHolderDatos(@NonNull View itemView) {
//            super(itemView);
//            dato = (TextView) itemView.findViewById(R.id.txtDatos);
//        }
//
//        public void asignar(String s) {
//            dato.setText(s);
//        }
    }
}
