package adastudio.idareyou.Adapters;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import adastudio.idareyou.Fragments.Contact_PopUp_Dialog_Fragment;
import adastudio.idareyou.Objects.Contact_Object;
import adastudio.idareyou.R;


/**
 * Created by NoCool on 5/4/2017.
 */

public class Contacts_Recycler_Adapter  extends RecyclerView.Adapter<Contacts_Recycler_Adapter.ViewHolder>
{

    private final String TAG = "RECYCLER_ADAPTER";
    Context context;
    ArrayList<Contact_Object> contacts_list;
    FragmentManager fragmentManager;
    Activity activity;

    public Contacts_Recycler_Adapter(Context context, ArrayList<Contact_Object> contacts_list, Activity activity)
    {
        this.context = context;
        this.contacts_list = contacts_list;
        this.activity = activity;
        fragmentManager = activity.getFragmentManager();

    }

    class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView contactsPictureImageView;
        TextView contactsInfoTextView;
        ImageButton contactsDareImageButton;
        ImageButton contactsAcceptImageButton;
        TextView contactsPosition;


        public ViewHolder(View itemView)
        {
            super(itemView);



            contactsAcceptImageButton = (ImageButton) itemView.findViewById(R.id.contacts_accept_ImageButton);
            contactsDareImageButton = (ImageButton) itemView.findViewById(R.id.contacts_dare_ImageButton);
            contactsInfoTextView = (TextView) itemView.findViewById(R.id.contacts_info_TextView);
            contactsPictureImageView = (ImageView) itemView.findViewById(R.id.contacts_picture_ImageView);
            contactsPosition = (TextView) itemView.findViewById(R.id.contacts_position_TextView);




            contactsPictureImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Contact_Object contact = contacts_list.get(Integer.parseInt(contactsPosition.getText().toString()));
                    Bundle info = new Bundle();
                    info.putParcelable("picture", contact.getContact_picture());
                    info.putString("name", contact.getContact_name());
                    info.putDouble("rankF", contact.getRank_private());
                    info.putDouble("rankW", contact.getRank_global());


                    Contact_PopUp_Dialog_Fragment contactsPopUpDialogFragment = new Contact_PopUp_Dialog_Fragment();
                    contactsPopUpDialogFragment.setArguments(info);
                    contactsPopUpDialogFragment.show(activity.getFragmentManager(), "Person's Stats");

                }
            });



        }
}
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(rootView);
        return viewHolder;
    }

     @Override
    public void onBindViewHolder(Contacts_Recycler_Adapter.ViewHolder holder, int position)
    {


        final Contact_Object  contact = contacts_list.get(position);

        holder.contactsInfoTextView.setText(contact.getContact_name());
        holder.contactsPosition.setText(String.valueOf(position));
        if(contact.getContact_picture()==null){
            holder.contactsPictureImageView.setImageResource(R.drawable.unknown_contact);
        }else{
            holder.contactsPictureImageView.setImageBitmap(contact.getContact_picture());
        }
        holder.contactsPictureImageView.setScaleType(ImageView.ScaleType.FIT_XY);



    }

    @Override
    public int getItemCount() {
        return contacts_list.size();
    }
}
