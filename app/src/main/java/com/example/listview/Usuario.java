package com.example.listview;

import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

public class Usuario {

    private String nombres;
    private String area;
    private String website;

    public String getNombre() {
        return nombres;
    }

    public String getEmail() {
        return area;
    }

    public String getWebsite() {
        return website;
    }

    public void setNombre(String nombre) {
        this.nombres = nombre;
    }

    public void setEmail(String area) {
        this.area = area;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setUrlavatar(String urlavatar) {
        this.urlavatar = urlavatar;
    }

    public String getUrlavatar() {
        return urlavatar;
    }

    private String urlavatar;

    public Usuario(String nombres, String area, String website, String urlavatar) {
        this.nombres = nombres;
        this.area = area;
        this.website = website;
        this.urlavatar = urlavatar;
    }

    public Usuario(JSONObject a) throws JSONException {
        nombres =  a.getString("idevaluador").toString();
        area =  a.getString("area").toString() ;
        website =  a.getString("imgJPG").toString() ;
        urlavatar = a.getString("imgjpg").toString() ;
    }

    public static ArrayList<Usuario> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList <String> lis = new ArrayList<>();
            for (int i = 0; i < datos.length(); i++) {
                JSONObject user=  datos.getJSONObject(i);
//                Log.d("DATOS", user.toString());
//                usuarios.add(new Usuario(user.getString("nombres"),
//                        user.getString("area"),
//                        user.getString("imgJPG"),
//                        user.getString("imgjpg")));
                lis.add("Nombre: "+user.getString("nombres")+ "\n"
                        + "Email: "+user.getString("area")+"\n"
                        + "Genero: "+user.getString("imgJPG")+"\n"
                        + "Estado: "+user.getString("imgjpg")+"\n\n");
                Log.d("DATOS", lis.toString());
            }
        return usuarios;
    }
}