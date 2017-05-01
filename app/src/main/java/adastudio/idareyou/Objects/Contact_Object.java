package adastudio.idareyou.Objects;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;


/**
 * Created by NoCool on 4/27/2017.
 */

public class Contact_Object {

    private String contact_username="N/A";
    private String contact_name="John Smith";
    private String contact_phoneNumber ="000";
    private Bitmap contact_picture=null;
    private double rank_private = 0.0;
    private double rank_global = 0.0;

    public String getContact_phoneNumber() {
        return contact_phoneNumber;
    }

    public void setContact_phoneNumber(String contact_phoneNumber) {
        this.contact_phoneNumber = contact_phoneNumber;
    }



    public String getContact_username() {
        return contact_username;
    }

    public void setContact_username(String contact_username) {
        this.contact_username = contact_username;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public Bitmap getContact_picture() {

        return contact_picture;
    }

    public void setContact_picture(Bitmap contact_picture) {

        this.contact_picture = contact_picture;
    }

    public double getRank_private() {
        return rank_private;
    }

    public void setRank_private(double rank_private) {
        this.rank_private = rank_private;
    }

    public double getRank_global() {
        return rank_global;
    }

    public void setRank_global(double rank_global) {
        this.rank_global = rank_global;
    }
}
