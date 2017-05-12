package com.kyrostechnologies.sample.messenger.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kyrostechnologies.sample.messenger.ActivityGroupDetails;
import com.kyrostechnologies.sample.messenger.ActivityMain;
import com.kyrostechnologies.sample.messenger.R;
import com.kyrostechnologies.sample.messenger.adapter.GroupsGridAdapter;
import com.kyrostechnologies.sample.messenger.data.Constant;
import com.kyrostechnologies.sample.messenger.data.Tools;
import com.kyrostechnologies.sample.messenger.model.Group;

import java.util.ArrayList;
import java.util.List;

public class PageGroupFragment extends Fragment {

    private View view;

    private RecyclerView recyclerView;
    private List<Group> items = new ArrayList<>();
    private GroupsGridAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_fragment_group, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        // use a linear layout manager
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), Tools.getGridSpanCount(getActivity())));
        recyclerView.setHasFixedSize(true);

        items = Constant.getGroupData(getActivity());

        // specify an adapter (see also next example)
        mAdapter = new GroupsGridAdapter(getActivity(), items);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new GroupsGridAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, Group obj, int position) {
                ActivityGroupDetails.navigate((ActivityMain) getActivity(), v.findViewById(R.id.lyt_parent), obj);
            }
        });
        return view;
    }

}
