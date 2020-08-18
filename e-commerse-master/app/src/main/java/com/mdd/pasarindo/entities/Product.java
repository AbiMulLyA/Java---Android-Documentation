package com.mdd.pasarindo.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.bumptech.glide.Glide;
import com.mdd.pasarindo.R;

import java.io.File;

@Entity(tableName = "products")
public class Product implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String photo, name, description;
    private long quantity, price;

    public Product(String photo, String name, long price, long quantity, String description) {
        this.photo = photo;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    protected Product(Parcel in) {
        id = in.readLong();
        photo = in.readString();
        name = in.readString();
        description = in.readString();
        quantity = in.readLong();
        price = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(photo);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeLong(quantity);
        dest.writeLong(price);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @BindingAdapter("file")
    public static void setImage(ImageView view, String path) {
        if (TextUtils.isEmpty(path)) view.setImageResource(R.drawable.unnamed);
        else {
            File file = new File(path);

            if (file.exists()) Glide.with(view).load(file).into(view);
            else view.setImageResource(R.drawable.unnamed);
        }
    }
}
