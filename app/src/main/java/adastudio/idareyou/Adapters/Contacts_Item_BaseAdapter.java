package adastudio.idareyou.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import adastudio.idareyou.Objects.Contact_Object;
import adastudio.idareyou.R;


/**
 * Created by NoCool on 4/26/2017.
 */

public class Contacts_Item_BaseAdapter extends BaseAdapter{


    View rootView;
    ArrayList<Contact_Object> contacts_list;

    public Contacts_Item_BaseAdapter(Context context, ArrayList<Contact_Object> contacts_list)
    {
        this.contacts_list = contacts_list;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    private static LayoutInflater inflater=null;


    @Override
    public int getCount() {
        return contacts_list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        final Holder contactHolder = new Holder();
        rootView = inflater.inflate(R.layout.contact_recyclerview_item, null);


        final Contact_Object  contact = contacts_list.get(position);

        contactHolder.contactsAcceptImageButton = (ImageButton) rootView.findViewById(R.id.contacts_accept_ImageButton);
        contactHolder.contactsDareImageButton = (ImageButton) rootView.findViewById(R.id.contacts_dare_ImageButton);
        contactHolder.contactsInfoTextView = (TextView) rootView.findViewById(R.id.contacts_info_TextView);
        contactHolder.contactsPictureImageView = (ImageView) rootView.findViewById(R.id.contacts_picture_ImageView);

        contactHolder.contactsInfoTextView.setText(contact.getContact_name());
        if(contact.getContact_picture()==null){
          contactHolder.contactsPictureImageView.setImageResource(R.drawable.unknown_contact);
        }else{
            contactHolder.contactsPictureImageView.setImageBitmap(contact.getContact_picture());

        }
        contactHolder.contactsPictureImageView.setScaleType(ImageView.ScaleType.FIT_XY);


        return rootView;

    }



//        private class contactImageViewOnClick implements View.OnClickListener
//    {
//
//        String contactName;
//        public contactImageViewOnClick(String contactName)
//        {
//
//            this.contactName = contactName;
//        }
//        @Override
//        public void onClick(View v)
//        {
//
//            switch (v.getId())
//            {
//
//            }
//        }
//    }
    private class Holder
    {
        ImageView contactsPictureImageView;
        TextView contactsInfoTextView;
        ImageButton contactsDareImageButton;
        ImageButton contactsAcceptImageButton;
    }

}
