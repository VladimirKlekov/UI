package dev.icerock.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dev.icerock.ui.databinding.FragmentSecondContactBinding
import dev.icerock.viewmodel.ContactsViewModel

class SecondContactFragment : Fragment(R.layout.fragment_second_contact) {
    private var _binding: FragmentSecondContactBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<SecondContactFragmentArgs>()
    private val secondContactsViewModel: ContactsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondContactBinding.inflate(inflater, container, false)
        val view = binding.root

        secondContactsViewModel.secondContact().forEach { element ->
            if (element.id == args.positionId) {
                binding.firstName.text = element.firstName
                binding.lastName.text = element.lastName
                binding.avatarIv.setImageResource(element.avatarResourceId)
                binding.container.firstNameTv.text = element.firstName
                binding.container.lastNameTv.text = element.lastName
            }
        }

        binding.container.backIv.setOnClickListener {
            findNavController().navigate(R.id.action_secondContactFragment_to_secondContactsFragment)
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}