package dev.icerock.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dev.icerock.ui.databinding.FragmentContactBinding
import dev.icerock.viewmodel.ContactsViewModel

class ContactFragment : Fragment(R.layout.fragment_contact) {
    private lateinit var binding: FragmentContactBinding
    private val contactViewModel: ContactsViewModel by viewModels()
    private val args by navArgs<ContactFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContactBinding.bind(view)

        contactViewModel.contactList.observe(viewLifecycleOwner) { element ->
            val contact = element.find { it.id == args.contactId } ?: run {
                findNavController().navigateUp()
                return@observe
            }
            binding.container.firstNameTv.text = contact.firstName
            binding.container.lastNameTv.text = contact.lastName
            binding.firstName.text = contact.firstName
            binding.lastName.text = contact.lastName
            binding.avatarIv.setImageResource(contact.avatarResourceId)
        }

        binding.container.backIv.setOnClickListener {
            findNavController().navigateUp()
        }

    }

}