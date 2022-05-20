package com.escobar.dummydictionary.ui.word

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.escobar.dummydictionary.DummyDictionaryApplication
import com.escobar.dummydictionary.R
import com.escobar.dummydictionary.databinding.FragmentWordListBinding
import com.escobar.dummydictionary.ui.WordViewModelFactory

class WordListFragment : Fragment() {

    private val viewModelFactory by lazy {
        val application = requireActivity().application as DummyDictionaryApplication
        WordViewModelFactory(application.getDictionaryRepository())
    }

    private val viewModel: WordViewModel by viewModels {
        viewModelFactory
    }
    private lateinit var binding: FragmentWordListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_word_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wordListRecyclerView = binding.wordListRecyclerView
        val wordAdapter = WordAdapter()
        wordListRecyclerView.apply {
            adapter = wordAdapter
        }

        viewModel.getAllWords()

        viewModel.status.observe(viewLifecycleOwner) { status ->
            when (status) {
                is WordUiState.Error -> Log.d("word list status", "Error", status.exception)
                WordUiState.Loading -> Log.d("word list status", "Error")
                is WordUiState.Success -> TODO()//status.word.observe(viewLifecycleOwner) { data  ->
                    // wordAdapter.setData(data)
                }
            }
        }
        /*
        val navController = findNavController()
        binding.actionAddWord.setOnClickListener {
            val action = WordListFragmentDirections.actionWordListFragmentToAddWordFragment()
            navController.navigate(action)
        }

        */

    }



