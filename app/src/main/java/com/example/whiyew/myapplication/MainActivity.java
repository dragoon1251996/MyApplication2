package com.example.whiyew.myapplication;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) this.findViewById(R.id.textView2);
        e2 = (EditText) this.findViewById(R.id.textView3);
        e3 = (EditText) this.findViewById(R.id.textView4);
        b=(Button)this.findViewById(R.id.button2);
        url="https://graph.facebook.com/"+e1.getText().toString()+"/feed?message="+e2.getText().toString()+"&access_token="+e3.getText().toString();
        b.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                final String finalMessages = messages;
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("TG", "onResponse: " + response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TG", "onErrorResponse: " + error.getMessage());
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> params = new HashMap<>();
                        params.put();
                        return params;
                    }

                    @Override
                    public Priority getPriority() {
                        return Priority.HIGH;
                    }
                };
                RequestQueue MyRequestQueue = Volley.newRequestQueue(context);

                MyRequestQueue.add(stringRequest);

            }
        });

    }
}
