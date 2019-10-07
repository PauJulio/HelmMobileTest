package example.pau.rickmorty;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private Context chContext;
    private ArrayList<Character> characters;

    public CharacterAdapter(Context chContext, ArrayList<Character> characters) {
        this.chContext = chContext;
        this.characters = new ArrayList<>(characters);
    }


    @Override
    public CharacterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.character, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.ViewHolder viewHolder, int position) {
        Glide.with(chContext).asBitmap().load(characters.get(position).getChImage()).into(viewHolder.chImage);
        viewHolder.chName.setText(characters.get(position).getChName());
        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView chImage;
        TextView chName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            chImage = itemView.findViewById(R.id.chImage);
            chName = itemView.findViewById(R.id.chName);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }


}
