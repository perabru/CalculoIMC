package com.example.calculoimc;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
public class HistoricoActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)

        val listView = findViewById<ListView>(R.id.listViewHistorico)

        // Recupera a lista enviada da MainActivity
        val historico = intent.getStringArrayListExtra("historico") ?: arrayListOf()

        // Mostra os dados no ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, historico)
        listView.adapter = adapter
    }
}
