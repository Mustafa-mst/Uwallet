package com.mgulay.pocket.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgulay.pocket.databinding.ExchangeRecyclerBinding
import com.mgulay.pocket.model.ExchangeVal

open class exchangeAdapter(val list:ArrayList<ExchangeVal>):RecyclerView.Adapter<exchangeAdapter.ExchanceVh>() {
    class ExchanceVh(val binding:ExchangeRecyclerBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchanceVh {
        val binding=ExchangeRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ExchanceVh(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ExchanceVh, position: Int) {
        holder.binding.countryFlag.setImageResource(list.get(position).img)
        holder.binding.currencyName.text=list.get(position).type
        holder.binding.curBuy.text=list.get(position).buy.substring(0..4)
        holder.binding.curSell.text=list.get(position).sell.substring(0..4)
        var place=list.get(position).changing.replace("%","").trim()
        var place02=place.replace(",",".")
        if (place02.toDouble()>0){
            holder.binding.curChanging.setTextColor(Color.parseColor("#008000"))
        }else{
            holder.binding.curChanging.setTextColor(Color.parseColor("#FF0000"))
        }
        holder.binding.curChanging.text=list.get(position).changing
    }
    fun refreshExList(exList:ArrayList<ExchangeVal>){
        list.clear()
        list.addAll(exList)
        notifyDataSetChanged()

    }
}