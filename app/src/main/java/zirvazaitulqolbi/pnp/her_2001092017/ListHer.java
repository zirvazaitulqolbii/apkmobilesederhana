package zirvazaitulqolbi.pnp.her_2001092017;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import zirvazaitulqolbi.pnp.her_2001092017.adapter.HerAdapter;
import zirvazaitulqolbi.pnp.her_2001092017.dao.HerDao;
import zirvazaitulqolbi.pnp.her_2001092017.model.HerModel;

public class ListHer extends AppCompatActivity {
    FloatingActionButton fabTambah2017;
    RecyclerView rvPeserta2017;
    HerDao herDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_her);

        fabTambah2017 = findViewById(R.id.fabTambah2017);
        rvPeserta2017 = findViewById(R.id.rvPeserta2017);

        herDao = new HerDao(this);

        ListHer();

        fabTambah2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListHer.this,
                        FHer.class));
            }
        });
    }
    private void ListHer() {
        try {
            List<HerModel> mItems = new ArrayList<>();
            mItems.clear();
            List<HerModel> list = herDao.getAllData();
            for(HerModel datas:list){
                HerModel md = new HerModel();
                md.setId_peserta_2017(datas.getId_peserta_2017());
                md.setNama_peserta_2017(datas.getNama_peserta_2017());
                md.setEmail_2017(datas.getEmail_2017());
                md.setJenis_kelamin_2017(datas.getJenis_kelamin_2017());
                md.setPassword_2017(datas.getPassword_2017());
                md.setSkema_pelatihan_2017(datas.getSkema_pelatihan_2017());
                md.setTanggal_pelatihan_2017(datas.getTanggal_pelatihan_2017());
                mItems.add(md);
            }
            HerAdapter adapter = new HerAdapter(ListHer.this, mItems);
            rvPeserta2017.setHasFixedSize(true);
            rvPeserta2017.setLayoutManager(new LinearLayoutManager(this));
            rvPeserta2017.setAdapter(adapter);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error "+e,
                    Toast.LENGTH_LONG).show();
        }
    }
}