package com.mgulay.pocket.viewmodel

import android.graphics.Color
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.storage.FirebaseStorage
import com.mgulay.pocket.model.ExchangeVal
import com.mgulay.pocket.adapter.exchangeAdapter
import com.mgulay.pocket.model.retrofit
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ExchangeFragmentViewModel:ViewModel() {
    private var exList=ArrayList<ExchangeVal>()
    private var storage:FirebaseStorage= FirebaseStorage.getInstance()
    fun getData(view:View, adapter: exchangeAdapter, progress:ProgressBar, recycler:RecyclerView){
        progress.visibility=View.VISIBLE
        recycler.visibility=View.GONE
        var retro= retrofit()
        var handler= CoroutineExceptionHandler({ coroutineContext, throwable ->
            Snackbar.make(view,throwable.localizedMessage,Snackbar.LENGTH_SHORT).setTextColor(
                Color.parseColor("#FFFFFF")
            ).setBackgroundTint(Color.parseColor("#2752E7")).show()})
        CoroutineScope(Dispatchers.IO+handler).launch {
                var get=retro.retrom.getValues()
                withContext(Dispatchers.Main){
                    if (get.isSuccessful){
                        progress.visibility=View.GONE
                        recycler.visibility=View.VISIBLE
                        get.body()?.let {
                            exList.add(ExchangeVal(it.usd.toString(),it.usd!!.img,it.usd!!.Alis!!,it.usd!!.Satis!!,it.usd!!.Degisim!!))
                            exList.add(ExchangeVal(it.gbp.toString(),it.gbp!!.img,it.gbp!!.Alis!!,it.gbp!!.Satis!!,it.gbp!!.Degisim!!))
                            exList.add(ExchangeVal(it.rub.toString(),it.rub!!.img,it.rub!!.Alis!!,it.rub!!.Satis!!,it.rub!!.Degisim!!))
                            exList.add(ExchangeVal(it.cad.toString(),it.cad!!.img,it.cad!!.Alis!!,it.cad!!.Satis!!,it.cad!!.Degisim!!))
                            exList.add(ExchangeVal(it.thb.toString(),it.thb!!.img,it.thb!!.Alis!!,it.thb!!.Satis!!,it.thb!!.Degisim!!))
                            exList.add(ExchangeVal(it.ALL.toString(),it.ALL!!.img,it.ALL!!.Alis!!,it.ALL!!.Satis!!,it.ALL!!.Degisim!!))
                            exList.add(ExchangeVal(it.ARS.toString(),it.ARS!!.img,it.ARS!!.Alis!!,it.ARS!!.Satis!!,it.ARS!!.Degisim!!))
                            exList.add(ExchangeVal(it.AUD.toString(),it.AUD!!.img,it.AUD!!.Alis!!,it.AUD!!.Satis!!,it.AUD!!.Degisim!!))
                            exList.add(ExchangeVal(it.AZN.toString(),it.AZN!!.img,it.AZN!!.Alis!!,it.AZN!!.Satis!!,it.AZN!!.Degisim!!))
                            exList.add(ExchangeVal(it.BAM.toString(),it.BAM!!.img,it.BAM!!.Alis!!,it.BAM!!.Satis!!,it.BAM!!.Degisim!!))
                            exList.add(ExchangeVal(it.BGN.toString(),it.BGN!!.img,it.BGN!!.Alis!!,it.BGN!!.Satis!!,it.BGN!!.Degisim!!))
                            exList.add(ExchangeVal(it.BHD.toString(),it.BHD!!.img,it.BHD!!.Alis!!,it.BHD!!.Satis!!,it.BHD!!.Degisim!!))
                            exList.add(ExchangeVal(it.BRL.toString(),it.BRL!!.img,it.BRL!!.Alis!!,it.BRL!!.Satis!!,it.BRL!!.Degisim!!))
                            exList.add(ExchangeVal(it.CHF.toString(),it.CHF!!.img,it.CHF!!.Alis!!,it.CHF!!.Satis!!,it.CHF!!.Degisim!!))
                            exList.add(ExchangeVal(it.CNY.toString(),it.CNY!!.img,it.CNY!!.Alis!!,it.CNY!!.Satis!!,it.CNY!!.Degisim!!))
                            exList.add(ExchangeVal(it.CZK.toString(),it.CZK!!.img,it.CZK!!.Alis!!,it.CZK!!.Satis!!,it.CZK!!.Degisim!!))
                            exList.add(ExchangeVal(it.DKK.toString(),it.DKK!!.img,it.DKK!!.Alis!!,it.DKK!!.Satis!!,it.DKK!!.Degisim!!))
                            exList.add(ExchangeVal(it.DZD.toString(),it.DZD!!.img,it.DZD!!.Alis!!,it.DZD!!.Satis!!,it.DZD!!.Degisim!!))
                            exList.add(ExchangeVal(it.EGP.toString(),it.EGP!!.img,it.EGP!!.Alis!!,it.EGP!!.Satis!!,it.EGP!!.Degisim!!))
                            exList.add(ExchangeVal(it.GEL.toString(),it.GEL!!.img,it.GEL!!.Alis!!,it.GEL!!.Satis!!,it.GEL!!.Degisim!!))
                            exList.add(ExchangeVal(it.HRK.toString(),it.HRK!!.img,it.HRK!!.Alis!!,it.HRK!!.Satis!!,it.HRK!!.Degisim!!))
                            exList.add(ExchangeVal(it.HUF.toString(),it.HUF!!.img,it.HUF!!.Alis!!,it.HUF!!.Satis!!,it.HUF!!.Degisim!!))
                            exList.add(ExchangeVal(it.IDR.toString(),it.IDR!!.img,it.IDR!!.Alis!!,it.IDR!!.Satis!!,it.IDR!!.Degisim!!))
                            exList.add(ExchangeVal(it.INR.toString(),it.INR!!.img,it.INR!!.Alis!!,it.INR!!.Satis!!,it.INR!!.Degisim!!))
                            exList.add(ExchangeVal(it.IQD.toString(),it.IQD!!.img,it.IQD!!.Alis!!,it.IQD!!.Satis!!,it.IQD!!.Degisim!!))
                            exList.add(ExchangeVal(it.IRR.toString(),it.IRR!!.img,it.IRR!!.Alis!!,it.IRR!!.Satis!!,it.IRR!!.Degisim!!))
                            exList.add(ExchangeVal(it.ISK.toString(),it.ISK!!.img,it.ISK!!.Alis!!,it.ISK!!.Satis!!,it.ISK!!.Degisim!!))
                            exList.add(ExchangeVal(it.JOD.toString(),it.JOD!!.img,it.JOD!!.Alis!!,it.JOD!!.Satis!!,it.JOD!!.Degisim!!))
                            exList.add(ExchangeVal(it.JPY.toString(),it.JPY!!.img,it.JPY!!.Alis!!,it.JPY!!.Satis!!,it.JPY!!.Degisim!!))
                            exList.add(ExchangeVal(it.KRW.toString(),it.KRW!!.img,it.KRW!!.Alis!!,it.KRW!!.Satis!!,it.KRW!!.Degisim!!))
                            exList.add(ExchangeVal(it.KWD.toString(),it.KWD!!.img,it.KWD!!.Alis!!,it.KWD!!.Satis!!,it.KWD!!.Degisim!!))
                            exList.add(ExchangeVal(it.KZT.toString(),it.KZT!!.img,it.KZT!!.Alis!!,it.KZT!!.Satis!!,it.KZT!!.Degisim!!))
                            exList.add(ExchangeVal(it.LBP.toString(),it.LBP!!.img,it.LBP!!.Alis!!,it.LBP!!.Satis!!,it.LBP!!.Degisim!!))
                            exList.add(ExchangeVal(it.LYD.toString(),it.LYD!!.img,it.LYD!!.Alis!!,it.LYD!!.Satis!!,it.LYD!!.Degisim!!))
                            exList.add(ExchangeVal(it.MAD.toString(),it.MAD!!.img,it.MAD!!.Alis!!,it.MAD!!.Satis!!,it.MAD!!.Degisim!!))
                            exList.add(ExchangeVal(it.MKD.toString(),it.MKD!!.img,it.MKD!!.Alis!!,it.MKD!!.Satis!!,it.MKD!!.Degisim!!))
                            exList.add(ExchangeVal(it.MXN.toString(),it.MXN!!.img,it.MXN!!.Alis!!,it.MXN!!.Satis!!,it.MXN!!.Degisim!!))
                            exList.add(ExchangeVal(it.NOK.toString(),it.NOK!!.img,it.NOK!!.Alis!!,it.NOK!!.Satis!!,it.NOK!!.Degisim!!))
                            exList.add(ExchangeVal(it.NZD.toString(),it.NZD!!.img,it.NZD!!.Alis!!,it.NZD!!.Satis!!,it.NZD!!.Degisim!!))
                            exList.add(ExchangeVal(it.PKR.toString(),it.PKR!!.img,it.PKR!!.Alis!!,it.PKR!!.Satis!!,it.PKR!!.Degisim!!))
                            exList.add(ExchangeVal(it.PLN.toString(),it.PLN!!.img,it.PLN!!.Alis!!,it.PLN!!.Satis!!,it.PLN!!.Degisim!!))
                            exList.add(ExchangeVal(it.QAR.toString(),it.QAR!!.img,it.QAR!!.Alis!!,it.QAR!!.Satis!!,it.QAR!!.Degisim!!))
                            exList.add(ExchangeVal(it.RON.toString(),it.RON!!.img,it.RON!!.Alis!!,it.RON!!.Satis!!,it.RON!!.Degisim!!))
                            exList.add(ExchangeVal(it.RSD.toString(),it.RSD!!.img,it.RSD!!.Alis!!,it.RSD!!.Satis!!,it.RSD!!.Degisim!!))
                            exList.add(ExchangeVal(it.SAR.toString(),it.SAR!!.img,it.SAR!!.Alis!!,it.SAR!!.Satis!!,it.SAR!!.Degisim!!))
                            exList.add(ExchangeVal(it.SEK.toString(),it.SEK!!.img,it.SEK!!.Alis!!,it.SEK!!.Satis!!,it.SEK!!.Degisim!!))
                            exList.add(ExchangeVal(it.SGD.toString(),it.SGD!!.img,it.SGD!!.Alis!!,it.SGD!!.Satis!!,it.SGD!!.Degisim!!))
                            exList.add(ExchangeVal(it.TND.toString(),it.TND!!.img,it.TND!!.Alis!!,it.TND!!.Satis!!,it.TND!!.Degisim!!))
                            exList.add(ExchangeVal(it.TWD.toString(),it.TWD!!.img,it.TWD!!.Alis!!,it.TWD!!.Satis!!,it.TWD!!.Degisim!!))
                            exList.add(ExchangeVal(it.UAH.toString(),it.UAH!!.img,it.UAH!!.Alis!!,it.UAH!!.Satis!!,it.UAH!!.Degisim!!))
                            exList.add(ExchangeVal(it.ZAR.toString(),it.ZAR!!.img,it.ZAR!!.Alis!!,it.ZAR!!.Satis!!,it.ZAR!!.Degisim!!))
                        }
                        adapter.refreshExList(exList)
                    }
                }


        }

    }
}