package br.com.bossini.usjt_ccp3bn_mcb_fila_de_chamados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaChamadosActivity extends AppCompatActivity {

    private ListView chamadosListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chamados);
        Intent origemIntent = getIntent();
        String nomeFila = origemIntent.getStringExtra("nome_fila");
        List <Chamado> chamados = buscaChamados(nomeFila);
        chamadosListView = findViewById(R.id.chamadosListView);
        /*ArrayAdapter <Chamado> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        chamados);*/
        ChamadoAdapter adapter = new ChamadoAdapter(this, chamados);
        chamadosListView.setAdapter(adapter);
        /*chamadosListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });*/
        chamadosListView.setOnItemClickListener((
                adapterView, view, position, id
        ) -> {
            Chamado chamadoSelecionado = chamados.get(position);
            Intent intent
                    = new Intent (this,
                    DetalhesChamadoActivity.class);
            intent.putExtra(
                    "chamado_selecionado",
                    chamadoSelecionado);
            startActivity(intent);

        });
    }

    public List <Chamado> geraListaChamados (){
        List <Chamado> chamados = new ArrayList<>();
        chamados.add(
                new Chamado (
                        new Fila ("Desktops",
                        R.drawable.ic_computer_black_24dp),
                        "Computador da secretária quebrado",
                        new Date(),
                        null,
                        "Aberto"

                )
        );
        chamados.add(new Chamado (
                new Fila ("Telefonia",
                        R.drawable. ic_phone_in_talk_black_24dp ),
                "Telefone não funciona.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Redes",
                        R.drawable. ic_network_check_black_24dp ),
                "Manutenção no proxy.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Servidores", R.drawable. ic_poll_black_24dp ),
                "Lentidão generalizada.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable. ic_new_releases_black_24dp ),
                "CRM",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable. ic_new_releases_black_24dp ),
                "Gestão de Orçamento",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Redes",
                        R.drawable. ic_network_check_black_24dp ),
                "Internet com lentidão",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable. ic_new_releases_black_24dp ),
                "Chatbot",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (new Fila ("Novos Projetos",
                R.drawable. ic_new_releases_black_24dp ),
                "Chatbot",
                new Date(),
                null,
                "Aberto")
        );
        return chamados;
    }

    /*public List<String> geraListaChamados(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Desktops: Computador da secretária quebrado.");
        lista.add("Telefonia: Telefone não funciona.");
        lista.add("Redes: Manutenção no proxy.");
        lista.add("Servidores: Lentidão generalizada.");
        lista.add("Novos Projetos: CRM");
        lista.add("Manutenção Sistema ERP: atualizar versão.");
        lista.add("Novos Projetos: Rede MPLS");
        lista.add("Manutenção Sistema de Vendas: incluir pipeline.");
        lista.add("Manutenção Sistema ERP: erro contábil");
        lista.add("Novos Projetos: Gestão de Orçamento");
        lista.add("Novos Projetos: Big Data");
        lista.add("Manoel de Barros");
        lista.add("Redes: Internet com lentidão");
        lista.add("Novos Projetos: Chatbot");
        lista.add("Desktops: troca de senha");
        lista.add("Desktops: falha no Windows");
        lista.add("Novos Projetos: ITIL V3");
        lista.add("Telefonia: liberar celular");
        lista.add("Telefonia: mover ramal");
        lista.add("Redes: ponto com defeito");
        lista.add("Novos Projetos: ferramenta EMM");
        return lista;
    }*/

    public List <Chamado> buscaChamados (String chave){
        List <Chamado> resultado = new ArrayList<>();
        if (chave == null || chave.isEmpty())
            return resultado;
        for (Chamado chamado: geraListaChamados()){
            if (chamado.getFila().getNome().toLowerCase().contains(chave.toLowerCase()))
                resultado.add(chamado);
        }
        return resultado;
    }
}
