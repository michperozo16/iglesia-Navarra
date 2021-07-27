package com.example.iglesianavarra;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SegundaActivity2<InstruccionesActivity> extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda2);


        }

        public void irDiscipulado(View view){
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://edu.cosechamundialtudela.com/login/index.php"));
            startActivity(i);
        }
        public void irAlavanzas(View view){
            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://cosechamundialnavarra.com/alabanzas-y-adoracion/"));
            startActivity(i);
        }
        public void irDiario(View view){
            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/groups/911992186288496"));
            startActivity(i);
        }
        public void irPredicas(View view){
            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://cosechamundialnavarra.com/predicas-en-audios/"));
            startActivity(i);

    }

    @SuppressLint("NonConstantResourceId")
    public void IrAPrimeraPantalla (View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);


    }
    // Metodo para mostrar y ocultar menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;

    }
    // Metodo para asignar las funciones correspondientes a las opciones.
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.compartir){
            Toast.makeText(this, "Compartir",Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.buscar){
            Toast.makeText(this, "Buscar",Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.item1){
            irDiscipulado(null);
            Toast.makeText(this, "Discipulado",Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.item2){
            irAlavanzas(null);
            Toast.makeText(this, "Alabanzas",Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.item3){
            irDiario(null);
            Toast.makeText(this, "Diario de intimidad",Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.item4){
            irPredicas(null);
            Toast.makeText(this, "Audios",Toast.LENGTH_SHORT).show();
            return true;
        } return  super.onOptionsItemSelected(item);
    }
}