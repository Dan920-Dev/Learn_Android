package com.escobar.dummydictionary.databinding;
import com.escobar.dummydictionary.R;
import com.escobar.dummydictionary.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginBindingImpl extends ActivityLoginBinding implements com.escobar.dummydictionary.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.login_text, 4);
        sViewsWithIds.put(R.id.imageView, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener faveditandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.passwordField.getValue()
            //         is viewModel.passwordField.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(favedit);
            // localize variables for thread safety
            // viewModel.passwordField.getValue()
            java.lang.String viewModelPasswordFieldGetValue = null;
            // viewModel.passwordField
            androidx.lifecycle.MutableLiveData<java.lang.String> viewModelPasswordField = null;
            // viewModel
            com.escobar.dummydictionary.ui.login.LoginViewModel viewModel = mViewModel;
            // viewModel.passwordField != null
            boolean viewModelPasswordFieldJavaLangObjectNull = false;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelPasswordField = viewModel.getPasswordField();

                viewModelPasswordFieldJavaLangObjectNull = (viewModelPasswordField) != (null);
                if (viewModelPasswordFieldJavaLangObjectNull) {




                    viewModelPasswordField.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener usernameTextandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.userField.getValue()
            //         is viewModel.userField.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(usernameText);
            // localize variables for thread safety
            // viewModel.userField.getValue()
            java.lang.String viewModelUserFieldGetValue = null;
            // viewModel.userField != null
            boolean viewModelUserFieldJavaLangObjectNull = false;
            // viewModel.userField
            androidx.lifecycle.MutableLiveData<java.lang.String> viewModelUserField = null;
            // viewModel
            com.escobar.dummydictionary.ui.login.LoginViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelUserField = viewModel.getUserField();

                viewModelUserFieldJavaLangObjectNull = (viewModelUserField) != (null);
                if (viewModelUserFieldJavaLangObjectNull) {




                    viewModelUserField.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ActivityLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.EditText) bindings[2]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.Button) bindings[1]
            , (android.widget.EditText) bindings[3]
            );
        this.favedit.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.signInButtom.setTag(null);
        this.usernameText.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.escobar.dummydictionary.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((com.escobar.dummydictionary.ui.login.LoginViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.escobar.dummydictionary.ui.login.LoginViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelUserField((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelPasswordField((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelUserField(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelUserField, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelPasswordField(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelPasswordField, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String viewModelUserFieldGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelUserField = null;
        java.lang.String viewModelPasswordFieldGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelPasswordField = null;
        com.escobar.dummydictionary.ui.login.LoginViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.userField
                        viewModelUserField = viewModel.getUserField();
                    }
                    updateLiveDataRegistration(0, viewModelUserField);


                    if (viewModelUserField != null) {
                        // read viewModel.userField.getValue()
                        viewModelUserFieldGetValue = viewModelUserField.getValue();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.passwordField
                        viewModelPasswordField = viewModel.getPasswordField();
                    }
                    updateLiveDataRegistration(1, viewModelPasswordField);


                    if (viewModelPasswordField != null) {
                        // read viewModel.passwordField.getValue()
                        viewModelPasswordFieldGetValue = viewModelPasswordField.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.favedit, viewModelPasswordFieldGetValue);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.favedit, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, faveditandroidTextAttrChanged);
            this.signInButtom.setOnClickListener(mCallback1);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.usernameText, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, usernameTextandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.usernameText, viewModelUserFieldGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        com.escobar.dummydictionary.ui.login.LoginViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.onLogin();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.userField
        flag 1 (0x2L): viewModel.passwordField
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}