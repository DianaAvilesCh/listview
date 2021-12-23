package com.example.listview;

import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

public class Usuario {

    private String id;
    private String nombres;
    private String area;
    private String urlavatar;
    private String urlavatar2;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getUrlavatar() {
        return urlavatar;
    }

    public void setUrlavatar(String urlavatar) {
        this.urlavatar = urlavatar;
    }

    public String getUrlavatar2() {
        return urlavatar2;
    }

    public void setUrlavatar2(String urlavatar2) {
        this.urlavatar2 = urlavatar2;
    }


    public Usuario(String id, String nombres, String area, String urlavatar, String urlavatar2) {
        this.id = id;
        this.nombres = nombres;
        this.area = area;
        this.urlavatar = urlavatar;
        this.urlavatar2 = urlavatar2;
    }

    public static ArrayList<Usuario> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList <String> lis = new ArrayList<>();
            for (int i = 0; i < datos.length(); i++) {
                JSONObject user=  datos.getJSONObject(i);
                //Log.d("DATOS", user.toString());
                usuarios.add(new Usuario(user.getString("idevaluador"),
                        user.getString("nombres"),
                        user.getString("area"),
                        user.getString("imgJPG"),
                        user.getString("imgjpg")));
            }
        return usuarios;
    }
}