package com.example.sprintfinal;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.example.sprintfinal.databinding.ActivityContactBinding;
import com.example.sprintfinal.databinding.ActivityContactBinding;

public class ContactActivity extends AppCompatActivity {

    private ActivityContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Configurar acción al hacer clic en el botón de LinkedIn
        binding.linkedinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // URL de LinkedIn
                String linkedinUrl = "https://www.linkedin.com/";

                // Crear intent para abrir la URL en un navegador externo
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedinUrl));
                startActivity(intent);
            }
        });

        // Configurar acción al hacer clic en el botón de WhatsApp
        binding.whatsappButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Número de teléfono de WhatsApp
                String phoneNumber = "+1234567890";

                // Crear intent para abrir la aplicación de WhatsApp con el número de teléfono
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumber));
                startActivity(intent);
            }
        });
    }
}
