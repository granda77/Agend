package itsco.edu.miagenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    public static final int NUEVO_CONTACTO = 10;

    private Button btnAgregar;
    private ListView lista;

    private ArrayList<Contacto> data;
    private ArrayAdapter<Contacto> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAgregar=(Button) findViewById(R.id.btn_ok);
        btnAgregar.setOnClickListener(this);

        lista=(ListView) findViewById(R.id.lista_contactos);
        data = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, data );

        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,NuevaActivity.class);
        startActivityForResult(i,NUEVO_CONTACTO);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Contacto c = data.get(position);
        Intent intent = new Intent(this,
                DetalleActivity.class);
        intent.putExtra("NOMBRE",c.getNombre());
        intent.putExtra("TELEFONO",c.getTelefono());
        intent.putExtra("EMAIL",c.getCorreo());

        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_OK){
            if(requestCode==NUEVO_CONTACTO){
                Contacto c = data.getParcelableExtra("CONTACTO");
                this.data.add(c);

                adapter.notifyDataSetChanged();
            }
        }
    }
}
