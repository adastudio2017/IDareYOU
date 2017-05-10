package adastudio.idareyou.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

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
    public Contacts_Recycler_Adapter(Context context, ArrayList<Contact_Object> contacts_list)
    {
        this.context = context;
        this.contacts_list = contacts_list;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView contactsPictureImageView;
        TextView contactsInfoTextView;
        ImageButton contactsDareImageButton;
        ImageButton contactsAcceptImageButton;

        public ViewHolder(View itemView)
        {
            super(itemView);


            contactsAcceptImageButton = (ImageButton) itemView.findViewById(R.id.contacts_accept_ImageButton);
            contactsDareImageButton = (ImageButton) itemView.findViewById(R.id.contacts_dare_ImageButton);
            contactsInfoTextView = (TextView) itemView.findViewById(R.id.contacts_info_TextView);
            contactsPictureImageView = (ImageView) itemView.findViewById(R.id.contacts_picture_ImageView);

        }
}
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(rootView);
        Log.d(TAG, "INSIDE dashbaord adapter");
        return viewHolder;
    }

     @Override
    public void onBindViewHolder(Contacts_Recycler_Adapter.ViewHolder holder, int position)
    {


        final Contact_Object  contact = contacts_list.get(position);
        Log.d(TAG, "INSIDE on bind ViewHolder");

        holder.contactsInfoTextView.setText(contact.getContact_name());
        if(contact.getContact_picture()==null){
            holder.contactsPictureImageView.setImageResource(R.drawable.unknown_contact);
        }else{
            holder.contactsPictureImageView.setImageBitmap(contact.getContact_picture());
        }
        holder.contactsPictureImageView.setScaleType(ImageView.ScaleType.FIT_XY);

        holder.contactsPictureImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Log.d("CONTACT", contact.getContact_name());
                //create a dialogFragment
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts_list.size();
    }
}
