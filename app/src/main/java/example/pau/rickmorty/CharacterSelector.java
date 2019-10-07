package example.pau.rickmorty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharacterSelector extends AppCompatActivity implements CharacterAdapter.ClickListener {

    private CharacterAdapter characterAdapter;
    private ArrayList<Character> characters = new ArrayList<>();
    private ArrayList<Boolean> likes;
    private static final String BASE_URL = "https://rickandmortyapi.com/api/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selector);

        getSource();
    }

    private void recycleInit(){
        RecyclerView recycleView = findViewById(R.id.recycleView);
        characterAdapter = new CharacterAdapter(this, characters, this);
        recycleView.setAdapter(characterAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getSource(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ConectorInterface conector = retrofit.create(ConectorInterface.class);
        Call<ResultsFromAPI> call = conector.getAllCharacters();

        call.enqueue(new Callback<ResultsFromAPI>() {
            @Override
            public void onResponse(Call<ResultsFromAPI> call, Response<ResultsFromAPI> response) {
                characters = response.body().getCharacters();
                likes = new ArrayList<>(characters.size());
                recycleInit();
            }

            @Override
            public void onFailure(Call<ResultsFromAPI> call, Throwable t) {
                Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this, CharacterSpecificActivity.class);
        intent.putExtra("chName", characters.get(position).getChName());
        intent.putExtra("chStatus", characters.get(position).getChStatus());
        intent.putExtra("chSpecies", characters.get(position).getChSpecies());
        intent.putExtra("chType", characters.get(position).getChType());
        intent.putExtra("chGender", characters.get(position).getChGender());
        intent.putExtra("chImage", characters.get(position).getChImage());
        //intent.putExtra("like", likes.get(position));
        startActivity(intent);
    }
}
