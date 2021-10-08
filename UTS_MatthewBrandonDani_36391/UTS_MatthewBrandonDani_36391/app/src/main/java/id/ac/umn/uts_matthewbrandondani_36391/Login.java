package id.ac.umn.uts_matthewbrandondani_36391;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText nama;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        nama = (EditText) findViewById(R.id.nama);
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(nama.getText())){
                    nama.setError("Harap Di-isi");
                } else{
                    Intent intentLibrary = new Intent(Login.this, Library.class);
                    String namaLogin = nama.getText().toString();
                    intentLibrary.putExtra("Nama", namaLogin);
                    startActivity(intentLibrary);
                }
            }
        });
    }
}
