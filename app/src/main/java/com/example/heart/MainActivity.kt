package com.example.heart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.ColorTemplate


class MainActivity : AppCompatActivity() {
    lateinit var lineChart: LineChart
    var lineData: LineData? = null

    var lineEntries1: ArrayList<Entry>? = null
    var lineEntries2: ArrayList<Entry>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lineChart = findViewById(R.id.lineChart)

        entries
        entries2

        val xAxisLabels = arrayListOf("","Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

        val set1 = LineDataSet(lineEntries1, "Data set 1")
        set1.apply {
            this.color = Color.BLUE
            this.setDrawValues(false)
            this.setColors(Color.BLUE)
            this.valueTextColor = Color.BLACK
            this.valueTextSize = 18f
            this.mode = LineDataSet.Mode.CUBIC_BEZIER
        }
        val set2 = LineDataSet(lineEntries2, "Data set 2")
        set2.apply {
            this.color = Color.BLUE
            this.setDrawValues(false)
            this.setColors(Color.RED)
            this.valueTextColor = Color.BLACK
            this.valueTextSize = 18f
            this.mode = LineDataSet.Mode.CUBIC_BEZIER
        }

        val dataSets: ArrayList<LineDataSet> = ArrayList()
        dataSets.add(set1)
        dataSets.add(set2)


        lineChart.apply {
            this.axisRight.isEnabled = false
            this.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabels)
            this.xAxis.position = XAxis.XAxisPosition.BOTTOM
            this.data = LineData(dataSets as List<ILineDataSet>?)
        }




    }

    private val entries: Unit
        get() {
            lineEntries1 = ArrayList<Entry>()
            lineEntries1!!.add(Entry(1f, 50f))
            lineEntries1!!.add(Entry(2f, 70f))
            lineEntries1!!.add(Entry(3f, 30f))
            lineEntries1!!.add(Entry(4f, 90f))
            lineEntries1!!.add(Entry(5f, 80f))
            lineEntries1!!.add(Entry(6f, 110f))
            lineEntries1!!.add(Entry(7f, 120f))
        }

    private val entries2: Unit
        get() {
            lineEntries2 = ArrayList<Entry>()
            lineEntries2!!.add(Entry(1f, 40f))
            lineEntries2!!.add(Entry(2f, 50f))
            lineEntries2!!.add(Entry(3f, 70f))
            lineEntries2!!.add(Entry(4f, 30f))
            lineEntries2!!.add(Entry(5f, 20f))
            lineEntries2!!.add(Entry(6f, 70f))
            lineEntries2!!.add(Entry(7f, 120f))
        }
}