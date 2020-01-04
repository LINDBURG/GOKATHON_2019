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

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class HouseActivity extends AppCompatActivity {
    private Button registeration;
  //  private RequestHttpURLConnection requestHttpURLConnectionPOST;
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

                final ContentValues values2 = new ContentValues();
                values2.put("homeAddress", address.getText().toString());
                values2.put("requirements", req.getText().toString());
                values2.put("price", price.getText().toString());
                values2.put("cleaningTarget", target.getText().toString());
                values2.put("roomPassword", password.getText().toString());

          /*      String values = "{\"homeAddress\":" + "\"" + address.getText().toString() + "\""
                        + ", \"requirements\":" + "\"" + req.getText().toString() + "\""
                        + ", \"price\":" + price.getText().toString()
                        + ", \"cleaningTarget\":" + "\"" + target.getText().toString() + "\""
                        + ", \"roomPassword\":" + "\"" + password.getText().toString() + "\"}";*/

              //  Log.d("밸루1 : ", values);
                Log.d("밸루2 : ", values2.toString());
              //  Toast.makeText(getApplicationContext(), values, Toast.LENGTH_LONG).show();


                url += LoginActivity.userEmail;

                Toast.makeText(getApplicationContext(), url, Toast.LENGTH_LONG).show();

                NetworkTask networkTask = new NetworkTask(url, values2);
                networkTask.execute();

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
            RequestHttpURLConnection requestHttpURLConnectionPost = new RequestHttpURLConnection();

            Log.d("으아", values.toString());
            Log.d("이익", url);

            result = requestHttpURLConnectionPost.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
            Log.d("====================", "===============");
           // Log.d("value11123", result);

           // Toast.makeText(getApplicationContext(), values, Toast.LENGTH_LONG).show();

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
            //tv_outPut.setText(s);
        }
    }




    public class RequestHttpURLConnection {

        public String request(String _url, ContentValues _params){

            // HttpURLConnection 참조 변수.
            HttpURLConnection urlConn = null;
            // URL 뒤에 붙여서 보낼 파라미터.
            StringBuffer sbParams = new StringBuffer();

            /**
             * 1. StringBuffer에 파라미터 연결
             * */
            // 보낼 데이터가 없으면 파라미터를 비운다.
            if (_params == null)
                sbParams.append("");
                // 보낼 데이터가 있으면 파라미터를 채운다.
            else {
                // 파라미터가 2개 이상이면 파라미터 연결에 &가 필요하므로 스위칭할 변수 생성.
                boolean isAnd = false;
                // 파라미터 키와 값.
                String key;
                String value;

                for(Map.Entry<String, Object> parameter : _params.valueSet()){
                    key = parameter.getKey();
                    value = parameter.getValue().toString();

                    // 파라미터가 두개 이상일때, 파라미터 사이에 &를 붙인다.
                    if (isAnd)
                        sbParams.append("&");

                    sbParams.append(key).append("=").append(value);

                    // 파라미터가 2개 이상이면 isAnd를 true로 바꾸고 다음 루프부터 &를 붙인다.
                    if (!isAnd)
                        if (_params.size() >= 2)
                            isAnd = true;
                }
            }

            /**
             * 2. HttpURLConnection을 통해 web의 데이터를 가져온다.
             * */
            try{
                Log.d("유아엘", _url);
                URL url = new URL(_url);
                urlConn = (HttpURLConnection) url.openConnection();

                // [2-1]. urlConn 설정.
                urlConn.setRequestMethod("POST"); // URL 요청에 대한 메소드 설정 : POST.
                urlConn.setRequestProperty("Accept-Charset", "UTF-8"); // Accept-Charset 설정.
                urlConn.setRequestProperty("Content-Type", "application/json");
                urlConn.setRequestProperty("Accept", "application/json");

                // [2-2]. parameter 전달 및 데이터 읽어오기.
                String strParams = sbParams.toString(); //sbParams에 정리한 파라미터들을 스트링으로 저장. 예)id=id1&pw=123;
                OutputStream os = urlConn.getOutputStream();
                os.write(strParams.getBytes("UTF-8")); // 출력 스트림에 출력.
                os.flush(); // 출력 스트림을 플러시(비운다)하고 버퍼링 된 모든 출력 바이트를 강제 실행.
                os.close(); // 출력 스트림을 닫고 모든 시스템 자원을 해제.

                // [2-3]. 연결 요청 확인.
                // 실패 시 null을 리턴하고 메서드를 종료.
                if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK)
                    return null;

                // [2-4]. 읽어온 결과물 리턴.
                // 요청한 URL의 출력물을 BufferedReader로 받는다.
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));

                // 출력물의 라인과 그 합에 대한 변수.
                String line;
                String page = "";

                // 라인을 받아와 합친다.
                while ((line = reader.readLine()) != null){
                    page += line;
                }

                return page;

            } catch (MalformedURLException e) { // for URL.
                e.printStackTrace();
            } catch (IOException e) { // for openConnection().
                e.printStackTrace();
            } finally {
                if (urlConn != null)
                    urlConn.disconnect();
            }

            return null;

        }
    }
}


