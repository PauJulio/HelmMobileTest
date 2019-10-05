package example.pau.rickmorty;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ConectorInterface {

    @GET("/character")
    Call< List<Character> > getAllCharacters();

    //Possiblement no faci falta
    @GET("/character/{Id}")
    Call<Character> getCharacterById(@Path("Id") int id);



}
