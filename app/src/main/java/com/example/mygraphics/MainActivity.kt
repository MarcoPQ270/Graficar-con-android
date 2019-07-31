package com.example.mygraphics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val entries = ArrayList<BarEntry>()//variable para los datos a graficar
    val labels = ArrayList<String>()//estas son las etiquetas de los meses, se podria decir que es lo que se va graficar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //mandamos llamar la funcion al iniciar la actividad
        setBarChart()
    }

    fun setBarChart() {
        //Agregamos datos de tipo float, en el primer paramtro
        // se indica el angulo de las Y y en en
        // segundo parametro el lado de X
        entries.add(BarEntry(8f, 0))
        entries.add(BarEntry(2f, 1))
        entries.add(BarEntry(5f, 2))
        entries.add(BarEntry(20f, 3))
        entries.add(BarEntry(15f, 4))
        entries.add(BarEntry(19f, 5))

        //Anadimos los datos a un dataset,
        // le pasamos como primer paramtro el arreglo de
        // lista y como segundo parametro el nombre de nuestro data set
        val barDataSet = BarDataSet(entries, "Ventas")

        //Agregamos el nombre de cada barra
        labels.add("18-Jul")
        labels.add("19-Jul")
        labels.add("20-Jul")
        labels.add("21-Jul")
        labels.add("22-Jul")
        labels.add("23-Jul")
        //Pasaremos los dos arreglos a un BarData
        val data = BarData(labels, barDataSet)
        // Le pasamos los datos a nuestra grafica en el archivo xml
        barChart.data = data
        // Agregamos la descripsion de nuestra grafica
        barChart.setDescription("Ventas por mes")

        //Configuramos el color de las barras
        //barDataSet.setColors(ColorTemplate.COLORFUL_COLORS)
        barDataSet.color = resources.getColor(R.color.colorAccent)

        //Tiempo de animacion de las barras
        barChart.animateY(5000)

    }
}