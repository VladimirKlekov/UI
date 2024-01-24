package dev.icerock.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.icerock.ui.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    val question: String = "Оба варианта работают. Который лучше использовать?"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.firstOptionBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_contactsFragment)

        }

        binding.secondOptionBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_secondContactsFragment)
        }

        binding.question.text = question

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}