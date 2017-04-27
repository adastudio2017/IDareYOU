package adastudio.idareyou.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import adastudio.idareyou.Adapters.Contacts_Item_BaseAdapter;
import adastudio.idareyou.R;

/**
 * Created by mojar on 4/24/2017.
 */

public class Contacts_Fragment extends Fragment
{


    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootView= inflater.inflate(R.layout.fragment_contacts, container, false);

        String[] contacts = {"Ali", "Armen" ,"Balls"};
        ListView contactsListListView = (ListView)rootView.findViewById(R.id.contacts_item_listview);

        contactsListListView.setAdapter(new Contacts_Item_BaseAdapter(getActivity().getApplicationContext(), contacts));
        return rootView;
    }

}
