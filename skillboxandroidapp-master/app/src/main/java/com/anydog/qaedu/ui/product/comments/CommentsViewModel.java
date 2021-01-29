package com.anydog.qaedu.ui.product.comments;

import androidx.lifecycle.MutableLiveData;

import com.anydog.qaedu.data.DataManager;
import com.anydog.qaedu.data.model.api.data.CommentItem;
import com.anydog.qaedu.ui.base.BaseViewModel;
import com.anydog.qaedu.utils.rx.SchedulerProvider;

import java.util.List;

public class CommentsViewModel extends BaseViewModel<CommentsNavigator> {

    private final MutableLiveData<List<CommentItem>> liveListData;
    private String productId;

    public CommentsViewModel(DataManager dataManager,
                             SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        liveListData = new MutableLiveData<>();
    }

    public MutableLiveData<List<CommentItem>> getLiveListData() {
        return liveListData;
    }

    public void sendReply(CommentItem item, String text) {
        if (item == null || text == null || text == "")
            return;
        Observe(getDataManager().sendReply(item.getId(), text),
                response -> {
                    if (response != null && response.getInfo() != null) {
                        fetch(item.getProductId());
                        //liveListData.getValue().;
                    }
                }
        );
    }

    public void sendComment(String text) {
        if (text == null || text == "")
            return;
        Observe(getDataManager().sendComment(productId, text),
                response -> {
                    if (response != null && response.getInfo() != null) {
                        fetch(productId);
                        //liveListData.getValue().;
                    }
                }
        );
    }

    public void fetch(String productId) {
        this.productId = productId;
        setIsLoading(true);
        Observe(getDataManager().getComments(productId),
                response -> {
                    if (response != null && response.getInfo() != null) {
                        liveListData.setValue(response.getInfo().getComments());
                    }
                }
        );
    }

    public void addItem(String itemId) {
    }

    public void removeItem(String itemId) {
    }

    public void send(String itemId) {
    }
}
