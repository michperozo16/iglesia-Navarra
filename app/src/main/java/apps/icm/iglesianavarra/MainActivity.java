package apps.icm.iglesianavarra;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.example.iglesianavarra.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    private Button login;
    private Button registrar;
    private Button cerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        setContentView(R.layout.activity_main);

         //evitar que la pantalla rote
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

/*
        login = findViewById(R.id.iniciarSesionPantalla);
        registrar = findViewById(R.id.registrarPantalla);
        cerrarSesion = findViewById(R.id.cerrarSesion_btn);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()!=null){
            login.setVisibility(View.GONE);
            registrar.setVisibility(View.GONE);
            cerrarSesion.setVisibility(View.VISIBLE);
        }
*/
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
        mAuth.signOut();
        if (mAuth.getCurrentUser()==null){
            login.setVisibility(View.VISIBLE);
            registrar.setVisibility(View.VISIBLE);
            cerrarSesion.setVisibility(View.GONE);

        }
    }

    /*public void irLibros(View view){

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


    }*/

    public void irIcmNavarra(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cosechamundialnavarra.com"));
        startActivity(i);

    }
    public void irLema(View view){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://cosechamundialnavarra.com/lema-2021/"));
        startActivity(i);
    }
    public void irPastor(View view){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://cosechamundialnavarra.com/videos/"));
        startActivity(i);
    }
    public void irPastora(View view){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://cosechamundialnavarra.com/videos-pastora/"));
        startActivity(i);
    }

    // nuevo Segunda pantalla
    public void irEscuela(View view){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://edu.cosechamundialnavarra.com/course/view.php?id=6"));
        startActivity(i);
   }
    public void irMinistros(View view){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://cosechamundialnavarra.com/ministros-icm/"));
        startActivity(i);
    }
    public void irVideo(View view){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://cosechamundialnavarra.com/videos/"));
        startActivity(i);

    }
    public void facebook(View view){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/groups/662093197932076"));
        startActivity(i);
    }

    // pasar a la segunda activiti
    public void irASegundaPantalla (View view){
       Intent i = new Intent(this, SegundaActivity2.class);
       startActivity(i);


    }

    // Metodo para mostrar y ocultar menu
   @Override public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;

    }
    // Metodo para asignar las funciones correspondientes a las opciones de menu.
   @Override public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.compartir){
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT,getResources().getString(R.string.app_name));
                String aux = "Descarga la app\n";
                //cuando mi app este en play store tengo que cambiar el link.
                //aux = aux + "https://play.google.com/store/apps/details?id=com.whatsapp&gl=ES"+getBaseContext().;
                aux=aux+"https://play.google.com/store/apps/details?id=apps.icm.iglesianavarra&gl=ES";
                i.putExtra(Intent.EXTRA_TEXT,aux);
                startActivity(i);
            }catch (Exception e){

            }
            Toast.makeText(this, "Compartir",Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.buscar){
            Toast.makeText(this, "Buscar",Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.item1){
            Toast.makeText(this, "Discipulado",Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.item2){
            Toast.makeText(this, "Alabanzas",Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.item3){
            Toast.makeText(this, "Diario de intimidad",Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.item4){
            Toast.makeText(this, "Predicas en audio",Toast.LENGTH_SHORT).show();
            return true;


        } return  super.onOptionsItemSelected(item);
    }



}