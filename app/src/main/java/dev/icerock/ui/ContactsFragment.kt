package dev.icerock.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import dev.icerock.ui.databinding.FragmentContactsBinding


class ContactsFragment : Fragment(R.layout.fragment_contacts) {
    private lateinit var binding: FragmentContactsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContactsBinding.bind(view)
    }
}