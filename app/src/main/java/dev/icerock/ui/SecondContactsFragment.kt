package dev.icerock.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dev.icerock.adapter.SecondAdapter
import dev.icerock.adapter.SecondContactListener
import dev.icerock.ui.databinding.FragmentSecondContactsBinding
import dev.icerock.viewmodel.ContactsViewModel

class SecondContactsFragment : Fragment(R.layout.fragment_second_contacts), SecondContactListener {
    private var _binding: FragmentSecondContactsBinding? = null
    private val binding get() = _binding!!
    private var secondAdapter: SecondAdapter? = null
    private val secondContactsViewModel: ContactsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondContactsBinding.inflate(inflater, container, false)
        val view = binding.root

        secondAdapter = SecondAdapter(
            secondContactsViewModel.secondContact(), this
        )
        binding.recyclerView.adapter = secondAdapter

        binding.container.backIv.setOnClickListener {
            findNavController().navigate(R.id.action_secondContactsFragment_to_mainFragment)
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onContact(position: Int) {
        val contactPosition = secondContactsViewModel.secondContact()[position]
        val action =
            SecondContactsFragmentDirections.actionSecondContactsFragmentToSecondContactFragment(
                contactPosition.id
            )
        findNavController().navigate(action)
    }
}