package example.pau.rickmorty;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharacterLocation {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("url")
    @Expose
    private String url;

    public CharacterLocation(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CharacterLocation{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
