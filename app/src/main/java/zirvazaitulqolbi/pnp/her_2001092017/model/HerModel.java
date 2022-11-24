package zirvazaitulqolbi.pnp.her_2001092017.model;

public class HerModel {
    public static final String TABLE_NAME = "peserta2017";
    public static final String COLUMN_ID_2017 = "id_peserta_2017";
    public static final String COLUMN_NAMA_PESERTA_2017 = "nama_peserta_2017";
    public static final String COLUMN_EMAIL_2017 = "email_2017";
    public static final String COLUMN_JENIS_KELAMIN_2017 = "jenis_kelamin_2017";
    public static final String COLUMN_PASSWORD_2017 = "password_2017";
    public static final String COLUMN_SKEMA_2017 = "skema_pelatihan_2017";
    public static final String COLUMN_TANGGAL_2017 = "tanggal_pelatihan_2017";

    //create table sql query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    +COLUMN_ID_2017 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +COLUMN_NAMA_PESERTA_2017 + " TEXT,"
                    +COLUMN_EMAIL_2017 + " TEXT,"
                    +COLUMN_JENIS_KELAMIN_2017 + " TEXT,"
                    +COLUMN_PASSWORD_2017 + " TEXT,"
                    +COLUMN_SKEMA_2017 + " TEXT,"
                    +COLUMN_TANGGAL_2017+ " TEXT"
                    +")";

    private int id_peserta_2017;
    private String nama_peserta_2017;
    private String email_2017;
    private String jenis_kelamin_2017;
    private String password_2017;
    private String skema_pelatihan_2017;
    private String tanggal_pelatihan_2017;

    public HerModel(){
    }

    public int getId_peserta_2017() {
        return id_peserta_2017;
    }

    public void setId_peserta_2017(int id_peserta_2017) {
        this.id_peserta_2017 = id_peserta_2017;
    }

    public String getNama_peserta_2017() {
        return nama_peserta_2017;
    }

    public void setNama_peserta_2017(String nama_peserta_2017) {
        this.nama_peserta_2017 = nama_peserta_2017;
    }

    public String getEmail_2017() {
        return email_2017;
    }

    public void setEmail_2017(String email_2017) {
        this.email_2017 = email_2017;
    }

    public String getJenis_kelamin_2017() {
        return jenis_kelamin_2017;
    }

    public void setJenis_kelamin_2017(String jenis_kelamin_2017) {
        this.jenis_kelamin_2017 = jenis_kelamin_2017;
    }

    public String getPassword_2017() {
        return password_2017;
    }

    public void setPassword_2017(String password_2017) {
        this.password_2017 = password_2017;
    }

    public String getSkema_pelatihan_2017() {
        return skema_pelatihan_2017;
    }

    public void setSkema_pelatihan_2017(String skema_pelatihan_2017) {
        this.skema_pelatihan_2017 = skema_pelatihan_2017;
    }

    public String getTanggal_pelatihan_2017() {
        return tanggal_pelatihan_2017;
    }

    public void setTanggal_pelatihan_2017(String tanggal_pelatihan_2017) {
        this.tanggal_pelatihan_2017 = tanggal_pelatihan_2017;
    }
}
