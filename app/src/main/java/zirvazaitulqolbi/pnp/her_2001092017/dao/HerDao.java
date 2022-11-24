package zirvazaitulqolbi.pnp.her_2001092017.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import zirvazaitulqolbi.pnp.her_2001092017.DbHelp;
import zirvazaitulqolbi.pnp.her_2001092017.model.HerModel;

public class HerDao {
        private DbHelp dbHelp;
        SQLiteDatabase db;

        public HerDao(Context context){ dbHelp = new DbHelp(context);}

        public void insert(HerModel data){
            db = dbHelp.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put(HerModel.COLUMN_NAMA_PESERTA_2017,data.getNama_peserta_2017());
            values.put(HerModel.COLUMN_EMAIL_2017,data.getEmail_2017());
            values.put(HerModel.COLUMN_JENIS_KELAMIN_2017,data.getJenis_kelamin_2017());
            values.put(HerModel.COLUMN_PASSWORD_2017,data.getPassword_2017());
            values.put(HerModel.COLUMN_SKEMA_2017,data.getSkema_pelatihan_2017());
            values.put(HerModel.COLUMN_TANGGAL_2017,data.getTanggal_pelatihan_2017());
            db.insert(HerModel.TABLE_NAME,null,values);
            db.close();
        }

        public void update(HerModel data,String email_2017){
            db = dbHelp.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put(HerModel.COLUMN_NAMA_PESERTA_2017,data.getNama_peserta_2017());
            values.put(HerModel.COLUMN_EMAIL_2017,data.getEmail_2017());
            values.put(HerModel.COLUMN_JENIS_KELAMIN_2017,data.getJenis_kelamin_2017());
            values.put(HerModel.COLUMN_PASSWORD_2017,data.getPassword_2017());
            values.put(HerModel.COLUMN_SKEMA_2017,data.getSkema_pelatihan_2017());
            values.put(HerModel.COLUMN_TANGGAL_2017,data.getTanggal_pelatihan_2017());
            db.update(HerModel.TABLE_NAME,values,"email_2017 = ?",new String[]{email_2017});
            db.close();
        }
        public void detele(int id){
            db = dbHelp.getReadableDatabase();
            String query = "delete from "+HerModel.TABLE_NAME+ "where id_peserta_2017 = ?" +id+" ";
        }

        public boolean cekData(String email_2017){
            boolean cek;
            String query="SELECT * FROM peserta2017 where "+ HerModel.COLUMN_EMAIL_2017+" = '"+email_2017+"'";
            db=dbHelp.getReadableDatabase();
            Cursor cursor=db.rawQuery(query,null);

            if (cursor.moveToFirst()){
                cek = true;
            } else{
                cek = false;
            }
            return cek;
        }

        public HerModel getOnedata (int id_peserta_2017){
            String query="SELECT * FROM peserta2017 where "+HerModel.COLUMN_ID_2017+" = "+id_peserta_2017;
            db=dbHelp.getReadableDatabase();
            Cursor cursor=db.rawQuery(query,null);
            HerModel data = null;
            if(cursor.moveToFirst()){
                data=new HerModel();
                data.setId_peserta_2017(cursor.getInt(0));
                data.setNama_peserta_2017(cursor.getString(1));
                data.setEmail_2017(cursor.getString(2));
                data.setJenis_kelamin_2017(cursor.getString(3));
                data.setPassword_2017(cursor.getString(4));
                data.setSkema_pelatihan_2017(cursor.getString(5));
                data.setTanggal_pelatihan_2017(cursor.getString(6));
            }
            return data;
        }
        public List<HerModel> getAllData(){
            List<HerModel> list = new ArrayList<>();
            String query = "select * from "+HerModel.TABLE_NAME+" order by "+HerModel.COLUMN_NAMA_PESERTA_2017;

            db = dbHelp.getReadableDatabase();
            Cursor cursor = db.rawQuery(query,null);

            if(cursor.moveToFirst()){
                do{
                    HerModel data = new HerModel();
                    data.setId_peserta_2017(cursor.getInt(0));
                    data.setNama_peserta_2017(cursor.getString(1));
                    data.setNama_peserta_2017(cursor.getString(1));
                    data.setEmail_2017(cursor.getString(2));
                    data.setJenis_kelamin_2017(cursor.getString(3));
                    data.setPassword_2017(cursor.getString(4));
                    data.setSkema_pelatihan_2017(cursor.getString(5));
                    data.setTanggal_pelatihan_2017(cursor.getString(6));
                    list.add(data);
                }while (cursor.moveToNext());
            }
            return list;
        }

    }


