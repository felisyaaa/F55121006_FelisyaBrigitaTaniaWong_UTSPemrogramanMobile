package com.felisya_brigita_tania_wong_f55121006.aplikasi_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] datadescription;
    private TypedArray dataPhoto;
    private PlanetAdapter adapter;
    private ArrayList<Planet> planets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new PlanetAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, planets.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        datadescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        planets = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Planet planet = new Planet ();
            planet.setPhoto(dataPhoto.getResourceId(i, -1));
            planet.setName(dataName[i]);
            planet.setDescription(datadescription[i]);
            planets.add(planet);
        }
        adapter.setPlanets(planets);
    }
}