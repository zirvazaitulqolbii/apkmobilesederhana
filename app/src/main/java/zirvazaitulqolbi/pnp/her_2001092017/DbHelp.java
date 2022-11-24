package zirvazaitulqolbi.pnp.her_2001092017;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import zirvazaitulqolbi.pnp.her_2001092017.model.HerModel;

public class DbHelp extends SQLiteOpenHelper {

    private static final String DbName="dts_2017";
    private static final int DbVersion=1;

    private Context context;

    public DbHelp(Context context) {
        super(context, DbName, null, DbVersion);
        this.context = context;
    }

    public DbHelp(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(HerModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
