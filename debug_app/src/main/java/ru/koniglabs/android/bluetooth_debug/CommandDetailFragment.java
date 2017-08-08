package ru.koniglabs.android.bluetooth_debug;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.koniglabs.android.bluetooth_debug.model.BtDevice;
import ru.koniglabs.android.bluetooth_debug.model.BtDevicesContent;

/**
 * A fragment representing a single Command detail screen.
 * This fragment is either contained in a {@link CommandListActivity}
 * in two-pane mode (on tablets) or a {@link CommandDetailActivity}
 * on handsets.
 */
public class CommandDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private BtDevice mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CommandDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = BtDevicesContent.getDeviceById(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.name);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.command_detail, container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.command_detail)).setText(mItem.mac);
        }

        return rootView;
    }
}
