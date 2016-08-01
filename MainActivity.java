package com.example.jsonretrive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity
{


    private Button login;

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    private String URL="http://riddles.magemojo.com/rest/V1/customers";




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.action_bar_root);
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                objectRequest();

            }
        });

    }


    public void objectRequest()
    {


        JSONObject innerOBJ = new JSONObject();
        try
        {
            innerOBJ.put("email","avj@augmentes.com");
            innerOBJ.put("firstname","Kavi");
            innerOBJ.put("lastname","jay");

        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }


        JSONObject paramOBJ = new JSONObject();
        try
        {
            paramOBJ.put("customer",innerOBJ);
            paramOBJ.put("password","Test@123456");

        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        System.out.println("-------------------------> paramOBJ " + paramOBJ);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, URL,paramOBJ, new Response.Listener<JSONObject>()
        {

            @Override
            public void onResponse(JSONObject response)
            {
                Toast.makeText(getApplicationContext(), ""+ response, Toast.LENGTH_LONG).show();
                Log.d("kkkkkkkkkkkkk",""+response);
            }
        }, new Response.ErrorListener()
        {

            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(getApplicationContext(), ""+ error, Toast.LENGTH_LONG).show();
                Log.d("kkkkkkkkkkkkk",""+error);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }


}
