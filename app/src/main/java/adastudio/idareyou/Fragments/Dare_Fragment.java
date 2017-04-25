package adastudio.idareyou.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import adastudio.idareyou.R;

public class Dare_Fragment extends Fragment {


    private View rootView;
//    ImageButton dareButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootView= inflater.inflate(R.layout.fragment_dare, container, false);

//        addListenerOnButton();
        return rootView;
    }

//    public void addListenerOnButton() {
//
//
//        dareButton = (ImageButton) rootView.findViewById(R.id.dareButton);
//        dareButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//             v.setBackgroundResource(R.mipmap.dare_btn_2);
//
//            }
//
//        });
//
//
//    }
}
