package com.example.iglesianavarra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class LibrosActivity2 extends AppCompatActivity {

    private ListView listView;

    private ArrayList <String> libros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros2);


        listView = findViewById(R.id.lisviewLibros);
        libros = new ArrayList<>();



        //Inicializacion del objeto en firebase Storage
        StorageReference mStorageRef = FirebaseStorage.getInstance().getReference();

        //traigo la referencia del bucket donde tengo guardado mis libros en pdf de Firebase
        StorageReference ref = mStorageRef.child("libros");

        //codigo para traer todos los titulos de los libros
        ref.listAll().addOnSuccessListener(listResult -> {
            for (StorageReference item : listResult.getItems()) {
                libros.add(item.getName() + "");
            }

            //configuro el adaptador de la lista
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, libros);
            //muestro el adaptador en la lista
            listView.setAdapter(adapter);
            /*se activa al clickear
            listView.setOnItemClickListener((parent, view, position, id) -> {


                final String titulo_libro_seleccion = listView.getItemAtPosition(position).toString();
                //abrir nueva activity
                Intent i = new Intent(getApplicationContext(), VisorPDFActivity.class);
                i.putExtra("TITULO LIBRO", titulo_libro_seleccion);
                startActivity(i);
            });*/


        }).addOnFailureListener((e) -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(LibrosActivity2.this);
            builder1.setMessage("Ha ocurrido un error al cargar los libros. revise su conexion a internet");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Ok",
                    (dialog, id) -> dialog.cancel());
            AlertDialog alert11 = builder1.create();
            alert11.show();
        });
        }
}