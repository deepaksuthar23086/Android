package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public ListView lv;
    String name, age;
    private static String json_url = "https://run.mocky.io/v3/02c77a35-becc-42a3-a946-e29112e59f09";
    ArrayList<HashMap<String, String>> friendsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friendsList = new ArrayList<>();
        lv = findViewById(R.id.listview);
        GetData getData = new GetData();
        getData.execute();
    }
    public class GetData extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {
            String current = "";
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(json_url);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream in = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(in);
                    int data = isr.read();
                    while (data != -1) {
                        current += (char) data;
                        data = isr.read();
                    }
                    return current;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return current;
        }
        protected void onPostExecute(String s ){
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("friends");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    name = jsonObject1.getString("name");
                    age = jsonObject1.getString("age");
                    HashMap<String, String> friend = new HashMap<>();
                    friend.put("name", name);
                    friend.put("age", age);
                    friendsList.add(friend);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this,
                    friendsList,
                    R.layout.row_layout,
                    new String[] {"name", "age"},
                    new int[]{R.id.textview, R.id.textview1});
            lv.setAdapter(adapter);
        }
    }
}