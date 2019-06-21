package com.example.reproductor;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import in.goodiebag.carouselpicker.CarouselPicker;

public class Activity2 extends AppCompatActivity {

    //CarouselPicker carouselPicker1;
    Button play_pause;
    MediaPlayer mp;
    int posicion=0;

    MediaPlayer vectormp [] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        play_pause = (Button)findViewById(R.id.btn_play);


        //Relacion parte logica-grafica
        vectormp[0] = MediaPlayer.create(this, R.raw.race);
        vectormp[1] = MediaPlayer.create(this, R.raw.sound);
        vectormp[2] = MediaPlayer.create(this, R.raw.tea);


/*
        carouselPicker1 = (CarouselPicker)findViewById(R.id.carouselPicker1);

        ArrayList<CarouselPicker.PickerItem> itemsImages = new ArrayList<>();
        itemsImages.add(new CarouselPicker.DrawableItem(R.drawable.no_repetir));
        itemsImages.add(new CarouselPicker.DrawableItem(R.drawable.anterior));
        itemsImages.add(new CarouselPicker.DrawableItem(R.drawable.reproducir));
        itemsImages.add(new CarouselPicker.DrawableItem(R.drawable.detener));
        itemsImages.add(new CarouselPicker.DrawableItem(R.drawable.siguiente));
        itemsImages.add(new CarouselPicker.OnClickListener();



        CarouselPicker.CarouselViewAdapter imageAdapter = new CarouselPicker.CarouselViewAdapter(this, itemsImages,0);
        carouselPicker1.setAdapter(imageAdapter);
        */

    }

    public void pausa(View view){
        if( vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pista Pausada", Toast.LENGTH_SHORT).show();
        }else{
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Pista Play", Toast.LENGTH_SHORT).show();

        }

    }

    public void siguiente(View view){
        if(posicion < vectormp.length -1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();
            }else{
                posicion++;

            }

        }else{
            Toast.makeText(this, "Fin de todas las pistas", Toast.LENGTH_SHORT).show();
        }
    }
    public void anterior(View view){
        if(posicion >= 1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this, R.raw.race);
                vectormp[1] = MediaPlayer.create(this, R.raw.sound);
                vectormp[2] = MediaPlayer.create(this, R.raw.tea);
                posicion--;
                vectormp[posicion].start();
            }else{
                posicion--;
            }

        }else{
            Toast.makeText(this, "Fin de todas las pistas", Toast.LENGTH_SHORT).show();

        }
    }
}
