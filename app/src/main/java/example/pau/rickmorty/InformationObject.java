package example.pau.rickmorty;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InformationObject {

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("pages")
    @Expose
    private int pages;

    @SerializedName("next")
    @Expose
    private String next;

    @SerializedName("prev")
    @Expose
    private String prev;

    public InformationObject(int count, int pages, String next, String prev) {
        this.count = count;
        this.pages = pages;
        this.next = next;
        this.prev = prev;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "InformationObject{" +
                "count=" + count +
                ", pages=" + pages +
                ", next='" + next + '\'' +
                ", prev='" + prev + '\'' +
                '}';
    }
}
