package dev.icerock.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.icerock.dto.Contact
import dev.icerock.ui.databinding.ItemContactsBinding

interface ContactListener {
    fun onContact(contact: Contact)
}

class Adapter(private val listener: ContactListener) :
    ListAdapter<Contact, ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemContactsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(
            binding = binding,
            listener = listener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact)
    }
}

class ViewHolder(
    private val binding: ItemContactsBinding,
    private val listener: ContactListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(contact: Contact) {
        binding.apply {
            firstNameTv.text = contact.firstName
            lastNameTv.text = contact.lastName
            avatarIv.setImageResource(contact.avatarResourceId)

            binding.root.setOnClickListener {
                listener.onContact(contact)
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: Contact, newItem: Contact): Any = Unit
}