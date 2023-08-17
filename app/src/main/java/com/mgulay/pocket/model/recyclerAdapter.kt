package com.mgulay.pocket.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgulay.pocket.R
import com.mgulay.pocket.databinding.RecyclerRowBinding

open class recyclerAdapter(var list:ArrayList<Spending>):RecyclerView.Adapter<recyclerAdapter.ExpensesVh>() {
    class ExpensesVh(val binding:RecyclerRowBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesVh {
        val binding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ExpensesVh(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ExpensesVh, position: Int) {
        holder.binding.recyclerTypeText.text=list.get(position).type
        holder.binding.recyclerDesText.text=list.get(position).description
        holder.binding.recyclerValueText.text=list.get(position).value.toString()
    }
    fun refreshRecyler(newList:ArrayList<Spending>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}