package adastudio.idareyou.Adapters;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import adastudio.idareyou.R;


/**
 * Created by NoCool on 4/26/2017.
 */

public class Contacts_Item_BaseAdapter extends BaseAdapter {


    View rootView;
    String[] contacts;

    public Contacts_Item_BaseAdapter(Context context, String[] contacts)
    {
        this.contacts = contacts;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    private static LayoutInflater inflater=null;


    @Override
    public int getCount() {
        return contacts.length;
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


        Holder contactHolder = new Holder();
        rootView = inflater.inflate(R.layout.contact_listview_item, null);


        contactHolder.contactsAcceptImageButton = (ImageButton) rootView.findViewById(R.id.contacts_accept_ImageButton);
        contactHolder.contactsDareImageButton = (ImageButton) rootView.findViewById(R.id.contacts_dare_ImageButton);
        contactHolder.contactsInfoTextView = (TextView) rootView.findViewById(R.id.contacts_info_TextView);
        contactHolder.contactsPictureImageView = (ImageView) rootView.findViewById(R.id.contacts_picture_ImageView);

        contactHolder.contactsInfoTextView.setText(contacts[position]);

        return rootView;
    }

    private class Holder
    {
        ImageView contactsPictureImageView;
        TextView contactsInfoTextView;
        ImageButton contactsDareImageButton;
        ImageButton contactsAcceptImageButton;
    }

}
