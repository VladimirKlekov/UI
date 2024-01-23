package dev.icerock.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import dev.icerock.adapter.Adapter
import dev.icerock.adapter.ContactListener
import dev.icerock.dto.Contact
import dev.icerock.ui.databinding.FragmentContactsBinding
import dev.icerock.viewmodel.ContactsViewModel

class ContactsFragment : Fragment(R.layout.fragment_contacts) {
    private lateinit var binding: FragmentContactsBinding
    private val contactsViewModel: ContactsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContactsBinding.bind(view)
        val adapter = Adapter(
            object : ContactListener {
                override fun onContact(contact: Contact) {
                    TODO("Not yet implemented")
                }
            }
        )

        binding.recyclerView.adapter = adapter

        contactsViewModel.contactList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }


    }
}