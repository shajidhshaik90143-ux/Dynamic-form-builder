package com.example.dynamicbuilder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class ChartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)

        val chart = findViewById<BarChart>(R.id.barChart)

        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(1f, 4f))
        entries.add(BarEntry(2f, 6f))
        entries.add(BarEntry(3f, 8f))
        entries.add(BarEntry(4f, 3f))

        val dataSet = BarDataSet(entries, "Sample Data")

        val data = BarData(dataSet)

        chart.data = data
        chart.invalidate()
    }
}