package com.example.sprintfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.example.sprintfinal.databinding.ActivityMainLandscapeBinding;
import com.example.sprintfinal.databinding.ActivityMainPortraitBinding;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private ActivityMainPortraitBinding portraitBinding;
    private ActivityMainLandscapeBinding landscapeBinding;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener las referencias a los botones flotantes en los diseños de paisaje y retrato
        landscapeBinding = ActivityMainLandscapeBinding.inflate(getLayoutInflater());
        portraitBinding = ActivityMainPortraitBinding.inflate(getLayoutInflater());

        // Verificar la orientación de la pantalla y establecer el diseño correspondiente
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(landscapeBinding.getRoot());
            fab = landscapeBinding.floatingActionButton;
        } else if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(portraitBinding.getRoot());
            fab = portraitBinding.floatingActionButton;
        }

        // Configurar el clic del botón flotante
        setupFloatingActionButton();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Mantener el diseño actual sin volver a inflar el diseño
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(landscapeBinding.getRoot());
            fab = landscapeBinding.floatingActionButton;
        } else if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(portraitBinding.getRoot());
            fab = portraitBinding.floatingActionButton;
        }

        // Volver a configurar el clic del botón flotante
        setupFloatingActionButton();
    }

    private void setupFloatingActionButton() {
        // Limpiar los listeners anteriores
        fab.setOnClickListener(null);

        // Acción al hacer clic en el botón flotante
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para iniciar la actividad ContactActivity
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });
    }
}
