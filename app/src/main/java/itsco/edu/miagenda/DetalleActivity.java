package itsco.edu.miagenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    private TextView txtNombre;
    private TextView txtTelefono;
    private TextView txtCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        txtNombre = (TextView)
                findViewById(R.id.txt_nombre);
        txtTelefono = (TextView)
                findViewById(R.id.txt_telefono);
        txtCorreo = (TextView)
                findViewById(R.id.txt_correo);

        Intent data = getIntent();
        txtNombre.setText(data.getStringExtra("NOMBRE"));
        txtTelefono.setText(data.getStringExtra("TELEFONO"));
        txtCorreo.setText(data.getStringExtra("CORREO"));
    }
}
