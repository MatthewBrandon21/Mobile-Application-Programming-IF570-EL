package id.ac.umn.uts_matthewbrandondani_36391;

import android.annotation.SuppressLint;
import java.util.LinkedList;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder> {
    private LinkedList<Sumbersfx> mDaftarSfx;
    private LayoutInflater mInflater;
    private Context mContext;
    public LibraryAdapter(Context context, LinkedList<Sumbersfx> mDaftarSfx){
        this.mDaftarSfx = mDaftarSfx;
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
    }
    @NonNull
    @Override
    public LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_sfx, parent, false);
        return new LibraryViewHolder(view, this);
    }
    @Override
    public void onBindViewHolder(@NonNull LibraryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Sumbersfx mSumberSfx = mDaftarSfx.get(position);
        holder.tvJudul.setText(mSumberSfx.getJudul());
        holder.tvKeterangan.setText(mSumberSfx.getKeterangan());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDaftarSfx.remove(position);
                notifyItemRemoved(position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mDaftarSfx.size();
    }
    public class LibraryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvJudul, tvKeterangan;
        private ImageButton btnDelete;
        private Sumbersfx mSumberSound;
        private int mPosisi;
        private LibraryAdapter mAdapter;
        public LibraryViewHolder(@NonNull View itemView, LibraryAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            tvKeterangan = (TextView) itemView.findViewById(R.id.tvKeterangan);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btnDelete);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v){
            mPosisi = getLayoutPosition();
            mSumberSound = mDaftarSfx.get(mPosisi);
            Intent detailIntent = new Intent(mContext, SFXDetail.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("SoundDetail", mSumberSound);
            detailIntent.putExtras(bundle);
            String namaSound = tvJudul.getText().toString();
            detailIntent.putExtra("NamaSound", namaSound);
            mContext.startActivity(detailIntent);
        }
    }
}
