package id.ac.umn.uts_matthewbrandondani_36391;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.LinkedList;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;


public class Library extends AppCompatActivity {
    RecyclerView rvDaftarSfx;
    LibraryAdapter mAdapter;
    LinkedList<Sumbersfx> daftarSfx = new LinkedList<>();
    ImageButton btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_page);
        Intent mainIntent = getIntent();
        String namauser = mainIntent.getStringExtra("Nama");
        Toast.makeText(Library.this,"Selamat Datang, " + namauser, Toast.LENGTH_LONG).show();
        getSupportActionBar(). setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(namauser);
        isiDaftarSound();
        rvDaftarSfx = (RecyclerView) findViewById(R.id.RV);
        mAdapter = new LibraryAdapter(this, daftarSfx);
        rvDaftarSfx.setAdapter(mAdapter);
        rvDaftarSfx.setLayoutManager(new LinearLayoutManager(this));
        btnDelete = (ImageButton) findViewById(R.id.btnDelete);
    }
    public void isiDaftarSound(){
        daftarSfx.add(new Sumbersfx("Old Projector", "Suara proyektor menyala", "android.resource://" + getPackageName() + "/" + R.raw.projector_old));
        daftarSfx.add(new Sumbersfx("Game Sound Mechanic", "Suara game untuk suatu action", "android.resource://" + getPackageName() + "/" + R.raw.game_sound_mechanical));
        daftarSfx.add(new Sumbersfx("Game Sound Steampunk", "Suara game untuk membuka pintu", "android.resource://" + getPackageName() + "/" + R.raw.game_sound_steampunk));
        daftarSfx.add(new Sumbersfx("Cat Kitten Meow", "Suara kucing lucu sekali", "android.resource://" + getPackageName() + "/" + R.raw.kitten_meow));
        daftarSfx.add(new Sumbersfx("Horror Male Laugh", "Suara ketawa mengerikan", "android.resource://" + getPackageName() + "/" + R.raw.horror_laugh_male_demonic));
        daftarSfx.add(new Sumbersfx("Horror Scrape", "Suara untuk suasana horror", "android.resource://" + getPackageName() + "/" + R.raw.horror_scrape));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_profile) {
            Intent profileIntent = new Intent(Library.this, Profile.class);
            startActivity(profileIntent);
        } else if (id == R.id.menu_home) {
            Intent homeIntent = new Intent(Library.this, MainActivity.class);
            startActivity(homeIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
