package com.mgulay.pocket.viewmodel

import android.graphics.Color
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.storage.FirebaseStorage
import com.mgulay.pocket.adapter.ExchangeValuableAdapter
import com.mgulay.pocket.model.ExchangeVal
import com.mgulay.pocket.model.retrofit
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.logging.Handler

class ExchangeGoldViewModel:ViewModel() {
    private var exList=ArrayList<ExchangeVal>()
    private var storage: FirebaseStorage = FirebaseStorage.getInstance()
     fun getValuableMaterials(view:View,progress:ProgressBar,recyclerView: RecyclerView,adapter:ExchangeValuableAdapter){
         progress.visibility=View.VISIBLE
         recyclerView.visibility=View.GONE
         var handler= CoroutineExceptionHandler({ coroutineContext, throwable ->
             Snackbar.make(view,throwable.localizedMessage,Snackbar.LENGTH_SHORT).setTextColor(
                 Color.parseColor("#FFFFFF")
             ).setBackgroundTint(Color.parseColor("#2752E7")).show()
         })

         CoroutineScope(Dispatchers.IO+handler).launch {
             var retro=retrofit().retrom.getValues()
             withContext(Dispatchers.Main){
                 if (retro.isSuccessful){
                     progress.visibility=View.GONE
                     recyclerView.visibility=View.VISIBLE
                     retro.body()?.let {
                         exList.add(ExchangeVal(it.ceyrek_altin.toString(),it.ceyrek_altin!!.img,it.ceyrek_altin!!.Alis!!,it.ceyrek_altin!!.Satis!!,it.ceyrek_altin!!.Degisim!!))
                         exList.add(ExchangeVal(it.gram_altin.toString(),it.gram_altin!!.img,it.gram_altin!!.Alis!!,it.gram_altin!!.Satis!!,it.gram_altin!!.Degisim!!))
                         exList.add(ExchangeVal(it.yarim_altin.toString(),it.yarim_altin!!.img,it.yarim_altin!!.Alis!!,it.yarim_altin!!.Satis!!,it.yarim_altin!!.Degisim!!))
                         exList.add(ExchangeVal(it.gremse_altin.toString(),it.gremse_altin!!.img,it.gremse_altin!!.Alis!!,it.gremse_altin!!.Satis!!,it.gremse_altin!!.Degisim!!))
                         exList.add(ExchangeVal(it.tam_altin.toString(),it.tam_altin!!.img,it.tam_altin!!.Alis!!,it.tam_altin!!.Satis!!,it.tam_altin!!.Degisim!!))
                         exList.add(ExchangeVal(it.resat_altin.toString(),it.resat_altin!!.img,it.resat_altin!!.Alis!!,it.resat_altin!!.Satis!!,it.resat_altin!!.Degisim!!))
                         exList.add(ExchangeVal(it.ata_altin.toString(),it.ata_altin!!.img,it.ata_altin!!.Alis!!,it.ata_altin!!.Satis!!,it.ata_altin!!.Degisim!!))
                         exList.add(ExchangeVal(it.cumhuriyet_altini.toString(),it.cumhuriyet_altini!!.img,it.cumhuriyet_altini!!.Alis!!,it.cumhuriyet_altini!!.Satis!!,it.cumhuriyet_altini!!.Degisim!!))
                         exList.add(ExchangeVal(it.onDort_ayar_altin.toString(),it.onDort_ayar_altin!!.img,it.onDort_ayar_altin!!.Alis!!,it.onDort_ayar_altin!!.Satis!!,it.onDort_ayar_altin!!.Degisim!!))
                         exList.add(ExchangeVal(it.onSekiz_ayar_altin.toString(),it.onSekiz_ayar_altin!!.img,it.onSekiz_ayar_altin!!.Alis!!,it.onSekiz_ayar_altin!!.Satis!!,it.onSekiz_ayar_altin!!.Degisim!!))
                         exList.add(ExchangeVal(it.besli_altin.toString(),it.besli_altin!!.img,it.besli_altin!!.Alis!!,it.besli_altin!!.Satis!!,it.besli_altin!!.Degisim!!))
                         exList.add(ExchangeVal(it.gumus.toString(),it.gumus!!.img,it.gumus!!.Alis!!,it.gumus!!.Satis!!,it.gumus!!.Degisim!!))
                     }
                     adapter.refreshExList(exList)

                 }
             }
         }
    }
}