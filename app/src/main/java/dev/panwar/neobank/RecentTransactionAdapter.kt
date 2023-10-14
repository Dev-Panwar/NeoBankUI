package dev.panwar.neobank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecentTransactionAdapter(private var transactionList:ArrayList<recent>):RecyclerView.Adapter<RecentTransactionAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tv_name)
        val profile_pic: ImageView = itemView.findViewById(R.id.image)
        val description: TextView = itemView.findViewById(R.id.tv_description)
        val amount:TextView=itemView.findViewById(R.id.tv_amount)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recent_transaction, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTransaction=transactionList[position]
        holder.name.text=currentTransaction.name
        holder.amount.text=currentTransaction.amount
        holder.profile_pic.setImageResource(currentTransaction.profile_pic)
        holder.description.text=currentTransaction.description

    }

}