package com.anydog.qaedu.ui.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.anydog.qaedu.BR;
import com.anydog.qaedu.R;
import com.anydog.qaedu.ViewModelProviderFactory;
import com.anydog.qaedu.databinding.FragmentProfileBinding;
import com.anydog.qaedu.ui.base.BaseFragment;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;

import javax.inject.Inject;

import static android.app.Activity.RESULT_OK;

public class ProfileFragment extends BaseFragment<FragmentProfileBinding, ProfileViewModel> implements ProfileNavigator {

    public static final String TAG = ProfileFragment.class.getSimpleName();
    @Inject
    ViewModelProviderFactory factory;
    private ProfileViewModel viewModel;

    public static ProfileFragment newInstance() {
        Bundle args = new Bundle();
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_profile;
    }

    @Override
    public ProfileViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(ProfileViewModel.class);
        return viewModel;
    }

    @Override
    public void goBack() {
        getBaseActivity().onFragmentDetached(TAG);
    }

    @Override
    public void getImage() {
        CropImage.activity().start(getContext(), this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri uri = result.getUri();
                GetFile(uri);
            }
//            else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
//                Exception error = result.getError();
//            }
        }
    }

    private void GetFile(Uri fileUri) {
        String str = fileUri.getPath();
        File file = new File(str);
        viewModel.updateProfileImage(file);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);
        viewModel.fetch();
    }

    @Override
    public void changeName() {

    }
}