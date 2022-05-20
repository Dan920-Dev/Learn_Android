package com.escobar.vaccinecovid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.escobar.vaccinecovid.databinding.FragmentVaccineBinding



class VaccineFragment : Fragment() {
    private var textsinovac = ""

    private lateinit var binding: FragmentVaccineBinding
    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_vaccine, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        addListeners()
    }

    fun addListeners(){
        binding.actionSinovac.setOnClickListener {
            textsinovac = binding.actionSinovac.text.toString()

            viewModel.getQuery(textsinovac)
        }
        binding.actionPfizer.setOnClickListener {
            textsinovac = binding.actionPfizer.text.toString()

            viewModel.getQuery(textsinovac)
        }
        binding.actionModerna.setOnClickListener {
            textsinovac = binding.actionModerna.text.toString()

            viewModel.getQuery(textsinovac)
        }

        val navController = findNavController()
        binding.actionContinueResult.setOnClickListener {
            val action  = VaccineFragmentDirections.actionVaccineFragmentToResultFragment()
            navController.navigate(action)
        }
    }


}