package com.example.listview;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UsuarioEvaluar {

    private String id;
    private String nombres;
    private String cargo;
    private String urlavatar;
    private String urlavatar2;
    private String situ;
    private String inicio;
    private String fin;

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public String getSitu() {
        return situ;
    }

    public void setSitu(String situ) {
        this.situ = situ;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public UsuarioEvaluar(String nombres, String cargo, String urlavatar,
                          String urlavatar2, String situ, String inicio, String fin) {
        this.nombres = nombres;
        this.cargo = cargo;
        this.urlavatar = urlavatar;
        this.urlavatar2 = urlavatar2;
        this.situ = situ;
        this.inicio = inicio;
        this.fin = fin;
    }

    public static ArrayList<UsuarioEvaluar> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<UsuarioEvaluar> usuarios = new ArrayList<>();
        ArrayList <String> lis = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            JSONObject user=  datos.getJSONObject(i);
            //Log.d("DATOS", user.toString());
            usuarios.add(new UsuarioEvaluar(user.getString("Nombres"),
                    user.getString("cargo"),
                    user.getString("imgJPG"),
                    user.getString("imgjpg"),
                    user.getString("situacion"),
                    user.getString("fechainicio"),
                    user.getString("fechafin")));
        }
        return usuarios;
    }
}
