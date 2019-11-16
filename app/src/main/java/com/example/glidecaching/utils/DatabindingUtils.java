package com.example.glidecaching.utils;

import android.util.Log;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glidecaching.model.Response;
import com.example.glidecaching.view.adapters.ImageAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DatabindingUtils {

    private static final String TAG = "TAG_DatabindingUtils";

    @BindingAdapter("data")
    public static <T> void setRecyclerViewProperties(RecyclerView recyclerView, List<Response> responseList) {
        if (recyclerView.getAdapter() instanceof ImageAdapter) {
            Log.d(TAG, "setRecyclerViewProperties: ");
            ((ImageAdapter) recyclerView.getAdapter()).setData(responseList);
        }
    }

    public interface BindableAdapter<T> {
        void setData(MutableLiveData<List<T>> data);
    }
}
