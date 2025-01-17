package example.pau.rickmorty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CharacterSpecificActivity extends AppCompatActivity {

    private int position;
    private String chName;
    private String chStatus;
    private String chSpecies;
    private String chType;
    private String chGender;
    private String chImage;
    private Boolean chLike;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_specific);

        getInfo();
    }

    private void getInfo(){
        if (getIntent().hasExtra("position") && getIntent().hasExtra("chName") && getIntent().hasExtra("chStatus") && getIntent().hasExtra("chSpecies") && getIntent().hasExtra("chType") && getIntent().hasExtra("chGender") && getIntent().hasExtra("chImage") && getIntent().hasExtra("like")){
            position = getIntent().getExtras().getInt("position");
            chName = getIntent().getStringExtra("chName");
            chStatus = getIntent().getStringExtra("chStatus");
            chSpecies = getIntent().getStringExtra("chSpecies");
            chType = getIntent().getStringExtra("chType");
            chGender = getIntent().getStringExtra("chGender");
            chImage = getIntent().getStringExtra("chImage");
            chLike = getIntent().getExtras().getBoolean("like");
            System.out.print("he arribat " + chLike);
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
        ImageView like = findViewById(R.id.specificLike);
        if (chLike){
            like.setImageResource(R.drawable.ic_action_unlike);
        } else {
            like.setImageResource(R.drawable.ic_action_like);
        }
        like.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ImageView like = findViewById(R.id.specificLike);
                if (chLike){
                    chLike = false;
                    like.setImageResource(R.drawable.ic_action_like);
                } else {
                    chLike = true;
                    like.setImageResource(R.drawable.ic_action_unlike);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("position", position);
        if (chLike) setResult(Activity.RESULT_OK,returnIntent);
        else setResult(Activity.RESULT_CANCELED,returnIntent);
        finish();
    }
}
