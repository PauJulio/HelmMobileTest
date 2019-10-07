package example.pau.rickmorty;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResultsFromAPI {

    @SerializedName("info")
    @Expose
    private InformationObject info;

    @SerializedName("results")
    @Expose
    private ArrayList<Character> characters;

    public ResultsFromAPI(InformationObject info, ArrayList<Character> characters) {
        this.info = info;
        this.characters = characters;
    }

    public InformationObject getInfo() {
        return info;
    }

    public void setInfo(InformationObject info) {
        this.info = info;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "ResultsFromAPI{" +
                "info=" + info +
                ", characters=" + characters +
                '}';
    }
}
