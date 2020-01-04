package com.example.gokathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
                String url = "http://54.180.123.81:8080/orders/1";

                address = (TextView) findViewById(R.id.location);
                req = (TextView) findViewById(R.id.etc);
                price = (TextView) findViewById(R.id.price);
                target = (TextView) findViewById(R.id.clean);
                password = (TextView) findViewById(R.id.password);

                final ContentValues values = new ContentValues();
                values.put("homeAddress", address.getText().toString());
                values.put("requirements", req.getText().toString());
                values.put("price", price.getText().toString());
                values.put("cleaningTarget", target.getText().toString());
                values.put("roomPassword", password.getText().toString());

                NetworkTask networkTask = new NetworkTask(url, values);
               // networkTask.execute();

                Toast.makeText(getApplicationContext(), values.toString(), Toast.LENGTH_LONG).show();

                Intent mainIntent = new Intent(HouseActivity.this, HomeActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });
    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        private String url;
        private ContentValues values;

        public NetworkTask(String url, ContentValues values) {

            this.url = url;
            this.values = values;
        }

        @Override
        protected String doInBackground(Void... params) {

            String result; // 요청 결과를 저장할 변수.
            RequestHttpURLConnection_POST requestHttpURLConnectionPost = new RequestHttpURLConnection_POST();
            result = requestHttpURLConnectionPost.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
            Log.d("====================", "===============");
            Log.d("value", result);
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
            //tv_outPut.setText(s);
        }
    }
}
