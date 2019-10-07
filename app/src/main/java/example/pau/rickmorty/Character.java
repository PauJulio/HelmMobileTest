package example.pau.rickmorty;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Character {

    @SerializedName("id")
    @Expose
    private int chId;

    @SerializedName("name")
    @Expose
    private String chName;

    @SerializedName("status")
    @Expose
    private String chStatus;

    @SerializedName("species")
    @Expose
    private String chSpecies;

    @SerializedName("type")
    @Expose
    private String chType;

    @SerializedName("gender")
    @Expose
    private String chGender;

    @SerializedName("origin")
    @Expose
    private Origin chOrigin;

    @SerializedName("location")
    @Expose
    private CharacterLocation chLocation;

    @SerializedName("image")
    @Expose
    private String chImage;

    @SerializedName("episode")
    @Expose
    private ArrayList<String> chEpisodes;

    @SerializedName("url")
    @Expose
    private String chUrl;

    @SerializedName("created")
    @Expose
    private String chCreated;

    public Character(int chId, String chName, String chStatus, String chSpecies, String chType, String chGender, Origin chOrigin, CharacterLocation chLocation, String chImage, ArrayList<String> chEpisodes, String chUrl, String chCreated) {
        this.chId = chId;
        this.chName = chName;
        this.chStatus = chStatus;
        this.chSpecies = chSpecies;
        this.chType = chType;
        this.chGender = chGender;
        this.chOrigin = chOrigin;
        this.chLocation = chLocation;
        this.chImage = chImage;
        this.chEpisodes = chEpisodes;
        this.chUrl = chUrl;
        this.chCreated = chCreated;
    }

    public int getChId() {
        return chId;
    }

    public void setChId(int chId) {
        this.chId = chId;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getChStatus() {
        return chStatus;
    }

    public void setChStatus(String chStatus) {
        this.chStatus = chStatus;
    }

    public String getChSpecies() {
        return chSpecies;
    }

    public void setChSpecies(String chSpecies) {
        this.chSpecies = chSpecies;
    }

    public String getChType() {
        return chType;
    }

    public void setChType(String chType) {
        this.chType = chType;
    }

    public String getChGender() {
        return chGender;
    }

    public void setChGender(String chGender) {
        this.chGender = chGender;
    }

    public Origin getChOrigin() {
        return chOrigin;
    }

    public void setChOrigin(Origin chOrigin) {
        this.chOrigin = chOrigin;
    }

    public CharacterLocation getChLocation() {
        return chLocation;
    }

    public void setChLocation(CharacterLocation chLocation) {
        this.chLocation = chLocation;
    }

    public String getChImage() {
        return chImage;
    }

    public void setChImage(String chImage) {
        this.chImage = chImage;
    }

    public ArrayList<String> getChEpisodes() {
        return chEpisodes;
    }

    public void setChEpisodes(ArrayList<String> chEpisodes) {
        this.chEpisodes = chEpisodes;
    }

    public String getChUrl() {
        return chUrl;
    }

    public void setChUrl(String chUrl) {
        this.chUrl = chUrl;
    }

    public String getChCreated() {
        return chCreated;
    }

    public void setChCreated(String chCreated) {
        this.chCreated = chCreated;
    }

    @Override
    public String toString() {
        return "Character{" +
                "chId=" + chId +
                ", chName='" + chName + '\'' +
                ", chStatus='" + chStatus + '\'' +
                ", chSpecies='" + chSpecies + '\'' +
                ", chType='" + chType + '\'' +
                ", chGender='" + chGender + '\'' +
                ", chOrigin=" + chOrigin +
                ", chLocation=" + chLocation +
                ", chImage='" + chImage + '\'' +
                ", chEpisodes=" + chEpisodes +
                ", chUrl='" + chUrl + '\'' +
                ", chCreated='" + chCreated + '\'' +
                '}';
    }
}