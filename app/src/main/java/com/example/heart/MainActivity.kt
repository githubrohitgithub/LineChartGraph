package com.example.heart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.heart.databinding.ActivityMainBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var dataSetEntries1: ArrayList<Entry>
    lateinit var dataSetEntries2: ArrayList<Entry>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataSet1
        dataSet2

        val xAxisLabels = arrayListOf("","Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
        val set1 = LineDataSet(dataSetEntries1, "Data set 1")
        set1.apply {
            this.color = Color.BLUE
            this.setDrawValues(false)
            this.setColors(Color.BLUE)
            this.valueTextColor = Color.BLACK
            this.valueTextSize = 18f
            this.mode = LineDataSet.Mode.CUBIC_BEZIER
            this.setCircleColor(Color.BLACK)
        }
        val set2 = LineDataSet(dataSetEntries2, "Data set 2")
        set2.apply {
            this.color = Color.BLUE
            this.setDrawValues(false)
            this.setColors(Color.RED)
            this.valueTextColor = Color.BLACK
            this.valueTextSize = 18f
            this.mode = LineDataSet.Mode.CUBIC_BEZIER
            this.setCircleColor(Color.BLACK)
        }

        val dataSets: ArrayList<LineDataSet> = ArrayList()
        dataSets.add(set1)
        dataSets.add(set2)


        binding.lineChart.apply {
            this.axisRight.isEnabled = false
            this.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabels)
            this.xAxis.position = XAxis.XAxisPosition.BOTTOM
            this.data = LineData(dataSets as List<ILineDataSet>?)
            this.description.text = "Systolic and Diatolic"
        }

    }

    private val dataSet1: Unit
        get() {
            dataSetEntries1 = ArrayList()
            dataSetEntries1.add(Entry(1f, 50f))
            dataSetEntries1.add(Entry(2f, 70f))
            dataSetEntries1.add(Entry(3f, 30f))
            dataSetEntries1.add(Entry(4f, 90f))
            dataSetEntries1.add(Entry(5f, 80f))
            dataSetEntries1.add(Entry(6f, 110f))
            dataSetEntries1.add(Entry(7f, 120f))
        }

    private val dataSet2: Unit
        get() {
            dataSetEntries2 = ArrayList()
            dataSetEntries2.add(Entry(1f, 40f))
            dataSetEntries2.add(Entry(2f, 50f))
            dataSetEntries2.add(Entry(3f, 70f))
            dataSetEntries2.add(Entry(4f, 30f))
            dataSetEntries2.add(Entry(5f, 20f))
            dataSetEntries2.add(Entry(6f, 70f))
            dataSetEntries2.add(Entry(7f, 120f))
        }
}