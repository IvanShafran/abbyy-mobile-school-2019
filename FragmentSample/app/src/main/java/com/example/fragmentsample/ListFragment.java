package com.example.fragmentsample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    public static final String TAG = "ListFragment";

    public static Fragment newInstance() {
        return new ListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.openDetailButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                ((DemoActivity) getActivity()).showDetailFragment("ghjkajsjakasd");
            }
        });
    }
}
