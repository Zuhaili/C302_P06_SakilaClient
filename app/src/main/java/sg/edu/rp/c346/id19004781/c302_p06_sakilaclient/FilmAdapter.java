package sg.edu.rp.c346.id19004781.c302_p06_sakilaclient;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FilmAdapter extends ArrayAdapter<Film> {
    private ArrayList<Film> film;
    private  Context context;
    private TextView tvTitle, tvYear, tvRating;
    public FilmAdapter(@NonNull Context context, int resource, ArrayList<Film> objects) {
        super(context, resource,objects);
        film = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.film_row, parent, false);

        tvTitle = rowView.findViewById(R.id.tvTitle);
        tvYear = rowView.findViewById(R.id.tvYear);
        tvRating = rowView.findViewById(R.id.tvRating);


        Film currentFilm = film.get(position);
        tvTitle.setText(currentFilm.getTitle());
        tvYear.setText(currentFilm.getYear()+"");
        tvRating.setText(currentFilm.getRating());


        return rowView;
    }

}
