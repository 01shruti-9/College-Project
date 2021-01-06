package rmcet.db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.rmcet.alumni.model.Alumini;
import com.rmcet.alumni.model.Student;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_NAME = "alumnidata";

    private static final String TABLE_USER = "UserRegister";
    private static final String TABLE_ALUMNI = "alumni";
    private static final String TABLE_STUDENT = "student";
    private static final String TABLE_STAFF = "staff";
    private static final String TABLE_COLLEGE = "college";
    private static final String TABLE_FEED = "feeds";

    private static final String UID ="_id";
    private static final String U_RNAME ="UserName";
    private static final String U_RPASS ="Password";
    private static final String U_RMOBI ="MobiNO";

    private static final String AID ="id";
    private static final String ALU_FIR_NAME ="firstname";
    private static final String ALU_MID_NAME ="middlename";
    private static final String ALU_LAS_NAME ="lastname";
    private static final String ALU_PASS ="Password";
    private static final String ALU_MOBI ="MobiNO";
    private static final String ALU_MAIL ="Mail";

    private static final String STD ="id";
    private static final String STD_FIR_NAME ="firstname";
    private static final String STD_MID_NAME ="middlename";
    private static final String STD_LAS_NAME ="lastname";
    private static final String STD_PASS ="Password";
    private static final String STD_MOBI ="MobiNO";

    private static final String STF ="id";
    private static final String STF_FIR_NAME ="firstname";
    private static final String STF_MID_NAME ="middlename";
    private static final String STF_LAS_NAME ="lastname";
    private static final String STF_PASS ="Password";
    private static final String STF_MOBI ="MobiNO";

    private static final String FEEDID ="_id";
    private static final String FBYUSER ="fbyuser";
    private static final String FCONTACT ="fcontact";
    private static final String FCOMMENT ="fcomment";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_USER =
                "CREATE TABLE " + TABLE_USER + "("
                        + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + U_RNAME + " TEXT,"
                        + U_RPASS + " TEXT,"
                        + U_RMOBI + " TEXT);";
        db.execSQL(CREATE_TABLE_USER);

            String CREATE_TABLE_ALUMNI =
                    "CREATE TABLE " + TABLE_ALUMNI + "("
                            + AID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + ALU_FIR_NAME + " TEXT,"
                            + ALU_MID_NAME + " TEXT,"
                            + ALU_LAS_NAME + " TEXT,"
                            + ALU_PASS + " TEXT,"
                            + ALU_MAIL + " TEXT,"
                            + ALU_MOBI + " TEXT);";
            db.execSQL(CREATE_TABLE_ALUMNI);

        String CREATE_TABLE_STUDENT =
                "CREATE TABLE " + TABLE_STUDENT + "("
                        + STD + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + STD_FIR_NAME + " TEXT,"
                        + STD_MID_NAME + " TEXT,"
                        + STD_LAS_NAME + " TEXT,"
                        + STD_PASS + " TEXT,"
                        + STD_MOBI + " TEXT);";
        db.execSQL(CREATE_TABLE_STUDENT);

        String CREATE_TABLE_STAFF =
                "CREATE TABLE " + TABLE_STAFF + "("
                        + STF + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + STF_FIR_NAME + " TEXT,"
                        + STF_MID_NAME + " TEXT,"
                        + STF_LAS_NAME + " TEXT,"
                        + STF_PASS + " TEXT,"
                        + STF_MOBI + " TEXT);";
        db.execSQL(CREATE_TABLE_STAFF);

        String CREATE_TABLE_FEED =
                "CREATE TABLE " + TABLE_FEED + "("
                        + FEEDID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + FBYUSER + " TEXT,"
                        + FCONTACT + " TEXT,"

                        + FCOMMENT + " TEXT);";
        db.execSQL(CREATE_TABLE_FEED);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALUMNI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STAFF);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FEED);
        // Create tables again
        onCreate(db); }

    // Adding new Users
    public void addUsers(String UserN,String Pass,String Mobi)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();



            values.put(U_RNAME, UserN);
            values.put(U_RPASS, Pass);
            values.put(U_RMOBI, Mobi);

            // Inserting Row
            db.insertWithOnConflict(TABLE_USER, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close(); // Closing database connection
    }
    // End of adding new users

    public void addalumni(String t1,String t2,String t3,String t4,String t5)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        try {

            values.put(ALU_FIR_NAME, t1 );
            values.put(ALU_MID_NAME, t2);
            values.put(ALU_LAS_NAME, t3);
            values.put(ALU_MAIL, t4);
            values.put(ALU_MOBI, t5);

            // Inserting Row
            db.insertWithOnConflict(TABLE_ALUMNI, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close(); // Closing database connection
    }




    // Adding new FEEDBACK
    public void addFeedback(String b1,String b2,String b3)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();


            values.put(FBYUSER, b1);
            values.put(FCONTACT, b2);
            values.put(FCOMMENT, b3);


            // Inserting Row
            db.insertWithOnConflict(TABLE_FEED, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close(); // Closing database connection
    }
    // End of adding new FEEDBACK

    public String getHelpPass(String uu1,String uu2) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select " + U_RPASS + " from "+TABLE_USER + " where " +U_RNAME+"='"+uu1+"'AND " +U_RMOBI+"='"+uu2+"'",null);
        if (c.moveToFirst())
        {
            return c.getString(c.getColumnIndex(U_RPASS));
        }
        else
        {
            return null;
        }
    }

    public boolean getLogData(String un,String pw) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from "+ TABLE_USER + " where " + U_RNAME+"='"+un+"' AND " +U_RPASS+"='"+pw+"'",null);
        if (c.moveToFirst())
        {
            return true;

        }
        else
        {
            return false;
        }
    }

    public boolean getLogData(String fn,String mn,String ln,String pw,String mb) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from "+ TABLE_ALUMNI + " where " + ALU_FIR_NAME+"='"+fn+"' AND " +ALU_PASS+"='"+pw+"'",null);
        if (c.moveToFirst())
        {
            return true;
        }
        else
        {
            return false;
        }


    }

    public Cursor getAllDatabyAlumni()
    {
        SQLiteDatabase db1 = this.getReadableDatabase();
        String buildSQL = "SELECT * FROM " + TABLE_ALUMNI;
        return db1.rawQuery(buildSQL, null);

    }






}
