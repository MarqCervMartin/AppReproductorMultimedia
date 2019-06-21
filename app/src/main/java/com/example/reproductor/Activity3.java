package com.example.reproductor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class Activity3 extends AppCompatActivity {
    CarouselPicker carrusel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        carrusel = (CarouselPicker)findViewById(R.id.CarouselPicker);
        List<CarouselPicker.PickerItem> texto = new ArrayList<>();
        texto.add(new CarouselPicker.DrawableItem(R.drawable.repetir));
        //texto.add(new CarouselPicker.TextItem("\tControl de Trama\n"+Control.toUpperCase(),15));
        texto.add(new CarouselPicker.TextItem("              ",15));
        texto.add(new CarouselPicker.DrawableItem(R.drawable.reproducir));
        texto.add(new CarouselPicker.TextItem("              ",15));
        texto.add(new CarouselPicker.DrawableItem(R.drawable.pausa));


        CarouselPicker.CarouselViewAdapter textAdapter = new CarouselPicker.CarouselViewAdapter(this, texto, 0);
        carrusel.setAdapter(textAdapter);

    }
}
