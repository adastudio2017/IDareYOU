package adastudio.idareyou.Fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import adastudio.idareyou.Adapters.Contacts_Item_BaseAdapter;
import adastudio.idareyou.Objects.Contact_Object;
import adastudio.idareyou.R;


/**
 * Created by mojar on 4/24/2017.
 */

public class Contacts_Fragment extends Fragment {


    View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_contacts, container, false);


        ArrayList<Contact_Object> contactsList = new ArrayList<Contact_Object>();
        getContactsIntoArrayList(contactsList);
        ListView contactsListListView = (ListView) rootView.findViewById(R.id.contacts_item_listview);


        contactsListListView.setAdapter(new Contacts_Item_BaseAdapter(getActivity().getApplicationContext(), contactsList));
        return rootView;
    }

    public void retriveContactList(ListView contactList) {

    }


    private void getContactsIntoArrayList(ArrayList<Contact_Object> contactsList) {

        Cursor cursor;
        String name, phonenumber;
        cursor = getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);


        while (cursor.moveToNext()) {


            name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            if(!phonenumber.isEmpty())
            {
                Contact_Object contact_temp = new Contact_Object();

                Contact_Object contact = new Contact_Object();
                contact.setContact_name(name);
                contact.setContact_phoneNumber(phonenumber);


                if(contactsList.size()==1){
                    contact_temp =contact;
                }

                if (!contact.getContact_name().equals(contact_temp.getContact_name()) &&
                        !contact.getContact_phoneNumber().equals(contact_temp.getContact_phoneNumber())){
                    contactsList.add(contact);
                    contact_temp = contact;
                }


            }

        }

        cursor.close();



    }



}
