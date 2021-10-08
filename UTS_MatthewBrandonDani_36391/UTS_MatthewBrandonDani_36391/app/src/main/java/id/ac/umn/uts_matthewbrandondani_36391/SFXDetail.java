package id.ac.umn.uts_matthewbrandondani_36391;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SFXDetail extends AppCompatActivity {
    private Button btnPlay;
    private TextView tvJudul;
    private TextView tvKeterangan;
    private ImageView soundDetail;
    MediaPlayer player = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sfx_detail);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        tvJudul = (TextView) findViewById(R.id.etJudul);
        tvKeterangan = (TextView) findViewById(R.id.etKeterangan);
        soundDetail = (ImageView) findViewById(R.id.soundDetail);
        Intent detailIntent = getIntent();
        Bundle bundle = detailIntent.getExtras();
        Sumbersfx ss =(Sumbersfx) bundle.getSerializable("SoundDetail");
        String judul = detailIntent.getStringExtra("NamaSound");
        getSupportActionBar(). setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(judul);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tvJudul.setText(ss.getJudul());
        tvKeterangan.setText(ss.getKeterangan());
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    player = MediaPlayer.create(SFXDetail.this, ss.getSoundURI());
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                        }
                    });
                } catch (Exception e){
                    e.printStackTrace();
                    if(player != null){
                        player.release();
                    }
                }
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        player.stop();
        player.release();
        return true;
    }
}
