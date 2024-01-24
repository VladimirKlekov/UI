package dev.icerock.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dev.icerock.adapter.Adapter
import dev.icerock.adapter.ContactListener
import dev.icerock.dto.Contact
import dev.icerock.ui.databinding.FragmentContactsBinding
import dev.icerock.viewmodel.ContactsViewModel

class ContactsFragment : Fragment(R.layout.fragment_contacts) {
    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!
    private val contactsViewModel: ContactsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter = Adapter(
            object : ContactListener {
                override fun onContact(contact: Contact) {
                    val action =
                        ContactsFragmentDirections.actionContactsFragmentToContactFragment(contact.id)
                    findNavController().navigate(action)
                }
            }
        )

        binding.recyclerView.adapter = adapter

        binding.container.backIv.setOnClickListener {
            findNavController().navigate(R.id.action_contactsFragment_to_mainFragment)
        }

        contactsViewModel.contactList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}