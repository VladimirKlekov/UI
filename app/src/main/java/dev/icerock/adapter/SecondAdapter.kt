package dev.icerock.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.icerock.dto.Contact
import dev.icerock.ui.databinding.ItemSecondContactsBinding

interface SecondContactListener {
    fun onContact(position: Int)
}

class SecondAdapter(
    private var rvListAdapter: List<Contact>,
    private val listener: SecondContactListener
) : RecyclerView.Adapter<SecondAdapter.SecondViewHolder>() {

    inner class SecondViewHolder(binding: ItemSecondContactsBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        val firstName = binding.firstNameTv
        val lastName = binding.lastNameTv
        val avatar = binding.avatarIv

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onContact(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        return SecondViewHolder(
            ItemSecondContactsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.firstName.text = rvListAdapter[position].firstName
        holder.lastName.text = rvListAdapter[position].lastName
        holder.avatar.setImageResource(rvListAdapter[position].avatarResourceId)
    }

    override fun getItemCount(): Int {
        return rvListAdapter.size
    }
}