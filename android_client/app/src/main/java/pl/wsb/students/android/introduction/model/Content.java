package pl.wsb.students.android.introduction.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content
{
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
