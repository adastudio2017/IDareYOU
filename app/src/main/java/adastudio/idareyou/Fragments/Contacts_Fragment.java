package adastudio.idareyou.Fragments;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;

import adastudio.idareyou.Activites.MainActivity;
import adastudio.idareyou.Adapters.Contacts_Item_BaseAdapter;
import adastudio.idareyou.Adapters.Contacts_Recycler_Adapter;
import adastudio.idareyou.Adapters.ViewAdapter;
import adastudio.idareyou.Objects.Contact_Object;
import adastudio.idareyou.R;

import static android.content.ContentValues.TAG;


/**
 * Created by mojar on 4/24/2017.
 */

public class Contacts_Fragment extends Fragment {



    View rootView;


    Context context;
    //Contacts_Item_BaseAdapter contactsListaBaseAdapter;
    Contacts_Recycler_Adapter adapter;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_contacts, container, false);


        ArrayList<Contact_Object> contactsList = new ArrayList<Contact_Object>();
        getContactsIntoArrayList(contactsList);
      //  ListView contactsListListView = (ListView) rootView.findViewById(R.id.contacts_item_recyclerView);

        //instead of listview
        RecyclerView contactsRecyclerView = (RecyclerView)rootView.findViewById(R.id.contacts_item_recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

         adapter = new Contacts_Recycler_Adapter(getActivity().getApplicationContext(), contactsList, getActivity());
        contactsRecyclerView.setLayoutManager(layoutManager);
       // context = getActivity().getApplicationContext();




       //contactsListListView.setAdapter(new Contacts_Item_BaseAdapter(getActivity().getApplicationContext(), contactsList));
       // contactsListaBaseAdapter = new Contacts_Item_BaseAdapter(getActivity().getApplicationContext(), contactsList);
     //   contactsListListView.setAdapter(contactsListaBaseAdapter);

        contactsRecyclerView.setAdapter(adapter);

        new  LoadPicturesInBackground().execute(contactsList);
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

        }catch (Exception e)
        {
            Log.d(TAG, e.toString());

        }
        return photo;
    }

    //method to check if a contact object exists in the list based on its name or phone number
    private Boolean containsName(ArrayList<Contact_Object> contactsList, String name, String phoneNumber){
        boolean flag = false;
        for (Contact_Object contact : contactsList){
            if (contact.getContact_name().equals(name) || contact.getContact_phoneNumber().equals(phoneNumber)){
                flag=true;
                break;
            }
        }
        return flag;
    }



    private void getContactsIntoArrayList(ArrayList<Contact_Object> contactsList) {

        Cursor cursor;
        String name, phonenumber, pictureId;
        Bitmap picture;
        ContentResolver cr =getContext().getContentResolver();

        cursor = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);


        while (cursor.moveToNext()) {

            phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            if(!phonenumber.isEmpty())
            {
                name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                Contact_Object contact = new Contact_Object();
                contact.setContact_name(name);
                contact.setContact_phoneNumber(phonenumber);

                if (containsName(contactsList,contact.getContact_name(),contact.getContact_phoneNumber())==false) {
                   // picture = getPhoto(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID)));
                    pictureId = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));
                    contact.setContact_pictureId(pictureId);
                   // contact.setContact_picture(picture);
                    contactsList.add(contact);
                }
            }
        }
        cursor.close();
    }

    private class LoadPicturesInBackground extends AsyncTask<ArrayList<Contact_Object> , Void, Void>
    {
        @Override
        protected Void doInBackground(ArrayList<Contact_Object>... contactList)
        {
//            Log.d(TAG, "CONTACT LIST: " + contactList[0].get(0).getContact_name());
           for(int i =0; i < contactList[0].size(); i ++)
           {

               contactList[0].get(i).setContact_picture(getPhoto(contactList[0].get(i).getContact_pictureId()));
               Log.d(TAG, "CONTACT LIST: " + contactList[0].get(i).getContact_name());
           }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
        }
    }










}
