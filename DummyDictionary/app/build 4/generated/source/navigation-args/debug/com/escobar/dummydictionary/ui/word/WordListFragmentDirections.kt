package com.escobar.dummydictionary.ui.word

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.escobar.dummydictionary.R

public class WordListFragmentDirections private constructor() {
  public companion object {
    public fun actionWordListFragmentToAddWordFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_wordListFragment_to_addWordFragment)
  }
}
