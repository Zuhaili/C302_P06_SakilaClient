package sg.edu.rp.c346.id19004781.c302_p06_sakilaclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ViewFilmsActivity extends AppCompatActivity {

    Category c;
    private ListView lvFilm;
    ArrayList<Film> alFilm = new ArrayList<Film>();
    FilmAdapter aaFilm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_films);

        lvFilm = (ListView) findViewById(R.id.lvFilm);
        aaFilm = new FilmAdapter(this, R.layout.film_row, alFilm);
        lvFilm.setAdapter(aaFilm);


        Intent intentReceived = getIntent();
        c = (Category) intentReceived.getSerializableExtra("category");

//        RequestParams params = new RequestParams();
//        params.put("id", c.getId());

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://10.0.2.2/C302_sakila/getFilmsByCategoryId.php?id=" + c.getId() , new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    for (int i=0; i<response.length(); i++) {
                        JSONObject film = (JSONObject)response.get(i);
                        Film f = new Film(film.getString("title"), film.getInt("release_year"), film.getString("rating"));
                        alFilm.add(f);
                        //Toast.makeText(ViewFilmsActivity.this,f.getRating(),Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {

                }
                aaFilm.notifyDataSetChanged();
            }

        });

    }
}