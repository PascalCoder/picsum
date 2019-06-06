package com.example.picsum.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Picsum implements Parcelable {

    @SerializedName("format")
    private String format;
    @SerializedName("width")
    private String width;
    @SerializedName("height")
    private String height;
    @SerializedName("filename")
    private String filename;
    @SerializedName("id")
    private String id;
    @SerializedName("author")
    private String author;
    @SerializedName("author_url")
    private String author_url;
    @SerializedName("post_url")
    private String post_url;

    protected Picsum(Parcel in) {
        format = in.readString();
        width = in.readString();
        height = in.readString();
        filename = in.readString();
        id = in.readString();
        author = in.readString();
        author_url = in.readString();
        post_url = in.readString();
    }

    public static final Creator<Picsum> CREATOR = new Creator<Picsum>() {
        @Override
        public Picsum createFromParcel(Parcel in) {
            return new Picsum(in);
        }

        @Override
        public Picsum[] newArray(int size) {
            return new Picsum[size];
        }
    };

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public void setAuthor_url(String author_url) {
        this.author_url = author_url;
    }

    public String getPost_url() {
        return post_url;
    }

    public void setPost_url(String post_url) {
        this.post_url = post_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(format);
        dest.writeString(width);
        dest.writeString(height);
        dest.writeString(filename);
        dest.writeString(id);
        dest.writeString(author);
        dest.writeString(author_url);
        dest.writeString(post_url);
    }
}
