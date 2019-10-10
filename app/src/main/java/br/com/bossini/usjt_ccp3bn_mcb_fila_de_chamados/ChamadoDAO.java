package br.com.bossini.usjt_ccp3bn_mcb_fila_de_chamados;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChamadoDAO {

    private Context context;

    public ChamadoDAO (Context context){
        this.context = context;
    }

    public List <Chamado> busca (String chave){
        ChamadoDBHelper dbHelper = new ChamadoDBHelper(context);
        List <Chamado> chamados = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql =
                String.format(
                        Locale.getDefault(),
                        "SELECT * FROM %1$s INNER JOIN %2$s ON %1$s.%3$s = %2$s.%3$s;",
                        HelpDeskContract.FilaContract.TABLE_NAME,
                        HelpDeskContract.ChamadoContract.TABLE_NAME,
                        HelpDeskContract.FilaContract.COLUMN_NAME_ID
                );
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()){
            int idChamado =
                    cursor.getInt(
                            cursor.
                                    getColumnIndex(
                                            //String.format(
                                            //        Locale.getDefault(),
                                            //        "%s.%s",
                                           //         HelpDeskContract.ChamadoContract.TABLE_NAME,
                                                    HelpDeskContract.ChamadoContract.COLUMN_NAME_ID
                                            ));//));
            String descricao =
                    cursor.getString(
                            cursor.
                                    getColumnIndex(
                                            //String.format(
                                            //        Locale.getDefault(),
                                            //        "%1$s.%2$s",
                                            //        HelpDeskContract.ChamadoContract.TABLE_NAME,
                                                    HelpDeskContract.ChamadoContract.COLUMN_NAME_DESCRICAO


                                            ));//);
            String status =
                    cursor.getString(
                            cursor.getColumnIndex(
                                    //String.format(
                                    //        Locale.getDefault(),
                                     //       "%s.%s",
                                     //       HelpDeskContract.ChamadoContract.TABLE_NAME,
                                            HelpDeskContract.ChamadoContract.COLUMN_NAME_STATUS
                                    ));//);
            long dtAbertura =
                    cursor.getLong(
                            cursor.getColumnIndex(
                                    //String.format(
                                    //        Locale.getDefault(),
                                     //       "%s.%s",
                                    //        HelpDeskContract.ChamadoContract.TABLE_NAME,
                                            HelpDeskContract.ChamadoContract.COLUMN_NAME_DT_ABERTURA


                                    ));//);

            long dtFechamento =
                    cursor.getLong(
                            cursor.getColumnIndex(
                                    //String.format(
                                    //        Locale.getDefault(),
                                     //       "%s.%s",
                                     //     HelpDeskContract.ChamadoContract.TABLE_NAME,
                                            HelpDeskContract.ChamadoContract.COLUMN_NAME_DT_FECHAMENTO


                                    ));//);

            String nomeFila =
                    cursor.getString(
                            cursor.getColumnIndex(
                                    //String.format(
                                    //        Locale.getDefault(),
                                    //        "%s.%s",
                                    //        HelpDeskContract.FilaContract.TABLE_NAME,
                                            HelpDeskContract.FilaContract.COLUMN_NAME_NOME


                                    ));//);

            int idFila =
                    cursor.getInt(
                            cursor.getColumnIndex(
                                    //String.format(
                                    //        Locale.getDefault(),
                                   //         "%s.%s",
                                   //         HelpDeskContract.FilaContract.TABLE_NAME,
                                            HelpDeskContract.FilaContract.COLUMN_NAME_ID


                                    ));//);

            int iconId =
                    cursor.getInt(
                            cursor.getColumnIndex(
                                    //String.format(
                                    //        Locale.getDefault(),
                                    //        "%s.%s",
                                    //        HelpDeskContract.FilaContract.TABLE_NAME,

                                            HelpDeskContract.FilaContract.COLUMN_NAME_ICON_ID

                                    ));//);

            Fila fila = new Fila (idFila, nomeFila, iconId);
            Chamado chamado = new Chamado (idChamado, fila, descricao, new Date(dtAbertura),
                    new Date (dtFechamento), status);
            System.out.println(chamados);
            chamados.add(chamado);
            System.out.println(chamados);
        }
        //cursor.moveToNext();
        cursor.close();
        return chamados;
    }
}
