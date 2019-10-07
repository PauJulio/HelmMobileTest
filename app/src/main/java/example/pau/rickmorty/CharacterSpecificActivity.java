package example.pau.rickmorty;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CharacterSpecificActivity extends AppCompatActivity {

    private String chName;
    private String chStatus;
    private String chSpecies;
    private String chType;
    private String chGender;
    private String chImage;
    private Boolean like;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_specific);

        getInfo();
        init();
    }

    private void getInfo(){
        if (getIntent().hasExtra("chName") && getIntent().hasExtra("chStatus") && getIntent().hasExtra("chSpecies") && getIntent().hasExtra("chType") && getIntent().hasExtra("chGender") && getIntent().hasExtra("chImage") /*&& getIntent().hasExtra("like")*/){
            chName = getIntent().getStringExtra("chName");
            chStatus = getIntent().getStringExtra("chStatus");
            chSpecies = getIntent().getStringExtra("chSpecies");
            chType = getIntent().getStringExtra("chType");
            chGender = getIntent().getStringExtra("chGender");
            chImage = getIntent().getStringExtra("chImage");
            //like = getIntent().getBooleanExtra("like", false);
            init();
        }
    }

    private void init() {
        TextView name = findViewById(R.id.specificName);
        name.setText("Name: "+chName);
        TextView status = findViewById(R.id.specificStatus);
        status.setText("Status: "+chStatus);
        TextView species = findViewById(R.id.specificSpecies);
        species.setText("Species: "+chSpecies);
        TextView type = findViewById(R.id.specificType);
        type.setText("Type: "+chType);
        TextView gender = findViewById(R.id.specificGender);
        gender.setText("Gender: "+chGender);
        ImageView image = findViewById(R.id.chPortrait);
        Glide.with(this).asBitmap().load(chImage).into(image);
    }

}
