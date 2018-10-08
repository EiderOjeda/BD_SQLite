package com.example.eider.basededatossqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Mantenimiento extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="base.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_CURSOS="CREATE TABLE CURSOS(CODIGO TEXT PRIMARY KEY, CURSO TEXT, CARRERA TEXT)";

    public Mantenimiento(Context context) {

        super(context, NOMBRE_BD, null, VERSION_BD);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){

        sqLiteDatabase.execSQL(TABLA_CURSOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLA_CURSOS);
        sqLiteDatabase.execSQL(TABLA_CURSOS);

    }

    public void agregarCursos(String codigo, String curso, String carrera){

        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO CURSOS VALUES('"+codigo+"','"+curso+"','"+carrera+"')");
            bd.close();
        }
    }


}