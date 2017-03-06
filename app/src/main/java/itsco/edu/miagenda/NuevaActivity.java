package itsco.edu.miagenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NuevaActivity extends AppCompatActivity
implements View.OnClickListener {

    private Button btnOk;
    private Button btnCancelar;

    private EditText txtNombre;
    private EditText txtTelefono;
    private EditText txtCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva);

        btnOk = (Button)
                findViewById(R.id.btn_ok);

        btnOk.setOnClickListener(this);

        btnCancelar = (Button)
                findViewById(R.id.btn_cancelar);

        btnCancelar.setOnClickListener(this);

        txtNombre = (EditText)
                findViewById(R.id.txt_nombre);

        txtTelefono = (EditText)
                findViewById(R.id.txt_telefono);

        txtCorreo = (EditText)
                findViewById(R.id.txt_correo);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btnOk.getId()){
            Intent data = getIntent();

            Contacto c = new Contacto();

            c.setNombre(
                    txtNombre.getText().toString());
            c.setTelefono(
                    txtTelefono.getText().toString());
            c.setCorreo(
                    txtCorreo.getText().toString());

            data.putExtra("CONTACTO", c);

            setResult(RESULT_OK,data);
        }

        if(v.getId()==btnCancelar.getId()){
            setResult(RESULT_CANCELED);
        }
        finish();

    }
}
