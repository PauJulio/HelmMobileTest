package example.pau.rickmorty;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ConectorInterface {

    static final String BASE_URL = "https://rickandmortyapi.com/api/";

    @GET("character")
    Call< ResultsFromAPI > getAllCharacters();

    //Most likely unnecessary
    @GET("character/{Id}")
    Call<Character> getCharacterById(@Path("Id") int id);



}
