package com.example.selecciones2122;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Array de elementos del ListView
        String [] elementos={"León","Zamora","Salamanca","Palencia","Valladolid",
                "Ávila", "Burgos", "Soria", "Segovia"};

        //Adaptador que hace de puente entre el widget y los datos
        ArrayAdapter<String> adaptador;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaramos el objeto ListView y lo enlazamos el control del xml
        ListView lista=(ListView)findViewById(R.id.listView);
        //Creamos el adaptador pasando como parámetro this(esta actividad)
        //La referencia al nuevo fichero de recurso R.layout.fila donde está el
        // formato de cada elemento
        //El array que contiene los elementos que va a mostrar
        adaptador=new ArrayAdapter<String>(this,R.layout.fila,elementos);
        //Asociamos el adaptador con la lista
        lista.setAdapter(adaptador);
        //Fijamos el listener de la lista para saber que ha pulsado el usuario
        lista.setOnItemClickListener(this);
    }

    /**
     * Método que se invoca cuando se hace click en alguno de los elementos de la
     * lista
     * @param a Componente padre donde se hace la selección
     * @param view El widget que se pulsó
     * @param position La posicion que ocupa en la lista
     * @param id El identificador de la fila que se seleccionó
     */
    public void onItemClick(AdapterView<?> a, View view, int position, long id){
        //Enlazamos con el textView que nos muestra información en la aplicación
        TextView t=(TextView)findViewById(R.id.textView);
        //Escribe en el textView la información del elemento clicado.
        t.setText("Has elegido:"+a.getItemAtPosition(position).toString());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}