package zirvazaitulqolbi.pnp.her_2001092017.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import zirvazaitulqolbi.pnp.her_2001092017.FHer;
import zirvazaitulqolbi.pnp.her_2001092017.R;
import zirvazaitulqolbi.pnp.her_2001092017.dao.HerDao;
import zirvazaitulqolbi.pnp.her_2001092017.model.HerModel;
import zirvazaitulqolbi.pnp.her_2001092017.notif.Notifikasi;

public class HerAdapter extends RecyclerView.Adapter<HerAdapter.ViewRecHolder>{

    private Context context;
    private List<HerModel> mItems;
    Notifikasi notifikasi;

    public HerAdapter(Context context, List<HerModel> mItems) {
        this.context = context;
        this.mItems = mItems;
    }
    @NonNull
    @Override
    public HerAdapter.ViewRecHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_her,parent,false);
        return new HerAdapter.ViewRecHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull HerAdapter.ViewRecHolder holder, int position) {
        final HerModel data = mItems.get(position);
        holder.tvnama_peserta_2017.setText(data.getNama_peserta_2017());
        holder.tvEmail.setText(data.getEmail_2017());
        holder.tvJk.setText(data.getJenis_kelamin_2017());
        holder.tvPassword.setText(data.getPassword_2017());
        holder.tvSkema.setText(data.getSkema_pelatihan_2017());
        holder.tvTanggal.setText(data.getTanggal_pelatihan_2017());
        notifikasi = new Notifikasi(context);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FHer.class);
                intent.putExtra("update",1);
                intent.putExtra("putIdUsername", data.getId_peserta_2017());
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                try {

                    HerDao herDao = new HerDao(context);
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                    alertDialog.setTitle("Konfirmasi");
                    alertDialog.setMessage("Apakah yakin menghapus data? "+data.getNama_peserta_2017());
                    alertDialog.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

                    alertDialog.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            herDao.detele(data.getId_peserta_2017());
                            mItems.remove(holder.getBindingAdapterPosition());
                            notifyDataSetChanged();
                            notifikasi.notif("Data Nama "+data.getNama_peserta_2017()+"Berhasil dihapus","Hapus Data Peserta");
                        }
                    });

                    AlertDialog dialog = alertDialog.create();
                    dialog.show();

                }catch (Exception e){
                    Toast.makeText(context,"Error "+e,Toast.LENGTH_LONG).show();
                }

                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewRecHolder extends RecyclerView.ViewHolder {
        TextView tvnama_peserta_2017,tvEmail,tvJk,tvPassword,tvSkema,tvTanggal;
        public ViewRecHolder(@NonNull View itemView) {
            super(itemView);
            tvnama_peserta_2017 = itemView.findViewById(R.id.tvnama_peserta_2017);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvJk = itemView.findViewById(R.id.tvJk);
            tvPassword = itemView.findViewById(R.id.tvPassword);
            tvSkema = itemView.findViewById(R.id.tvSkema);
            tvTanggal = itemView.findViewById(R.id.tvTanggal);

        }
    }
}
