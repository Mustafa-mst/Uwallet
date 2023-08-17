package com.mgulay.pocket.viewmodel

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.media.Image
import android.text.InputType
import android.view.Display.Mode
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.SetOptions
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mgulay.pocket.R
import com.mgulay.pocket.model.Spending
import com.mgulay.pocket.model.recyclerAdapter
import com.mgulay.pocket.view.loginStuff.MainActivity
import java.lang.Exception

class HomeFragmentVievModel:ViewModel() {
    private var allExpenses=0
    private var regularExpenses=0
    var username=MutableLiveData<String>()
    var rentPaymentText=MutableLiveData<Int>()
    var isEmpty=MutableLiveData<Boolean>()
    var installmentsText=MutableLiveData<Int>()
    var savingsText=MutableLiveData<Int>()
    var totalExtenses=MutableLiveData<Int>()
    var progressBar=MutableLiveData<Boolean>()
    var arrayList= ArrayList<Spending>()

    fun GetFromFirebase(refresh:recyclerAdapter,view: View,database:FirebaseFirestore,auth: FirebaseAuth){
        progressBar.value=true
        database.collection("Users").document(auth.currentUser!!.uid).get().addOnSuccessListener {
            progressBar.value=false
           username.value=it.get("userName")as String
            var rentPayment=it.get("rentPaymentText") as Long?
            var installment=it.get("installmentText") as Long?
            var savings = it.get("savingsText") as Long?
            var extenses = it.get("totalExtenses") as Long?
            var a=0
            var b=0

            getExpensesToFirebase(database,auth,refresh)
            savings?.let {
                savingsText.value = it.toInt()
            }
            installment?.let {
                b=it.toInt()
                installmentsText.value=it.toInt()
            }
            rentPayment?.let {
                a=it.toInt()
                rentPaymentText.value=it.toInt()

            }
            extenses?.let {
                allExpenses=0
                allExpenses=a+b
                totalExtenses.value = it.toInt()
            }

        }.addOnFailureListener {
            Toast.makeText(view.context,it.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }
    fun InsertFirebase(database: FirebaseFirestore,auth: FirebaseAuth){
        var hashList= hashMapOf<String,Any?>("totalExtenses" to totalExtenses.value,"savingsText" to savingsText.value,"installmentText" to installmentsText.value,"rentPaymentText" to rentPaymentText.value)
        database.collection("Users").document(auth.currentUser!!.uid).set(hashList, SetOptions.merge())
    }

    fun exitTheApp(view:View,context:Context,auth:FirebaseAuth,activity:Activity){
        var dialog= AlertDialog.Builder(context)
        dialog.setTitle("Çıkış")
        dialog.setMessage("Hesabınızdan Çıkış Yapmak İstiyor Musunuz ?")
        dialog.setPositiveButton("Evet", DialogInterface.OnClickListener { dialog, which ->
            auth.signOut()
            val intent= Intent(context, MainActivity::class.java)
            context.startActivity(intent)

        })
        dialog.setNegativeButton("Hayır", DialogInterface.OnClickListener { dialog, which ->

        })
        dialog.show()
    }
    fun changeTheRegularExes(view:View,context: Context){
        var myView= LinearLayout(context)
        myView.orientation= LinearLayout.VERTICAL
        val changeHomeRent= EditText(context)
        changeHomeRent.hint="Kira Değerini Değiştir"
        changeHomeRent.inputType=InputType.TYPE_CLASS_NUMBER
        val changeInstallments= EditText(context)
        changeInstallments.hint="Taksit Değerini Değiştir"
        changeInstallments.inputType=InputType.TYPE_CLASS_NUMBER
        myView.addView(changeHomeRent)
        myView.addView(changeInstallments)

        var dialog=AlertDialog.Builder(context)
        dialog.setView(myView)
        dialog.setTitle("Sabit Giderleri Düzenle")
        dialog.setPositiveButton("Kaydet",DialogInterface.OnClickListener { dialog, which ->
            if (!changeHomeRent.text.isNullOrEmpty()&&!changeInstallments.text.isNullOrEmpty()){
                regularExpenses=0
                installmentsText.value=changeInstallments.text.toString().trim().toInt()
                rentPaymentText.value=changeHomeRent.text.toString().trim().toInt()
                regularExpenses=installmentsText.value!!+rentPaymentText.value!!
                allExpenses+=regularExpenses
                totalExtenses.value = allExpenses
                savingsText.value=(savingsText.value!!-totalExtenses.value!!)
            }else{
                Snackbar.make(view,"Lütfen Boş Değer Kaydetmeyiniz",Snackbar.LENGTH_SHORT).setTextColor(
                    Color.parseColor("#FFFFFF")).setBackgroundTint(Color.parseColor("#2752E7")).show()
            }

        })
        dialog.show()
    }
    fun changeTheSavings(view: View,context: Context) {
        val changeSavings = EditText(context)
        changeSavings.hint = "Lütfen değer giriniz"
        changeSavings.inputType=InputType.TYPE_CLASS_NUMBER
        var dialog = AlertDialog.Builder(context)
        dialog.setView(changeSavings)
        dialog.setTitle("Varlık Düzenle")
        dialog.setPositiveButton("Kaydet") { dialog, which ->
            if (!changeSavings.text.trim().toString().isNullOrEmpty()) {
                savingsText.value = changeSavings.text.toString().trim().toInt()

            } else {
                Snackbar.make(view, "Lütfen Boş Değer Kaydetmeyiniz ", Snackbar.LENGTH_SHORT)
                    .setTextColor(
                        Color.parseColor("#FFFFFF")
                    ).setBackgroundTint(Color.parseColor("#2752E7")).show()
            }
        }
        dialog.show()

    }
    fun addExpenses(view:View,refresh:recyclerAdapter,auth: FirebaseAuth,database: FirebaseFirestore){

        val spinLay=LayoutInflater.from(view.context).inflate(R.layout.spinner_custom,null)
        var expensesList= listOf("\uD83D\uDD35 Ev","\uD83D\uDFE1 Kişisel"
            ,"\uD83D\uDD34 Yemek","\uD83D\uDFE2 Seyahat")

        var adapter=ArrayAdapter(view.context,android.R.layout.simple_spinner_item,expensesList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        var spinner=spinLay.findViewById<Spinner>(R.id.spinnerCustom)
        var infoForExpenses=spinLay.findViewById<EditText>(R.id.infoForExpenses)
        var valueForExpenses=spinLay.findViewById<EditText>(R.id.valueForExpenses)
        spinner.adapter=adapter
        if (spinner.selectedItem!=null){

            var dialog=AlertDialog.Builder(view.context).setView(spinLay).setTitle("Harcama Ekle")
            dialog.setPositiveButton("Kaydet") { dialog, which ->
                if (!infoForExpenses.text.toString().trim()
                        .isNullOrEmpty() && !valueForExpenses.text.toString().trim().isNullOrEmpty()
                ) {
                    isEmpty.value = false
                    arrayList.add(
                        Spending(
                            spinner.selectedItem.toString(),
                            infoForExpenses.text.toString(),
                            valueForExpenses.text.toString()
                        )
                    )
                    allExpenses += valueForExpenses.text.toString().trim().toInt()
                    totalExtenses.value = allExpenses
                    savingsText.value = savingsText.value!! - totalExtenses.value!!
                    refresh.refreshRecyler(arrayList)
                    insertExpensesToFirebase(
                        auth.currentUser!!.uid,
                        database,
                        view,
                        spinner,
                        infoForExpenses.text.toString(),
                        valueForExpenses.text.toString()
                    )
                } else {
                    Snackbar.make(view, "Lütfen Boşlukları Doldurunuz", Snackbar.LENGTH_SHORT)
                        .setTextColor(
                            Color.parseColor("#FFFFFF")
                        ).setBackgroundTint(Color.parseColor("#2752E7")).show()
                }


            }
            dialog.show()
        }



    }
    fun insertExpensesToFirebase(uuid:String,database:FirebaseFirestore,view:View,spinner: Spinner,infoText:String,valueForEx:String){
            var time=Timestamp.now()
            var hashMap= hashMapOf<String,Any>("userId" to uuid ,"spinnerItem" to spinner.selectedItem.toString(),"infoForExpenses" to infoText,"valueForExpenses" to valueForEx,"time" to time)
            database.collection("Expenses").add(hashMap).addOnSuccessListener {
            }.addOnFailureListener {
                Snackbar.make(view,it.localizedMessage,Snackbar.LENGTH_SHORT).setTextColor(
                    Color.parseColor("#FFFFFF")).setBackgroundTint(Color.parseColor("#2752E7")).show()
            }
        }

    fun getExpensesToFirebase(database: FirebaseFirestore,auth: FirebaseAuth,refresh:recyclerAdapter){

        database.collection("Expenses").whereEqualTo("userId",auth.currentUser!!.uid).get().addOnSuccessListener {
            if (!it.isEmpty){
                it.documents.forEach {
                    arrayList.add(Spending(it.get("spinnerItem")as String,it.get("infoForExpenses") as String,it.get("valueForExpenses") as String))
                    isEmpty.value=false
                    allExpenses+=it.get("valueForExpenses").toString().toInt()
                    if (savingsText.value!=null&&totalExtenses.value!=null){
                    totalExtenses.value= allExpenses
                    }
                }
                refresh.refreshRecyler(arrayList)


            }
        }
    }
    }



