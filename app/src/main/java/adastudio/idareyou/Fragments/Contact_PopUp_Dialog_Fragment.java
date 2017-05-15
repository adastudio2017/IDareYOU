package adastudio.idareyou.Fragments;


import android.app.DialogFragment;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import adastudio.idareyou.R;


public class Contact_PopUp_Dialog_Fragment extends DialogFragment {

//    public static Contact_PopUp_Fragment newInstance(Activity activity) {
//        Contact_PopUp_Fragment contactPopFragment = new Contact_PopUp_Fragment();
//        return contactPopFragment;
//    }


    TextView contact_popup_name;
    TextView contact_popup_rankF;
    TextView contact_popup_rankW;
    ImageView contact_popup_picture;
    View v;

    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_contact_popup, container, false);

        contact_popup_name = (TextView) v.findViewById(R.id.contact_popup_name);
        contact_popup_rankF = (TextView) v.findViewById(R.id.contact_popup_rank_f_textview);
        contact_popup_rankW = (TextView) v.findViewById(R.id.contact_popup_rank_w_textview);
        contact_popup_picture = (ImageView) v.findViewById(R.id.contact_popup_image_imageview);

        Bundle info = getArguments();
        contact_popup_name.setText(info.getString("name"));
        contact_popup_picture.setImageBitmap((Bitmap) info.getParcelable("picture"));
        contact_popup_picture.setScaleType(ImageView.ScaleType.FIT_XY);
        contact_popup_rankF.setText(String.valueOf(info.getDouble("rankF")));
        contact_popup_rankW.setText(String.valueOf(info.getDouble("rankW")));
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        return v;
    }




}
