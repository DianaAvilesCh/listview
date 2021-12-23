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
        String desconocido ="https://www.definicionabc.com/wp-content/uploads/desconocido.jpg";

        holder.tvNombre.setText(usuario.getNombres());
        holder.tvArea.setText(usuario.getArea());
        holder.tvId.setText(usuario.getId());
        try{
            Glide.with(Ctx)
                    .load(usuario.getUrlavatar())
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(Glide.with(Ctx)
                    .load(usuario.getUrlavatar())
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

        TextView tvNombre, tvArea, tvId;
        ImageView imageView;

        public ViewHolderDatos(View itemView) {
            super(itemView);

            tvNombre= itemView.findViewById(R.id.txtNombre);
            tvId= itemView.findViewById(R.id.txtId);
            tvArea = itemView.findViewById(R.id.txtArea);
            imageView = itemView.findViewById(R.id.imgAvatar);
        }

    }
}
