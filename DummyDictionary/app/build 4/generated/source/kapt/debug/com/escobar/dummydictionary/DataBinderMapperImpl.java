package com.escobar.dummydictionary;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.escobar.dummydictionary.databinding.ActivityLoginBindingImpl;
import com.escobar.dummydictionary.databinding.FragmentAddWordBindingImpl;
import com.escobar.dummydictionary.databinding.FragmentWordListBindingImpl;
import com.escobar.dummydictionary.databinding.ItemWordBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYLOGIN = 1;

  private static final int LAYOUT_FRAGMENTADDWORD = 2;

  private static final int LAYOUT_FRAGMENTWORDLIST = 3;

  private static final int LAYOUT_ITEMWORD = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.escobar.dummydictionary.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.escobar.dummydictionary.R.layout.fragment_add_word, LAYOUT_FRAGMENTADDWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.escobar.dummydictionary.R.layout.fragment_word_list, LAYOUT_FRAGMENTWORDLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.escobar.dummydictionary.R.layout.item_word, LAYOUT_ITEMWORD);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTADDWORD: {
          if ("layout/fragment_add_word_0".equals(tag)) {
            return new FragmentAddWordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_add_word is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWORDLIST: {
          if ("layout/fragment_word_list_0".equals(tag)) {
            return new FragmentWordListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_word_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMWORD: {
          if ("layout/item_word_0".equals(tag)) {
            return new ItemWordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_word is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "viewModel");
      sKeys.put(2, "word");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/activity_login_0", com.escobar.dummydictionary.R.layout.activity_login);
      sKeys.put("layout/fragment_add_word_0", com.escobar.dummydictionary.R.layout.fragment_add_word);
      sKeys.put("layout/fragment_word_list_0", com.escobar.dummydictionary.R.layout.fragment_word_list);
      sKeys.put("layout/item_word_0", com.escobar.dummydictionary.R.layout.item_word);
    }
  }
}
