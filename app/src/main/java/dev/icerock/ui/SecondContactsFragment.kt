package dev.icerock.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dev.icerock.adapter.SecondAdapter
import dev.icerock.dto.Contact
import dev.icerock.ui.databinding.FragmentSecondContactsBinding
import dev.icerock.viewmodel.ContactsViewModel

class SecondContactsFragment : Fragment(R.layout.fragment_second_contacts) {
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
            requireContext(),
            secondContactsViewModel.secondContact()
        )
        binding.recyclerView.adapter = secondAdapter

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}