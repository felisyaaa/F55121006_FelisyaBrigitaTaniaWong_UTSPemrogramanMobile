package com.felisya_brigita_tania_wong_f55121006.aplikasi_uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlanetAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Planet> planets;

    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }

    public PlanetAdapter(Context context) {
        this.context = context;
        planets = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return planets.size();
    }

    @Override
    public Object getItem(int i) {
        return planets.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_planet, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Planet planet = (Planet) getItem(i);
        viewHolder.bind(planet);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.planetName);
            txtDescription = view.findViewById(R.id.planetDesc);
            imgPhoto = view.findViewById(R.id.planetPhoto);
        }

        void bind(Planet planet) {
            txtName.setText(planet.getName());
            txtDescription.setText(planet.getDescription());
            imgPhoto.setImageResource(planet.getPhoto());
        }
    }
}
