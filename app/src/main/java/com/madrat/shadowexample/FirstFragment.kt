package com.madrat.shadowexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.madrat.shadowexample.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var nullableBinding: FragmentFirstBinding? = null
    private val binding get() = nullableBinding!!
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        nullableBinding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            binding.buttonFirst.setOnClickListener {
                NavHostFragment.findNavController(this@FirstFragment)
                    .navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        nullableBinding = null
    }
}