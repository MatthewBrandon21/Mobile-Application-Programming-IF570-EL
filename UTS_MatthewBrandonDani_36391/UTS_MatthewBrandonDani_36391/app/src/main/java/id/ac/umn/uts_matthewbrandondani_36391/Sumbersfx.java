package id.ac.umn.uts_matthewbrandondani_36391;

import android.net.Uri;
import java.io.Serializable;

public class Sumbersfx implements Serializable {
    private String judul, keterangan, soundURI;
    public Sumbersfx(String judul, String keterangan, String soundURI){
        this.judul = judul;
        this.keterangan = keterangan;
        this.soundURI = soundURI;
    }
    public String getJudul(){return this.judul;}
    public String getKeterangan(){return this.keterangan;}
    public Uri getSoundURI(){return Uri.parse(this.soundURI);}
    public void setJudul(String judul){this.judul = judul;}
    public void setKeterangan(String keterangan){this.keterangan = keterangan;}
    public void setSoundURI(String soundURI){this.soundURI = soundURI;}
    public String toString(){return this.getJudul() + " => " + this.getKeterangan();}
}
