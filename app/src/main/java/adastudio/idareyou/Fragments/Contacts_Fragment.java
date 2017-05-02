package adastudio.idareyou.Fragments;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import adastudio.idareyou.Adapters.Contacts_Item_BaseAdapter;
import adastudio.idareyou.Objects.Contact_Object;
import adastudio.idareyou.R;


/**
 * Created by mojar on 4/24/2017.
 */

public class Contacts_Fragment extends Fragment  {


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



    private Bitmap getPhoto(String id){

        Bitmap photo = null;
        try{
            InputStream inputStream = ContactsContract.Contacts.openContactPhotoInputStream(
                    getActivity().getContentResolver(),
                    ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI , new Long(id).longValue()));
            if(inputStream != null)
                photo= BitmapFactory.decodeStream(inputStream);

        }catch (Exception e){

        }
        return photo;
    }

    //method to check if a contact object exists in the list based on its name or phone number
    private Boolean containsName(ArrayList<Contact_Object> list, String name, String phonenumber){
        boolean flag = false;
        for (Contact_Object contact : list){
            if (contact.getContact_name().equals(name) || contact.getContact_phoneNumber().equals(phonenumber)){
                flag=true;
                break;
            }
        }
        return flag;
    }



    private void getContactsIntoArrayList(ArrayList<Contact_Object> contactsList) {

        Cursor cursor;
        String name, phonenumber;
        Uri photoUri;
        Bitmap picture;
        ContentResolver cr =getContext().getContentResolver();

        cursor = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);


        while (cursor.moveToNext()) {


            name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            if(!phonenumber.isEmpty())
            {
                Contact_Object contact = new Contact_Object();
                contact.setContact_name(name);
                contact.setContact_phoneNumber(phonenumber);

                if (containsName(contactsList,contact.getContact_name(),contact.getContact_phoneNumber())==false) {
                    picture = getPhoto(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID)));
                    contact.setContact_picture(picture);
                    contactsList.add(contact);
                }
            }
        }
        cursor.close();
    }




}
