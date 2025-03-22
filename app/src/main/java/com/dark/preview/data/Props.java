package com.dark.preview.data;

import com.google.gson.annotations.SerializedName;

public class Props {
    public String width;
    public String height;
    public String orientation;
    @SerializedName("items-align")
    public String items_align;
    @SerializedName("background-color")
    public String backgroundColor;
}
