package com.example.sample_simple_list_item_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //プログラミング言語一覧
        val languages = mutableListOf("Java","Kotlin","C#","HTML","CSS","JavaScript","PHP","Unity","Swift","Python","Ruby")

        //プログラミング言語説明一覧
        val explanations = mutableListOf("なんでも作れる万能言語","Android公式の開発言語","マイクロソフトが開発している言語","Webページを作成するために開発された言語","Webページのスタイルを指定するための言語","Webサイトに動きをつけるために開発された言語","サーバーサイドの言語","ゲーム開発プラットフォーム","iOSアプリの言語","AIが作れる言語？","日本人が開発した言語")

        //ListViewの取得
        val languages_list = findViewById<ListView>(R.id.languages_list)

        //SimpleAdapterで使用するMutableListオブジェクトを用意
        //プログラミング言語と説明を紐付けるMap
        val languages_sets:MutableList<MutableMap<String,String>> = mutableListOf()

        //1つ1つプログラミング言語と説明を紐づける
        var setCount:Int = 0
        while(setCount < languages.size) {
            val set = mutableMapOf("language" to languages[setCount],"explanation" to explanations[setCount])
            languages_sets.add(set)
            setCount++
        }

        //SimpleAdapter第4引数from用データの用意
        val from = arrayOf("language","explanation")

        //SimpleAdapter第5引数to用データの用意
        val to = intArrayOf(android.R.id.text1,android.R.id.text2)

        //SimpleAdapterの作成
        val adapter = SimpleAdapter(applicationContext,languages_sets,android.R.layout.simple_list_item_2,from,to)
        //アダプタの登録
        languages_list.adapter = adapter
    }
}
