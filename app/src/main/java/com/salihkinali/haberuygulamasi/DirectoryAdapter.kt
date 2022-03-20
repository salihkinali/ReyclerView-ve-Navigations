package com.salihkinali.haberuygulamasi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salihkinali.haberuygulamasi.databinding.ListItemMessageBinding
import com.salihkinali.haberuygulamasi.model.PhoneDirectoryModel

class DirectoryAdapter(private var personList: ArrayList<PhoneDirectoryModel>):RecyclerView.Adapter<DirectoryAdapter.MessageCardDesign>() {
    var onMessageSize:(PhoneDirectoryModel) -> Unit = {}
    var onMessageItem: (PhoneDirectoryModel) -> Unit = {}
    class MessageCardDesign(val messageCardviewBinding: ListItemMessageBinding):RecyclerView.ViewHolder(messageCardviewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DirectoryAdapter.MessageCardDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val messageCardviewBinding = ListItemMessageBinding.inflate(layoutInflater,parent,false)
        return MessageCardDesign(messageCardviewBinding)
    }

    override fun onBindViewHolder(holder: DirectoryAdapter.MessageCardDesign, position: Int) {
       val person = personList[position]
        holder.messageCardviewBinding.ImageMessage.setImageResource(person.personImage)
        holder.messageCardviewBinding.profilname.text = person.personName
        holder.messageCardviewBinding.personMessage.text = person.personMessage
        holder.messageCardviewBinding.dateTime.text = person.personDate

        holder.messageCardviewBinding.root.setOnClickListener {
            onMessageItem(person)

        }
        holder.messageCardviewBinding.root.setOnLongClickListener {
            onMessageSize(person)
            true
        }
    }
    override fun getItemCount(): Int {
        return personList.size
    }

}