package com.madrat.shadowexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.madrat.shadowexample.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var nullableBinding: FragmentSecondBinding? = null
    private val binding get() = nullableBinding!!
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        nullableBinding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            buttonSecond.setOnClickListener {
                NavHostFragment.findNavController(this@SecondFragment)
                    .navigate(R.id.action_SecondFragment_to_FirstFragment)
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        nullableBinding = null
    }
}