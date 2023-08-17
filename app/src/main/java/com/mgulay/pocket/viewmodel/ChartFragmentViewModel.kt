package com.mgulay.pocket.viewmodel

import android.graphics.Color
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.mgulay.pocket.model.Chart


class ChartFragmentViewModel:ViewModel() {

    var totalPurchase=0
    var home=0f
    var homeChart=0f
    var personal=0f
    var personalChart=0f
    var travel=0f
    var travelChart=0f
    var food=0f
    var foodChart=0f
    var getValue=ArrayList<Chart>()


    fun getFromFirebase(auth: FirebaseAuth,database:FirebaseFirestore,anyChartView: PieChart,progress:ProgressBar){
        progress.visibility=View.VISIBLE
        anyChartView.visibility=View.GONE
        database.collection("Expenses").whereEqualTo("userId",auth.currentUser!!.uid).get().addOnSuccessListener {
            progress.visibility=View.GONE
            anyChartView.visibility=View.VISIBLE
            if (!it.isEmpty){
                it.documents.forEach {
                    getValue.add(Chart(it.get("spinnerItem")as String,it.get("valueForExpenses")as String))
                }
                setChart(getValue)
                insert(anyChartView)
            }
        }

    }
    fun setChart(list:ArrayList<Chart>){
        list.forEach {
            totalPurchase += it.valueExpenses.toInt()
        }
        list.forEach {

            when(it.spinnerItem){
                "\uD83D\uDD35 Ev"->{home+=it.valueExpenses.toFloat()
                    homeChart=(((home)/totalPurchase)*100)
                    println(homeChart)
                }
                "\uD83D\uDFE1 Kişisel"->{personal+=it.valueExpenses.toInt()
                    personalChart=(((personal/totalPurchase)*100))


                }
                "\uD83D\uDD34 Yemek"->{food+=it.valueExpenses.toInt()
                    foodChart=(((food/totalPurchase)*100))

                }
                "\uD83D\uDFE2 Seyahat"->{travel+=it.valueExpenses.toInt()
                    travelChart=(((travel/totalPurchase)*100))

                }
                else->{
                    println("boş")
                }
        }
        }
        list.forEach {
            when(it.spinnerItem){
                "\uD83D\uDD35 Ev"->{
                    homeChart=(((home)/totalPurchase)*100)
                    println(homeChart)
                }
                "\uD83D\uDFE1 Kişisel"->{
                    personalChart=(((personal/totalPurchase)*100))


                }
                "\uD83D\uDD34 Yemek"->{
                    foodChart=(((food/totalPurchase)*100))

                }
                "\uD83D\uDFE2 Seyahat"->{
                    travelChart=(((travel/totalPurchase)*100))

                }
                else->{
                    println("boş")
                }
            }
        }

    }

    fun insert(anyChartView: PieChart) {
        println(travelChart)
        var list= arrayListOf<PieEntry>(PieEntry(travelChart,"Seyahat"), PieEntry(personalChart,"Kişisel"),PieEntry(foodChart,"Yemek"),PieEntry(homeChart,"Ev"))
        var pie = PieDataSet(list, "")
        pie.setColors(ColorTemplate.MATERIAL_COLORS, 255)
        pie.valueTextSize = 14f
        pie.valueTextColor = Color.BLACK
        val pieData = PieData(pie)
        anyChartView.data = pieData
        anyChartView.description.isEnabled = false
        anyChartView.animateY(1000)

    }
}