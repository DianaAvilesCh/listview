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

import java.util.List;

public class AdapterEvaluar extends RecyclerView.Adapter<AdapterEvaluar.ViewHolderDatos> {

    List<UsuarioEvaluar> listUser;
    Context Ctx;

    public AdapterEvaluar(Context mCtx, List<UsuarioEvaluar> listuser) {
        this.listUser = listuser;
        Ctx=mCtx;
    }

    @NonNull
    @Override
    public AdapterEvaluar.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_evaluar,null,false);
        return new AdapterEvaluar.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEvaluar.ViewHolderDatos holder, int position) {
        UsuarioEvaluar usuario = listUser.get(position);
        String desconocido ="https://us.123rf.com/450wm/metelsky/metelsky1809/metelsky180900220/109815466-perfil-de-avatar-de-hombre-silueta-de-rostro-masculino-o-icono-aislado-sobre-fondo-blanco-ilustració.jpg";

        holder.tvNombre.setText(usuario.getNombres());
        holder.tvCargo.setText(usuario.getCargo());
        holder.tvSitu.setText(usuario.getSitu());
        holder.tvInicio.setText(usuario.getInicio());
        holder.tvFin.setText(usuario.getFin());

        try{
            Glide.with(Ctx)
                    .load(usuario.getUrlavatar())
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(Glide.with(Ctx)
                            .load(usuario.getUrlavatar2())
                            .error( Glide.with(Ctx)
                                    .load(desconocido)))
                    .into(holder.imageView);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView tvNombre, tvCargo, tvSitu, tvInicio, tvFin;
        ImageView imageView;

        public ViewHolderDatos(View itemView) {
            super(itemView);

            tvNombre= itemView.findViewById(R.id.txtNombre);
            tvCargo= itemView.findViewById(R.id.txtCargo);
            tvSitu = itemView.findViewById(R.id.txtSituacion);
            tvInicio = itemView.findViewById(R.id.txtFecha);
            tvFin = itemView.findViewById(R.id.txtFechanfin);
            imageView = itemView.findViewById(R.id.imgAvatar);
        }

    }
}