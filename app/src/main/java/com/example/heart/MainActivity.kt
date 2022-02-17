package com.example.heart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.ScatterChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {
    lateinit var lineChart: LineChart
    var lineData: LineData? = null
    var lineDataSet: LineDataSet? = null
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
        }
        val set2 = LineDataSet(lineEntries2, "Data set 2")
        set2.apply {
            this.color = Color.BLUE
            this.setDrawValues(false)
        }

        val dataSets: ArrayList<LineDataSet> = ArrayList()
        dataSets.add(set1)
//        dataSets.add(set2)
//        dataSets.add(set3)


        lineDataSet = LineDataSet(lineEntries1, "Set 1")
        lineData = LineData(lineDataSet)
        lineChart.data = lineData


        lineChart.data = LineData(dataSets as List<ILineDataSet>?)

        lineDataSet!!.setColors(*ColorTemplate.JOYFUL_COLORS)
        lineDataSet!!.valueTextColor = Color.BLACK
        lineDataSet!!.valueTextSize = 18f
        lineDataSet!!.mode = LineDataSet.Mode.CUBIC_BEZIER
        lineChart.axisRight.isEnabled = false
        lineChart.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabels)
        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM

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