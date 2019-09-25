package br.com.bossini.usjt_ccp3bn_mcb_fila_de_chamados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChamadoDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "chamados.db";
    private static final int DB_VERSION = 1;

    public ChamadoDBHelper (Context context){
        super (context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(HelpDeskContract.createTableFila());
        sqLiteDatabase.execSQL(HelpDeskContract.createTableChamado());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
