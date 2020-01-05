package com.example.gokathon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class HouseActivity extends AppCompatActivity {
    private Button registeration;
    private RequestHttpURLConnection_POST requestHttpURLConnectionPost;
    private TextView address = null;
    private TextView req = null;
    private TextView price = null;
    private TextView target = null;
    private TextView password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        registeration = (Button) findViewById(R.id.registerButton);
        registeration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://54.180.123.81:8080/orders/";

                address = (TextView) findViewById(R.id.location);
                req = (TextView) findViewById(R.id.etc);
                price = (TextView) findViewById(R.id.price);
                target = (TextView) findViewById(R.id.clean);
                password = (TextView) findViewById(R.id.password);

                final Map<String, String> values = new HashMap<>();
                values.put("homeAddress", address.getText().toString());
                values.put("requirements", req.getText().toString());
                values.put("price", price.getText().toString());
                values.put("cleaningTarget", target.getText().toString());
                values.put("roomPassword", password.getText().toString());

                url += LoginActivity.userEmail;
                NetworkTask networkTask = new NetworkTask(url, values);
                 networkTask.execute();

                Toast.makeText(getApplicationContext(), values.toString(), Toast.LENGTH_LONG).show();

                Intent mainIntent = new Intent(HouseActivity.this, HomeActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });
    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        private String url;
        private Map<String, String> values;
        public NetworkTask(String url, Map<String, String> values) {

            this.url = url;
            this.values = values;
            Log.d("ohmygod", String.valueOf(values));
        }

        @Override
        protected String doInBackground(Void... params) {
            Gson gson = new Gson();
            String result = gson.toJson(new OrderDetail(values.get("homeAddress"), values.get("requirements"),
                    Integer.parseInt(values.get("price")), values.get("cleaningTarget"), values.get("roomPassword")));

            RequestHttpURLConnection_POST requestHttpURLConnectionPOST = new RequestHttpURLConnection_POST();
            result = requestHttpURLConnectionPOST.request(url, result);
            Log.d("ohmygooood", result);
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
            //tv_outPut.setText(s);
        }

        public class OrderDetail{
            private String homeAddress;
            private String requirements;
            private int price;
            private String cleaningTarget;
            private String roomPassword;

            OrderDetail(){

            }

            OrderDetail(String homeAddress, String requirements, int price, String cleaningTarget,
                        String roomPassword){
                this.homeAddress=homeAddress;
                this.requirements=requirements;
                this.price=price;
                this.cleaningTarget=cleaningTarget;
                this.roomPassword=roomPassword;
            }
        }
    }
}
