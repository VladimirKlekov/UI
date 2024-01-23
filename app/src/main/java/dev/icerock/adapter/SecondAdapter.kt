package dev.icerock.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.icerock.dto.Contact
import dev.icerock.ui.databinding.ItemSecondContactsBinding

class SecondAdapter(private val context: Context,
                    private var rvListAdapter: List<Contact>):RecyclerView.Adapter<SecondAdapter.SecondViewHolder>() {

    class SecondViewHolder(binding:ItemSecondContactsBinding): RecyclerView.ViewHolder(binding.root){
        val firstName = binding.firstNameTv
        val lastName = binding.lastNameTv
        val avatar = binding.avatarIv

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        return SecondViewHolder(ItemSecondContactsBinding.inflate(
            LayoutInflater.from(context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.firstName.text = rvListAdapter[position].firstName
        holder.lastName.text = rvListAdapter[position].lastName
        holder.avatar.setImageResource(rvListAdapter[position].avatarResourceId)
        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return rvListAdapter.size
    }
}