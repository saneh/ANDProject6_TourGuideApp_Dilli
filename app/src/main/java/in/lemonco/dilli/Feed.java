package in.lemonco.dilli;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Feed class stores details such as image, title, description, location of a particular place, event, lifestyle etc
 */
public class Feed implements Parcelable {
    private String mTitle;
    private String mDescription;
    private String mLocation;
    private String mWhen;
    private int mImageResourceId;
    private String mPrice;

    public Feed(String title, String description, String location, String price, int image) {
        mTitle = title;
        mDescription = description;
        mImageResourceId = image;
        mLocation = location;
        mPrice = price;
    }

    public Feed(String title, String description, String location, String price, int image, String when) {
        mTitle = title;
        mDescription = description;
        mImageResourceId = image;
        mLocation = location;
        mWhen = when;
        mPrice = price;
    }

    //constructor that takes a Parcel and gives you an object populated with it's values
    private Feed(Parcel in) {
        mTitle = in.readString();
        mDescription = in.readString();
        mLocation = in.readString();
        mPrice = in.readString();
        mImageResourceId = in.readInt();
        mWhen = in.readString();
    }


    //Methods to implement the parceable interface, for moving object across activities using intent
    @Override
    public int describeContents() {
        return 0;
    }

    // write your object's data to the passed-in Parcel
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mTitle);
        out.writeString(mDescription);
        out.writeString(mLocation);
        out.writeString(mPrice);
        out.writeInt(mImageResourceId);
        out.writeString(mWhen);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Feed> CREATOR = new Parcelable.Creator<Feed>() {
        public Feed createFromParcel(Parcel in) {
            return new Feed(in);
        }

        public Feed[] newArray(int size) {
            return new Feed[size];
        }
    };


    //getter methods
    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmWhen() {
        return mWhen;
    }

    public String getmPrice() {
        return mPrice;
    }
}
