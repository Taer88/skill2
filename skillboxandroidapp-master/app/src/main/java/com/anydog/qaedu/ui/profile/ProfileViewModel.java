package com.anydog.qaedu.ui.profile;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.androidnetworking.interfaces.UploadProgressListener;
import com.anydog.qaedu.data.DataManager;
import com.anydog.qaedu.data.model.api.data.Profile;
import com.anydog.qaedu.ui.base.BaseViewModel;
import com.anydog.qaedu.utils.rx.SchedulerProvider;

import java.io.File;


public class ProfileViewModel extends BaseViewModel<ProfileNavigator> implements UploadProgressListener {
    private static final String TAG = "ProfileViewModel";
    public final ObservableField<String> name;
    public final ObservableField<String> avatar;
    public final ObservableField<String> about;
    // TODO: fixed profile
    private final String profileId = "5ed82fd544390e4998a9ab66";

    public ProfileViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        about = new ObservableField<>();
        avatar = new ObservableField<>();
        name = new ObservableField<>();
    }

    private void Bind(Profile profile) {
        about.set(profile.getAbout());
        avatar.set(profile.getAvatar());
        name.set(profile.getUsername());
    }

    public void updateProfileImage(File file) {
        Observe(getDataManager().updateProfileImage(file, getDataManager().getProfileId(), this),
                response -> {
                    if (response != null && response.getInfo() != null) {
                        fetch();
                    }
                }
        );
    }

    public void fetch() {
        setIsLoading(true);
        Observe(getDataManager().getProfile(getDataManager().getProfileId()),
                response -> {
                    if (response != null && response.getInfo() != null) {
                        Bind(response.getInfo());
                    }
                }
        );
    }

    public void logout() {
        getNavigator().logout();
    }

    @Override
    public void onProgress(long bytesUploaded, long totalBytes) {
        Log.d("Uploading", "Uploaded " + bytesUploaded + " of " + totalBytes);
    }
}
