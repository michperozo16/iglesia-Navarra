package com.example.iglesianavarra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;

    private Button login;
    private Button registrar;
    private Button cerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        login = findViewById(R.id.iniciarSesionPantalla);
        registrar = findViewById(R.id.registrarPantalla);
        cerrarSesion = findViewById(R.id.cerrarSesion_btn);

        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser()!=null){
            login.setVisibility(View.GONE);
            registrar.setVisibility(View.GONE);
            cerrarSesion.setVisibility(View.VISIBLE);
        }

    }

    public void irIniciar(View view){
        Intent i = new Intent(this, IniciarSesionActivity.class);
                startActivity(i);
    }

    public void irRegistrarse(View view){
        Intent i = new Intent(this, RegistrarseActivity.class);
        startActivity(i);

    }

    public void CerrarSesion(View view){
        auth.signOut();
        if (auth.getCurrentUser()==null){
            login.setVisibility(View.VISIBLE);
            registrar.setVisibility(View.VISIBLE);
            cerrarSesion.setVisibility(View.GONE);

        }
    }

    public void irLibros(View view){

        if (auth.getCurrentUser()!=null){
            Intent i = new Intent(this, LibrosActivity2.class);
            startActivity(i);
        }else {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setMessage("Debes Registrarte o iniciar sesion para acceder a los libros");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Ok",
                    (dialog, id) -> {dialog.cancel(); });
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }


    }

    public void irIcmNavarra(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cosechamundialnavarra.com"));
        startActivity(i);
    }
    public void irLema(View view){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://cosechamundialnavarra.com/lema-2021/"));
        startActivity(i);
    }
    public void irNosotros(View view){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://cosechamundialnavarra.com/nosotros/"));
        startActivity(i);
    }
    public void irEncuentro(View view){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://cosechamundialnavarra.com/encuentros-de-amistad/"));
        startActivity(i);
    }

    // nuevo
    public void irEscuela(View view){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://edu.cosechamundialtudela.com/login/index.php"));
        startActivity(i);
   }
  /* public void irLibros(View view){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://cosechamundialnavarra.com/encuentros-de-amistad/"));
        startActivity(i);
    }*/
    public void irVideo(View view){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://vimeo.com/562443593/89b0697f8f"));
        startActivity(i);

    }public void facebook(View view){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/groups/662093197932076"));
        startActivity(i);
    }

}