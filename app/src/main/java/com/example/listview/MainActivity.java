package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtUser;
    RecyclerView recyclerView;
    RequestQueue requestQueue;
    String URL = "https://www.uealecpeterson.net/ws/listadoevaluadores.php";
    ArrayList<Usuario> listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        stringRequest();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public void stringRequest(){
        txtUser = (TextView)findViewById(R.id.txtLsUser);
        StringRequest request = new StringRequest(Request.Method.GET,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject object = new JSONObject(response);
                            JSONArray JSONlista=  object.getJSONArray("listaaevaluador");

                            listUser = Usuario.JsonObjectsBuild(JSONlista);

                            Adapter adapter = new Adapter(getApplicationContext(), listUser);

                            int resId = R.anim.layout_animation_down_to_up;
                            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                                    resId);
                            recyclerView.setLayoutAnimation(animation);

                            recyclerView.setAdapter(adapter);


                        }catch (JSONException e) {
                            e.printStackTrace();
                            txtUser.setVisibility(View.VISIBLE);
                            txtUser.setKeyListener(null);
                            txtUser.setText("HOLA " + e.toString() + "\n");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
                    public void onErrorResponse(final VolleyError error) {
                        txtUser.setKeyListener(null);
                        if(error.networkResponse == null
                                && error instanceof NoConnectionError
                                && error.getMessage().contains("javax.net.ssl.SSLHandshakeException"))
                        {
                            txtUser.setVisibility(View.VISIBLE);
                            txtUser.setText(error.toString());
                            // Se ha producido un error con el certificado SSL y la conexión ha sido
                            // rechazada
                        }
                    }
                }
                );
        requestQueue.add(request);
    }
}
