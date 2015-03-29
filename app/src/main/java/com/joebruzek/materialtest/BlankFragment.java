package com.joebruzek.materialtest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.software.shell.fab.ActionButton;

/**
 * Created by jbruzek on 3/29/15.
 */
public class BlankFragment extends Fragment {

    private TextView title;

    /**
     * initialize the interface
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.material_fragment, container, false);
        container.removeAllViews();

        title = (TextView)v.findViewById(R.id.fragment_textView);
        title.setText(getArguments().getString("name", "TExt"));

        //Floating action button taken from here:
        // https://github.com/shell-software/fab
        ActionButton actionButton = (ActionButton) v.findViewById(R.id.action_button);
        actionButton.setButtonColor(getResources().getColor(R.color.accent));
        actionButton.setButtonColorPressed(getResources().getColor(R.color.accentDark));
        actionButton.setImageDrawable(getResources().getDrawable(R.drawable.fab_plus_icon));
        actionButton.setShowAnimation(ActionButton.Animations.JUMP_FROM_DOWN);
        actionButton.setHideAnimation(ActionButton.Animations.JUMP_TO_DOWN);
        actionButton.playShowAnimation();

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked the FAB", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}
