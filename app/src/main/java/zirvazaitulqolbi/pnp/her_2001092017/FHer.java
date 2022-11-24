package zirvazaitulqolbi.pnp.her_2001092017;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import zirvazaitulqolbi.pnp.her_2001092017.dao.HerDao;
import zirvazaitulqolbi.pnp.her_2001092017.model.HerModel;
import zirvazaitulqolbi.pnp.her_2001092017.notif.Notifikasi;

public class FHer extends AppCompatActivity {
    EditText ed_nama2017,edEmail,edPassword;
    TextView tvDate;
    Spinner spinSkema;
    RadioGroup rgJk;
    RadioButton rbPerempuan,rbLaki;
    Button btnSimpan2017;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;

    HerDao herDao;
    Notifikasi notikasi;

    int update,id_peserta_2017;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fher);
        tvDate = findViewById(R.id.tvDate);
        ed_nama2017 = findViewById(R.id.ed_nama2017);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        spinSkema = findViewById(R.id.spinSkema);
        rgJk = findViewById(R.id.rgJk);
        rbPerempuan = findViewById(R.id.rbPerempuan);
        rbLaki = findViewById(R.id.rbLaki);
        btnSimpan2017 = findViewById(R.id.btnSimpan2017);
        tvDate = findViewById(R.id.tvDate);

        herDao = new HerDao(this);
        notikasi = new Notifikasi(FHer.this);

        Intent data=getIntent();
        update=data.getIntExtra("update",0);
        id_peserta_2017=data.getIntExtra("putIdUsername",0);

        if(update==1){
            HerModel herModel = new HerModel();
            herModel = herDao.getOnedata(id_peserta_2017);
            edEmail.setEnabled(false);
            btnSimpan2017.setText("Edit");
            ed_nama2017.setText(herModel.getNama_peserta_2017());
            edEmail.setText(herModel.getEmail_2017());
            edPassword.setText(herModel.getPassword_2017());
            tvDate.setText(herModel.getTanggal_pelatihan_2017());

        }
        simpan();
        tanggal();
    }
    void simpan(){
        btnSimpan2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    HerModel data = new HerModel();
                    data.setNama_peserta_2017(ed_nama2017.getText().toString());
                    data.setEmail_2017(edEmail.getText().toString());
                    data.setPassword_2017(edPassword.getText().toString());
                    data.setSkema_pelatihan_2017(spinSkema.getSelectedItem().toString());
                    data.setTanggal_pelatihan_2017(tvDate.getText().toString());

                    if(update==1){
                        herDao.update(data, String.valueOf(id_peserta_2017));
                        notikasi.notif("Data Email "+edEmail.getText().toString()+"Berhasil diupdate",
                                "update Data Peserta");
                        startActivity(new Intent(FHer.this,
                                ListHer.class));
                    }else {
                        if (herDao.cekData(edEmail.getText().toString()) == true) {
                            Toast.makeText(getApplicationContext(), "Data Email " +
                                    edEmail.getText().toString() + "Sudah ada", Toast.LENGTH_LONG).show();
                        } else {
                            herDao.insert(data);
                            notikasi.notif("Data Email " + edEmail.getText().toString() + "Berhasil disimpan",
                                    "Insert Data Peserta");
                            startActivity(new Intent(FHer.this,
                                    ListHer.class));

                        }
                    }


                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error" + e, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    void tanggal() {
        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd-mm-yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                tvDate.setText(sdf.format(myCalendar.getTime()));
            }
        };

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tanggal();
                new DatePickerDialog(FHer.this, date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
}